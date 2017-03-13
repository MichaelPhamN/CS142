
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
	
//	public double getCenterX(int point){
//		
//	}
//	
//	public double getCenterY(int point){
//		
//	}
	
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
		double[] scalePointXs = new double[3];
		double[] scalePointYs = new double[3];
		scalePointXs[0] = (super.getCenterX() - this.x1)*scaleFactor + super.getCenterX();
		scalePointYs[0] = (super.getCenterY() - this.y1)*scaleFactor + super.getCenterY();
		System.out.println(scalePointXs[0]);
		System.out.println(scalePointYs[0]);
		
		scalePointXs[1] = (super.getCenterX() - this.x2)*scaleFactor + super.getCenterX();
		scalePointYs[1] = (super.getCenterY() - this.y2)*scaleFactor + super.getCenterY();
		System.out.println(scalePointXs[1]);
		System.out.println(scalePointYs[1]);
		
		scalePointXs[2] = (super.getCenterX() - this.x3)*scaleFactor + super.getCenterX();
		scalePointYs[2] = (super.getCenterY() - this.y3)*scaleFactor + super.getCenterY();
		System.out.println(scalePointXs[2]);
		System.out.println(scalePointYs[2]);
	}
	
}
