package BackEnd;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class loader {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");

	// public static String DB_URL = new
	// String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");

	public static void main(String[] args) throws ClassNotFoundException {

		String newInput = "";
		String[] InsertRows = { "select * from Patient" };

		for (int i = 0; i < InsertRows.length; ++i) {
			System.out.println(InsertRows[i]);
		}

		try {
			Class.forName(JDBC_DRIVER);
			try {
				// Get a connection from the connection factory
				Connection con = DriverManager.getConnection(DB_URL,
						// "jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
						USERNAME, PASSWORD);

				// Show some database/driver metadata
				SQLUtil.printDriverInfo(con);

				// Create a Statement object so we can submit SQL statements to the driver
				Statement stmt = con.createStatement();

				// Submit the statement
				for (int i = 0; i < InsertRows.length; ++i) {
					System.out.print(InsertRows[i] + "...");
					int rowsAffected = stmt.executeUpdate(InsertRows[i]);
					if (rowsAffected == 1)
						System.out.println("OK");
				}

				// Close the statement
				stmt.close();

				// Close the connection
				con.close();
			} catch (SQLException e1) {
				SQLUtil.printSQLExceptions(e1);
			}

		} // try for Class.forName(JDBC_DRIVER);
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // catch
	}
}
