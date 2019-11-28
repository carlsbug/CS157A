

import java.sql.*;


import BackEndOldVersion.SQLUtil;


public class addPatientTester {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");

	//	public static String DB_URL = new String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/project");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	
	public static void main(String args[]) throws SQLException {
		
		
/* add patient */
		
		/*
		 * 
		insert into Patient(THC, Country_ID,State_ID,ZIP_ID,WStatus_ID,Occup_ID,Surname,First_name) values ('a', 0,0,0,0,0,'Min','Keon');
		insert into Patient(THC, Country_ID,State_ID,ZIP_ID,WStatus_ID,Occup_ID,Surname,First_name) values ('b', 0,0,0,0,0,'last','Mustafa');
		insert into Patient(THC, Country_ID,State_ID,ZIP_ID,WStatus_ID,Occup_ID,Surname,First_name) values ('c', 0,0,0,0,0,'name','Endalk');
		 */
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "keon", "7eu6Y.La=VJh");
		// Create a Statement
		Statement stmt = conn.createStatement();
		//get number of patient enrolled in the database
		int numberRow = 0;
		try {

			ResultSet cset = stmt.executeQuery("SELECT COUNT(*) FROM Patient;");
			while (cset.next()) {
				numberRow = cset.getInt("count(*)");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		String newInput = "";
		String[] InsertRows = {"INSERT INTO Patient(THC, CurrentDate, First_name, Middle_name, Last_name, Date_of_Birth,\n" + 
				"				Gender, Phone, Email, Street_Address, City, State_ID, ZIP_ID, Country_ID , Photo,\n" + 
				"				Social_Security_Number, Insurnace)\n" + 
				"				VALUES('abc','2019-11-01','Keon','middle','Min','1993-03-12','F',415999999,'email','street','city',(SELECT STATE_ID FROM REF_State WHERE Name = 'CALIFORNIA'), \n" + 
				"                (SELECT ZIP_ID FROM REF_Zip WHERE Name = 95112),\n" + 
				"				(SELECT Country_ID FROM REF_Country WHERE Name = 'ETHIOPHIA'),'Photo','SSN','Insurance');"};
		
		for (int a=0; a<InsertRows.length; ++a)
		{
			System.out.println(InsertRows[a]);
		}


		try {
			Class.forName(JDBC_DRIVER);
			try
			{
			          // Get a connection from the connection factory
				Connection con = DriverManager.getConnection(
				DB_URL,
				  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
				USERNAME, PASSWORD);
		
				// Show some database/driver metadata
				SQLUtil.printDriverInfo(con);

				// Create a Statement object so we can submit SQL statements to the driver
//				 stmt = con.createStatement();

				// Submit the statement
				for (int i=0; i<InsertRows.length; ++i)
				{
					System.out.print(InsertRows[i] + "...");
					int rowsAffected = stmt.executeUpdate(InsertRows[i]);
					if (rowsAffected == 1)
						System.out.println("OK");
				}

				// Close the statement
				stmt.close();

				// Close the connection
				con.close();
			}
			catch (SQLException e1)
			{
	          	 	SQLUtil.printSQLExceptions(e1);		
	         }
			
			
		} //try for Class.forName(JDBC_DRIVER);
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch		
}
}
