
public class Rectangle extends Shape {
	public java.awt.Rectangle rect;
	
	public Rectangle(java.awt.Rectangle rect){
		this.rect = rect;
	}
	
	@Override
	public double area(){
		return rect.height * rect.width;
	}	


	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2 * (rect.height + rect.width); 
	}
}
