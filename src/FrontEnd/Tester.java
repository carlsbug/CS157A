package FrontEnd;

import javax.swing.JFrame;

public class Tester {
	public static void main(String[] args) {
		
		MyModel model = new MyModel();
		myView view = new myView(model);
		myController controller = new myController(model, view);

		JFrame myFrame = new JFrame();
		myFrame.add(view);
		myFrame.pack();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}
}
