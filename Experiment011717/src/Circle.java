
public class Circle extends Shape{
	public double radius;
	public double centerX, centerY;
	public Circle(double CenterX, double CenterY, double radius){
		this.radius = radius;
		this.centerX = CenterX;
		this.centerY = CenterY;
	}
	// String representation: ({x}, {y}) radius {r}
	// where {x},{y}, {r} are the actual values
	public String toString(){
		return "({" + this.centerX + "}, {" + this.centerY + "}) radius {" + this.radius + "}";
	}
	
	@Override
	public double area(){
		return radius * radius * Math.PI;
	}
	
	@Override
	public double periemeter(){
		return 2 * Math.PI * radius; 
	}
	
	public boolean equals(Object o){
		if(o instanceof Circle){
			Circle c = (Circle) o;
			return centerX == c.centerX && centerY== c.centerY && radius == c.radius;
		}
		return false;
	}
	public boolean intersects(Circle c){
		// compute the distance between the two centers
		// square root of (x1 - x2)^2 + (y1 - y2)^2
		return (centerX - c.centerX)*(centerX - c.centerX) 
				+ (centerY - c.centerY)*(centerY - c.centerY) < radius + c.radius;
	}
}
