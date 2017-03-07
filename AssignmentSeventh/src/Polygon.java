
public abstract class Polygon extends Shape {
	public Polygon(double centerX, double centerY) {
		super(centerX, centerY);
	}

	/**
	 * Get the number of points in this polygon (an n-gon has n points, e.g. a
	 * pentagon has 5 points, etc.).
	 * 
	 * @return number of points in this polygon
	 */
	public abstract int pointCount();

	/**
	 * Get x coordinate of point at index provided. Points are indexed in
	 * clockwise order.
	 * 
	 * @param point
	 *            Index of point
	 * @return x coordinate of point, or IllegalArgumentException if point < 0
	 *         or point >= pointCount().
	 */
	public abstract double getPointX(int point);

	/**
	 * Get y coordinate of point at index provided. Points are indexed in
	 * clockwise order.
	 * 
	 * @param point
	 *            Index of point
	 * @return y coordinate of point, or IllegalArgumentException if point < 0
	 *         or point >= pointCount().
	 */
	public abstract double getPointY(int point);

}
