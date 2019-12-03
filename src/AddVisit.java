import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddVisit extends JFrame {
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");

	// public static String DB_URL = new
	// String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/test");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	private String CDate;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblNewLabel;
	private JLabel lblLast;
	private JLabel lblStreetAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblSsn;
	
	static int id;
	static int num;

	/**
	 * Launch the application.
	 */

	public boolean flagCheckString(String s) {
		boolean flag = true;
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	public boolean flagCheckInt(String s) {
		boolean flag = true;
		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i]) == false) {
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	public static void AddVist(int VisitId,int numberRow) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					AddVisit frame = new AddVisit(VisitId, numberRow);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddVisit(int VisitId,int numberRow) throws SQLException {
		id = VisitId;
		num = numberRow;
		
		//updator to get current THC
		String tableName = "Visit";
		/* Get number of tuples and MAX THC */
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh"); // Connect
		// //
		// database
		Statement tempStmt = conn.createStatement();// Create a Statement
		
		
		
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
		
		
		/* Get number of tuples and MAX THC */
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		CDate = (formatter.format(date));
		
		
		setTitle("Add Visit");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		System.out.println(VisitId);
		
		textField = new JTextField(Integer.toString(VisitId));
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField(CDate);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String VisitID =  Integer.toString(VisitId);
				
				String THC = "NULL";
				String fName = "NULL";
				String lName = "NULL";
				String visitNum = "NULL";
				String comments = "NULL";

				Patient p = new Patient();
				//
//				if (flagCheckString(textField.getText()) == true && flagCheckString(textField_1.getText()) == true
//						&& flagCheckString(textField_2.getText()) == true && flagCheckInt(textField_3.getText()) == true
//						&& flagCheckString(textField_4.getText()) == true && flagCheckInt(textField_5.getText()) == true
//						&& // TextField 6 & 7 can be mix of digits and strings
//				flagCheckString(textField_6.getText()) == true && flagCheckString(textField_7.getText()) == true)

				//

				{
					
					THC = textField_1.getText();
					fName = textField_2.getText();
					lName = textField_3.getText();
					visitNum = textField_4.getText();
					comments = textField_5.getText();
			
	
					
					if (!fName.equals("") && !lName.equals("") 
						 && !comments.equals("")) {
						System.out.println("hey!!!");
						String[] InsertRows = {
								"INSERT INTO Visit(Visit_ID, THC, Visit_nr, Date, Comments\n)"
								+ "VALUES ('"+ VisitID + "', '"+ THC + "','" +
								visitNum + "', '" + CDate + "', '" + comments +"'"
								+");" };
										
				

						for (int a = 0; a < InsertRows.length; ++a) {
							System.out.println(InsertRows[a]);
						}

						try {
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
							} catch (SQLException e1) {
								SQLUtil.printSQLExceptions(e1);
							}

						} // try for Class.forName(JDBC_DRIVER);
						catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} // catch

					}
				}
				setVisible(false);
			}

		});
		btnNewButton.setForeground(Color.RED);

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		
		JLabel lblHtc = new JLabel("Visit ID");

		lblNewLabel = new JLabel("THC #");

		lblLast = new JLabel("First Name");

		lblStreetAddress = new JLabel("Last Name");

		lblCity = new JLabel("Visit #");

		lblState = new JLabel("Date");

		lblZip = new JLabel("Comments");

		lblSsn = new JLabel("SSN");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblHtc).addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
														.createSequentialGroup().addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lblStreetAddress,
																		GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
																.addComponent(
																		lblLast, GroupLayout.DEFAULT_SIZE, 68,
																		Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addGap(6)
																		.addGroup(gl_contentPane
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(textField_3,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(textField_2,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)))))
												.addComponent(
														textField, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE))
										.addGap(92))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 68,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 68,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblZip, GroupLayout.PREFERRED_SIZE, 68,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_5, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(textField_6, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGap(84))
								.addGroup(
										gl_contentPane.createSequentialGroup()
												.addComponent(lblSsn, GroupLayout.PREFERRED_SIZE, 68,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_7, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(70))))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(285, Short.MAX_VALUE).addComponent(btnNewButton).addGap(67)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(44)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLast))
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStreetAddress))
								.addGap(32)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCity))
								.addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblState))
								.addGap(24)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblZip))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSsn)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblHtc)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
				.addGap(47).addComponent(btnNewButton).addContainerGap(39, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
