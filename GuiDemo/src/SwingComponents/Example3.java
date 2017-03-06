package SwingComponents;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Example3 {

	public static void main(String[] args) {
		JFrame j = new JFrame("Ví dụ về FlowLayout");
		
		j.setLayout(new GridLayout(3,1));
		
		JLabel lb1 = new JLabel("Layout in action: FlowLayout");
		
		
	}

}
