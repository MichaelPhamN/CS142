import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class GFxReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawingPanel panel;
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		try {
			Scanner s = new Scanner(chooser.getSelectedFile());
			panel = new DrawingPanel(s.nextInt(),s.nextInt());
			Graphics g = panel.getGraphics();
			while(s.hasNextLine()){
				String command = s.next();
				if(command.equals("oval"))
				{
					String type = s.next();
					int x = s.nextInt();
					int y = s.nextInt();
					int width = s.nextInt();
					int height = s.nextInt();
					if(type == "")
					g.drawOval(x, y, width, height);
				}else if(command.equals("rectangle")){
					g.drawRect(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
				}
				else if(command.equals("color")){
					g.setColor(new Color(s.nextInt(),s.nextInt(),s.nextInt()));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}