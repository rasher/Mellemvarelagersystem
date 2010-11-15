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
		b.setNavn("Dragering");
	}
}
