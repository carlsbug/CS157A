import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.SwingConstants;

public class eTRT extends JFrame {

	private JPanel contentPane;
	public static String USERNAME = new String("endalk");
    public static String PASSWORD = new String("1234qwer");
	public static String DB_URL = new String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eTRT frame = new eTRT();
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
	public eTRT() {
		setTitle("eTRT");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("eTRT");
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
	
		
		
		JButton btnPatients_1 = new JButton("Patients");
		btnPatients_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient nw= new Patient();
				nw.NewScreen();
			}
		});
		btnPatients_1.setBounds(33, 50, 158, 72);
		contentPane.add(btnPatients_1);
		
		
		
		JButton btnVisits = new JButton("Visits");
		btnVisits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisitsScreen nw= new VisitsScreen();
				nw.NewScreen1();
			}
		});
		btnVisits.setBounds(241, 50, 158, 72);
		contentPane.add(btnVisits);
		
		JButton btnAnalytics = new JButton("Analytics");
		btnAnalytics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Demographics nw= new Demographics();
				nw.NewScreen3();
			}
		});
		btnAnalytics.setBounds(33, 152, 145, 60);
		contentPane.add(btnAnalytics);
		
		JButton btnNewButton = new JButton("Others");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Location nw= new Location();
				nw.NewScreen2();
				
				
			}
		});
		btnNewButton.setBounds(241, 152, 165, 60);
		contentPane.add(btnNewButton);
	}
}
