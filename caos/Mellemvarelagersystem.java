/**
 * 
 */
package caos;

import java.util.Scanner;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class Mellemvarelagersystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("**********************************");
		System.out.println("* Carletti mellemvarelagersystem *");
		System.out.println("**********************************\n");
		
		int valg = -1;
		Scanner scanner = new Scanner(System.in);
		while (valg != 99) {
			System.out.println("Hovedmenu. Vælg ønsket handling:");
			System.out.println(" 1. Udtag vare til delbehandling");
			System.out.println(" 2. Vis alle mellemvarer");
			System.out.println(" 3. Beregn tid på lager for mellemvare");
			System.out.println(" 4. Vis mellemvarer fra produkttype");
			System.out.println(" 5. Registrer ny mellemvare");
			System.out.println(" 6. Ryd op i gamle data");
			System.out.println("99. Afslut");
			valg = scanner.nextInt();
			switch (valg) {
			case 5:
				OpretMellemvare.registrerNyMellemvare();
				break;
			case 4:
				MellemvareFraProdukttype.main(new String[]{});
				break;
			case 3:
				break;
			case 2:
				visMellemvarer.main(new String[]{});
				break;
			case 1:
				UdtagTilDelbehandling.udtagTilDelbehandling();
				break;
			case 99:
				break;
			default:
				System.err.println("Ugyldigt valg.");
				break;
			}
		}
	}
}
