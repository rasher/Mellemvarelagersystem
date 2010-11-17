/**
 * 
 */
package model;


/**
 * @author Jonas Häggqvist (10dm10v1)
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Service service = Service.getInstance();
		Behandling b = service.createBehandling();
		Behandling b1 = service.createBehandling();
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
		Produkttype p = service.createProdukttype(b);
		Produkttype p1 = service.createProdukttype(b1);
		Mellemvare m = service.createMellemvare(p);
		Mellemvare m1 = service.createMellemvare(p1);
		m.startTørring();
		m1.startTørring();
		
	}
}
