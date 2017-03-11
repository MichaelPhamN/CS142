import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
public class MyNumberPanel extends JPanel implements  MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isFinished=false;
	public boolean getIsFinished()
	{
		return isFinished;
	}
	public void addNumber(MyNumber number)
	{
		arr.add(number);
	}
	public void addNumbers(int num)
	{
		arr.clear();
		Random ran=new Random(); 
		for(int i=0;i<num;i++)
		{
			MyNumber number=new MyNumber(ran.nextInt(100), getGraphics());
			number.setX(i*MyNumber.YSIZE);
			number.setY(getBounds().getHeight()/2-MyNumber.YSIZE);
			addNumber(number);
		}
	}
	public MyNumberPanel()
	{
		arr=new ArrayList<MyNumber>();
		addMouseListener(this);
		
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		Graphics2D g2 = (Graphics2D) arg0;
		for(int i=0;i<arr.size();i++)
		{
			MyNumber number=arr.get(i);
			number.setGraph(g2);
			number.draw();
		}
	}
	public void printInfor()
	{
		for(MyNumber number:arr)
		{
			System.out.println(number.getNumber() +"(x:"+number.getX() +",y:"+number.getY()+")");
		}
	}
	public synchronized void doSelectionSort()
	{
		
	}
	public synchronized void doInsertionSort()
	{
		
	}
	public synchronized void doQuickSort()
	{
		
	}
	public synchronized void moveControl(MyNumber number1,MyNumber number2)
	{
		printInfor();
		double x1=number1.getX();
		double y1=number1.getY();
		double x2=number2.getX();
		double y2=number2.getY();
		try {
				for(int k=1;k<150;k++)
				{
					number1.setY(y1+k);
					number2.setY(y2-k);
					Thread.sleep(10);
					repaint();
				}
				int k=0;
				while(number1.getX()<=x2-1)
				{
					k++;
					number1.setX(x1+k);
					number2.setX(x2-k);
					Thread.sleep(10);
					repaint();
				}
				y1=number1.getY();
				y2=number2.getY();
				for(k=1;k<150;k++)
				{
					number1.setY(y1-k);
					number2.setY(y2+k);
					Thread.sleep(10);
					repaint();
				}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	public synchronized void doBubbleSort()
	{
		try {
			isFinished=false;
			for(int i=0;i<arr.size();i++)
			{
				for(int j=i+1;j<arr.size();j++)
				{
					MyNumber number1=arr.get(i);
					MyNumber number2=arr.get(j);
					if(number1.getNumber()>number2.getNumber())
					{
						moveControl(number1, number2);
						MyNumber nt1=number1;
						number1=number2;
						number2=nt1;
						arr.set(i, number1);
						arr.set(j, number2);
					}
				}
				
			}
			isFinished=true;
			System.out.println("-------");
			printInfor();
			MyNumber.COLOR1=Color.BLUE;
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	ArrayList<MyNumber>arr=new ArrayList<MyNumber>();
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(MyNumber number : arr)
		{
			boolean b= number.getFace().contains(e.getPoint().getX(), e.getPoint().getY());
			if(b==true)
				{
					System.out.println(b+" - " + number);
					Graphics2D g=(Graphics2D)number.getGraph();
					g.setColor(Color.YELLOW);
					g.fill(number.getFace());
					this.repaint(number.getFace().getBounds());
				}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
