import java.sql.*;
import java.util.Arrays;

public class updatePatient {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		/* Get number of tuples */
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect																// database
		Statement tempStmt = conn.createStatement();// Create a Statement
		int numberRow = 0; // get number of tuples enrolled in a table
		try {
			ResultSet cset = tempStmt.executeQuery("SELECT COUNT(*) FROM Patient;");
			while (cset.next()) {
				numberRow = cset.getInt("count(*)");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		/* Get number of tuples */
		//print out number of tuples
//		System.out.println("tuple: " + numberRow);
		
		
		/* Select all patients*/
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(
		"SELECT p.THC, p.CurrentDate, p.First_name, p.Middle_name, p.Last_name, p.Date_of_Birth,\n"
		+ "p.Gender, p.Phone, p.Email, p.Street_Address, p.City, (SELECT Name FROM REF_State WHERE State_ID = p.State_ID),\n" + 
		"(SELECT Name FROM REF_Zip WHERE ZIP_ID = p.ZIP_ID) ,(SELECT Name FROM REF_Country WHERE Country_ID = p.Country_ID), p.Photo,\n"
		+ "p.Social_Security_Number, p.Insurnace\n"
		+ "FROM Patient p;");
		String patients[][] = new String[numberRow][];
		int i = 0;
		while (rset.next() && i < numberRow) {
			String THC = rset.getString(1);
			String currentDate = rset.getString(2);
			String firstName = rset.getString(3);
			String middleName = rset.getString(4);
			String lastName = rset.getString(5);
			String DOB = rset.getString(6);
			String gender = rset.getString(7);
			String phone = rset.getString(14);
			String email = rset.getString(9);
			String streetAddr = rset.getString(10);
			String city = rset.getString(11);
			String state = rset.getString(12);
			String zip = rset.getString(13);
			String country = rset.getString(14);
			String photo = rset.getString(15);
			String SSN = rset.getString(16);
			String insurance = rset.getString(17);
			patients[i] = new String[] { THC, currentDate, firstName, middleName, lastName, DOB, gender,
					phone, email, streetAddr, city, state, zip, country, photo, SSN, insurance };
			i++;

		}
		/* Select all patients*/
		//print out all patients
		 for (int j = 0; j < numberRow; j++)
		 System.out.println(Arrays.toString(patients[j]));
		
		/* Get changed array*/
		
		
		
		
		
		
		
		/* Get changed array*/
		
		/* Update patient */
//		String sql = "UPDATE Patient p\n"
//		+ "SET p.THC=?, p.First_name=?, p.Middle_name=?, p.Last_name=?, p.Date_of_Birth=?,"
//		+ "p.Gender=?, p.Phone=?, p.Email=?, p.Street_Address=?, p.City=?, SELECT State_ID FROM REF_State WHERE Name =?, "
//		+ "(SELECT ZIP_ID FROM REF_Zip WHERE Name = p.ZIP_ID)=?, (SELECT Country_ID FROM REF_Country WHERE Name =?, p.Photo=?,"
//		+ "p.Social_Security_Number=?, p.Insurnace=?" + "WHERE THC =?";
		 
//		String sql = "UPDATE Patient p\n"
//		+ "SET p.First_name=?, p.Last_name=?,  SELECT State_ID FROM REF_State WHERE Name =?,"
//		+ "p.Gender=?, p.City=?, "
//		+ "WHERE THC =?";
			String sql = "UPDATE Patient p\n"
					+ "SET p.THC=?, p.First_name=?, p.Last_name=?, State_ID = (SELECT State_ID from REF_State where Name = ?), p.Gender =?, p.city =?"
					 + "WHERE THC =?";

		for (int k = 0; k < numberRow; k++) {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
//			preparedStatement.setString(1, patients[k][0]);//// THC
//			preparedStatement.setString(2, patients[k][2]); // firstName list[k][2]
//			preparedStatement.setString(3, (patients[k][3])); // Middle_name
//			preparedStatement.setString(4, (patients[k][4])); // Last_name
//			preparedStatement.setString(5, (patients[k][5])); // Date_of_Birth
//			preparedStatement.setString(6, (patients[k][6])); // Gender
//			preparedStatement.setString(7, patients[k][7]);// Phone
//			preparedStatement.setString(8, (patients[k][8]));// Email
//			preparedStatement.setString(9, patients[k][9]);// Street_Address
//			preparedStatement.setString(10, patients[k][10]);// City
//			preparedStatement.setString(11, patients[k][11]);// state
//			preparedStatement.setString(12, patients[k][12]);// zip
//			preparedStatement.setString(13, patients[k][13]);// country
//			preparedStatement.setString(14, patients[k][14]);// photo
//			preparedStatement.setString(15, patients[k][15]);// SSN
//			preparedStatement.setString(16, patients[k][16]);// insurance
//			preparedStatement.setString(17, patients[k][0]);//// THC
			preparedStatement.setString(1, patients[k][0]);//// THC
			preparedStatement.setString(2,  patients[k][2]); // firstName list[k][2]
			preparedStatement.setString(3, patients[k][4]); // last
			preparedStatement.setString(4, patients[k][11]);//// state
			preparedStatement.setString(5,  patients[k][6]);//gender
			preparedStatement.setString(6,  patients[k][10]);
			preparedStatement.setString(7,  patients[k][0]);
			preparedStatement.executeUpdate();
	


		}
		
//		rset = stmt.executeQuery("select * from Patient");
		/* Update patient */
		
	/* Check if it is updated*/
		// print out updated values to test
		i = 0;
		while (rset.next() && i < numberRow) {
			String THC = rset.getString(1);
			String currentDate = rset.getString(2);
			String firstName = rset.getString(3);
			String middleName = rset.getString(4);
			String lastName = rset.getString(5);
			String DOB = rset.getString(6);
			String gender = rset.getString(7);
			String phone = rset.getString(8);
			String email = rset.getString(9);
			String streetAddr = rset.getString(10);
			String city = rset.getString(11);
			String state = rset.getString(12);
			String zip = rset.getString(13);
			String country = rset.getString(14);
			String photo = rset.getString(15);
			String SSN = rset.getString(16);
			String insurance = rset.getString(17);

			patients[i] = new String[] { THC, currentDate, firstName, middleName, lastName, DOB, gender,
					(phone), email, streetAddr, city, state, zip, country, photo, SSN, insurance };
			i++;
		} // while
		//print out patients array
//		 for (int j = 0; j < numberRow; j++)
//		 System.out.println(Arrays.toString(patients[j]));
	/* Check if it is updated*/
		
	
	}//main
}
