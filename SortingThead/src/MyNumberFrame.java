import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

enum SORTTYPE{BUBBLE_SORT,SELECTION_SORT,INSERTION_SORT,QUICK_SORT};
public class MyNumberFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static SORTTYPE SortType=SORTTYPE.BUBBLE_SORT;
	MyNumberPanel pnCenter=null;
	JTextField txtNumber=null;
	public MyNumberFrame()
	{
		addControl();
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void addControl()
	{
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		con.add(pnNorth,BorderLayout.NORTH);
		JPanel pnNothBorder=new JPanel();
		pnNothBorder.setLayout(new BoxLayout(pnNothBorder, BoxLayout.Y_AXIS));
		JPanel pnNorthBorderLine1=new JPanel();
		JLabel lblNumber=new JLabel("Number Of:");
		txtNumber=new JTextField(3);
		JButton btnDraw=new JButton("Draw");
		pnNorthBorderLine1.add(lblNumber);
		pnNorthBorderLine1.add(txtNumber);
		pnNorthBorderLine1.add(btnDraw);
	
		
		JPanel pnNorthBorderLine2=new JPanel();
		pnNorthBorderLine1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnNorthBorderLine2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAlgorithm=new JLabel("Algorithm:");
		final JComboBox cboAlgorithm=new JComboBox(new String[]{"Bubble Sort","Selection Sort","Insertion Sort","Quick Sort"});
		JButton btnSort=new JButton("Start Sort");
		pnNorthBorderLine2.add(lblAlgorithm);
		pnNorthBorderLine2.add(cboAlgorithm);
		pnNorthBorderLine2.add(btnSort);
		
		pnNothBorder.add(pnNorthBorderLine1);
		pnNothBorder.add(pnNorthBorderLine2);
		pnNorthBorderLine1.setBackground(Color.LIGHT_GRAY);
		pnNorthBorderLine2.setBackground(Color.LIGHT_GRAY);
		
		con.add(pnNothBorder,BorderLayout.NORTH);
		pnCenter=new MyNumberPanel();
		con.add(pnCenter,BorderLayout.CENTER);
		
		btnDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				drawControl();
			}
		});
		
		btnSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int n=cboAlgorithm.getSelectedIndex();
				switch(n)
				{
				case 0:
					SortType=SORTTYPE.BUBBLE_SORT;
					break;
				case 1:
					SortType=SORTTYPE.SELECTION_SORT;
					break;
				case 2:
					SortType=SORTTYPE.INSERTION_SORT;
					break;
				case 3:
					SortType=SORTTYPE.QUICK_SORT;
					break;
				}
				MyNumberPanelRunable run=new MyNumberPanelRunable(pnCenter);
				Thread th=new Thread(run);
				th.start();
			}
		});
	}
	
	public void drawControl()
	{
		int num=Integer.parseInt(txtNumber.getText());
		MyNumber.COLOR1=Color.BLACK;
		pnCenter.addNumbers(num);
		pnCenter.repaint();
		
	}
}
