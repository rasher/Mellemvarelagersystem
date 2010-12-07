package caos;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Jonas Häggqvist
 */
public class Database {
	private static Connection connection;

	/**
	 * Få en instans af Service klassen
	 * 
	 * @return Service klasse objekt
	 */
	public static Connection getConnection() {
		String filnavn = "jdbcsettings.txt";
		if (connection == null) {
			Scanner scanner;
			try {
				scanner = new Scanner(new File(filnavn));
				Class.forName(scanner.nextLine());
				connection = DriverManager.getConnection(scanner.nextLine());
			} catch (FileNotFoundException e) {
				System.err.println("Indsæt din jdbc url i filen " + filnavn);
			} catch (SQLException e) {
				System.err.println("Kunne ikke forbinde til databasen");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println("Ugyldig klassenavn");
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Kunne ikke lukke databaseforbindelse");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Constructor
	 */
	private Database() {

	}

	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println("Forbindelse oprettet: " + conn);
		closeConnection();
	}
}
