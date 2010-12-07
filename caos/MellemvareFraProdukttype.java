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
			ResultSet res=stmt.executeQuery("select m.BATCHNUMMER, d.NAVN, bt.RÆKKEFØLGE, (select COUNT(bt.ID) from BehandlingsTrin bt, Mellemvare_BehandlingsTrin mbt where mbt.Mellemvare_BATCHNUMMER = m.BATCHNUMMER and bt.ID = mbt.behandlingsTrin_ID) from Mellemvare m, Delbehandling d, BehandlingsTrin bt where (m.PRODUKTTYPE_ID, d.ID) in"
					+ "(select Produkttype.ID, bt.DELBEHANDLING_ID from Produkttype where Produkttype.NAVN = '" + produkttype + "' and m.AKTUELBEHANDLINGSTRIN_ID = bt.ID)");
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

