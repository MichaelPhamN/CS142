import java.awt.Rectangle;
import java.util.Scanner;

public class RectangleInput {

	public static Rectangle inputRectangle(Scanner s){
		System.out.println("Please enter a rectangle width:");
		int width = s.nextInt();
		System.out.println("Please enter a rectangle height:");
		int height = s.nextInt();
		System.out.println("Please enter the upper left x coordinate:");
		int x = s.nextInt();
		System.out.println("Please enter the upper left y coordinate:");
		int y = s.nextInt();
		return new Rectangle(x,y,width,height);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Rectangle r1 = inputRectangle(s);
		Rectangle r2 = inputRectangle(s);
		Rectangle r3 = r1.intersection(r2);
	}

}
