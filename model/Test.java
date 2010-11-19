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
	
	public static void opretTestData() {
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
		b.addDelbehandling(d1);
		b.addDelbehandling(d2);
		b1.addDelbehandling(d3);
		b1.addDelbehandling(d4);
		
		service.gemIDatabase(d1);
		service.gemIDatabase(d2);
		service.gemIDatabase(d3);
		service.gemIDatabase(d4);
		service.gemIDatabase(b);
		service.gemIDatabase(b1);
		Produkttype p = service.createProdukttype(b);
		p.setNavn("Bolcheting");
		Produkttype p1 = service.createProdukttype(b1);
		p1.setNavn("Skumbanan");
		service.gemIDatabase(p);
		service.gemIDatabase(p1);
		Mellemvare m = service.createMellemvare(p);
		Mellemvare m1 = service.createMellemvare(p1);

	
		
		try {
			m.startDelbehandling();
			m1.startDelbehandling();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.startTørring();
		m1.startTørring();
		service.gemIDatabase(m);
		service.gemIDatabase(m1);
	}
	
	public static void main(String[] args) {
		opretTestData();
//		søgMellemvare(13);
//		søgMellemvare(14);
//		søgMellemvare(-60);
	}
}
