
public class Circle extends Shape {

	private double radius;

	/**
	 * Creates a Circle with the given center xy coordinate and radius. Throws
	 * IllegalArgumentException if the radius is not positive.
	 * 
	 * @param x
	 *            Center x coordinate
	 * @param y
	 *            Center y coordinate
	 * @param radius
	 *            Radius (must be positive)
	 */
	public Circle(double x, double y, double radius) {
		super(x, y);
		if (radius <= 0) {
			throw new IllegalArgumentException();
		}
		this.radius = radius;
	}

	@Override
	public void scale(double scaleFactor) {
		if (scaleFactor <= 0) {
			throw new IllegalArgumentException();
		}
		radius *= scaleFactor;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

}
