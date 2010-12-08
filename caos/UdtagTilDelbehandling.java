/**
 * 
 */
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
public class UdtagTilDelbehandling {

	public static void main(String[] args) {
		udtagTilDelbehandling();
	}
	
	public static void udtagTilDelbehandling() {
		Connection conn = Database.getConnection();
		try {
			String sql = "";
			Statement stmt = conn.createStatement();
			int produktType = OpretMellemvare.vælgProdukttype();
			/*
			 * Indlæs mellemvare id Vælg aktuelBehandlingsTrin if
			 * aktuelBehandlingsTrin != null or
			 * aktuelBehandlingsTrin.tørringsstart != null
			 */
			int mellemvare = vælgMellemvare(produktType);
			
			// Hvis der findes en aktuel delbehandling, skal dens slut sættes til nu
			stmt.execute("BEGIN TRANSACTION");
			ResultSet aktuelDelbehandling = stmt.executeQuery("select bt.ID as ID, bt.TØRRINGSTART as tørringstart, bt.RÆKKEFØLGE as rækkefølge from BehandlingsTrin bt " +
				"left join Mellemvare_BehandlingsTrin mbt on bt.ID=mbt.behandlingsTrin_ID " +
				"left join Mellemvare m on m.BATCHNUMMER=mbt.Mellemvare_BATCHNUMMER " +
				"where m.BATCHNUMMER=" + mellemvare + " " +
				"and m.AKTUELBEHANDLINGSTRIN_ID=bt.ID");
			int trinNr = 1;
			if (aktuelDelbehandling.next()) {
				// Hvis der er en aktuel delbehandling og den ikke har påbegyndt tørring kan vi
				// ikke fortsætte
				if (aktuelDelbehandling.getTimestamp("tørringstart") == null) {
					System.err.println("Vare er ikke påbegyndt tørring og kan derfor ikke udtages til næste delbehandling");
					stmt.close();
					Database.closeConnection();
					return;
				}
				trinNr = aktuelDelbehandling.getInt("rækkefølge") + 1;
				stmt.executeUpdate("update BehandlingsTrin set slut=current_timestamp where id="+aktuelDelbehandling.getInt("ID"));
			}
			
			// Sæt aktuelt-behandlingstrin til næste
			sql = String.format("update Mellemvare set aktuelbehandlingstrin_id=(select bt.ID from BehandlingsTrin bt " +
					"left join Mellemvare_BehandlingsTrin mbt on mbt.behandlingsTrin_ID=bt.ID " +
					"left join Mellemvare m on m.BATCHNUMMER=mbt.Mellemvare_BATCHNUMMER " +
					"where m.BATCHNUMMER=%1$d " +
					"and bt.RÆKKEFØLGE=%2$d) where batchnummer=%1$d",
					mellemvare, trinNr
			);
			stmt.executeUpdate(sql);
			
			// Sæt start for det aktuelle behandlingstrin
			sql = String.format("update behandlingstrin set start=current_timestamp where id=(select bt.ID from BehandlingsTrin bt " +
				"left join Mellemvare m on m.AKTUELBEHANDLINGSTRIN_ID=bt.ID " +
				"where m.BATCHNUMMER=%d)",
					mellemvare
			);
			stmt.executeUpdate(sql);
			stmt.execute("COMMIT TRANSACTION");
			System.out.println("Vare udtaget til delbehanlding.");
			stmt.close();
			Database.closeConnection();
		} catch (SQLException e) {
			System.err.println("Der opstod en fejl under handlingen:");
			e.printStackTrace();
		}
	}

	/**
	 * @param produktType
	 * @return
	 */
	private static int vælgMellemvare(int produktType) {
		int mellemvare = -1;
		Scanner scanner = new Scanner(System.in);
		Connection conn = Database.getConnection();
		try {
			System.out.println("Mellemvarer:");
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT BATCHNUMMER FROM Mellemvare WHERE PRODUKTTYPE_ID="+produktType);
			while (res.next()) {
				System.out.println(String.format("  %4d.", res.getInt("BATCHNUMMER")));
			}
			System.out.print("Indtast batchnummer: ");
			mellemvare = scanner.nextInt();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mellemvare;
	}
}
