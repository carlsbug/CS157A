/*
 * Build a relation
 */
import java.sql.*;

public class buildTables
{
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");
	
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	
	public static void
	main(String[] args) throws ClassNotFoundException
	{
		 String TableList[][] = new String[7][];
		 TableList[0] = new String[] {"CREATE TABLE REF_Occupation(\n" + 
		 		"	Occup_ID SMALLINT not null,\n" + 
		 		"	Name VARCHAR(25),\n" + 
		 		"	PRIMARY KEY(Occup_ID)\n" + 
		 		");"};
		 TableList[1] = new String[] {"CREATE TABLE REF_Works(\n" + 
		 		"	WStatus_ID SMALLINT not null,\n" + 
		 		"	Name VARCHAR(25),\n" + 
		 		"	PRIMARY KEY(WStatus_ID)\n" + 
		 		");"};
		 TableList[2] = new String[] {"CREATE TABLE REF_State(\n" + 
		 		"	State_ID SMALLINT  not null,\n" + 
		 		"	Name VARCHAR(25),\n" + 
		 		"	PRIMARY KEY(State_ID)\n" + 
		 		");"};
		 TableList[3] = new String[] {"CREATE TABLE REF_Country(\n" + 
		 		"	Country_ID SMALLINT  not null,\n" + 
		 		"	Name VARCHAR(25),\n" + 
		 		"	PRIMARY KEY(Country_ID)\n" + 
		 		");"};
		 TableList[4] = new String[] {"CREATE TABLE REF_Zip(\n" + 
		 		"	ZIP_ID SMALLINT not null,\n" + 
		 		"	Name VARCHAR(25),\n" + 
		 		"	PRIMARY KEY(ZIP_ID)\n" + 
		 		");"};
		 TableList[5] = new String[] {"CREATE TABLE Patient(\n" + 
		 		"	THC varchar(6) not null,\n" + 
		 		"	CurrentDate DATE,\n" + 
		 		"	First_name VARCHAR(15) not null,\n" + 
		 		"	Middle_name VARCHAR(15),\n" + 
		 		"	Last_name VARCHAR(15) not null,\n" + 
		 		"	Date_of_Birth DATE not null,\n" + 
		 		"	Gender VARCHAR(1) not null,\n" + 
		 		"	Phone VARCHAR(14) not null,\n" + 
		 		"	Email VARCHAR(50),\n" + 
		 		"	Street_Address VARCHAR(60) not null,\n" + 
		 		"	City VARCHAR(30) not null,\n" + 
		 		"	State_ID SMALLINT,\n" + 
		 		"	ZIP_ID SMALLINT not null,\n" + 
		 		"	Country_ID SMALLINT not null,\n" + 
		 		"	Photo VARCHAR(1000),\n" + 
		 		"	Social_Security_Number VARCHAR(10),\n" + 
		 		"	Insurnace VARCHAR(10),\n" + 
		 		"\n" + 
		 		"  -- Demographic\n" + 
		 		"	WStatus_ID SMALLINT,\n" + 
		 		"	Occup_ID SMALLINT,\n" + 
		 		"	Educational_Degree VARCHAR(10),\n" + 
		 		"	Tin_background CHAR(1),\n" + 
		 		"	H_background CHAR(1),\n" + 
		 		"	Tin_When Date,\n" + 
		 		"	H_When Date,\n" + 
		 		"	-- T_lnd_comments VARCHAR(10000),\n" + 
		 		"	-- H_lnd_comments VARCHAR(10000)\n" + 
		 		"	--\n" + 
		 		"	-- Tinnitus_Onset VARCHAR(10),\n" + 
		 		"	-- Tinnitus_Etiology VARCHAR(10),\n" + 
		 		"	-- Hyperacusis_Onset VARCHAR(10),\n" + 
		 		"	-- Hyperacusis_Etiology VARCHAR(10),\n" + 
		 		"\n" + 
		 		"\n" + 
		 		"	CONSTRAINT PK_PATIENT PRIMARY KEY (THC),\n" + 
		 		"	CONSTRAINT FK_PATIENT_REFERENCE_REF_COUN FOREIGN KEY(Country_ID) REFERENCES REF_Country(Country_ID) ON UPDATE CASCADE\n" + 
		 		"	ON DELETE CASCADE,\n" + 
		 		"	CONSTRAINT FK_PATIENT_REFERENCE_REF_STAT FOREIGN KEY(State_ID) REFERENCES REF_State(State_ID) ON UPDATE CASCADE\n" + 
		 		"	ON DELETE CASCADE,\n" + 
		 		"	CONSTRAINT FK_PATIENT_REFERENCE_REF_ZIP FOREIGN KEY(ZIP_ID) REFERENCES REF_Zip(ZIP_ID) ON UPDATE CASCADE\n" + 
		 		"	ON DELETE CASCADE,\n" + 
		 		"	CONSTRAINT FK_PATIENT_REFERENCE_REF_WORK FOREIGN KEY(WStatus_ID) REFERENCES REF_Works(WStatus_ID) ON UPDATE CASCADE\n" + 
		 		"	ON DELETE CASCADE,\n" + 
		 		"	CONSTRAINT FK_PATIENT_REFERENCE_REF_OCCU FOREIGN KEY(Occup_ID) REFERENCES REF_Occupation(Occup_ID) ON UPDATE CASCADE\n" + 
		 		"	ON DELETE CASCADE\n" + 
		 		");"};
		 TableList[6] = new String[] {"CREATE TABLE Visit(\n" + 
		 		"	Visit_ID INTEGER not null,\n" + 
		 		"	THC VARCHAR(1) not null,\n" + 
		 		"	Visit_nr SMALLINT not null,\n" + 
		 		"	Date DATETIME not null,\n" + 
		 		"	Comments VARCHAR(150),\n" + 
		 		"\n" + 
		 		"	CONSTRAINT PK_VISIT PRIMARY KEY (Visit_ID),\n" + 
		 		"	CONSTRAINT FK_VISIT_REFERENCE_PATIENT FOREIGN KEY(THC) REFERENCES Patient(THC) ON UPDATE CASCADE\n" + 
		 		"	ON DELETE CASCADE\n" + 
		 		");"};

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
//			for (int i=0; i<TableList.length; ++i)
//			{
//				System.out.print(TableList[i] + "...");
//				int rowsAffected = stmt.executeUpdate(TableList[i]);
//				if (rowsAffected == 0)	// DDL statements return rowcount of 0
//					System.out.println("OK");
//			}
			String temp = "";
			 for(int i = 0; i < TableList.length; i++)
			 {
			     for(int j = 0; j < TableList[i].length; j++)
			     {
			         System.out.print(TableList[i][j]);
					 temp = temp + TableList[i][j];
			     }
			int rowsAffected = stmt.executeUpdate(temp);
			if (rowsAffected == 0)	// DDL statements return rowcount of 0
				System.out.println("OK");
			    temp = "";
			 }

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
