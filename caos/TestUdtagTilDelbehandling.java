/**
 * 
 */
package caos;

import java.util.Scanner;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class TestUdtagTilDelbehandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Test udtagning til delbehandling for samtidig tilgang");
		System.out.print("Indtast batchnummer: ");
		Scanner scanner = new Scanner(System.in);
		int batchnummer = scanner.nextInt();
		TestThread t1 = new TestThread(batchnummer);
		TestThread t2 = new TestThread(batchnummer);
		t1.start();
		t2.start();
	}
}
