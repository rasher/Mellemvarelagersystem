package caos;

import java.sql.Connection;
import java.util.Scanner;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class OpretMellemvare {
	private static Connection conn;
	private static Scanner scanner;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" ***************************");
		System.out.println(" * Registrer ny mellemvare *");
		System.out.println(" ***************************");
		System.out.println("");
		scanner = new Scanner(System.in);
		conn = Database.getConnection();
	}
}
