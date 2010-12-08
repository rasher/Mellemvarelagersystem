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
		System.out.println("**********************************");
		
		int valg = -1;
		Scanner scanner = new Scanner(System.in);
		while (valg != 99) {
			System.out.println("\nHovedmenu.");
			System.out.println("  1. Udtag vare til delbehandling");
			System.out.println("  2. Vis alle mellemvarer");
			System.out.println("  3. Beregn tid på lager for mellemvare");
			System.out.println("  4. Vis mellemvarer fra produkttype");
			System.out.println("  5. Registrer ny mellemvare");
			System.out.println("  6. Ryd op i gamle data");
			System.out.println(" 80. Test samtidig tilgang af udtag til delbehandling");
			System.out.println(" 81. Opret stored procedure til oprydning af gamle data");
			System.out.println(" 99. Afslut");
			System.out.print("\nVælg ønsket handling: ");
			valg = scanner.nextInt();
			switch (valg) {
			case 1:
				UdtagTilDelbehandling.main(new String[]{});
				break;
			case 2:
				visMellemvarer.main(new String[]{});
				break;
			case 3:
				visMaksimaleLagertiderForMellemvarer.main(new String[]{});
				break;
			case 4:
				MellemvareFraProdukttype.main(new String[]{});
				break;
			case 5:
				OpretMellemvare.registrerNyMellemvare();
				break;
			case 6:
				ExecuteStoredProcedure.main(new String[]{});
				break;
			case 80:
				TestUdtagTilDelbehandling.main(new String[]{});
				break;
			case 81:
				OpretStoredProcedure.main(new String[]{});
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
