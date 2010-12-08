package caos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class visMaksimaleLagertiderForMellemvarer {
	private static Connection conn;
	private static Scanner scanner;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" ********************************************************");
		System.out.println(" * vis liste over mellemvarer, med maksimale lagertider *");
		System.out.println(" ********************************************************");
		System.out.println("");
		conn = Database.getConnection();
		System.out.println("indtast batchnummer:");
		Scanner scanner = new Scanner(System.in);
		int batchnummer = scanner.nextInt();
		visMellemvarerMedMaksimaleLagertider(batchnummer);
	}

	/**
	 *
	 */
	private static void visMellemvarerMedMaksimaleLagertider(int batchnummer) {
		System.out.println("Batchnummer\t" + "Produkttype\t" + "Maksimal minimumtørringstid\t" + "Maksimal maksimumtørringstid");
		System.out.println("--------------------------------------------------------------------------------------------");
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("select m.BATCHNUMMER, p.NAVN, SUM(d.MINIMUMTØRRINGSTID) as maxmin, SUM(d.MAKSIMUMTØRRINGSTID) as maxmax from Delbehandling d, Mellemvare m, Produkttype p, Mellemvare_BehandlingsTrin mbt, BehandlingsTrin bt where p.ID = m.PRODUKTTYPE_ID AND m.BATCHNUMMER = mbt.Mellemvare_BATCHNUMMER AND mbt.behandlingsTrin_ID = bt.ID AND bt.DELBEHANDLING_ID = d.ID AND m.BATCHNUMMER = " + batchnummer + " Group by m.BATCHNUMMER, p.NAVN;");
			while (res.next()) {
				String out = String.format("  %1$4d\t\t%2$s\t\t%3$4d\t\t\t\t%4$4d", res.getInt("BATCHNUMMER"), res.getString("NAVN"), res.getInt("maxmin"), res.getInt("maxmax"));
				System.out.println(out);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
