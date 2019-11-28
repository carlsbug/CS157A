package ForPatient;

import java.sql.*;



public class UpdatePatient {
	public static void main(String args[]) throws SQLException {

		/* Bring patient */
		// Connect to the database
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

		
		
		
		// Select the table names from the user_tables
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

			// int d = rset.getInt(5);
			// int e = rset.getInt(6);
			// String firstName = rset.getString(7);
			// String lastName = rset.getString(8);
			// String SSN = rset.getString(9);
			// String DOB = rset.getString(10);
			// String insurance = rset.getString(11);
			// String Tin_Background = rset.getString(12);
			// String H_Background = rset.getString(13);
			// String Tin_WHEN = rset.getString(14);
			// String H_when = rset.getString(15);
			// String T_Ind_comments = rset.getString(16);
			// String H_Ind_comments = rset.getString(17);

			list[i] = new String[] { THC, currentDate, firstName, middleName, lastName, DOB, gender,
					Integer.toString(phone), email, streetAddr, city, state, zip, country, photo, SSN, insurance };
			i++;

		}
		//print out list
		//		for (int j = 0; j < numberRow; j++)
		//					System.out.println(Arrays.toString(list[j]));


		
		
		
		
		//change values of list here!
		
		
		
		
		
		
		//change values of list here!
		
		
		
		
		
		/* Let's update the list */
		String sql = "UPDATE Patient p, REF_State s, REF_Zip z,REF_Country c\n"
				+ "SET p.First_name=?, p.Middle_name=?, p.Last_name=?, p.Date_of_Birth=?,"
				+ "p.Gender=?, p.Phone=?, p.Email=?, p.Street_Address=?, p.City=?, s.Name=?, z.Name=?, c.Name=?, p.Photo=?,"
				+ "p.Social_Security_Number=?, p.Insurnace=?" + "WHERE THC =?";

		for (int k = 0; k < numberRow; k++) {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, list[k][2]); // firstName list[k][2]
			preparedStatement.setString(2, (list[k][3])); // Middle_name
			preparedStatement.setString(3, (list[k][4])); // Last_name
			preparedStatement.setString(4, (list[k][5])); // Date_of_Birth
			preparedStatement.setString(5,(list[k][6])); // Gender
			preparedStatement.setInt(6, Integer.parseInt(list[k][7]));// Phone
			preparedStatement.setString(7, (list[k][8]));// Email
			preparedStatement.setString(8, list[0][9]);// Street_Address
			preparedStatement.setString(9, list[0][10]);// City
			preparedStatement.setString(10, list[0][11]);// state
			preparedStatement.setString(11, list[0][12]);// zip
			preparedStatement.setString(12, list[0][13]);// country
			preparedStatement.setString(13, list[0][14]);// photo
			preparedStatement.setString(14, list[0][15]);// SSN
			preparedStatement.setString(15, list[0][16]);// insurance
			preparedStatement.setString(16, list[k][0]);//// THC
			preparedStatement.executeUpdate();
			rset = stmt.executeQuery("select * from Patient");

			//print out updated values to test
			i = 0;
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

				list[i] = new String[] { THC, currentDate, firstName, middleName, lastName, DOB, gender,
						Integer.toString(phone), email, streetAddr, city, state, zip, country, photo, SSN, insurance };
				i++;

			}//while
		}//for k
//		print out list that has been updated
//		for (int j = 0; j < numberRow; j++)
//			System.out.println(Arrays.toString(list[j]));
	}
}
