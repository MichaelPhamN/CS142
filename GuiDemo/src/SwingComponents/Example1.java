package SwingComponents;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example1 {

	public static void main(String[] args) {
		JFrame f = new JFrame("Vi du Java Swing");
		
		JLabel j1 = new JLabel("Control in action: JLabel", JLabel.CENTER);		
		f.add(j1);
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		JLabel controlPanel = new JLabel("Chao mung ban den voi bai huong dan Java Swing");
		controlPanel.setOpaque(true);
		controlPanel.setBackground(Color.GRAY);
		controlPanel.setForeground(Color.WHITE);
		p.add(controlPanel);
		f.add(p);
		
		
		JLabel j2 = new JLabel("", JLabel.CENTER);		
		
		f.add(j2);
		
		f.setSize(400, 400);
		f.setLayout(new GridLayout(3,1));
		f.setVisible(true);
		
		
	}

}
