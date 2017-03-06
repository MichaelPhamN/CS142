package SwingComponents;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Simple2 extends JFrame {	
	public Simple2(){
		JButton b = new JButton("Click");
		b.setBounds(130, 100, 100, 40);
		
		add(b);
		
		setSize(400,500);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Simple2();

	}

}
