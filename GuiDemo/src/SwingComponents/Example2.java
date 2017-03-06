package SwingComponents;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Example2 {

	public static void main(String[] args) {
		JFrame f = new JFrame("Flow Layout Demo");
		
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);
		
		f.setSize(300, 300);
		f.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 100));
		f.setVisible(true);
		

	}

}
