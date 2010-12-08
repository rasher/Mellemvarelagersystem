package caos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.CallableStatement;

public class ExecuteStoredProcedure {
	public static void main(String[] args)
	{
		try 
		{
			Connection minConnection;
			minConnection = Database.getConnection();
			java.sql.CallableStatement cstmt = minConnection.prepareCall("{EXECUTE sletdata}");
			System.out.println("Opret Stored procedure: ");
			ResultSet res= cstmt.executeQuery();
			System.out.println("Stored procedure oprettet!");
			while (res.next()) {
				System.out.println("Batchnummer: " + res.getString(1) + "\t Delbehandingsnavn: " + res.getString(2)+ "\t Delbehanding: " 
						+ res.getString(3) + " ud af " + res.getString(4));
			}
			if(res != null)
				res.close();
			if (cstmt != null) cstmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
}
