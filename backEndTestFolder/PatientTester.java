import java.sql.*;

public class PatientTester {
	public static void main(String args[]) throws SQLException {
		// Connect to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "keon", "7eu6Y.La=VJh");

		// Create a Statement
		Statement stmt = conn.createStatement();

		// Select the table names from the user_tables
		ResultSet rset = stmt.executeQuery("select * from Patient");

		// Iterate through the result and print out the table names
		String list[][] = new String[100][];
		int i = 0;
		while (rset.next()) {

			String id = rset.getString(1);
			int a = rset.getInt(2);
			int b = rset.getInt(3);
			int c = rset.getInt(4);
			int d = rset.getInt(5);
			int e = rset.getInt(6);
			String firstName = rset.getString(7);
			String lastName = rset.getString(8);
			String SSN = rset.getString(9);
			String DOB = rset.getString(10);
			String insurance = rset.getString(11);
			String Tin_Background = rset.getString(12);
			String H_Background = rset.getString(13);
			String Tin_WHEN = rset.getString(14);
			String H_when = rset.getString(15);
			String T_Ind_comments = rset.getString(16);
			String H_Ind_comments = rset.getString(17);

			System.out.println(id + " " + a + " " + b + " " + c + " " + d + " " + e + " " + firstName + " " + lastName);
			list[i] = new String[] { id, Integer.toString(a), Integer.toString(b), Integer.toString(c),
					Integer.toString(d), Integer.toString(e), firstName, lastName, SSN, DOB, insurance, Tin_Background,
					H_Background, Tin_WHEN, H_when, T_Ind_comments, H_Ind_comments };
			// list[i] = {};

		}

		String sql = "UPDATE Patient"
				+ " SET Country_ID=?, State_ID=? ,ZIP_ID =?, WStatus_ID=?, Occup_ID=?, Surname=?,First_name=?,SSN=?,DOB=?,"
				+ "Insurance =?,  Tin_Background=?,H_Background=?,Tin_WHEN=?,H_when=?,T_Ind_comments=?,H_Ind_comments=?"
				+ " WHERE THC =?";

		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, Integer.parseInt(list[0][1]));
		preparedStatement.setInt(2, Integer.parseInt(list[0][2]));
		preparedStatement.setInt(3, Integer.parseInt(list[0][3]));
		preparedStatement.setInt(4, Integer.parseInt(list[0][4]));
		preparedStatement.setInt(5, Integer.parseInt(list[0][5]));
		preparedStatement.setString(6, "haha");
		preparedStatement.setString(7, "haha");
		preparedStatement.setString(8, list[0][8]);
		preparedStatement.setString(9, list[0][9]);
		preparedStatement.setString(10, list[0][10]);
		preparedStatement.setString(11, list[0][11]);
		preparedStatement.setString(12, list[0][12]);
		preparedStatement.setString(13, list[0][13]);
		preparedStatement.setString(14, list[0][14]);
		preparedStatement.setString(15, list[0][15]);
		preparedStatement.setString(16, list[0][16]);
		preparedStatement.setString(17, "abc");
		preparedStatement.executeUpdate();

		rset = stmt.executeQuery("select * from Patient");

		i = 0;
		while (rset.next()) {

			String id = rset.getString(1);
			int a = rset.getInt(2);
			int b = rset.getInt(3);
			int c = rset.getInt(4);
			int d = rset.getInt(5);
			int e = rset.getInt(6);
			String firstName = rset.getString(7);
			String lastName = rset.getString(8);
			String SSN = rset.getString(9);
			String DOB = rset.getString(10);
			String insurance = rset.getString(11);
			String Tin_Background = rset.getString(12);
			String H_Background = rset.getString(13);
			String Tin_WHEN = rset.getString(14);
			String H_when = rset.getString(15);
			String T_Ind_comments = rset.getString(16);
			String H_Ind_comments = rset.getString(17);

			System.out.println(id + " " + a + " " + b + " " + c + " " + d + " " + e + " " + firstName + " " + lastName);
			list[i] = new String[] { id, Integer.toString(a), Integer.toString(b), Integer.toString(c),
					Integer.toString(d), Integer.toString(e), firstName, lastName, SSN, DOB, insurance, Tin_Background,
					H_Background, Tin_WHEN, H_when, T_Ind_comments, H_Ind_comments };
			// list[i] = {};

		}

	}
}
