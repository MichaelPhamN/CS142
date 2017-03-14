import java.util.Arrays;

public class Triangle extends Polygon{
	private double x1, y1;
	private double x2, y2;
	private double x3, y3;	
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){		
		super((x1 + x2 + x3)/3, (y1 + y2 + y3)/3);
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
		
		this.x3 = x3;
		this.y3 = y3;
//		throw new IllegalArgumentException();
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
		double[][] points = new double[3][2];
		double tmpX, tmpY;
		points[0][0] = this.x1;
		points[0][1] = this.y1;
		
		points[1][0] = this.x2;
		points[1][1] = this.y2;
		
		points[2][0] = this.x3;
		points[2][1] = this.y3;		
		for(int i = 0; i <2; i++){			
			for(int j = i + 1; j <3; j++){
				if(points[i][0] > points[j][0])
				{					
					tmpX = points[i][0];
					tmpY = points[i][1];
					points[i][0] = points[j][0];
					points[i][1] = points[j][1];
					points[j][0] = tmpX;
					points[j][1] = tmpY;				
				}else if(points[i][0] == points[j][0]){
					if(points[i][1] > points[j][1]){
						tmpX = points[j][0];
						tmpY = points[j][1];
						points[j][0] = points[i][0];
						points[j][1] = points[i][1];
						points[i][0] = tmpX;
						points[i][1] = tmpY;
					}
				}				
			}
			
			
		}
		if(point == 0){
			int xStart = -1;
			for(int i = 0; i < 3; i++){
				if(points[i][0] == this.x1 && points[i][1] == this.y1)
				{
					xStart = i;
					break;
				}
			}
			if(xStart == 0)
				return points[0][0];			
		}
	}
	
	@Override
	public double getPointY(int point) {
		
		throw new IllegalArgumentException();
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
		if (scaleFactor <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.x1 = super.getCenterX() - (super.getCenterX() - this.x1)*scaleFactor;
		this.y1 = super.getCenterY() - (super.getCenterY() - this.y1)*scaleFactor;
		
		this.x2 = super.getCenterX() - (super.getCenterX() - this.x2)*scaleFactor;
		this.y2 = super.getCenterY() - (super.getCenterY() - this.y2)*scaleFactor;
		
		this.x3 = super.getCenterX() - (super.getCenterX() - this.x3)*scaleFactor;
		this.y3 = super.getCenterY()- (super.getCenterY() - this.y3)*scaleFactor;
	}
	
}
