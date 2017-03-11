import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyNumber {
	public static final int XSIZE = 50;
	public static final int YSIZE = 50;
	private double x = 0;
	private double y = 0;
	private int num=0;
	private Graphics graph=null;
	private Ellipse2D face;
	public Ellipse2D getShape()
	{
		face=new Ellipse2D.Double(x, y, XSIZE, YSIZE);
		return face;
	}
	public void setNumber(int num)
	{
		this.num=num;
	}
	public void setGraph(Graphics graph)
	{
		this.graph=graph;
	}
	public int getNumber()
	{
		return this.num;
	}
	public MyNumber(int num)
	{
		this.num=num;
	}
	public MyNumber(int num, Graphics graph)
	{
		this.graph=graph;
		this.num=num;
	}
	public static Color COLOR1=Color.BLACK;
	public static Color COLOR2=Color.RED;
	public void draw()
	{
		if(graph!=null)
		{
			Graphics2D g=(Graphics2D) graph;
			
			g.setColor(COLOR1);
			g.fill(getShape());
			
			Font font=new Font("arial", Font.ITALIC|Font.BOLD, 15);
			g.setFont(font);
			g.setColor(COLOR2);
			g.drawString(num+"", (float)x+18, (float)(y+30));
		}
	}
	public void setX(double x)
	{
		this.x=x;
	}
	public double getX()
	{
		return this.x;
	}
	public double getY()
	{
		return this.y;
	}
	public void setY(double y)
	{
		this.y=y;
	}
	public MyNumber()
	{
		this.num=0;
		this.graph=null;
	}
	public Ellipse2D getFace()
	{
		return face;
	}
	public Graphics getGraph()
	{
		return this.graph;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.num+"";
	}
}
