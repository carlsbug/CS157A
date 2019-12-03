import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ViewPatient {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	static int num;
	static String temp[][];
	public static void main(String[] args) throws SQLException  
	{  
	}
	public void ViewPatient() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect																										// database
		Statement tempStmt = conn.createStatement();// Create a Statement
		int numberRow = 0; // get number of tuples enrolled in a table
		try {
			ResultSet cset = tempStmt.executeQuery("SELECT COUNT(*) FROM Patient;");
			while (cset.next()) {
				numberRow = cset.getInt("count(*)");
				num = numberRow;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(
				"SELECT p.THC, p.CurrentDate, p.First_name, p.Middle_name, p.Last_name, p.Date_of_Birth,\n"
				+ "p.Gender, p.Phone, p.Email, p.Street_Address, p.City, (SELECT Name FROM REF_State WHERE State_ID = p.State_ID),\n" + 
				"(SELECT Name FROM REF_Zip WHERE ZIP_ID = p.ZIP_ID) ,(SELECT Name FROM REF_Country WHERE Country_ID = p.Country_ID), p.Photo,\n"
				+ "p.Social_Security_Number, p.Insurnace\n"
				+ "FROM Patient p;");
		String patients[][] = new String[numberRow][];
		temp = new String[numberRow][];
		int i = 0;
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
					phone, email, streetAddr, city, state, zip, country, photo, SSN, insurance };
			temp[i] = new String[] { THC,firstName, lastName, state, gender, city, currentDate };
			i++;
			

		}
		Object[][] dataEntries = temp;
	
		JFrame frame = new JFrame();  
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
		String[] columnTitles = { "THC","First Name", "Last Name", "State", "Gender", "City", "Date added" };
//		Object[][] dataEntries = {  
//				{ "ABHISHEK", "DUBEY", new Integer(50), "B-tech"},  
//				{ "MANISH", "TIWARI", new Integer(80), "PG" },  
//				{ "ANURUDDHA ", "PANDEY", new Integer(80), "Msc" },  
//				{ "Bindresh", "AGINHOTRI", new Integer(80), "Bsc" },  
//				{ "SOURABH", "TRIPATHI", new Integer(80), "PG" },  
//				{ "AMIT", "GUPTA", new Integer(70), "Gratuate" },  
//				{ "AMIT", "VERMA", new Integer(55), "12TH" } };  
		TableModel model = new myTable(columnTitles, dataEntries);  
		JTable table = new JTable(model);  
		table.createDefaultColumnsFromModel();  
		String[] genderBox = { "F","M"};  
		JComboBox comboBox = new JComboBox(genderBox);  
		//5th column
		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));  
		frame.add(new JScrollPane(table));  
		frame.setSize(600, 200);  
		frame.setVisible(true);  
	}  
}  
class myTable extends AbstractTableModel 
{  
//	String sql = "UPDATE Patient p\n"
//	+ "SET p.First_name=?, p.Last_name=?,  SELECT State_ID FROM REF_State WHERE Name =?,"
//	+ "p.Gender=?, p.City=?, "
//	+ "WHERE THC =?";
	String[] columnTitles;  
	Object[][] dataEntries;  
	int rowCount;  
	public myTable(String[] columnTitles, Object[][] dataEntries)  
	{  
		this.columnTitles = columnTitles;  
		this.dataEntries = dataEntries;  
	}  
	public int getRowCount()  
	{  
		return dataEntries.length;  
	}  
	public int getColumnCount()  
	{  
		return columnTitles.length;  
	}  
	public Object getValueAt(int row, int column)  
	{  
		return dataEntries[row][column];  
	}  
	public String getColumnName(int column)  
	{  
		return columnTitles[column];  
	}  
	public Class getColumnClass(int column)  
	{  
		return getValueAt(0, column).getClass();  
	}  
	public boolean isCellEditable(int row, int column)  
	{  
		return true;  
	}  
	public void setValueAt(Object value, int row, int column) 
	{  	

		dataEntries[row][column] = value;  
		try {
			doit(row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doit(int row) throws SQLException
	{
		/* Get number of tuples */
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect																// database
		Statement tempStmt = conn.createStatement();// Create a Statement
		int num = 0; // get number of tuples enrolled in a table
		try {
			ResultSet cset = tempStmt.executeQuery("SELECT COUNT(*) FROM Patient;");
			while (cset.next()) {
				num = cset.getInt("count(*)");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		/* Get number of tuples */
		
		
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect																// database
		 tempStmt = conn.createStatement();// Create a Statement
			String sql = "UPDATE Patient p\n"
					+ "SET p.THC=?, p.First_name=?, p.Last_name=?, State_ID = (SELECT State_ID from REF_State where Name = ?), p.Gender =?, p.city =?"
					 + "WHERE THC =?";
		
		for (int k = 0; k < num; k++) {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, (String)(dataEntries[row][0]));
			preparedStatement.setString(2, (String)(dataEntries[row][1]));
			preparedStatement.setString(3, (String)(dataEntries[row][2]));
			preparedStatement.setString(4, (String)(dataEntries[row][3]));
			preparedStatement.setString(5, (String)(dataEntries[row][4]));
			preparedStatement.setString(6, (String)(dataEntries[row][5]));
			preparedStatement.setString(7, (String)(dataEntries[row][0]));
			preparedStatement.executeUpdate();
		}
		
	}
}  

