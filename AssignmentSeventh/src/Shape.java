
public abstract class Shape {
	// The center point of this shape (the average of all points making up the
	// perimeter of the shape)
	private double centerX, centerY;

	/**
	 * Construct a Shape object. Shapes should be constructed with positive
	 * area.
	 * 
	 * @param centerX Center x coordinate
	 * @param centerY Center y coordinate
	 */
	public Shape(double centerX, double centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}

	/**
	 * Get the x coordinate of the center of this shape.
	 * 
	 * @return center X
	 */
	public double getCenterX() {
		return centerX;
	}

	/**
	 * Get the y coordinate of the center of this shape.
	 * 
	 * @return center Y
	 */
	public double getCenterY() {
		return centerY;
	}

	/**
	 * Move shape to a new location.
	 * 
	 * @param newCenterX
	 *            New x coordinate of center
	 * @param newCenterY
	 *            New y coordinate of center
	 */
	public void move(double newCenterX, double newCenterY) {
		centerX = newCenterX;
		centerY = newCenterY;
	}

	/**
	 * Uniformly scale the shape by the given scale factor along both axes. The
	 * center should remain the same. Throws an IllegalArgumentException if the
	 * given scale factor is not a positive value.
	 * 
	 * @param scaleFactor
	 *            Scale factor (must be greater than 0)
	 */
	public abstract void scale(double scaleFactor);

	/**
	 * Retrieve the area of this Shape object. All shapes have positive area.
	 * 
	 * @return area
	 */
	public abstract double area();

	/**
	 * Retrieve the perimeter of this Shape object.
	 * 
	 * @return perimeter
	 */
	public abstract double perimeter();

}
