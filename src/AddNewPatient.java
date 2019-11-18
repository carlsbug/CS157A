
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
//	public static String USERNAME = new String("endalk");
//    public static String PASSWORD = new String("1234qwer");
//	public static String DB_URL = new String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");

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
	private JLabel lblStreetA;
	private JLabel lblCity;
	private JLabel lblS;
	private JLabel lblZip;
	private JTextField textField_11;
	private JLabel lblCountry;
	private JTextField textField_12;
	private JLabel lblPhoto;
	private JTextField textField_13;
	private JLabel lblSocialSecurityNumber;
	private JTextField textField_14;
	private JLabel lblInsurance;
	private  JButton btnAdd; 
	
	
	
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		getContentPane().add(b);
		
	
		
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
		
		
		
		
		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setBounds(92, 11, 72, 16);
		
		JLabel lblMiddleNameoptional = new JLabel("Middle Name  [Optional]");
		lblMiddleNameoptional.setBounds(13, 49, 148, 16);
		
		JLabel lblLastName = new JLabel("Last Name ");
		lblLastName.setBounds(88, 87, 70, 16);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(98, 120, 79, 16);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(117, 158, 44, 16);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(127, 185, 38, 16);
		
		JLabel lblEmail = new JLabel("E-mail  [Optional]");
		lblEmail.setBounds(69, 223, 108, 16);
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
		
		lblS = new JLabel("State [Optional]");
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
		
		lblPhoto = new JLabel("Photo [Optional]");
		lblPhoto.setBounds(117, 434, 63, 16);
		contentPane.add(lblPhoto);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(193, 457, 176, 26);
		contentPane.add(textField_13);
		
		lblSocialSecurityNumber = new JLabel("Social Security Number [Optional]");
		lblSocialSecurityNumber.setBounds(13, 462, 176, 16);
		contentPane.add(lblSocialSecurityNumber);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(193, 485, 130, 26);
		contentPane.add(textField_14);
		
		lblInsurance = new JLabel("Insurance [Optional]");
		lblInsurance.setBounds(60, 490, 63, 16);
		contentPane.add(lblInsurance);
				
	}
			
}
