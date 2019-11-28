
import java.sql.*;



import java.util.Arrays;
public class bringDataFromPatient {
	public static void main(String args[]) throws SQLException {

		/* Bring patient */
		// Connect to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "keon", "7eu6Y.La=VJh");

		// Create a Statement
		Statement stmt = conn.createStatement();

		// Select the table names from the user_tables
		int numberRow = 0;
		try {

			ResultSet cset = stmt.executeQuery("SELECT COUNT(*) FROM Patient;");
			while (cset.next()) {
				numberRow = cset.getInt("count(*)");
				System.out.println("numbsasdasdasdasdasdasder:"+ numberRow);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	
		System.out.println("numbsasdasdasdasdasdasder:"+ numberRow);
		
		ResultSet rset = stmt.executeQuery(
				"SELECT p.THC, p.CurrentDate, p.First_name, p.Middle_name, p.Last_name, p.Date_of_Birth,\n"
						+ "p.Gender, p.Phone, p.Email, p.Street_Address, p.City, s.Name, z.Name, c.Name, p.Photo,\n"
						+ "p.Social_Security_Number, p.Insurnace\n"
						+ "FROM Patient p, REF_State s, REF_Zip z,REF_Country c;");

		// Iterate through the result and print out the table names
		String list[][] = new String[numberRow][];
		int i = 0;
		while (rset.next() && i < numberRow) {
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

			list[i] = new String[] { THC, currentDate, firstName, middleName, lastName, DOB, gender,
					Integer.toString(phone), email, streetAddr, city, state, zip, country, photo, SSN, insurance };
			i++;

		}
		
		
		
//		
		for(int j = 0; j< numberRow;j++)
		{
			System.out.println("asdasdasdasdasdasd:"+ numberRow);
			System.out.println(Arrays.toString(list[j]));
		}
		for(int j = 0; j< numberRow;j++)
		{
			System.out.println("asdasdasdasdasdasd:"+ numberRow);
			System.out.println(Arrays.toString(list[j]));
		}


	}
}
