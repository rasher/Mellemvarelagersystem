package model;

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
	public List<Mellemvare> getKlar()
	{
		em.getTransaction().begin();
		return em.createNamedQuery("findMinimumstidOpnået").getResultList();
	}
	public List<Mellemvare> getNærOverskredet()
	{
		em.getTransaction().begin();
		return em.createNamedQuery("find")
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
		return em.createNamedQuery("findAlleMellemvare").getResultList();
	}
	
	public List<Produkttype> getProdukttype()
	{
		em.getTransaction().begin();
		return em.createNamedQuery("findProdukttyper").getResultList();
	}
	
	public List<Behandling> getBehandlinger()
	{
		em.getTransaction().begin();
		return em.createNamedQuery("findAlleBehandlinger").getResultList();
	}
	
	public List<Delbehandling> getDelbehandlinger()
	{
		em.getTransaction().begin();
		return em.createNamedQuery("findDelbehandlinger").getResultList();
	}

}
