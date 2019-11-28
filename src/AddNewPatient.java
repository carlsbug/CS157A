
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEndOldVersion.SQLUtil;

import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AddNewPatient extends JFrame {

	
	
	public static String USERNAME = new String("keon");
	public static String PASSWORD = new String("7eu6Y.La=VJh");

	//	public static String DB_URL = new String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/project");
	public static String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
	private JPanel contentPane;

	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private String CDate = (formatter.format(date));
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JLabel lblStreetA;
	private JLabel lblCity;
	private JLabel lblS;
	private JLabel lblZip;
	private JLabel lblCountry;
	private JLabel lblPhoto;
	private JLabel lblSocialSecurityNumber;
	private JLabel lblInsurance;
	private JButton btnAdd;
	private Patient[] Patients = new Patient[100];
	private String[] newPatient = new String[16];
	int i = 0;
	
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

	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewPatient frame = new AddNewPatient();
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
	public AddNewPatient() throws SQLException {
		
		
		
		

//updator to get current THC
 
 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "keon", "7eu6Y.La=VJh");
 Statement stmt = conn.createStatement();
	int numberRow = 0;
	try {

		ResultSet cset = stmt.executeQuery("SELECT COUNT(*) FROM Patient;");
		while (cset.next()) {
			numberRow = cset.getInt("count(*)");
		}
	} catch (Exception ex) {
		System.out.println(ex.getMessage());
	}
	final String THC = Integer.toString(numberRow);
	
		setBackground(Color.WHITE);
		setTitle(" New Patient");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200, 200, 465, 713);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

		
		JButton b = new JButton ("Submit");
		b.setForeground(Color.RED);
		b.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		b.setBackground(Color.BLUE);
		b.setBounds(244, 550, 79, 40);
		contentPane.add(b);
		

		b.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				  
				   String fName = "NULL";;
				   String mName = "NULL";
				   String lName = "NULL";
				   String dOB = "NULL";
				   String gender = "NULL";
				   String phone = "NULL";
				   String email = "NULL";
				   String street = "NULL";
				   String city = "NULL";
				   String state = "NULL";
				   String zipCode = "NULL";
				   String country = "NULL";
				   String photo = "NULL";
				   String SSN = "NULL";
				   String insurance = "NULL";
		
				   System.out.println("HAHAHAHA1:"+zipCode);
				   Patient p = new Patient();
//				   
				  if (flagCheckString(textField.getText()) == true && 
				  	  flagCheckString(textField_1.getText()) == true &&
					  flagCheckString(textField_2.getText()) == true &&
//							  flagCheckInt(textField_3.getText()) == true &&
					  flagCheckString(textField_4.getText()) == true &&
					  flagCheckInt(textField_5.getText()) == true && //TextField 6 & 7 can be mix of digits and strings
					  flagCheckString(textField_8.getText()) == true &&
					  flagCheckString(textField_9.getText()) == true &&
					  flagCheckInt(textField_10.getText()) == true &&
					  flagCheckString(textField_11.getText()) == true &&
					  flagCheckString(textField_12.getText()) == true &&
					 flagCheckString(textField_13.getText()) == true &&
					  flagCheckString(textField_14.getText()) == true)
