
public class TriangleTesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle tr = new Triangle(0,0,3,0,0,-3);
//		tr.move(1, -1);
//		System.out.println(tr.getPointX(0));
//		System.out.println(tr.getPointY(0));
//		System.out.println(tr.getPointX(1));
//		System.out.println(tr.getPointY(1));
//		System.out.println(tr.getPointX(2));
//		System.out.println(tr.getPointY(2));
//		System.out.println(tr.getCenterX());
//		System.out.println(tr.getCenterY());
		tr.move(-1,-1);
		System.out.println(tr.getPointX(0));
		System.out.println(tr.getPointY(0));
		System.out.println(tr.getPointX(1));
		System.out.println(tr.getPointY(1));
		System.out.println(tr.getPointX(2));
		System.out.println(tr.getPointY(2));
		System.out.println(tr.getCenterX());
		System.out.println(tr.getCenterY());
	}

}
