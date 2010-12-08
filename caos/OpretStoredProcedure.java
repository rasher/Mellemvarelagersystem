package caos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OpretStoredProcedure {
	public static void main(String[] args)
	{
		try 
		{
			Connection minConnection;
			minConnection = Database.getConnection();
			Statement stmt = minConnection.createStatement();
			System.out.println("Opret Stored procedure: ");
			boolean res=stmt.execute("create PROCEDURE sletdata as BEGIN delete from Produkttype_Mellemvare " +
					"where Produkttype_Mellemvare.mellemvarer_BATCHNUMMER in (select Mellemvare.BATCHNUMMER " +
					"from Mellemvare where Mellemvare.AKTUELBEHANDLINGSTRIN_ID IS NULL OR Mellemvare.MAKSIMUMTØRRINGNÅET < CURRENT_TIMESTAMP); " +
					"delete from Mellemvare_BehandlingsTrin where Mellemvare_BehandlingsTrin.Mellemvare_BATCHNUMMER in (select Mellemvare.BATCHNUMMER " +
					"from Mellemvare where Mellemvare.AKTUELBEHANDLINGSTRIN_ID IS NULL or Mellemvare.MAKSIMUMTØRRINGNÅET < CURRENT_TIMESTAMP); " +
					"delete from Mellemvare where Mellemvare.AKTUELBEHANDLINGSTRIN_ID IS NULL or Mellemvare.MAKSIMUMTØRRINGNÅET < CURRENT_TIMESTAMP; " +
					"delete from BehandlingsTrin where BehandlingsTrin.ID not in (select Mellemvare_BehandlingsTrin.behandlingsTrin_ID from Mellemvare_BehandlingsTrin); " +
					"END");
			System.out.println("Stored procedure oprettet!");
			//if (res != null) res.close();
			if (stmt != null) stmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
}
