
public class Triangle extends Polygon{
	private double x1, y1;
	private double x2, y2;
	private double x3, y3;	
	private double xCenter, yCenter;
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
		super((x1 + x2 + x3)/3, (y1 + y2 + y3)/3);
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
		
		this.x3 = x3;
		this.y3 = y3;
	}
	
	public double getCenterX(){
		return super.getCenterX();
	}
	
	public double getCenterY(){
		return super.getCenterY();
	}
	
	@Override
	public int pointCount() {
		return 3;
	}
	
	@Override
	public double getPointX(int point) {
		return xCenter;
	}
	
	@Override
	public double getPointY(int point) {
		return yCenter;
	}
	
	@Override 
	public double area(){
		double area = Math.abs((x1 * (y2 - y3) + x2 * (y3-y1) + x3 * (y1 - y2))/2);
		return area;
	}
	
	@Override
	public double perimeter(){
		double perimeter = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) + Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3)) 
							+ Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
		return perimeter;
	}
	
	
	@Override
	public void scale(double scaleFactor){
		this.x1 = super.getCenterX() - (super.getCenterX() - this.x1)*scaleFactor;
		this.y1 = super.getCenterY() - (super.getCenterY() - this.y1)*scaleFactor;
		
		this.x2 = super.getCenterX() - (super.getCenterX() - this.x2)*scaleFactor;
		this.y2 = super.getCenterY() - (super.getCenterY() - this.y2)*scaleFactor;
		
		this.x3 = super.getCenterX() - (super.getCenterX() - this.x3)*scaleFactor;
		this.y3 = super.getCenterY()- (super.getCenterY() - this.y3)*scaleFactor;
	}
	
}
