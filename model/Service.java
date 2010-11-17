package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.*;

public class Service {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mellemvarelager");
	private EntityManager em = emf.createEntityManager();
	private static Service thisInstance;
	
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
		Mellemvare nyMellemvare = new Mellemvare();
		nyMellemvare.setProdukttype(produkttype);
		for(Delbehandling delbehandling : produkttype.getDelbehandlinger())
		{
			BehandlingsTrin nytBehandlingsTrin = new BehandlingsTrin();
			nytBehandlingsTrin.setDelbehandling(delbehandling);
			nyMellemvare.addBehandlingsTrin(nytBehandlingsTrin);
			gemIDatabase(nytBehandlingsTrin);
		}
		return nyMellemvare;
	}
	public Produkttype createProdukttype(Behandling behandling)
	{
		Produkttype nyProdukttype = new Produkttype();
		nyProdukttype.setBehandling(behandling);
		return nyProdukttype;
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
		List<Mellemvare> minOpnået = em.createNamedQuery("findMinimumstidOpnået").getResultList();
		List<Mellemvare> resultatListe = new ArrayList<Mellemvare>();
		GregorianCalendar skæringsPunkt = new GregorianCalendar();
		skæringsPunkt.add(GregorianCalendar.HOUR, antalTimerFraMaks);
		for(Mellemvare m : minOpnået)
		{
			if(m.getMaksimumTørringNået().after(skæringsPunkt) == klarListe)
				resultatListe.add(m);
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

}
