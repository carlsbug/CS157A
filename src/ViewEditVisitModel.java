import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

class ViewEditVisitModel extends AbstractTableModel {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	static String temp[][];
	Object[][] data;

	public ViewEditVisitModel() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect
																										// database
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
		// print out number of tuples
		/* Select all patients */
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT p.THC, p.First_name, p.Last_name,\n"
				+ "(SELECT Name FROM REF_State WHERE State_ID = p.State_ID),p.Gender, p.City, p.CurrentDate \n"
				+ "FROM Patient p;");
		String patients[][] = new String[numberRow][];
		int i = 0;
		while (rset.next() && i < numberRow) {
			String THC = rset.getString(1);
			String firstName = rset.getString(2);
			String lastName = rset.getString(3);
			String state = rset.getString(4);
			String gender = rset.getString(5);
			String city = rset.getString(6);
			String currentDate = rset.getString(7);
			patients[i] = new String[] { THC,firstName, lastName, state, gender, city, currentDate };

			i++;

		}
		temp = patients;
		data = temp;
	}

//Two arrays used for the table data
	String[] columnNames = { "THC","First Name", "Last Name", "State", "Gender", "City", "Date added" };


//	data = { { "Endalk ", "Sisay", "California", "F", "San Jose", "60", "11/11/19" },
//			{ "Mustafa", "...", "Origon", "M", "Palo Alto", "20", "10/12/19" },
//			{ "Keon", "...", "Texas", "M", " Campbell", "20", "09/09/12" }, };

	@Override

	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return data[row][column];
	}

//Used by the JTable object to set the column names
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

//Used by the JTable object to render different
//functionality based on the data type
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0 || column == 1) {
			return false;
		} else {
			return true;
		}
	}
}