//					  
					 
				  {
					   fName = textField.getText();
					   mName = textField_1.getText();
				       lName = textField_2.getText();
				       dOB = textField_3.getText();
				       gender = textField_4.getText();
				       phone = textField_5.getText();
				       email = textField_6.getText();
				       street = textField_7.getText();
				       city = textField_8.getText();
				       state = textField_9.getText();
				       zipCode = textField_10.getText();
				       country = textField_11.getText();
				       photo = textField_12.getText();
				       SSN = textField_13.getText();
				       insurance = textField_14.getText();

				       System.out.println("HAHAHAHA2:"+zipCode);
				       
				       if (!fName.equals("") && !lName.equals("") && !dOB.equals("") &&
				    		   !gender.equals("") && !phone.equals("") && !street.equals("") 
				    		   && !city.equals("") && !zipCode.equals("") && !country.equals("") && !SSN.equals(""))
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
							
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				    	   
				       	p.addPatient(fName,mName,lName,dOB,gender, 
					    phone,email,street,city,state,zipCode,country,photo,SSN,insurance);
				         
					   Patients[i] = p;
					   System.out.println(Patients[i].getFName() + " added ");
				       }
				       else {
				    	   System.out.println("Failed: answer all that are not * marked");
				       }
				  }
				  else {
//					  JFrame errorPane;
//					  errorPane.NewScreen();
					  System.out.println("Failed: wrong text in a place");
				  }
				  
			    
			   }
			});
		
		

		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setBounds(92, 11, 72, 16);
		
		JLabel lblMiddleNameoptional = new JLabel("Middle Name*");
		lblMiddleNameoptional.setBounds(13, 49, 148, 16);
		
		JLabel lblLastName = new JLabel("Last Name ");
		lblLastName.setBounds(88, 87, 70, 16);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth ");
		lblDateOfBirth.setBounds(98, 120, 79, 16);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(117, 158, 44, 16);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(127, 185, 38, 16);
		
		JLabel lblEmail = new JLabel("E-mail*");
		lblEmail.setBounds(69, 223, 108, 16);
		
		lblStreetA = new JLabel("Street Address");
		lblStreetA.setBounds(69, 261, 108, 16);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(117, 306, 44, 16);
		
		lblS = new JLabel("State*");
		lblS.setBounds(69, 340, 108, 16);
		
		lblZip = new JLabel("Zip");
		lblZip.setBounds(117, 368, 44, 16);
		
		lblCountry = new JLabel("Country");
		lblCountry.setBounds(98, 406, 63, 16);
		
		lblPhoto = new JLabel("Photo*");
		lblPhoto.setBounds(117, 434, 63, 16);
		
		lblSocialSecurityNumber = new JLabel("Social Security Number*");
		lblSocialSecurityNumber.setBounds(13, 462, 176, 16);
		
		lblInsurance = new JLabel("Insurance*");
		lblInsurance.setBounds(60, 490, 63, 16);
		
		textField = new JTextField();
		textField.setBounds(193, 6, 130, 26);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 44, 130, 26);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(193, 82, 130, 26);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(193, 115, 130, 26);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(193, 153, 130, 26);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(193, 180, 130, 26);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(193, 218, 130, 26);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(193, 256, 130, 26);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(193, 294, 130, 26);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(193, 332, 130, 26);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(193, 370, 130, 26);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(193, 401, 130, 26);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(193, 429, 130, 26);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(193, 457, 176, 26);
		
	

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(193, 485, 130, 26);

		contentPane.setLayout(null);
		contentPane.add(lblMiddleNameoptional);
		contentPane.add(lblLastName);
		contentPane.add(lblGender);
		contentPane.add(lblDateOfBirth);
		contentPane.add(lblEmail);
		contentPane.add(lblPhone);
		contentPane.add(lblFirstName);
		contentPane.add(textField_3);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(textField_4);
		contentPane.add(textField_6);
		contentPane.add(textField);
		contentPane.add(textField_5);

		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(193, 256, 130, 26);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(193, 294, 130, 26);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(193, 332, 130, 26);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(193, 370, 130, 26);
		contentPane.add(textField_10);
		
		lblStreetA = new JLabel("Street Address");
		lblStreetA.setBounds(69, 261, 108, 16);
		contentPane.add(lblStreetA);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(117, 306, 44, 16);
		contentPane.add(lblCity);
		
		lblS = new JLabel("State(Optional)");
		lblS.setBounds(69, 340, 108, 16);
		contentPane.add(lblS);
		
		lblZip = new JLabel("Zip");
		lblZip.setBounds(117, 368, 44, 16);
		contentPane.add(lblZip);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(193, 401, 130, 26);
		contentPane.add(textField_11);
		
		lblCountry = new JLabel("Country");
		lblCountry.setBounds(98, 406, 63, 16);
		contentPane.add(lblCountry);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(193, 429, 130, 26);
		contentPane.add(textField_12);
		
		lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(117, 434, 63, 16);
		contentPane.add(lblPhoto);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(193, 457, 176, 26);
		contentPane.add(textField_13);
		
		lblSocialSecurityNumber = new JLabel("Social Security Number");
		lblSocialSecurityNumber.setBounds(13, 462, 176, 16);
		contentPane.add(lblSocialSecurityNumber);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(193, 485, 130, 26);
		contentPane.add(textField_14);
		
		lblInsurance = new JLabel("Insurance");
		lblInsurance.setBounds(60, 490, 63, 16);

		contentPane.add(lblInsurance);

		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(183, 553, 117, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add New Patient");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(170, 635, 130, 50);
		contentPane.add(btnNewButton_1);

		contentPane.add(textField_14);
		contentPane.add(lblS);
		contentPane.add(lblZip);
		contentPane.add(textField_11);
		contentPane.add(lblCountry);
		contentPane.add(textField_12);
		contentPane.add(lblPhoto);
		contentPane.add(textField_13);
		contentPane.add(lblSocialSecurityNumber);
		contentPane.add(lblCity);
		contentPane.add(lblStreetA);
		contentPane.add(textField_10);
		contentPane.add(textField_7);
		contentPane.add(textField_8);
		contentPane.add(textField_9);

				
	}
	//public static void main(String args[]) throws SQLException {
		
		///* Bring patient */		
				// Connect to the database
//				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "keon", "7eu6Y.La=VJh");
		//
//				// Create a Statement
//				Statement stmt = conn.createStatement();
		//
