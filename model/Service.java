package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.*;

/**
 * Service klasse til Carletti Mellemvarelagersystemet
 * 
 * @author Peter Runge Christensen
 * @author Jonas Häggqvist
 */
public class Service {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mellemvarelager");
	private EntityManager em = emf.createEntityManager();
	private static Service thisInstance;
	private final int antalRækker = 12;
	private final int pladserPerRække = 6;
	
	/**
	 * Få en instans af Service klassen
	 * @return Service klasse objekt
	 */
	public static Service getInstance()
	{
		if(thisInstance == null)
			thisInstance = new Service();
		return thisInstance;
	}
	
	/**
	 * Constructor
	 */
	private Service()
	{
		
	}
	
	/**
	 * Opret en mellemvare af en given produkttype. Der oprettes behandlingstrin
	 * og den første behandling påbegyndes og tørring startes.
	 * @param produkttype Mellemvarens produkttype
	 * @return Den oprettede mellemvare
	 */
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
	
	/**
	 * Opret en ny produkttype med en given behandling
	 * @param behandling behandlingen der skal tilknyttes
	 * @return den oprettede produkttype
	 */
	public Produkttype createProdukttype(Behandling behandling)
	{
		Produkttype nyProdukttype = new Produkttype();
		nyProdukttype.setBehandling(behandling);
		return nyProdukttype;
	}
	
	/**
	 * Opret en BehandlingDelbehandlingRelation som står for at knytte en
	 * behandling til en delbehandling.
	 * @return Den oprettede BehandlingDelbehandlingRelation
	 */
	public BehandlingDelbehandlingRelation createBehandlingDelbehandlingRelation()
	{
		return new BehandlingDelbehandlingRelation();
	}
	
	/**
	 * Opret en Behandling
	 * @return Den oprettede Behandling
	 */
	public Behandling createBehandling()
	{
		Behandling nyBehandling = new Behandling();
		return nyBehandling;
	}
	
	/**
	 * Opret en Delbehandling
	 * @return Den oprettede Delbehandling
	 */
	public Delbehandling createDelbehandling()
	{
		Delbehandling nyDelbehandling = new Delbehandling();
		return nyDelbehandling;
	}
	
	/**
	 * Hent en liste af mellemvarer som har opnået deres minimums tørringstid
	 * og er mere end antalTimerFraMaks timer fra at nå deres maksimale
	 * tørringstid.
	 * @param antalTimerFraMaks Skæringspunktet før maksimale tørringstid
	 * @return Listen af Mellemvarer
	 */
	public List<Mellemvare> getKlar(int antalTimerFraMaks)
	{
		return getTørringsDatoListe(antalTimerFraMaks, true);
	}
	
	/**
	 * Hent en liste af mellemvarer som har opnået deres minimums tørringstid
	 * og er mindre end antalTimerFraMaks timer fra at nå deres maksimale
	 * tørringstid.
	 * @param antalTimerFraMaks Skæringspunktet før maksimale tørringstid
	 * @return Listen af Mellemvarer
	 */
	public List<Mellemvare> getNærOverskredet(int antalTimerFraMaks)
	{
		return getTørringsDatoListe(antalTimerFraMaks, false);
	}
	
