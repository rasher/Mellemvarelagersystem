package caos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class visMellemvarer {
	private static Connection conn;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" ****************************");
		System.out.println(" * Vis liste af mellemvarer *");
		System.out.println(" ****************************");
		System.out.println("");
		conn = Database.getConnection();
		visMellemvareListe();
	}

	/**
	 *
	 */
	private static void visMellemvareListe() {
		System.out.println("Batchnummer\t" + "Minimumtørring nået\t" + "optimaltørring nået\t" + "maksimumtørring nået\t" + "Tid til maksimumtørring er nået\t");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("	select BATCHNUMMER, MINIMUMTØRRINGNÅET, OPTIMALTØRRINGNÅET, MAKSIMUMTØRRINGNÅET, DATEDIFF(mi, current_timestamp, MAKSIMUMTØRRINGNÅET) as TidTilMaks from Mellemvare where MAKSIMUMTØRRINGNÅET not like 'null' Order By TidTilMaks;");
			while (res.next()) {
				String out = String.format("  %1$4d\t\t%2$te/%2$tm/%2$tY - %2$tH:%2$tM\t%3$te/%3$tm/%3$tY - %3$tH:%3$tM\t%4$te/%4$tm/%4$tY - %4$tH:%4$tM\t\t%5$5d minutter", res.getInt("BATCHNUMMER"), res.getTimestamp("MINIMUMTØRRINGNÅET"), res.getTimestamp("OPTIMALTØRRINGNÅET"), res.getTimestamp("MAKSIMUMTØRRINGNÅET"), res.getInt("TidTilMaks"));
				System.out.println(out);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
