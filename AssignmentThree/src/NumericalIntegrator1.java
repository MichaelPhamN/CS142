import java.util.Arrays;
public class NumericalIntegrator1 {
	public static double[] createTableForFixedFunction(double MinX, int NumPoints, double Distance){
		double[] table = new double[NumPoints];
		for(int i = 0; i< NumPoints; i++){
			double x = MinX + i * Distance;
			double y = Math.pow(x, 3) - x*x + 3;
			table[i] = y;
		}		 
		return table;
	}
	public static void main(String[] args) {
		double minX = -1;
		double maxX = 1;
		int numPoints = 5;
		double distance = (maxX - minX)/(numPoints - 1);
		double[] fnTable = createTableForFixedFunction(minX, numPoints, distance);
		System.out.println(Arrays.toString(fnTable));
	}

}
