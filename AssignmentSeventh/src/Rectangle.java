
public class Rectangle extends Polygon {

	private double width, height;

	/**
	 * Create a Rectangle with the given upper left xy coordinate, width, and
	 * height. Throws IllegalArgumentException if a rectangle of non-positive
	 * width or height is specified.
	 * 
	 * @param x
	 *            Upper left x coordinate
	 * @param y
	 *            Upper left y coordinate
	 * @param width
	 *            Width (must be positive)
	 * @param height
	 *            Height (must be positive)
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x + width / 2, y + height / 2);
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}
		this.width = width;
		this.height = height;
	}

	@Override
	public int pointCount() {
		return 4;
	}

	@Override
	public double getPointX(int point) {
		if (point == 0 || point == 3) {
			return getCenterX() - width / 2;
		}
		if (point == 1 || point == 2) {
			return getCenterX() + width / 2;
		}
		throw new IllegalArgumentException();
	}

	@Override
	public double getPointY(int point) {
		if (point == 0 || point == 1) {
			return getCenterY() - height / 2;
		}
		if (point == 2 || point == 3) {
			return getCenterY() + height / 2;
		}
		throw new IllegalArgumentException();
	}

	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return 2 * (width + height);
	}

	@Override
	public void scale(double scaleFactor) {
		if (scaleFactor <= 0) {
			throw new IllegalArgumentException();
		}
		width *= scaleFactor;
		height *= scaleFactor;
	}

}
