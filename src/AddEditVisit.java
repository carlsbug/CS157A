
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
EventQueue.invokeLater(new Runnable()
{
@Override
public void run()
{
new AddEditVisit();
}
});
}
public AddEditVisit()
{
JFrame guiFrame = new JFrame();
//make sure the program exits when the frame closes
guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
guiFrame.setTitle("View/Edit Visit");
guiFrame.setSize(700,200);
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
table.setBackground(Color.CYAN);
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
