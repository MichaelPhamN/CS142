import java.awt.*;
public class DrawingDemo2D {

	public static void main(String[] args) {
		int width = 600, height = 400;
		int diameter = 100;
		DrawingPanel panel = new DrawingPanel(width,height);
		Graphics g = panel.getGraphics();
		//stripped row
//		for(int y = 0; y + diameter <= height; y = y+ diameter){
//			if(y/200 * 200 == y) g.setColor(Color.BLACK);
//			else g.setColor(Color.BLUE);
//			for(int x = 0; x + diameter <= width; x = x + diameter){
//				g.drawOval(x, y, diameter, diameter);
//			}
//		}
		//Now, try drawing a column at a time (stripped columns)
		for(int y = 0; y + diameter <= height; y = y+ diameter){			
			for(int x = 0; x + diameter <= width; x = x + diameter){
				if(x/200 * 200 == x) g.setColor(Color.BLACK);
				else g.setColor(Color.BLUE);
				g.drawOval(x, y, diameter, diameter);
			}
		}
	}

}
