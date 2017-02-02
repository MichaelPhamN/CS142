
public class NumericalIntegrator {
	public static double Area(double MinX, double MaxX, int NumPoints){
		double rangeInterval = (MaxX - MinX)/(NumPoints - 1);
		double sumAreas = 0;
		for(double i = MinX; i  < MaxX; i = i + rangeInterval){
			double[] arrY = new double[2]; 
			int j = 0;
			for(double x = i; x <= i + rangeInterval; x = x + rangeInterval){				
				double y = x*x;						
				arrY[j] = y;
				j++;
			}
			sumAreas = sumAreas + (((arrY[0] + arrY[1])/2)*rangeInterval);			
		}
		return sumAreas;
	}
	
	public static void main(String[] args) {
		double minX = -2.0;
		double maxX = 2.0;		
		int numPoints = 3;
		double preArea = 0, nextArea = 0;
		System.out.println(Area(minX, maxX, numPoints));
		while(true){
			int i = numPoints;
			int j = numPoints + 1;
			preArea = Area(minX, maxX, i);
			nextArea = Area(minX, maxX, j);
			if(nextArea - preArea <= 0.01){
				System.out.println(i);
				break;
			}else{
				numPoints = numPoints + 1;
			}
		}
		
		
	}

}
