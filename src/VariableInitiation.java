import java.sql.*;

public class VariableInitiation {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");

	public static void main(String[] args) throws ClassNotFoundException {

		// Load the Driver
		// Class.forName("oracle.jdbc.driver.OracleDriver");
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
		} 
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
	}

	static String[] InsertRows = { "insert into REF_Occupation values (0,'doctor');\n",
			"insert into REF_Occupation values (1,'eater');\n",
			"insert into REF_Occupation values (2,'luxury bed tester');\n",
			"insert into REF_Occupation values (3,'software developer');\n",
			"insert into REF_Occupation values (4,'teacher');\n",
			"insert into REF_Occupation values (5,'professor');\n",
			"insert into REF_Occupation values (6,'taxi driver');\n",
			"insert into REF_Occupation values (7,'pilot');\n", "insert into REF_Occupation values (8,'student');\n",
			"insert into REF_Occupation values (9,'lawyer');\n", "insert into REF_Zip values (0,'00000');\n",
			"insert into REF_Zip values (1,'95112');\n", "insert into REF_Zip values (2,'95126');\n",
			"insert into REF_Zip values (3,'95555');\n", "insert into REF_Zip values (4,'35007');\n",
			"insert into REF_Zip values (5,'99501');\n", "insert into REF_Zip values (6,'85006');\n",
			"insert into REF_Zip values (7,'95123');\n", "insert into REF_Zip values (8,'95143');\n",
			"insert into REF_Zip values (9,'95512');\n", "insert into REF_Zip values (10,'35237');\n",
			"insert into REF_Zip values (11,'92131');\n", "insert into REF_Zip values (12,'82346');\n",

			"insert into REF_Works values (0,'active');\n", "insert into REF_Works values (1,'not active');\n",

			"insert into REF_State values (0,'arkansas');\n", "insert into REF_State values (1,'california');\n",
			"insert into REF_State values (2,'colorado');\n", "insert into REF_State values (3,'connecticut');\n",
			"insert into REF_State values (4,'delaware');\n", "insert into REF_State values (5,'florida');\n",
			"insert into REF_State values (6,'georgia');\n", "insert into REF_State values (7,'hawaii');\n",
			"insert into REF_State values (8,'idaho');\n", "insert into REF_State values (9,'illinois');\n",
			"insert into REF_State values (10,'indiana');\n", "insert into REF_State values (11,'iowa');\n",
			"insert into REF_State values (12,'kansas');\n", "insert into REF_State values (13,'kentucky');\n",
			"insert into REF_State values (14,'louisiana');\n", "insert into REF_State values (15,'maine');\n",
			"insert into REF_State values (16,'maryland');\n", "insert into REF_State values (17,'massachusetts');\n",
			"insert into REF_State values (18,'michigan');\n", "insert into REF_State values (19,'minnesota');\n",
			"insert into REF_State values (20,'mississippi');\n", "insert into REF_State values (21,'missouri');\n",
			"insert into REF_State values (22,'montana');\n", "insert into REF_State values (23,'nebraska');\n",
			"insert into REF_State values (24,'nevada');\n", "insert into REF_State values (25,'new Hampshire');\n",
			"insert into REF_State values (26,'new Jersey');\n", "insert into REF_State values (27,'new Mexico');\n",
			"insert into REF_State values (28,'new York');\n", "insert into REF_State values (29,'north Carolina');\n",
			"insert into REF_State values (30,'north Dakota');\n", "insert into REF_State values (31,'ohio');\n",
			"insert into REF_State values (32,'oklahoma');\n", "insert into REF_State values (33,'oregon');\n",
			"insert into REF_State values (34,'pennsylvania');\n",
			"insert into REF_State values (35,'rhode Island');\n",
			"insert into REF_State values (36,'south Carolina');\n",
			"insert into REF_State values (37,'south Dakota');\n", "insert into REF_State values (38,'tennessee');\n",
			"insert into REF_State values (39,'texas');\n", "insert into REF_State values (40,'utah');\n",
			"insert into REF_State values (41,'vermont');\n", "insert into REF_State values (42,'virginia');\n",
			"insert into REF_State values (43,'washington');\n", "insert into REF_State values (44,'west Virginia');\n",
			"insert into REF_State values (45,'wisconsin');\n", "insert into REF_State values (46,'wyoming');\n",
			"insert into REF_State values (47,'Alabama');\n", "insert into REF_State values (48,'Alaska');\n",
			"insert into REF_State values (49,'Arizona');\n", "insert into REF_State values (50,'Arkansas');\n",

			"insert into REF_Country values (0,'south korea');\n", "insert into REF_Country values (1,'pakistan');\n",
			"insert into REF_Country values (2,'ethiophia');\n",
			"insert into REF_Country values (3,'united states');\n",
			"insert into REF_Country values (4,'afghanistan');\n", "insert into REF_Country values (5,'albania');\n",
			"insert into REF_Country values (6,'algeria');\n", "insert into REF_Country values (7,'austria');\n",
			"insert into REF_Country values (8,'poland');\n", "insert into REF_Country values (9,'belgium');\n",
			"insert into REF_Country values (10,'brazil');\n", "insert into REF_Country values (11,'canada');\n",
			"insert into REF_Country values (12,'chile');\n", "insert into REF_Country values (13,'china');\n",
			"insert into REF_Country values (14,'colombia');\n", "insert into REF_Country values (15,'costa Rica');\n",
			"insert into REF_Country values (16,'cuba');\n", "insert into REF_Country values (17,'denmark');\n",
			"insert into REF_Country values (18,'dominica');\n", "insert into REF_Country values (19,'egypt');\n",
			"insert into REF_Country values (20,'france');\n", "insert into REF_Country values (21,'greece');\n",
			"insert into REF_Country values (22,'india');\n", "insert into REF_Country values (23,'iran');\n",
			"insert into REF_Country values (24,'italy');\n", "insert into REF_Country values (25,'israel');\n",
			"insert into REF_Country values (26,'liberia');\n", "insert into REF_Country values (27,'mexico');\n",
			"insert into REF_Country values (28,'russia');\n", "insert into REF_Country values (29,'taiwan');\n",
			"insert into REF_Country values (30,'vietnam');\n" };
}
