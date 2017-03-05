package SwingComponents;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstSwingExample {

	public static void main(String[] args) {
		
		// Create New JFrame
		JFrame f = new JFrame();
		
		// Create New Button & set Size
		JButton b = new JButton("Click");
		b.setBounds(130, 100, 100, 40);
		
		// Set Button to Frame
		f.add(b);
		
		// Set Size of Frame
		f.setSize(400, 500);
		f.setLayout(null);
		f.setVisible(true);
		
	}

}
