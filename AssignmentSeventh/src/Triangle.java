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
	
	public boolean isClockwise(double x1, double y1, double x2, double y2, double x3, double y3)
	{		
		double sum = 0;
		sum = sum + (x2 - x1) * (y2 + y1) + (x3 - x2) * (y3 + y2);		
		if(sum > 0)
			return true;
		else
			return false;
	}
	
	@Override
	public double getPointX(int point) {
		double newX1, newX2, newX3;
		
		double distanceMoveCenterX;
		
		distanceMoveCenterX = super.getCenterX() + (this.x1 + this.x2 + this.x3)/3;
		
		newX1 = this.x1 - distanceMoveCenterX;
		newX2 = this.x2 - distanceMoveCenterX;
		newX3 = this.x3 - distanceMoveCenterX;
		
		if(isClockwise(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3)){			
			if(point == 0){				
				return newX1;
			}
			if(point == 1){
				return newX2;
			}
			if(point ==  2){
				return newX3;
			}
		}else{
			if(point == 0)
				return  newX1;
			if(point == 1)
				return  newX3;
			if(point == 2)
				return  newX2;
		}
		throw new IllegalArgumentException();
	}
	
	@Override
	public double getPointY(int point) {
		double newY1, newY2, newY3;
		
		double distanceMoveCenterY;
		
		distanceMoveCenterY = super.getCenterY() + (this.y1 + this.y2 + this.y3)/3;
		
		newY1 = this.y1 - distanceMoveCenterY;
		newY2 = this.y2 - distanceMoveCenterY;
		newY3 = this.y3 - distanceMoveCenterY;
		if(isClockwise(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3)){
			if(point == 0){
				return newY1;
			}
			if(point == 1){
				return newY2;
			}
			if(point ==  2){
				return newY3;
			}
		}else{
			if(point == 0)
				return newY1;
			if(point == 1)
				return newY3;
			if(point == 2)
				return newY2;
		}
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
		
		
		double newX1, newX2, newX3;
		double newY1, newY2, newY3;
		double newScaleX1, newScaleX2, newScaleX3;
		double newScaleY1, newScaleY2, newScaleY3;
		double newCenterX, newCenterY;
		double distanceMoveCenterX;
		double distanceMoveCenterY;
		
		distanceMoveCenterX = (this.x1 + this.x2 + this.x3)/3 - super.getCenterX();
		
		newX1 = this.x1 - distanceMoveCenterX;
		newX2 = this.x2 - distanceMoveCenterX;
		newX3 = this.x3 - distanceMoveCenterX;		
		newCenterX = (newX1 + newX2 + newX3)/3;
		
		distanceMoveCenterY = (this.y1 + this.y2 + this.y3)/3 - super.getCenterY();
		
		newY1 = this.y1 - distanceMoveCenterY;
		newY2 = this.y2 - distanceMoveCenterY;
		newY3 = this.y3 - distanceMoveCenterY;
		newCenterY = (newY1 + newY2 + newY3)/3;
		
//		System.out.println(newX1);
//		System.out.println(newY1);
//		System.out.println(newX2);
//		System.out.println(newY2);
//		System.out.println(newX3);
//		System.out.println(newY3);
//		System.out.println(newCenterX);
//		System.out.println(newCenterY);
//		System.exit(0);
		
		newScaleX1 = newCenterX - (newCenterX - newX1)*scaleFactor;
		newScaleY1 = newCenterY - (newCenterY - newY1)*scaleFactor;
		
		newScaleX2 = newCenterX - (newCenterX - newX2)*scaleFactor;
		newScaleY2 = newCenterY - (newCenterY - newY2)*scaleFactor;
		
		newScaleX3 = newCenterX - (newCenterX - newX3)*scaleFactor;
		newScaleY3 = newCenterY - (newCenterY - newY3)*scaleFactor;
		
		if(isClockwise(newScaleX1, newScaleY1, newScaleX2, newScaleY2, newScaleX3, newScaleY3)){	
			this.x1 = newScaleX1;
			this.y1 = newScaleY1;
			
			this.x2 = newScaleX2;
			this.y2 = newScaleY2;
			
			this.x3 = newScaleX3;
			this.y3 = newScaleY3;			
		}else{
			this.x1 = newScaleX1;
			this.y1 = newScaleY1;
			
			this.x2 = newScaleX3;
			this.y2 = newScaleY3;
			
			this.x3 = newScaleX2;
			this.y3 = newScaleY2;	
		}
		
		System.out.println(this.x1);
		System.out.println(this.y1);
		
		System.out.println(this.x2);
		System.out.println(this.y2);
		
		System.out.println(this.x3);
		System.out.println(this.y3);
//		this.x1 = super.getCenterX() - (super.getCenterX() - this.x1)*scaleFactor;
//		this.y1 = super.getCenterY() - (super.getCenterY() - this.y1)*scaleFactor;
//		
//		this.x2 = super.getCenterX() - (super.getCenterX() - this.x2)*scaleFactor;
//		this.y2 = super.getCenterY() - (super.getCenterY() - this.y2)*scaleFactor;
//		
//		this.x3 = super.getCenterX() - (super.getCenterX() - this.x3)*scaleFactor;
//		this.y3 = super.getCenterY()- (super.getCenterY() - this.y3)*scaleFactor;
	}
	
}
