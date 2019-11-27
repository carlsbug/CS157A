import javax.swing.table.AbstractTableModel;

class ViewEditVisitModel extends AbstractTableModel{
//Two arrays used for the table data
String[] columnNames  = {"First Name", "Last Name", "State"
, "Gender", "City", "Age", "Date added" };
Object[][] data = {
{"Endalk ", "Sisay", "California", "Male","San Jose" , "60", "11/11/19" },
{"Mustafa", "...", "Origon", "Male","Palo Alto", "20", "10/12/19"},
{"Keon", "...", "Texas", "Male", " Campbell", "20", "09/09/12" },
};
@Override
public int getRowCount()
{
return data.length;
}
@Override
public int getColumnCount()
{
return columnNames.length;
}
@Override
public Object getValueAt(int row, int column)
{
return data[row][column];
}
//Used by the JTable object to set the column names
@Override
public String getColumnName(int column) {
return columnNames[column];
}
//Used by the JTable object to render different
//functionality based on the data type
@Override
public Class getColumnClass(int c) {
return getValueAt(0, c).getClass();
}
@Override
public boolean isCellEditable(int row, int column)
{
if (column == 0 || column == 1)
{
return false;
}
else
{
return true;
}
}
}
