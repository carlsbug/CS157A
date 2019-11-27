import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

public class AddEditVisit {
	public static void NewScreen4() {
		//Use the event dispatch thread for Swing components
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AddEditVisit();
			}
		});
	}
	  public static void main (String args [])
		       throws SQLException
		  {
		    // Load the JDBC driver
			//Uncomment below if you are using Oracle
		    //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Uncomment below if you are using Oracle
		    //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		    // Connect to the database
		    	    Connection conn =
		    	      DriverManager.getConnection 
							//Oracle: You must put a database name after the @ sign in the connection URL.
							// You can use either the fully specified SQL*net syntax or a short cut
							// syntax as <host>:<port>:<sid>.  The example uses the short cut syntax.
		    	    		//Uncomment below if you are using Oracle, provide your username and password
							//("jdbc:oracle:thin:@10.250.9.170:1521:XE","username", "password");
							//Uncomment below if you are using MySQL, provide name of your database, username and password
							("jdbc:mysql://localhost:3306/test","root", "Rounding!2"); 


		    // Create a Statement
		    Statement stmt = conn.createStatement ();

		    // Select the table names from the user_tables
		  //Uncomment below if you are using Oracle
		    //ResultSet rset = stmt.executeQuery ("select TABLE_NAME from USER_TABLES");
		  //Uncomment below if you are using MySQL
		    ResultSet rset = stmt.executeQuery ("select * from Patient");

		    // Iterate through the result and print out the table names
		    String list [][] = new String[100][];
		    for(int i = 0; i < 100; i++)
		    {
		    	
		    }
		    int i = 0;
		    while (rset.next ())
		    {

		    	 String id = rset.getString(1); 
		    	 int a = rset.getInt(2);
		    	 int b = rset.getInt(3);
		    	 int c = rset.getInt(4);
		    	 int d = rset.getInt(5);
		    	 int e = rset.getInt(6);
		    	 String firstName = rset.getString(7);
		    	 String lastName = rset.getString(8);
		    	 System.out.println(id + " " + a + " " + b + " "+ c + " " + d + " " + e + " " +firstName + " " + lastName);
		    	 list[i] = new String [] {id, Integer.toString(a), Integer.toString(b), Integer.toString(c), Integer.toString(d), Integer.toString(e),firstName,lastName};
		    	// list[i] = {}; 
		    }
//		      System.out.println (rset.getString (1));
		  }
	public AddEditVisit() {
		JFrame guiFrame = new JFrame();
		//make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("View/Edit Visit");
		guiFrame.setSize(700, 200);
		//This will center the JFrame in the middle of the screen
		guiFrame.setLocationRelativeTo(null);

		JTable table = new JTable(new ViewEditVisitModel());
		//Set the column sorting functionality on
		table.setAutoCreateRowSorter(true);
		//Uncomment the next line if you want to turn the grid lines off
		// table.setShowGrid(false);
		//Change the colour of the table - yellow for gridlines
		//blue for background
		table.setGridColor(Color.YELLOW);
		table.setBackground(Color.CYAN); // color
		//String array to populate the combobox options

		//Set the default editor for the states column to be the combobox
		TableColumn stateColumn = table.getColumnModel().getColumn(2);

		//set the Event column to be larger than the rest and the Place column
		//to be smaller
		TableColumn eventColumn = table.getColumnModel().getColumn(3);
		eventColumn.setPreferredWidth(150);
		TableColumn placeColumn = table.getColumnModel().getColumn(4);
		placeColumn.setPreferredWidth(5);

		//Place the JTable object in a JScrollPane for a scrolling table
		JScrollPane tableScrollPane = new JScrollPane(table);
		guiFrame.add(tableScrollPane);
		guiFrame.setVisible(true);
	}
}
