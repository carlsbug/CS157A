import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEndOldVersion.SQLUtil;

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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddVisit extends JFrame {

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

	
	
	
	
	public static void AddVist() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					AddVisit frame = new AddVisit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddVisit() {
		setTitle("Add Visit");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   String THC = "NULL";
				   String fName = "NULL";
				   String lName = "NULL";
				   String street = "NULL";
				   String city = "NULL";
				   String state = "NULL";
				   String zipCode = "NULL";
				   String SSN = "NULL";


				   Patient p = new Patient();
//				   
				  if (flagCheckString(textField.getText()) == true && 
				  	  flagCheckString(textField_1.getText()) == true &&
					  flagCheckString(textField_2.getText()) == true &&
					  flagCheckInt(textField_3.getText()) == true &&
					  flagCheckString(textField_4.getText()) == true &&
					  flagCheckInt(textField_5.getText()) == true && //TextField 6 & 7 can be mix of digits and strings
					  flagCheckString(textField_6.getText()) == true &&
					  flagCheckString(textField_7.getText()) == true)
				
//					  
					 
				  {
					   THC = textField.getText();
				       fName = textField_1.getText();
				       lName = textField_2.getText();
				       street = textField_3.getText();
				       city = textField_4.getText();
				       state = textField_5.getText();
				       zipCode = textField_6.getText();
				       SSN = textField_6.getText();
				   

				       System.out.println("HAHAHAHA2:"+zipCode);
				       
				       if (!fName.equals("") && !lName.equals("")
				    		   && !street.equals("") 
				    		   && !city.equals("")&& !state.equals("") && !zipCode.equals("")  && !SSN.equals(""))
				       {
							String[] InsertRows = {"INSERT INTO Patient(THC, CurrentDate, First_name, Middle_name, Last_name, Date_of_Birth," + 
									"				Gender, Phone, Email, Street_Address, City, State_ID, ZIP_ID, Country_ID , Photo," + 
									"				Social_Security_Number, Insurnace)" + 
									"				VALUES('"+ THC +"', "+ CDate +", '"+fName+"', '"+mName+"','"+lName+"','"+dOB+"',"
											+ "'"+gender+"',"+phone+", '"+email+"', '"+street+"','"+city+"',"
									+"(SELECT STATE_ID FROM REF_State WHERE Name = '"+ state+"')"+","
									 + "(SELECT ZIP_ID FROM REF_Zip WHERE Name = "+(zipCode)+")," + 
									"(SELECT Country_ID FROM REF_Country WHERE Name = '"+country+"'),'"+photo+"','"+SSN+"','"+insurance+"');"};
							  System.out.println("HAHAHAHA3:"+zipCode);
							
							for (int a=0; a<InsertRows.length; ++a)
							{
								System.out.println(InsertRows[a]);
							}


							try {
								Class.forName(JDBC_DRIVER);
								try
								{
								          // Get a connection from the connection factory
									Connection con = DriverManager.getConnection(
									DB_URL,
									  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
									USERNAME, PASSWORD);
							
									// Show some database/driver metadata
									SQLUtil.printDriverInfo(con);

									// Create a Statement object so we can submit SQL statements to the driver
									Statement stmt = con.createStatement();

									// Submit the statement
									for (int i=0; i<InsertRows.length; ++i)
									{
										System.out.print(InsertRows[i] + "...");
										int rowsAffected = stmt.executeUpdate(InsertRows[i]);
										if (rowsAffected == 1)
											System.out.println("OK");
									}

									// Close the statement
									stmt.close();

									// Close the connection
									con.close();
								}
								catch (SQLException e1)
								{
						          	 	SQLUtil.printSQLExceptions(e1);		
						         }
							
							} //try for Class.forName(JDBC_DRIVER);
							catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}//catch		
							
				 
				    	   
				    	   
				    	   
				       }}}
				
		});
		btnNewButton.setForeground(Color.RED);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblHtc = new JLabel("THC #");
		
		lblNewLabel = new JLabel("First Name");
		
		lblLast = new JLabel("Last Name");
		
		lblStreetAddress = new JLabel("Street Address");
		
		lblCity = new JLabel("City");
		
		lblState = new JLabel("State");
		
		lblZip = new JLabel("Zip");
		
		lblSsn = new JLabel("SSN");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHtc)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblStreetAddress, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
										.addComponent(lblLast, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(6)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(92))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblZip, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(84))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSsn, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(70))))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(285, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(67))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLast))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStreetAddress))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCity))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblState))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblZip))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSsn)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblHtc)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGap(47)
					.addComponent(btnNewButton)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
