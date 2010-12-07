package caos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class visMellemvarer {
	private static Connection conn;
	private static Scanner scanner;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" ****************************");
		System.out.println(" * Vis liste af mellemvarer *");
		System.out.println(" ****************************");
		System.out.println("");
		conn = Database.getConnection();
		visMellemvarer();
	}

	/**
	 *
	 */
	private static void visMellemvarer() {
		System.out.println("Mellemvarer:");
		System.out.println("");
		System.out.println("Batchnummer\t" + "Minimumtørring nået\t" + "optimaltørring nået\t" + "maksimumtørring nået\t" + "Tid til maksimumtørring er nået\t");
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("	select BATCHNUMMER, MINIMUMTØRRINGNÅET, OPTIMALTØRRINGNÅET, MAKSIMUMTØRRINGNÅET, DATEDIFF(mi, current_timestamp, MAKSIMUMTØRRINGNÅET) as TidTilMaks from Mellemvare where MAKSIMUMTØRRINGNÅET not like 'null' Order By TidTilMaks;");
			while (res.next()) {
				String out = String.format("  %1$4d %2$tm %2$te,%2$tY - %2$tH:%2$tM %3$tm %3$te,%3$tY - %3$tH:%3$tM %4$tm %4$te,%4$tY - %4$tH:%4$tM %5$5d", res.getInt("BATCHNUMMER"), res.getDate("MINIMUMTØRRINGNÅET"), res.getDate("OPTIMALTØRRINGNÅET"), res.getDate("MAKSIMUMTØRRINGNÅET"), res.getInt("TidTilMaks"));
				System.out.println(out);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
