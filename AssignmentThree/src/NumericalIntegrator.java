public class NumericalIntegrator {
	public static double Area(double MinX, double MaxX, int NumPoints){
		double rangeInterval = (MaxX - MinX)/(NumPoints - 1);
		double sumAreas = 0;
		for(double i = MinX; i  < MaxX; i = i + rangeInterval){
			double[] arrY = new double[2]; 
			int j = 0;
			for(double x = i; x <= i + rangeInterval; x = x + rangeInterval){				
				double y = Math.pow(x,3)-x*x+3;						
				arrY[j] = y;
				j++;
			}
			sumAreas = sumAreas + (((arrY[0] + arrY[1])/2)*rangeInterval);			
		}
		return sumAreas;
	}
	
	public static void main(String[] args) {
		double minX = -1.0;
		double maxX = 1.0;		
		int numPoints = 5;
		double currentArea = 0, newArea = 0;
		System.out.println(Area(minX, maxX, numPoints));
		while(true){
			int i = numPoints;
			int j = numPoints + 1;			
			currentArea = Area(minX, maxX, i);			
			newArea = Area(minX, maxX, j);			
			double percentArea = newArea/currentArea;
			if(0.9999 <= percentArea &&  percentArea <= 1.0001){				
				System.out.println(i + " is the point which next area bigger than previous area at most 100.01%  and at less 99.99%");
				System.out.println("The Area which next area bigger than previous area at most 100.01%  and at less 99.99% is " + Area(minX, maxX, i));
				break;
			}else{
				numPoints = numPoints + 1;
			}
		}
		
		
	}

}