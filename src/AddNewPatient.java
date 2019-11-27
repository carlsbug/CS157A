
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AddNewPatient extends JFrame {

	private JPanel contentPane;
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
	 */
	public AddNewPatient() {
		
		
		setBackground(Color.WHITE);
		setTitle(" New Patient");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200, 200, 465, 713);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
<<<<<<< HEAD
=======
		
		JButton b = new JButton ("Submit");
		b.setForeground(Color.RED);
		b.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		b.setBackground(Color.BLUE);
		b.setBounds(244, 550, 79, 40);
		contentPane.add(b);
>>>>>>> branch 'master' of https://github.com/carlsbug/CS157A-Team3-Problem1.git
		
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
		
			
				   Patient p = new Patient();
				   
				  if (flagCheckString(textField.getText()) == true && 
				  	  flagCheckString(textField_1.getText()) == true &&
					  flagCheckString(textField_2.getText()) == true &&
					  flagCheckInt(textField_3.getText()) == true &&
					  flagCheckString(textField_4.getText()) == true &&
					  flagCheckInt(textField_5.getText()) == true && //TextField 6 & 7 can be mix of digits and strings
					  flagCheckString(textField_8.getText()) == true &&
					  flagCheckString(textField_9.getText()) == true &&
					  flagCheckInt(textField_10.getText()) == true &&
					  flagCheckString(textField_11.getText()) == true &&
					  flagCheckString(textField_12.getText()) == true &&
					  flagCheckInt(textField_13.getText()) == true &&
					  flagCheckString(textField_14.getText()) == true)
					  
					 
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

				       //
				       if (!fName.equals("") && !lName.equals("") && !dOB.equals("") &&
				    		   !gender.equals("") && !phone.equals("") && !street.equals("") 
				    		   && !city.equals("") && !zipCode.equals("") && !country.equals("") && !SSN.equals(""))
				       {
				    	   
				       	p.addPatient(fName,mName,lName,dOB,gender, 
					    phone,email,street,city,state,zipCode,country,photo,SSN,insurance);
				         
					   Patients[i] = p;
					   System.out.println(Patients[i].getFName() + " added ");
				       }else {
				    	   System.out.println("Failed: answer all that are not * marked");
				       }
				  }else {
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
		
		
<<<<<<< HEAD
		
		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setBounds(92, 11, 72, 16);
		
		JLabel lblMiddleNameoptional = new JLabel("Middle Name (Optional)");
		lblMiddleNameoptional.setBounds(13, 49, 148, 16);
		
		JLabel lblLastName = new JLabel("Last Name ");
		lblLastName.setBounds(88, 87, 70, 16);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(98, 120, 79, 16);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(117, 158, 44, 16);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(127, 185, 38, 16);
		
		JLabel lblEmail = new JLabel("E-mail (Optional)");
		lblEmail.setBounds(69, 223, 108, 16);
=======
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(193, 485, 130, 26);

>>>>>>> branch 'master' of https://github.com/carlsbug/CS157A-Team3-Problem1.git
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
<<<<<<< HEAD
		
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
=======
>>>>>>> branch 'master' of https://github.com/carlsbug/CS157A-Team3-Problem1.git
		contentPane.add(lblInsurance);
<<<<<<< HEAD
		
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
=======
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
>>>>>>> branch 'master' of https://github.com/carlsbug/CS157A-Team3-Problem1.git
				
	}
}
