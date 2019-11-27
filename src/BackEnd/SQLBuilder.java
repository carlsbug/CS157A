package BackEnd;
/*
 * Build a relation
 */
import java.sql.*;


public class SQLBuilder
{
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");
	
//	public static String DB_URL = new String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	
	static String[]	Tables = {
			"create table STATE (" +
					"Name varchar(25) not null" + ")"
	};
	static String[]	dropTables = {
			"drop table STATE"
	};

	public static void
	main(String[] args) throws ClassNotFoundException
	{

		// Load the Driver
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName(JDBC_DRIVER);

		try
		{
			// Get a connection from the connection factory
			Connection con = DriverManager.getConnection(
					DB_URL,
					//"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
					USERNAME, PASSWORD);

			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);//////////////////////////?????????????????????????????????????????????????

			// Create a Statement object so we can submit SQL statements to the driver
			Statement stmt = con.createStatement();

			// Submit the statement
			for (int i=0; i<Tables.length; ++i)
			{
				System.out.print(Tables[i] + "...");
				int rowsAffected = stmt.executeUpdate(Tables[i]);
				if (rowsAffected == 0)	// DDL statements return rowcount of 0
					System.out.println("OK");
			}
			// Drop the Table
//			for (int i=0; i<dropTables.length; ++i)
//			{
//				System.out.print(dropTables[i] + "...");
//				int rowsAffected = stmt.executeUpdate(dropTables[i]);
//				if (rowsAffected == 0)	// DDL statements return rowcount of 0
//					System.out.println("OK");
//			}

			// Close the statement
			stmt.close();

			// Close the connection
			con.close();
		}
		catch (SQLException e)
		{
			SQLUtil.printSQLExceptions(e);		
		}
	}	
}
