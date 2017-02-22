
public class Rectangle extends Shape {
	public java.awt.Rectangle rect;
	
	public Rectangle(Rectangle rect){
		this.rect = rect;
	}
	
	@Override
	public double area(){
		return rect.height * rect.width;
	}
	
	@Override
	public double periemeter(){
		return 2 * (rect.height + rect.width); 
	}
}
