import java.awt.*;
public class DrawingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 600, height = 400;
		int diameter = 100;
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getDebuggingGraphics();
		int xOffset = 10;
		for(int x = 0, y = height - diameter; x + diameter <= width; x = x + xOffset){
			if(x/3  * 3 == x) continue;
			g.drawOval(x, y, diameter, diameter);
		}
		//Line circle on the top
		for(int x = 0, y = 0; x + diameter <= width; x = x + xOffset){
			if(x/3  * 3 == x) continue;
			g.drawOval(x, y, diameter, diameter);
		}
		
		//Line circle on the left
		for(int x = 0, y = 0; y + diameter < height; y = y + xOffset){
			if(y/3  * 3 == y) continue;
			g.drawOval(x, y, diameter, diameter);
		}
		
		//Line circle on the right
		for(int y = 0, x = width - diameter; y + diameter < height; y = y + xOffset){	
			if(y/3  * 3 == y) continue;
			g.drawOval(x, y, diameter, diameter);
		}
	}

}
