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

public class AddEditVisit {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	static int num;
	static String temp[][];
//	public static void main(String[] args) throws SQLException  
//	{  
//  
//	}
	public void AddEditVisit() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect																										// database
		Statement tempStmt = conn.createStatement();// Create a Statement
		int numberRow = 0; // get number of tuples enrolled in a table
		try {
			ResultSet cset = tempStmt.executeQuery("SELECT COUNT(*) FROM Visit;");
			while (cset.next()) {
				numberRow = cset.getInt("count(*)");
				num = numberRow;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(
				"SELECT v.Visit_ID,v.Date, (SELECT First_name FROM Patient WHERE THC = v.THC), (SELECT Last_name FROM Patient WHERE THC = v.THC), v.Comments\n"
				+ "FROM Visit v;");
		String Visits[][] = new String[numberRow][];
		temp = new String[numberRow][];
		int i = 0;
		while (rset.next() && i < numberRow) {
			String Visit_ID = rset.getString(1);
			String Date = rset.getString(2);
			String Patient = rset.getString(3) + " " + rset.getString(4);
			String comments = rset.getString(5);

			Visits[i] = new String[] { Visit_ID, Date, Patient, comments };
			temp[i] =Visits[i];
// String[] { THC,firstName, lastName, state, gender, city, currentDate };
			i++;
			

		}
		Object[][] dataEntries = temp;
	
		JFrame frame = new JFrame();  
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
		String[] columnTitles = { "ID","Date", "Patient", "Comments"};
//		Object[][] dataEntries = {  
//				{ "ABHISHEK", "DUBEY", new Integer(50), "B-tech"},  
//				{ "MANISH", "TIWARI", new Integer(80), "PG" },  
//				{ "ANURUDDHA ", "PANDEY", new Integer(80), "Msc" },  
//				{ "Bindresh", "AGINHOTRI", new Integer(80), "Bsc" },  
//				{ "SOURABH", "TRIPATHI", new Integer(80), "PG" },  
//				{ "AMIT", "GUPTA", new Integer(70), "Gratuate" },  
//				{ "AMIT", "VERMA", new Integer(55), "12TH" } };  
		TableModel model = new anotherTableModel(columnTitles, dataEntries);  
		JTable table = new JTable(model);  
		table.createDefaultColumnsFromModel();  
//		String[] genderBox = { "F","M"};  
//		JComboBox comboBox = new JComboBox(genderBox);  
//		//5th column
//		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));  
		frame.add(new JScrollPane(table));  
		frame.setSize(600, 200);  
		frame.setVisible(true);  
	}

}  
class anotherTableModel extends AbstractTableModel 
{  
//	String sql = "UPDATE Patient p\n"
//	+ "SET p.First_name=?, p.Last_name=?,  SELECT State_ID FROM REF_State WHERE Name =?,"
//	+ "p.Gender=?, p.City=?, "
//	+ "WHERE THC =?";
	String[] columnTitles;  
	Object[][] dataEntries;  
	int rowCount;  
	public anotherTableModel(String[] columnTitles, Object[][] dataEntries)  
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
			ResultSet cset = tempStmt.executeQuery("SELECT COUNT(*) FROM Visit;");
			while (cset.next()) {
				num = cset.getInt("count(*)");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		/* Get number of tuples */
		
		
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect																// database
		 tempStmt = conn.createStatement();// Create a Statement
			String sql = "UPDATE Visit v\n"
					+ "SET v.Comments=?"
					 + "WHERE Visit_ID =?";
		
			

		for (int k = 0; k < num; k++) {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, (String)(dataEntries[row][3]));
			preparedStatement.setString(2, (String)(dataEntries[row][0]));
			preparedStatement.executeUpdate();
		}
		
	}
}  

