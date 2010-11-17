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
		List<Mellemvare> minOpnået = em.createNamedQuery("findMinimumstidOpnået").getResultList();
		List<Mellemvare> resultatListe = new ArrayList<Mellemvare>();
		GregorianCalendar skæringsPunkt = new GregorianCalendar();
		skæringsPunkt.add(GregorianCalendar.HOUR, antalTimerFraMaks);
		for(Mellemvare m : minOpnået)
		{
			if(m.getMaksimumTørringNået().after(skæringsPunkt) == klarListe)
				resultatListe.add(m);
		}
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
		return em.createNamedQuery("findAlleMellemvare").getResultList();
	}
	
	public List<Produkttype> getProdukttype()
	{
		return em.createNamedQuery("findProdukttyper").getResultList();
	}
	
	public List<Behandling> getBehandlinger()
	{
		return em.createNamedQuery("findAlleBehandlinger").getResultList();
	}
	
	public List<Delbehandling> getDelbehandlinger()
	{
		return em.createNamedQuery("findDelbehandlinger").getResultList();
	}

}
