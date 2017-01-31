
public class NumericalIntegrator {

	public static void main(String[] args) {
		double minX = -2.0;
		double maxX = 2.0;		
		int numPoints = 3;
		
		double rangeInterval = (maxX - minX)/(numPoints - 1);
		double sumAreas = 0;
		for(double i = minX; i  < maxX; i = i + rangeInterval){
			double[] arrY = new double[2]; 
			int j = 0;
			for(double x = i; x <= i + rangeInterval; x = x + rangeInterval){				
				double y = x*x;						
				arrY[j] = y;
				j++;
			}
			sumAreas = sumAreas + (((arrY[0] + arrY[1])/2)*rangeInterval);			
		}
		System.out.println(sumAreas);
		
	}

}
