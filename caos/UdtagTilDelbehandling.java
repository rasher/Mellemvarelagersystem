/**
 * 
 */
package caos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Jonas Häggqvist (10dm10v1)
 * 
 */
public class UdtagTilDelbehandling {

	public static void main(String[] args) {
		int produktType = OpretMellemvare.vælgProdukttype();
		int mellemvare = vælgMellemvare(produktType);
		udtagTilDelbehandling(mellemvare, false);
	}
	
    public static synchronized void udtagTilDelbehandling(int batchNummer, boolean medPause) {
		Connection conn = Database.getConnection();
		Statement stmt = null;
		try {
			String sql = "";
			stmt = conn.createStatement();
		
			// Hvis der findes en aktuel delbehandling, skal dens slut sættes til nu
			conn.setAutoCommit(false);
			ResultSet aktuelDelbehandling = stmt.executeQuery("select bt.ID as ID, bt.TØRRINGSTART as tørringstart, bt.RÆKKEFØLGE as rækkefølge from BehandlingsTrin bt " +
				"left join Mellemvare_BehandlingsTrin mbt on bt.ID=mbt.behandlingsTrin_ID " +
				"left join Mellemvare m on m.BATCHNUMMER=mbt.Mellemvare_BATCHNUMMER " +
				"where m.BATCHNUMMER=" + batchNummer + " " +
				"and m.AKTUELBEHANDLINGSTRIN_ID=bt.ID");
			int trinNr = 1;
			if (aktuelDelbehandling.next()) {
				// Hvis der er en aktuel delbehandling og den ikke har påbegyndt tørring kan vi
				// ikke fortsætte
				if (aktuelDelbehandling.getTimestamp("tørringstart") == null) {
					System.err.println("Vare er ikke påbegyndt tørring og kan derfor ikke udtages til næste delbehandling");
					stmt.close();
					conn.setAutoCommit(true);
					Database.closeConnection();
					return;
				}
				trinNr = aktuelDelbehandling.getInt("rækkefølge") + 1;
				stmt.executeUpdate("update BehandlingsTrin set slut=current_timestamp where id="+aktuelDelbehandling.getInt("ID"));
			}
			
			// For at teste holder vi her en pause så vi kan se at de to threads
			// ikke tilgår funktionen samtidigt.
			if (medPause) {
				System.out.println(String.format("Pause start: %1$tH:%1$tM:%1$tS.%1$tL", new GregorianCalendar()));
				int k = 1;
				int l = 2;
				Random r = new Random();
				int nymax = (Math.abs(r.nextInt()) % 100000+1) + 20000;
				for (int i=0; i < nymax; i += 1) {
					for (int j=0; j < nymax; j += 1) {
						k = l - k;
						l = k - l;
					}
				}
				System.out.println(String.format("Pause slut: %1$tH:%1$tM:%1$tS.%1$tL", new GregorianCalendar()));
			}
			
			// Sæt aktuelt-behandlingstrin til næste
			// TODO: TJEK AT DER FINDES ET NÆSTE
			sql = String.format("update Mellemvare set aktuelbehandlingstrin_id=(select bt.ID from BehandlingsTrin bt " +
					"left join Mellemvare_BehandlingsTrin mbt on mbt.behandlingsTrin_ID=bt.ID " +
					"left join Mellemvare m on m.BATCHNUMMER=mbt.Mellemvare_BATCHNUMMER " +
					"where m.BATCHNUMMER=%1$d " +
					"and bt.RÆKKEFØLGE=%2$d) where batchnummer=%1$d",
					batchNummer, trinNr
			);
			stmt.executeUpdate(sql);
			
			// Sæt start for det aktuelle behandlingstrin
			sql = String.format("update behandlingstrin set start=current_timestamp where id=(select bt.ID from BehandlingsTrin bt " +
				"left join Mellemvare m on m.AKTUELBEHANDLINGSTRIN_ID=bt.ID " +
				"where m.BATCHNUMMER=%d)",
					batchNummer
			);
			stmt.executeUpdate(sql);
			
			sql = String.format("update Mellemvare set MINIMUMTØRRINGNÅET=null, OPTIMALTØRRINGNÅET=null, MAKSIMUMTØRRINGNÅET=null " +
					"where BATCHNUMMER=%d",
						batchNummer
				);
			stmt.executeUpdate(sql);
			
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Vare udtaget til delbehanlding.");
			stmt.close();
			Database.closeConnection();
		} catch (SQLException e) {
			if (stmt != null) {
				try {
					stmt.execute("ROLLBACK TRANSACTION");
				} catch (SQLException e1) {
					System.err.println("Der opstod en fejl under handlingen:");
					e1.printStackTrace();
				}
			}
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
