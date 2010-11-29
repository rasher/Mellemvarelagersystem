package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.*;

public class Service {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mellemvarelager");
	private EntityManager em = emf.createEntityManager();
	private static Service thisInstance;
	private final int antalRækker = 12;
	private final int pladserPerRække = 6;
	
	public static Service getInstance()
	{
		if(thisInstance == null)
			thisInstance = new Service();
		return thisInstance;
	}
	
	private Service()
	{
		
	}
	public Mellemvare createMellemvare(Produkttype produkttype)
	{
		Mellemvare nyMellemvare = null;

		if(produkttype != null){
			em.getTransaction().begin();
			nyMellemvare = new Mellemvare();
			nyMellemvare.setProdukttype(produkttype);
			for(Delbehandling delbehandling : produkttype.getDelbehandlinger())
			{
				BehandlingsTrin nytBehandlingsTrin = new BehandlingsTrin();
				nytBehandlingsTrin.setDelbehandling(delbehandling);
				nyMellemvare.addBehandlingsTrin(nytBehandlingsTrin);
				em.persist(nytBehandlingsTrin);
			}
			em.persist(nyMellemvare);
			em.getTransaction().commit();
		}
		return nyMellemvare;
	}
	public Produkttype createProdukttype(Behandling behandling)
	{
		Produkttype nyProdukttype = new Produkttype();
		nyProdukttype.setBehandling(behandling);
		return nyProdukttype;
	}
	public BehandlingDelbehandlingRelation createBehandlingDelbehandlingRelation()
	{
		return new BehandlingDelbehandlingRelation();
	}
	
	public Behandling createBehandling()
	{
		Behandling nyBehandling = new Behandling();
		return nyBehandling;
	}
	public Delbehandling createDelbehandling()
	{
		Delbehandling nyDelbehandling = new Delbehandling();
		return nyDelbehandling;
	}
	public List<Mellemvare> getKlar(int antalTimerFraMaks)
	{
		return getTørringsDatoListe(antalTimerFraMaks, true);
	}
	
	public List<Mellemvare> getNærOverskredet(int antalTimerFraMaks)
	{
		return getTørringsDatoListe(antalTimerFraMaks, false);
	}
	
	private List<Mellemvare> getTørringsDatoListe(int antalTimerFraMaks, boolean klarListe)
	{
		em.getTransaction().begin();
		System.out.println("Hent " + (klarListe ? "klarlisten":"næroverskredetliste") + " - mellemvarer " + (klarListe?"før":"indenfor") + " " + antalTimerFraMaks + " timer før maks");
		List<Mellemvare> minOpnået = em.createNamedQuery("findMinimumstidOpnået").getResultList();
		List<Mellemvare> resultatListe = new ArrayList<Mellemvare>();
		GregorianCalendar skæringsPunkt = new GregorianCalendar();
		skæringsPunkt.add(GregorianCalendar.HOUR, antalTimerFraMaks);
		for(Mellemvare m : minOpnået)
		{
			if(m.getMaksimumTørringNået().after(skæringsPunkt) == klarListe) {
				resultatListe.add(m);
				System.out.println("  INCL: " + m);
			}
			else
				System.out.println("  EXCL: " + m);
		}
		em.getTransaction().commit();
		return resultatListe;
	}
	
