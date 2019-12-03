import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VisitsScreen extends JFrame {
	
//	public static String USERNAME = new String("endalk");
//    public static String PASSWORD = new String("1234qwer");
//	public static String DB_URL = new String("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");
	private JPanel contentPane;
   
	/**
	 * Launch the application. 
	 */
	public static void NewScreen1 () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisitsScreen frame = new VisitsScreen();
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
	public VisitsScreen () {
		setTitle("Visitors");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddNewVisit = new JButton("Add New Visit");
		btnAddNewVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tableName = "Visit";
				/* Get number of tuples and MAX THC */
				Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "keon", "7eu6Y.La=VJh");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} // Connect
				// //
				// database
				Statement tempStmt = null;
				try {
					tempStmt = conn.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}// Create a Statement
				
				int numberRow = 0; // get number of tuples enrolled in a table
				try {
					ResultSet cset = tempStmt.executeQuery("SELECT COUNT(*) FROM " + tableName + ";");
					while (cset.next()) {
						numberRow = cset.getInt("count(*)");
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				//	System.out.println("We have " + numberRow+ " much patients");
				int VisitIDtemp = 0;
				if (numberRow == 0) {
					VisitIDtemp = 0;
				} else {
					int temp = 0;
					try {
						ResultSet cset = tempStmt.executeQuery("SELECT MAX(THC) FROM " + tableName + ";");
						while (cset.next()) {
							temp = cset.getInt("MAX(THC)");
						}
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					//		System.out.println("the number is " + temp);
					VisitIDtemp = temp + 1;
				}
				final int VisitId = VisitIDtemp;
				
				AddVisit nw = null;
				try {
					nw = new AddVisit(VisitId,numberRow);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nw.AddVist(VisitId,numberRow);
			}
		});
		
		JButton btnVieweditVisits = new JButton("View/Edit Visits");
		btnVieweditVisits.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				AddEditVisit nw = null;
//				try {
//					nw = new AddEditVisit();
//					
//				} catch (SQLException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
////				nw.NewScreen();			
//			}
//		});
			public void actionPerformed(ActionEvent e) {
				AddEditVisit nw = null;
				nw = new AddEditVisit();
				try {
					nw.AddEditVisit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(btnAddNewVisit)
					.addGap(86)
					.addComponent(btnVieweditVisits, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnVieweditVisits, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(btnAddNewVisit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addGap(95))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
