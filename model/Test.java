package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * @author Peter Runge Christensen
 * @author Jonas Häggqvist
 */
public class Test {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mellemvarelager");
	private EntityManager em = emf.createEntityManager();

	private static Test thisInstance;
	
	/**
	 * @return En instans af Test klassen
	 */
	public static Test getInstance()
	{
		if(thisInstance == null)
			thisInstance = new Test();
		return thisInstance;
	}
	
	/**
	 * Constructor
	 */
	private Test()
	{
		
	}
	
	/**
	 * Opret en mængde testdata i databasen.
	 */
	public void opretTestData() {
		Service service = Service.getInstance();
		Behandling b = service.createBehandling();
		b.setNavn("Drage");
		Behandling b1 = service.createBehandling();
		b1.setNavn("Chokoladeovertrukket skum");
		Behandling b2 = service.createBehandling();
		b2.setNavn("Cremefyldt chokolade");
		Delbehandling d1 = service.createDelbehandling();
		d1.setNavn("Sukkerlag");
		d1.setBehandlingsSted("Hal 1");
		d1.setMinimumTørringsTid(2);
		d1.setOptimalTørringsTid(3);
		d1.setMaksimumTørringsTid(4);
		Delbehandling d2 = service.createDelbehandling();
		d2.setNavn("Cremefyld");
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
		BehandlingDelbehandlingRelation bdr7 = service.createBehandlingDelbehandlingRelation();
		BehandlingDelbehandlingRelation bdr8 = service.createBehandlingDelbehandlingRelation();
		bdr1.setDelbehandling(d1);
		bdr1.setRækkefølge(1);
		bdr2.setDelbehandling(d1);
		bdr1.setRækkefølge(2);
		bdr3.setDelbehandling(d1);
		bdr3.setRækkefølge(3);
		bdr4.setDelbehandling(d3);
		bdr4.setRækkefølge(1);
		bdr5.setDelbehandling(d4);
		bdr5.setRækkefølge(2);
		bdr6.setDelbehandling(d4);
		bdr6.setRækkefølge(3);
		bdr7.setDelbehandling(d2);
		bdr7.setRækkefølge(1);
		bdr8.setDelbehandling(d2);
		bdr8.setRækkefølge(2);
		b1.addBehandlingDelbehandlingRelation(bdr1);
		b1.addBehandlingDelbehandlingRelation(bdr2);
		b1.addBehandlingDelbehandlingRelation(bdr3);
		b.addBehandlingDelbehandlingRelation(bdr4);
		b.addBehandlingDelbehandlingRelation(bdr5);
		b.addBehandlingDelbehandlingRelation(bdr6);
		b2.addBehandlingDelbehandlingRelation(bdr7);
		b2.addBehandlingDelbehandlingRelation(bdr8);
		
		service.gemIDatabase(d1);
		service.gemIDatabase(d2);
		service.gemIDatabase(d3);
		service.gemIDatabase(d4);
		service.gemIDatabase(b);
		service.gemIDatabase(b1);
		service.gemIDatabase(b2);
		service.gemIDatabase(bdr1);
		service.gemIDatabase(bdr2);
		service.gemIDatabase(bdr3);
		service.gemIDatabase(bdr4);
		service.gemIDatabase(bdr5);
		service.gemIDatabase(bdr6);
		service.gemIDatabase(bdr7);
		service.gemIDatabase(bdr8);
		
		Produkttype p = service.createProdukttype(b);
		p.setNavn("Bolcheting");
		Produkttype p1 = service.createProdukttype(b1);
		p1.setNavn("Skumbanan");
		Produkttype p2 = service.createProdukttype(b2);
		p2.setNavn("Frøer");
		service.gemIDatabase(p);
		service.gemIDatabase(p1);
		service.gemIDatabase(p2);
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
	
	/**
	 * Test-metode til hurtige tests
	 */
	public void test()
	{
		em.getTransaction().begin();
		System.out.println(em.createNamedQuery("findMinimumstidOpnået").getResultList());
		System.out.println(em.createNamedQuery("findAlleMellemvarer").getResultList());
	}
	
	/**
	 * Slet alle objekter i databasen.
	 */
	public void sletAlt() {
		em.getTransaction().begin();
		em.createQuery("delete from Mellemvare").executeUpdate();
		em.createQuery("delete from BehandlingsTrin").executeUpdate();
		em.createQuery("delete from Produkttype").executeUpdate();
		em.createQuery("delete from Behandling").executeUpdate();
		em.createQuery("delete from BehandlingsTrin").executeUpdate();
		em.getTransaction().commit();
	}
	
	/**
	 * Sæt alle mellemvarer i databasen til at have opnået deres minimums tørringstid.
	 */
	public void sætAlleKlar() {
		em.getTransaction().begin();
		em.createQuery("update Mellemvare set minimumTørringNået=CURRENT_TIMESTAMP").executeUpdate();
		em.getTransaction().commit();
	}
	
	/**
	 * Main-metode, brugt under test
	 * @param args kommandolinje parametre
	 */
	public static void main(String[] args) {
		getInstance().test();
	}
}
