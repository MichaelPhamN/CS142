
public class TriangleTest {
	private static boolean allClockwise = true;
	public static boolean check(String quantity, int got, int expected) {
		if (got == expected) {
			System.out.println(quantity+" "+got+" OK");
			return true;
		} else {
			System.out.println(quantity+" not OK: expected "+expected+", got "+got);
			return false;
		}
	}
	public static boolean check(String quantity, double got, double expected) {
		final double epsilon = 1.0/1073741824.0;
		if (Math.abs(got-expected) < epsilon) {
			System.out.println(quantity+" "+got+" OK");
			return true;
		} else {
			System.out.println(quantity+" not OK: expected "+expected+", got "+got);
			return false;
		}
		
	}
	public static boolean checkPoints(Polygon t, double[] pointXs, double[] pointYs) {
		boolean firstPoint = true;
		firstPoint = firstPoint && check("New x1 point",t.getPointX(0), pointXs[0]);
		firstPoint = firstPoint && check("New y1 point",t.getPointY(0), pointYs[0]);
		if (firstPoint) {
			System.out.println("First point OK.");
			System.out.println("Checking for next two points in clockwise order:");
			boolean both = true;
			both = both && check("New x2 point",t.getPointX(1), pointXs[2]);
			both = both && check("New y2 point",t.getPointY(1), pointYs[2]);
			both = both && check("New x3 point",t.getPointX(2), pointXs[1]);
			both = both && check("New y3 point",t.getPointY(2), pointYs[1]);
			if (both) {
				System.out.println("Points are in clockwise order. OK!");
			} else {
				allClockwise = false;
				System.out.println("Checking for counterclockwise order. (Might still be OK.)");
				both = true;
				both = both && check("New x2 point",t.getPointX(1), pointXs[1]);
				both = both && check("New y2 point",t.getPointY(1), pointYs[1]);
				both = both && check("New x3 point",t.getPointX(2), pointXs[2]);
				both = both && check("New y3 point",t.getPointY(2), pointYs[2]);
				if (both) {
					System.out.println("Points are in counterclockwise order! For extra credit, make sure the points are always in clockwise order.");
				} else {
					System.out.println("Points not in counterclockwise order either! Not actually OK!");
				}
			}
			return both;
		} else {
			System.out.println("First point not OK.");
			return false;
		}
	}
	public static void main(String[] args) {
		double[][] triangles = {{0,0,1,0,0,-1},{0,0,0,-1,1,0}, {10,2,0,-1.5,2,-1.5}, {1.2,3.4,5.6,7.8,9.10,11.12}};
		double[] areas = {0.5, 0.5, 3.5,0.3960000000000019};
		double[] perimeters = {3.414213562373095,3.414213562373095,21.326934648495033,22.092428528315892};
		double[] centerXs = {0.3333333333333333,0.3333333333333333,4.0,5.3};
		double[] centerYs = {-0.3333333333333333,-0.3333333333333333,-0.3333333333333333,7.44};
		double[][] newPointXs = {{-0.3333333333333333,-0.3333333333333333,0.6666666666666667},{-0.3333333333333333,-0.3333333333333333,0.6666666666666667},{6,-4,-2.0},{-4.1,3.8,0.2999999999999998}};
		double[][] newPointYs = {{0.3333333333333333,-0.6666666666666667,0.3333333333333333},{0.3333333333333333,-0.6666666666666667,0.3333333333333333},{2.3333333333333335,-1.1666666666666667,-1.1666666666666667},{-4.040000000000001,3.679999999999999,0.35999999999999943}};
		double[] scaleFactor = {1.5,0.5,2.0,0.25};
		double[][] scalePointXs = {{-1.5,-1.5,0},{-1.1666666666666667,-1.1666666666666667,-0.6666666666666666},{11.0,-9.0,-5.0},{-2.025,-0.050000000000000044,-0.925}};
		double[][] scalePointYs = {{-0.5,-2.0,-0.5},{-0.8333333333333334,-1.3333333333333335,-0.8333333333333334},{3.666666666666667,-3.3333333333333335,-3.3333333333333335},{-2.0100000000000002,-0.0800000000000003,-0.9100000000000001}};
		int okCount = 0;
		int ecCount = 0;
		for (int i = 0; i < triangles.length; i++) {
			try {
				boolean allOK = true;
				System.out.println("Creating Polygon Triangle with vertices: ("+triangles[i][0]+", "+triangles[i][1]+"), ("+triangles[i][2]+", "+triangles[i][3]+"), ("+triangles[i][4]+", "+triangles[i][5]+")");
				Polygon t = new Triangle(triangles[i][0], triangles[i][1], triangles[i][2], triangles[i][3], triangles[i][4], triangles[i][5]);
				allOK = allOK && check("Point count", t.pointCount(), 3);
				allOK = allOK && check("Area", t.area(), areas[i]);
				allOK = allOK && check("Perimeter", t.perimeter(), perimeters[i]);
				allOK = allOK && check("Center x", t.getCenterX(), centerXs[i]);
				allOK = allOK && check("Center y", t.getCenterY(), centerYs[i]);
				System.out.println("Moving to (0, 0)");
				t.move(0, 0);
				allOK = allOK && check("New area", t.area(), areas[i]);
//				allOK = allOK && check("New perimeter", t.perimeter(), perimeters[i]);
//				allOK = allOK && checkPoints(t, newPointXs[i], newPointYs[i]);
				if (allOK) {
					okCount++;
					System.out.println("All OK for this triangle. Checking scale extra credit. Moving to (-1, -1)");
					t.move(-1, -1);
					System.out.println("Scaling by "+scaleFactor[i]);
					t.scale(scaleFactor[i]);
					allOK = allOK && check("Scaled area", t.area(), areas[i]*scaleFactor[i]*scaleFactor[i]);
					allOK = allOK && checkPoints(t, scalePointXs[i], scalePointYs[i]);
					if (allOK) {
						ecCount++;
						System.out.println("Scale extra credit looks OK for this example!");
					}
				} else {
					System.out.println("Please correct the above 'not OK' items for this triangle. Some additional errors may appear!");
				}
				if (i < triangles.length-1) {
					System.out.println("----------------------------------------------------------------------------------------------------------");
				}
			} catch (Exception e) {
				System.out.println("Uh oh, there was an exception! You should take a look at your code!");
				e.printStackTrace(System.out);
				System.out.println("Moving on to next triangle.");
			}
		}
		System.out.println(okCount+"/"+triangles.length+" triangles had no errors seen.");
		if (okCount < triangles.length) {
			System.out.println("Please try to fix the errors!");
		} else {
			System.out.println("Great! At least one additional triangle will be tested when grading.");
		}
		if (allClockwise && okCount == triangles.length) {
			System.out.println("All triangles were in clockwise order!");
		} else {
			System.out.println("You didn't get all triangles with no errors and in clockwise order.");
		}
		if (ecCount > 0) {
			System.out.println(ecCount+"/"+triangles.length+" triangles' scale methods were OK.");
		} else {
			System.out.println("It looks like you didn't implement the extra credit scale method.");
		}
	}

}
