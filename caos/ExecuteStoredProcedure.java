package caos;

import java.sql.Connection;

public class ExecuteStoredProcedure {
	public static void main(String[] args)
	{
		try 
		{
			Connection minConnection;
			minConnection = Database.getConnection();
			java.sql.CallableStatement cstmt = minConnection.prepareCall("EXECUTE sletdata");
			System.out.println("Kald stored procedure: ");
			cstmt.execute();
			System.out.println("Stored procedure kaldt!");
			if (cstmt != null) cstmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
}
