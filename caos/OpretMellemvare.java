package caos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		int produktType = vælgProdukttype();
	}

	/**
	 * @return Det indtastede id
	 */
	private static int vælgProdukttype() {
		System.out.println("Produkttyper:");
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT ID, NAVN FROM Produkttype ORDER BY NAVN");
			while (res.next()) {
				String out = String.format("  %2d. %s", res.getInt("ID"), res.getString("NAVN"));
				System.out.println(out);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
