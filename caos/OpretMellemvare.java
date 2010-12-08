package caos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class OpretMellemvare {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		registrerNyMellemvare();
	}
	
	/**
	 * 
	 */
	public static void registrerNyMellemvare() {
		System.out.println(" ***************************");
		System.out.println(" * Registrer ny mellemvare *");
		System.out.println(" ***************************");
		System.out.println("");
		int produktType = vælgProdukttype();
		int batchNummer = opretMellemvare(produktType);
		System.out.println("Mellemvare oprettet med batchnummer: " + batchNummer);
	}

	/**
	 * @param produktType
	 * @return
	 */
	private static int opretMellemvare(int produktType) {
		int mellemvareBatchnummer = -1;
		try {
			Connection conn = Database.getConnection();
			Statement stmt = conn.createStatement();
			mellemvareBatchnummer = næsteNøgle("Mellemvare", "BATCHNUMMER");
			stmt.execute("BEGIN TRANSACTION");
			stmt.executeUpdate("INSERT INTO Mellemvare (BATCHNUMMER, PRODUKTTYPE_ID) VALUES ("+mellemvareBatchnummer+", "+produktType+")", Statement.RETURN_GENERATED_KEYS);
			ResultSet delbehandlinger = stmt.executeQuery(
					"select d.NAVN as navn, d.id as id, bd.RÆKKEFØLGE as rækkefølge, d.MINIMUMTØRRINGSTID as minimumtørringstid, d.OPTIMALTØRRINGSTID as optimaltørringstid, d.MAKSIMUMTØRRINGSTID as maksimumtørringstid from Produkttype p " +
					"left join Behandling b on p.BEHANDLING_NR=b.NR " +
					"left join Behandling_Behandling_Delbehandling bbd on bbd.Behandling_NR=b.NR " +
					"left join Behandling_Delbehandling bd on bd.ID=bbd.behandlingDelbehandlingRelationer_ID " +
					"left join Delbehandling d on d.ID=bd.DELBEHANDLING_ID " +
					"where p.ID=" + produktType + " " +
					"ORDER BY bd.RÆKKEFØLGE");
			
			int næsteNøgle;
			int førsteBehandlingsTrin = næsteNøgle = næsteNøgle("BehandlingsTrin", "ID");
			while (delbehandlinger.next()) {
				Statement opdaterStmt = conn.createStatement();
				opdaterStmt.executeUpdate("INSERT INTO BehandlingsTrin (ID, RÆKKEFØLGE, DELBEHANDLING_ID) VALUES ("+næsteNøgle+", "+delbehandlinger.getInt("rækkefølge")+", "+delbehandlinger.getInt("id")+")");
				opdaterStmt.executeUpdate("INSERT INTO Mellemvare_BehandlingsTrin (Mellemvare_BATCHNUMMER, behandlingsTrin_ID) VALUES ("+mellemvareBatchnummer+", "+næsteNøgle+")");
				if (næsteNøgle == førsteBehandlingsTrin) {
					opdaterStmt.executeUpdate("UPDATE Mellemvare SET AKTUELBEHANDLINGSTRIN_ID="+førsteBehandlingsTrin+", MINIMUMTØRRINGNÅET=DATEADD(hour, "+delbehandlinger.getInt("minimumtørringstid")+", current_timestamp), OPTIMALTØRRINGNÅET=DATEADD(hour, "+delbehandlinger.getInt("optimaltørringstid")+", current_timestamp), MAKSIMUMTØRRINGNÅET=DATEADD(hour, "+delbehandlinger.getInt("maksimumtørringstid")+", current_timestamp) WHERE BATCHNUMMER="+mellemvareBatchnummer);
					opdaterStmt.executeUpdate("UPDATE BehandlingsTrin SET START=current_timestamp, TØRRINGSTART=current_timestamp WHERE ID="+førsteBehandlingsTrin);
				}
				næsteNøgle += 1;
			}
			stmt.execute("COMMIT TRANSACTION");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mellemvareBatchnummer;
	}

	/**
	 * @param tabel
	 * @param column
	 * @return Næste værdi af den numeriske kolonne column i tabellen tabel
	 */
	public static int næsteNøgle(String tabel, String column) {
		int næsteNøgle = -1;
			Statement stmt;
			try {
				Connection conn = Database.getConnection();
				stmt = conn.createStatement();
				ResultSet res = stmt.executeQuery("SELECT MAX("+column+")+1 as næsteNøgle FROM " + tabel);
				res.next();
				næsteNøgle = res.getInt("næsteNøgle");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return næsteNøgle;
	}

	/**
	 * Præsenter en liste af produkttyper og bed brugeren om at indtaste
	 * nummeret på en produkttype.
	 * 
	 * @return Det indtastede id
	 */
	public static int vælgProdukttype() {
		System.out.println("Produkttyper:");
		ArrayList<Integer> produkttyper = new ArrayList<Integer>();
		int produktType = -1;
		try {
			Connection conn = Database.getConnection();
			Scanner scanner = new Scanner(System.in);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT ID, NAVN FROM Produkttype ORDER BY NAVN");
			while (res.next()) {
				String out = String.format("  %2d. %s", res.getInt("ID"), res.getString("NAVN"));
				System.out.println(out);
				produkttyper.add(Integer.valueOf(res.getInt("ID")));
			}
			while (!produkttyper.contains(Integer.valueOf(produktType))) {
				System.out.print("Vælg produkttypenr: ");
				produktType = scanner.nextInt();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produktType;
	}
}
