/**
 * 
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * @author Jonas Häggqvist (10dm10v1)
 * 
 */
public class Test {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mellemvarelager");
	private EntityManager em = emf.createEntityManager();

	private static Test thisInstance;
	
	public static Test getInstance()
	{
		if(thisInstance == null)
			thisInstance = new Test();
		return thisInstance;
	}
	
	private Test()
	{
		
	}
	
	public void opretTestData() {
		Service service = Service.getInstance();
		Behandling b = service.createBehandling();
		b.setNavn("Drage");
		Behandling b1 = service.createBehandling();
		b1.setNavn("Chokoladeovertrukket skum");
		Delbehandling d1 = service.createDelbehandling();
		d1.setNavn("Første sukkerlag");
		d1.setBehandlingsSted("Hal 1");
		d1.setMinimumTørringsTid(2);
		d1.setOptimalTørringsTid(3);
		d1.setMaksimumTørringsTid(4);
		Delbehandling d2 = service.createDelbehandling();
		d2.setNavn("Andet sukkerlag");
		d2.setBehandlingsSted("Hal 2");
		d2.setMinimumTørringsTid(1);
		d2.setOptimalTørringsTid(2);
		d2.setMaksimumTørringsTid(3);
		Delbehandling d3 = service.createDelbehandling();
		d3.setNavn("Skumblanding");
		d3.setBehandlingsSted("Hal 3");
		d3.setMinimumTørringsTid(1);
		d3.setOptimalTørringsTid(2);
		d3.setMaksimumTørringsTid(3);
		Delbehandling d4 = service.createDelbehandling();
		d4.setNavn("Chokoladeovertræk");
		d4.setBehandlingsSted("Hal 4");
		d4.setMinimumTørringsTid(1);
		d4.setOptimalTørringsTid(2);
		d4.setMaksimumTørringsTid(3);
		BehandlingDelbehandlingRelation bdr1 = service.createBehandlingDelbehandlingRelation();
		BehandlingDelbehandlingRelation bdr2 = service.createBehandlingDelbehandlingRelation();
		BehandlingDelbehandlingRelation bdr3 = service.createBehandlingDelbehandlingRelation();
		BehandlingDelbehandlingRelation bdr4 = service.createBehandlingDelbehandlingRelation();
		BehandlingDelbehandlingRelation bdr5 = service.createBehandlingDelbehandlingRelation();
		BehandlingDelbehandlingRelation bdr6 = service.createBehandlingDelbehandlingRelation();
		bdr1.setDelbehandling(d1);
		bdr1.setRækkefølge(1);
		bdr2.setDelbehandling(d1);
		bdr1.setRækkefølge(2);
		bdr3.setDelbehandling(d2);
		bdr3.setRækkefølge(3);
		bdr4.setDelbehandling(d3);
		bdr4.setRækkefølge(4);
		bdr5.setDelbehandling(d4);
		bdr5.setRækkefølge(5);
		bdr6.setDelbehandling(d4);
		bdr6.setRækkefølge(6);
		b1.addBehandlingDelbehandlingRelation(bdr1);
		b1.addBehandlingDelbehandlingRelation(bdr2);
		b1.addBehandlingDelbehandlingRelation(bdr3);
		b.addBehandlingDelbehandlingRelation(bdr4);
		b.addBehandlingDelbehandlingRelation(bdr5);
		b.addBehandlingDelbehandlingRelation(bdr6);
		
		
		service.gemIDatabase(d1);
		service.gemIDatabase(d2);
		service.gemIDatabase(d3);
		service.gemIDatabase(d4);
		service.gemIDatabase(b);
		service.gemIDatabase(b1);
		service.gemIDatabase(bdr1);
		service.gemIDatabase(bdr2);
		service.gemIDatabase(bdr3);
		service.gemIDatabase(bdr4);
		service.gemIDatabase(bdr5);
		service.gemIDatabase(bdr6);
		
		Produkttype p = service.createProdukttype(b);
		p.setNavn("Bolcheting");
		Produkttype p1 = service.createProdukttype(b1);
		p1.setNavn("Skumbanan");
		service.gemIDatabase(p);
		service.gemIDatabase(p1);
		Mellemvare m = service.createMellemvare(p);
		Mellemvare m1 = service.createMellemvare(p1);

	
		
		try {
			service.startDelbehandling(m);
			service.startDelbehandling(m1);
			service.startTørring(m);
			service.startTørring(m1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.gemIDatabase(m);
		service.gemIDatabase(m1);
	}
	
	public void test()
	{
		em.getTransaction().begin();
		System.out.println(em.createNamedQuery("findMinimumstidOpnået").getResultList());
		System.out.println(em.createNamedQuery("findAlleMellemvarer").getResultList());
	}
	
	public void sletAlt() {
		em.getTransaction().begin();
		em.createQuery("delete from Mellemvare").executeUpdate();
		em.createQuery("delete from BehandlingsTrin").executeUpdate();
		em.createQuery("delete from Produkttype").executeUpdate();
		em.createQuery("delete from Behandling").executeUpdate();
		em.createQuery("delete from BehandlingsTrin").executeUpdate();
		em.getTransaction().commit();
	}
	
	public void sætAlleKlar() {
		em.getTransaction().begin();
		em.createQuery("update Mellemvare set minimumTørringNået=CURRENT_TIMESTAMP").executeUpdate();
		em.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		//getInstance().opretTestData();
//		søgMellemvare(13);
//		søgMellemvare(14);
//		søgMellemvare(-60);
		getInstance().test();
	}
}
