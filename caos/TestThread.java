/**
 * 
 */
package caos;

import java.util.GregorianCalendar;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class TestThread extends Thread {
	private int batchNummer;

	public TestThread(int batchNummer) {
		super();
		this.batchNummer = batchNummer;
	}
	
	public void run() {
		System.out.println(String.format("Thread startet: %1$tH:%1$tM:%1$tS.%1$tL", new GregorianCalendar()));
		UdtagTilDelbehandling.udtagTilDelbehandling(batchNummer, true);
		System.out.println(String.format("Thread sluttet: %1$tH:%1$tM:%1$tS.%1$tL", new GregorianCalendar()));
	}
}
