import java.awt.Point;

public class Rectangle {

	double length, height, rectArea; // assigning variables for length, height and area of the rectangle

	Point ul; // assigning variables for all corners
	Point ur;
	Point lr;
	Point ll;

	Rectangle(Point p_ul, Point p_ur, Point p_lr, Point p_ll) { //constructor assigning Point variables 
		ul = p_ul;
		ur = p_ur;
		lr = p_lr;
		ll = p_ll;        
	}

	Rectangle(int x_ul, int y_ul, int x_ur, int y_ur, int x_lr, int y_lr, int x_ll, int y_ll) { //constructor assigning coordinates for each corner Point variable
		ul = new Point (x_ul, y_ul);
		ur = new Point (x_ur, y_ur);
		lr = new Point (x_lr, y_lr);
		ll = new Point (x_ll, y_ll);        
	}

	public double rectArea() {
		double length = Math.sqrt( (ur.getX()-ul.getX()) * (ur.getX()-ul.getX()) ) + ( (ur.getY()-ul.getY()) * (ur.getY()-ul.getY()) ); //calculates length
		double height = Math.sqrt( (ur.getX()-lr.getX()) * (ur.getX()-lr.getX()) ) + ( (ur.getY()-lr.getY()) * (ur.getY()-lr.getY()) ); //calculates height

		return(length * height);
	}

	void displayInfo() { //Print statements   
		System.out.println("Rectangle Info: ");
		System.out.println("Upper Left Point (x,y) : (" + ul.getX() + "," + ul.getY() + ")");
		System.out.println("Upper Right Point (x,y) : (" + ur.getX() + "," + ur.getY() + ")");
		System.out.println("Lower Left Point (x,y) : (" + ll.getX() + "," + ll.getY() + ")");
		System.out.println("Lower Right Point (x,y) : (" + lr.getX() + "," + lr.getY() + ")");        
		System.out.println("Area: " + rectArea);
		System.out.println("Length: " + length);
		System.out.println("Height: " + height);
		System.out.println("ur-lr(Y): " + (ur.getY()-lr.getY()));// this prints 4
		System.out.println("ur-lr(X): " + (ur.getX()-lr.getX()));// this prints 0
	}    
}