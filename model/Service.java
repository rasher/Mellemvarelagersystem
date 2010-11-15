package model;

import java.util.List;
import javax.persistence.*;

public class Service {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Service");
	private EntityManager em = emf.createEntityManager();
	private Service thisInstance;
	
	public Service getInstance()
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
		em.getTransaction().begin();
		em.persist(nyMellemvare);
		em.getTransaction().commit();
		return nyMellemvare;
	}
	public Produkttype createProdukttype(Behandling behandling)
	{
		Produkttype nyProdukttype = new Produkttype();
		nyProdukttype.setBehandling(behandling);
		em.getTransaction().begin();
		em.persist(nyProdukttype);
		em.getTransaction().commit();
		return nyProdukttype;
	}
	public Behandling createBehandling()
	{
		Behandling nyBehandling = new Behandling();
		em.getTransaction().begin();
		em.persist(nyBehandling);
		em.getTransaction().commit();
		return nyBehandling;
	}
	public Delbehandling createDelbehandling()
	{
		Delbehandling nyDelbehandling = new Delbehandling();
		em.getTransaction().begin();
		em.persist(nyDelbehandling);
		em.getTransaction().commit();
		return nyDelbehandling;
	}
	public List<Mellemvare> getKlar()
	{
		return null;
	}
	public List<Mellemvare> getNærOverskredet()
	{
		return null;
	}

}