	public void gemIDatabase(Object o)
	{
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	public List<Mellemvare> getMellemvarer()
	{
		em.getTransaction().begin();
		List<Mellemvare> mellemvarer = em.createNamedQuery("findAlleMellemvarer").getResultList();
		em.getTransaction().commit();
		return mellemvarer;

	}
	
	public List<Produkttype> getProdukttyper()
	{
		em.getTransaction().begin();
		List<Produkttype> produkttyper = em.createNamedQuery("findProdukttyper").getResultList();
		em.getTransaction().commit();
		return produkttyper;
	}
	
	public List<Behandling> getBehandlinger()
	{
		em.getTransaction().begin();
		List<Behandling> behandlinger =  em.createNamedQuery("findAlleBehandlinger").getResultList();
		em.getTransaction().commit();
		return behandlinger;
	}
	
	public List<Delbehandling> getDelbehandlinger()
	{
		em.getTransaction().begin();
		List<Delbehandling> behandlinger = em.createNamedQuery("findDelbehandlinger").getResultList();
		em.getTransaction().commit();
		return behandlinger;
	}
	
	public void fjernFraDatabase(Object o)
	{
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}

	/**
	 * Slå en mellemvare op i databasen.
	 * @param batchNummer
	 * @return Mellemvaren med det givne batchNummer, eller null hvis ingen findes
	 */
	public Mellemvare søgMellemvare(int batchNummer) {
		
		em.getTransaction().begin();
		Query nq = em.createNamedQuery("søgMellemvareFraBatchNummer");
		nq.setParameter("batchNummer", batchNummer);
		List<Mellemvare> mellemvarer = nq.getResultList();
		em.getTransaction().commit();
		if (mellemvarer.size() > 0) {
			return mellemvarer.get(0);
		}
		return null;
	}
	
	public Placering beregnPlacering(Mellemvare mellemvare)
	{
		Placering optimalPlacering = null;
		long optimalForskel = Long.MAX_VALUE;
		em.getTransaction().begin();
		for(int række = 1 ; række <= antalRækker ; række++)
		{
			Query nq = em.createNamedQuery("findVarerIRække");
			nq.setParameter("række", række);
			List<Mellemvare> mellemvarer = nq.getResultList();
			if(mellemvarer.size() < 1)
				{
					optimalPlacering = new Placering();
					optimalPlacering.setRække(række);
					optimalPlacering.setPladsIRække(1);
					optimalForskel = 0;
					continue;
				}
			Mellemvare m = mellemvarer.get(mellemvarer.size() - 1);
			if(m.getPlacering().getPladsIRække() < pladserPerRække)
				if(m.getMaksimumTørringNået().before(mellemvare.getMinimumTørringNået()))
				{
					long forskel = mellemvare.getMinimumTørringNået().getTimeInMillis() - 
						m.getMaksimumTørringNået().getTimeInMillis();
					if(forskel < optimalForskel)
					{
						optimalForskel = forskel;
						optimalPlacering = new Placering();
						optimalPlacering.setRække(række);
						optimalPlacering.setPladsIRække(m.getPlacering().getPladsIRække() + 1);
					}
				}
		}
		em.getTransaction().commit();
		return optimalPlacering;
	}
	
	public void fjernFraRække(Mellemvare mellemvare) throws Exception {
		if (mellemvare.getPlacering() == null) {
			throw new Exception("Mellemvare er ikke i nogen række");
		}
		em.getTransaction().begin();
		
		Query nq = em.createNamedQuery("findVarerIRække");
		nq.setParameter("række", mellemvare.getPlacering().getRække());
		List<Mellemvare> mellemvarer = nq.getResultList();
		for (Mellemvare m: mellemvarer) {
			if (m.getPlacering().getPladsIRække() > mellemvare.getPlacering().getPladsIRække()) {
				m.getPlacering().setPladsIRække(m.getPlacering().getPladsIRække() - 1);
				em.persist(m);
			}
		}
		mellemvare.setPlacering(null);
		em.persist(mellemvare);
		em.getTransaction().commit();		
	}
	
	public void sendTilPakning(Mellemvare mellemvare) throws Exception {
		fjernFraRække(mellemvare);
		mellemvare.sendTilPakning();
		gemIDatabase(mellemvare);
	}
	
	public void startDelbehandling(Mellemvare mellemvare) throws Exception {
		if (mellemvare.getAktueltBehandlingTrin() != null) {
			fjernFraRække(mellemvare);
		}
		mellemvare.startDelbehandling();
		gemIDatabase(mellemvare);
	}
	
	public void startTørring(Mellemvare mellemvare) throws Exception {
		Placering placering = beregnPlacering(mellemvare);
		if (placering != null) {
			mellemvare.setPlacering(placering);
		}
		else {
			throw new Exception("Mellemvarelageret er fyldt");
		}
		mellemvare.setPlacering(placering);
		mellemvare.startTørring();
		gemIDatabase(mellemvare);
	}

}
