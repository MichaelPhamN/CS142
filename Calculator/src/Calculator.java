import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNorth = new JButton("North");
		contentPane.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnWest = new JButton("West");
		contentPane.add(btnWest, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("South");
		contentPane.add(btnNewButton_1, BorderLayout.SOUTH);
		
		JButton btnEast = new JButton("East");
		contentPane.add(btnEast, BorderLayout.EAST);
		
		JButton btnCenter = new JButton("Center");
		contentPane.add(btnCenter, BorderLayout.CENTER);
	}

}
