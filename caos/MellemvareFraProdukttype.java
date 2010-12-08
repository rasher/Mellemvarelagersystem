package caos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MellemvareFraProdukttype
{
	public static void main(String[] args)
	{
		try 
		{
			Connection minConnection;
			minConnection = Database.getConnection();
			Statement stmt = minConnection.createStatement();
			System.out.println("Indtast produkttype: ");
			BufferedReader lineIn = new BufferedReader(new InputStreamReader(System.in));
			String produkttype= lineIn.readLine();
			System.out.println("Tilknyttet mellemvarer: ");
			ResultSet res=stmt.executeQuery("SELECT m.BATCHNUMMER, d.NAVN, bt.RÆKKEFØLGE, (SELECT COUNT(*) FROM " +
     "Mellemvare_BehandlingsTrin mbt, BehandlingsTrin bt WHERE mbt.Mellemvare_BATCHNUMMER=m.BATCHNUMMER " +
     "AND mbt.behandlingsTrin_ID=bt.ID) as ANTALTRIN FROM Produkttype p RIGHT JOIN Mellemvare m ON p.ID = m.PRODUKTTYPE_ID " +
     "RIGHT JOIN BehandlingsTrin bt ON bt.ID = m.AKTUELBEHANDLINGSTRIN_ID RIGHT JOIN Delbehandling d ON d.ID = bt.DELBEHANDLING_ID " +
     "WHERE p.NAVN = '" + produkttype +"';");
			while (res.next()) {
				System.out.println("Batchnummer: " + res.getString(1) + "\t Delbehandingsnavn: " + res.getString(2)+ "\t Delbehanding: " 
						+ res.getString(3) + " ud af " + res.getString(4));
			}
			if (res != null) res.close();
			if (stmt != null) stmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
}

