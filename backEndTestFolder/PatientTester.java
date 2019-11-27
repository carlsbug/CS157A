import java.sql.*;

import BackEnd.SQLUtil;

public class PatientTester {
//	public static String USERNAME = new String("keon");
//	public static String PASSWORD = new String("7eu6Y.La=VJh");
//
//	//	public static String DB_URL = new String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
//	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	public static void main(String args[]) throws SQLException {
		
/* Bring patient */		
		// Connect to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "keon", "7eu6Y.La=VJh");

		// Create a Statement
		Statement stmt = conn.createStatement();

		// Select the table names from the user_tables
		ResultSet rset = stmt.executeQuery("SELECT p.THC, p.CurrentDate, p.First_name, p.Middle_name, p.Last_name, p.Date_of_Birth,\n" + 
				"p.Gender, p.Phone, p.Email, p.Street_Address, p.City, s.Name, z.Name, c.Name, p.Photo,\n" + 
				"p.Social_Security_Number, p.Insurnace\n" + 
				"FROM Patient p, REF_State s, REF_Zip z,REF_Country c;");

		// Iterate through the result and print out the table names
		String list[][] = new String[100][];
		int i = 0;
		while (rset.next()) {
			String THC = rset.getString(1);
			String currentDate = rset.getString(2);
			String firstName = rset.getString(3);
			String middleName = rset.getString(4);
			String lastName = rset.getString(5);
			String DOB = rset.getString(6);
			String gender = rset.getString(7);
			int phone = rset.getInt(8);
			String email = rset.getString(9);
			String streetAddr = rset.getString(10);
			String city = rset.getString(11);
			String state = rset.getString(12);
			String zip = rset.getString(13);
			String country = rset.getString(14);
			String photo = rset.getString(15);
			String SSN = rset.getString(16);
			String insurance = rset.getString(17);
			
//			int d = rset.getInt(5);
//			int e = rset.getInt(6);
//			String firstName = rset.getString(7);
//			String lastName = rset.getString(8);
//			String SSN = rset.getString(9);
//			String DOB = rset.getString(10);
//			String insurance = rset.getString(11);
//			String Tin_Background = rset.getString(12);
//			String H_Background = rset.getString(13);
//			String Tin_WHEN = rset.getString(14);
//			String H_when = rset.getString(15);
//			String T_Ind_comments = rset.getString(16);
//			String H_Ind_comments = rset.getString(17);

			
			list[i] = new String[] { THC,currentDate, firstName,middleName,
					lastName, DOB, gender, Integer.toString(phone), email, streetAddr, city
					, state, zip, country, photo, SSN, insurance};
			System.out.println(list[i]);
	
			// list[i] = {};

		}
		

		
		
///* update */
//
//		String sql = "UPDATE Patient p, REF_State s, REF_Zip z,REF_Country c\n" + 
//				"SET p.THC=?, p.CurrentDate=?, p.First_name=?, p.Middle_name=?, p.Last_name=?, p.Date_of_Birth=?,\n" + 
//				"p.Gender=?, p.Phone=?, p.Email=?, p.Street_Address=?, p.City=?, s.Name=?, z.Name=?, c.Name=?, p.Photo=?,\n" + 
//				"p.Social_Security_Number=?, p.Insurnace=?\n" + 
//				"WHERE THC =?";
//
//		PreparedStatement preparedStatement = conn.prepareStatement(sql);
//		preparedStatement.setInt(1, Integer.parseInt(list[0][1]));
//		preparedStatement.setInt(2, Integer.parseInt(list[0][2]));
//		preparedStatement.setInt(3, Integer.parseInt(list[0][3]));
//		preparedStatement.setInt(4, Integer.parseInt(list[0][4]));
//		preparedStatement.setInt(5, Integer.parseInt(list[0][5]));
//		preparedStatement.setString(6, "haha");
//		preparedStatement.setString(7, "haha");
//		preparedStatement.setString(8, list[0][8]);
//		preparedStatement.setString(9, list[0][9]);
//		preparedStatement.setString(10, list[0][10]);
//		preparedStatement.setString(11, list[0][11]);
//		preparedStatement.setString(12, list[0][12]);
//		preparedStatement.setString(13, list[0][13]);
//		preparedStatement.setString(14, list[0][14]);
//		preparedStatement.setString(15, list[0][15]);
//		preparedStatement.setString(16, list[0][16]);
//		preparedStatement.setString(17, "abc");
//		preparedStatement.executeUpdate();
//
//		rset = stmt.executeQuery("select * from Patient");
//
//		i = 0;
//		while (rset.next()) {
//
//			String id = rset.getString(1);
//			int a = rset.getInt(2);
//			int b = rset.getInt(3);
//			int c = rset.getInt(4);
//			int d = rset.getInt(5);
//			int e = rset.getInt(6);
//			String firstName = rset.getString(7);
//			String lastName = rset.getString(8);
//			String SSN = rset.getString(9);
//			String DOB = rset.getString(10);
//			String insurance = rset.getString(11);
//			String Tin_Background = rset.getString(12);
//			String H_Background = rset.getString(13);
//			String Tin_WHEN = rset.getString(14);
//			String H_when = rset.getString(15);
//			String T_Ind_comments = rset.getString(16);
//			String H_Ind_comments = rset.getString(17);
//
//			System.out.println(id + " " + a + " " + b + " " + c + " " + d + " " + e + " " + firstName + " " + lastName);
//			list[i] = new String[] { id, Integer.toString(a), Integer.toString(b), Integer.toString(c),
//					Integer.toString(d), Integer.toString(e), firstName, lastName, SSN, DOB, insurance, Tin_Background,
//					H_Background, Tin_WHEN, H_when, T_Ind_comments, H_Ind_comments };
//			// list[i] = {};
//
//		}
//
//	}
}
