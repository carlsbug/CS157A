package FrontEnd;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class myView extends JPanel{
	JTextArea textArea = new JTextArea(15, 30);
	JTextField textField = new JTextField(15);
	JButton addButton = new JButton("add");
	
	private MyModel model;
	
	public myView(MyModel _model)
	{
		model = _model;
		
		setLayout(new BorderLayout());
		add(addButton, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
	}
	
	public String getText()
	{
		return textField.getText();
	}
	
	public void setTextArea()
	{
		textArea.setText(model.nameList());
	}
	
	public void addLineListener(ActionListener e)
	{
		addButton.addActionListener(e);
	}
}