//				// Select the table names from the user_tables
//				ResultSet rset = stmt.executeQuery("SELECT p.THC, p.CurrentDate, p.First_name, p.Middle_name, p.Last_name, p.Date_of_Birth,\n" + 
//						"p.Gender, p.Phone, p.Email, p.Street_Address, p.City, s.Name, z.Name, c.Name, p.Photo,\n" + 
//						"p.Social_Security_Number, p.Insurnace\n" + 
//						"FROM Patient p, REF_State s, REF_Zip z,REF_Country c;");
		//
//				// Iterate through the result and print out the table names
//				String list[][] = new String[100][];
//				int i = 0;
//				while (rset.next()) {
//					String THC = rset.getString(1);
//					String currentDate = rset.getString(2);
//					String firstName = rset.getString(3);
//					String middleName = rset.getString(4);
//					String lastName = rset.getString(5);
//					String DOB = rset.getString(6);
//					String gender = rset.getString(7);
//					int phone = rset.getInt(8);
//					String email = rset.getString(9);
//					String streetAddr = rset.getString(10);
//					String city = rset.getString(11);
//					String state = rset.getString(12);
//					String zip = rset.getString(13);
//					String country = rset.getString(14);
//					String photo = rset.getString(15);
//					String SSN = rset.getString(16);
//					String insurance = rset.getString(17);
//					
////					int d = rset.getInt(5);
////					int e = rset.getInt(6);
////					String firstName = rset.getString(7);
////					String lastName = rset.getString(8);
////					String SSN = rset.getString(9);
////					String DOB = rset.getString(10);
////					String insurance = rset.getString(11);
////					String Tin_Background = rset.getString(12);
////					String H_Background = rset.getString(13);
////					String Tin_WHEN = rset.getString(14);
////					String H_when = rset.getString(15);
////					String T_Ind_comments = rset.getString(16);
////					String H_Ind_comments = rset.getString(17);
		//
//					
//					list[i] = new String[] { THC,currentDate, firstName,middleName,
//							lastName, DOB, gender, Integer.toString(phone), email, streetAddr, city
//							, state, zip, country, photo, SSN, insurance};
//					System.out.println(list[i]);
		//	
//					// list[i] = {};
		//
//				}
				
		/* add patient */
				
				/*
				 * 
				insert into Patient(THC, Country_ID,State_ID,ZIP_ID,WStatus_ID,Occup_ID,Surname,First_name) values ('a', 0,0,0,0,0,'Min','Keon');
				insert into Patient(THC, Country_ID,State_ID,ZIP_ID,WStatus_ID,Occup_ID,Surname,First_name) values ('b', 0,0,0,0,0,'last','Mustafa');
				insert into Patient(THC, Country_ID,State_ID,ZIP_ID,WStatus_ID,Occup_ID,Surname,First_name) values ('c', 0,0,0,0,0,'name','Endalk');

				 */
//				String newInput = "";
//			
//				
//				String[] InsertRows = {"INSERT INTO Patient(THC, CurrentDate, First_name, Middle_name, Last_name, Date_of_Birth,\n" + 
//						"				Gender, Phone, Email, Street_Address, City, State_ID, ZIP_ID, Country_ID , Photo,\n" + 
//						"				Social_Security_Number, Insurnace)\n" + 
//						"				VALUES('abc','2019-11-01','Keon','middle','Min','1993-03-12','F',415999999,'email','street','city',(SELECT STATE_ID FROM REF_State WHERE Name = 'CALIFORNIA'), \n" + 
//						"                (SELECT ZIP_ID FROM REF_Zip WHERE Name = 95112),\n" + 
//						"				(SELECT Country_ID FROM REF_Country WHERE Name = 'ETHIOPHIA'),'Photo','SSN','Insurance');"};
//				
//				
//				for (int a=0; a<InsertRows.length; ++a)
//				{
//					System.out.println(InsertRows[a]);
//				}
//
//
//				try {
//					Class.forName(JDBC_DRIVER);
//					try
//					{
//					          // Get a connection from the connection factory
//						Connection con = DriverManager.getConnection(
//						DB_URL,
//						  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
//						USERNAME, PASSWORD);
//				
//						// Show some database/driver metadata
//						SQLUtil.printDriverInfo(con);
//
//						// Create a Statement object so we can submit SQL statements to the driver
//						Statement stmt = con.createStatement();
//
//						// Submit the statement
//						for (int i=0; i<InsertRows.length; ++i)
//						{
//							System.out.print(InsertRows[i] + "...");
//							int rowsAffected = stmt.executeUpdate(InsertRows[i]);
//							if (rowsAffected == 1)
//								System.out.println("OK");
//						}
//
//						// Close the statement
//						stmt.close();
//
//						// Close the connection
//						con.close();
//					}
//					catch (SQLException e1)
//					{
//			          	 	SQLUtil.printSQLExceptions(e1);		
//			         }
//					////
//					
//				} //try for Class.forName(JDBC_DRIVER);
//				catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}//catch		
//				
				
	//}
}