	/**
	 * Hent en liste af Mellemvarer som har opnået deres minimums tørringstid.
	 * Returnerer kun Mellemvarer som er enten over eller under antalTimerFraMaks
	 * fra at nå deres maksimale tørringstid. 
	 * @param antalTimerFraMaks Skæringspunktet før maksimale tørringstid
	 * @param klarListe Returner listen af mellemvarer der ikke er tæt på deres maksimale tørringstid.
	 * @return Listen af Mellemvarer
	 */
	private List<Mellemvare> getTørringsDatoListe(int antalTimerFraMaks, boolean klarListe)
	{
		em.getTransaction().begin();
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
	
	/**
	 * Gem et objekt i Databasen
	 * @param o Objektet der skal gemmes
	 */
	public void gemIDatabase(Object o)
	{
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	/**
	 * Hent alle Mellemvarer
	 * @return Listen af alle mellemvarer
	 */
	public List<Mellemvare> getMellemvarer()
	{
		em.getTransaction().begin();
		List<Mellemvare> mellemvarer = em.createNamedQuery("findAlleMellemvarer").getResultList();
		em.getTransaction().commit();
		return mellemvarer;

	}
	
	/**
	 * Hent alle Produkttyper
	 * @return Listen af alle Produkttyper
	 */
	public List<Produkttype> getProdukttyper()
	{
		em.getTransaction().begin();
		List<Produkttype> produkttyper = em.createNamedQuery("findProdukttyper").getResultList();
		em.getTransaction().commit();
		return produkttyper;
	}
	
	/**
	 * Hent alle Behandlinger
	 * @return Listen af alle Behandlinger
	 */
	public List<Behandling> getBehandlinger()
	{
		em.getTransaction().begin();
		List<Behandling> behandlinger =  em.createNamedQuery("findAlleBehandlinger").getResultList();
		em.getTransaction().commit();
		return behandlinger;
	}
	
	/**
	 * Hent alle Delbehandlinger
	 * @return Listen af alle Delbehandlinger
	 */
	public List<Delbehandling> getDelbehandlinger()
	{
		em.getTransaction().begin();
		List<Delbehandling> behandlinger = em.createNamedQuery("findDelbehandlinger").getResultList();
		em.getTransaction().commit();
		return behandlinger;
	}
	
	/**
	 * Fjern et objekt fra databasen
	 * @param o Objektet der skal fjernes
	 */
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
	
	/**
	 * Find den bedst mulige placering på mellemvarelageret for en mellemvare.
	 * Placeringen udregnes på følgende måde:
	 * - Findes der en tom række, sættes varen på den første tomme række
	 * - Ellers placeres varen på den række hvor forskellen på den bageste
	 *   vares optimaltid og den nye vares optimaltid er så lille som muligt.
	 *   Det tjekkes at den nye vares maksimaltid ikke ligger før den bageste
	 *   vares optimaltid.
	 * 
	 * @param mellemvare Mellemvaren der skal placeres på mellemvarelageret
	 * @return Den bedst fundne placering for mellemvaren, eller null hvis ingen vare er fundet
	 */
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
				if (optimalForskel > 0)
				{
					optimalPlacering = new Placering();
					optimalPlacering.setRække(række);
					optimalPlacering.setPladsIRække(1);
					optimalForskel = 0;
				}
				continue;
			}
			Mellemvare iRække = mellemvarer.get(mellemvarer.size() - 1);
			if(iRække.getPlacering().getPladsIRække() < pladserPerRække)
			{
				if(iRække.getOptimalTørringNået().before(mellemvare.getOptimalTørringNået()) &&
						iRække.getMaksimumTørringNået().before(mellemvare.getMaksimumTørringNået()))
				{
					long forskel = mellemvare.getOptimalTørringNået().getTimeInMillis() - 
						iRække.getOptimalTørringNået().getTimeInMillis();
					if(forskel < optimalForskel)
					{
						optimalForskel = forskel;
						optimalPlacering = new Placering();
						optimalPlacering.setRække(række);
						optimalPlacering.setPladsIRække(iRække.getPlacering().getPladsIRække() + 1);
					}
				}
			}
		}
		em.getTransaction().commit();
		return optimalPlacering;
	}
	
	/**
	 * Fjern en mellemvare fra en given række. Alle mellemvarer der står bagved
	 * flyttes en plads frem.
	 * @param mellemvare Mellemvaren der skal fjernes.
	 * @throws Exception Hvis Mellemvaren ikke har nogen placering
	 */
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
	
	/**
	 * Send en Mellemvare til pakning. Den fjernes fra den række den står i.
	 * @param mellemvare Mellemvaren der skal sendes til pakning.
	 * @throws Exception
	 */
	public void sendTilPakning(Mellemvare mellemvare) throws Exception {
		fjernFraRække(mellemvare);
		mellemvare.sendTilPakning();
		gemIDatabase(mellemvare);
	}
	
	/**
	 * Start næste delbehandling på en mellemvare. Hvis der er en igangværende
	 * delbehandling, fjernes den først fra den række den står i på lageret.
	 * @param mellemvare Mellemvaren der skal påbegynde delbehandling
	 * @throws Exception
	 */
	public void startDelbehandling(Mellemvare mellemvare) throws Exception {
		if (mellemvare.getAktueltBehandlingTrin() != null) {
			fjernFraRække(mellemvare);
		}
		mellemvare.startDelbehandling();
		gemIDatabase(mellemvare);
	}
	
	/**
	 * Start tørring af en mellemvare. Der findes en placering for mellevaren
	 * og denne sættes på mellemvaren.
	 * @param mellemvare Mellemvaren der skal til tørring
	 * @throws Exception Hvis der ikke kan findes en plads til mellemvaren.
	 */
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
