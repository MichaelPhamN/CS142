import java.awt.Rectangle;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Phuc Pham N
 * SID 201206284
 * Class 9:30 - 10:30
 *
 */
public class RectangleFun {
	public static Rectangle intectionRectangles(Rectangle[] rec){
		Rectangle intersectRectangle = new Rectangle();
		return intersectRectangle;
	}
	
	public static boolean isInteger(String input){
		if(input == null){
			return false;
		}else{
			int lengthOfString = input.length();
			if(lengthOfString == 0)
				return false;
			else{
				boolean checkInteger = true;
				for (int i = 0; i < lengthOfString; i++) {
					if(i == 0 && input.charAt(i) == '-')
					{
						if(input.length() == 1)
							return false;
						else
							continue;
					}
					char c = input.charAt(i);
					if(c < '0' || c > '9'){
						checkInteger = false;
						break;
					}
				}
				if(checkInteger){
					return true;					
				}else{
					return false;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String strNumberOfRectangles;
		int numberOfRectangles;
		while(true){
			System.out.println("How many rectangles would you like to enter?");
			strNumberOfRectangles = sc.next();
			if(!isInteger(strNumberOfRectangles)){
				System.err.println("Wrong input. Please check your input!!!");
			}				
			else{
				numberOfRectangles = Integer.parseInt(strNumberOfRectangles);
				if(numberOfRectangles > 0)
					break;
				else
					System.err.println("Wrong input. Please check your input!!!");
			}
		}	
		Rectangle[] rec = new Rectangle[numberOfRectangles];
		for (int i = 0; i < numberOfRectangles; i++) {
			while(true){	
				System.out.println("Please enter rectangle "+ (i + 1) +":");
				String strUpperX, strUpperY, strLowerX, strLowerY;				
				int upperX, upperY, lowerX, lowerY;
				strUpperX = sc.next();
				strUpperY = sc.next();
				strLowerX = sc.next();
				strLowerY = sc.next();
				if(isInteger(strUpperX) && isInteger(strUpperY) && isInteger(strLowerX) && isInteger(strLowerY)){
					upperX = Integer.parseInt(strUpperX);
					upperY = Integer.parseInt(strUpperY);
					lowerX = Integer.parseInt(strLowerX);
					lowerY = Integer.parseInt(strLowerY);
					if((upperX < lowerX) && (upperY < lowerY)){
						rec[i] = new Rectangle(upperX, upperY, lowerX - upperX, lowerY - upperY);
						break;
					}else{
						System.out.println("Sorry, that rectangle was entered incorrectly.");
					}
				}else{
					System.out.println("Sorry, that rectangle was entered incorrectly.");
				}
			}	
		}
		int smallestX, smallestY, largestX, largestY;
		smallestX = (int)rec[0].getMinX();
		smallestY = (int)rec[0].getMinY();
		largestX = (int)rec[0].getMaxX();
		largestY = (int)rec[0].getMaxY();
		for (int i = 0; i < rec.length; i++) {			
			Rectangle rectangle = rec[i].getBounds();
			if(rectangle.getMinX() < smallestX){
				smallestX = (int)rectangle.getMinX();
			}
			if(rectangle.getMinY() < smallestY){
				smallestY = (int)rectangle.getMinY();
			}
			if(rectangle.getMaxX() > largestX){
				largestX = (int)rectangle.getMaxX();
			}
			if(rectangle.getMaxY() > largestY){
				largestY = (int)rectangle.getMaxY();
			}
			
		}
		System.out.println("The bounds of the smallest rectangle containing the above rectangles: (" 
						+ smallestX + "," + smallestY + ")-(" + largestX + "," + largestY + ")");
		int countInterect = 0;
		for (int i = 0; i < rec.length -1; i++) {
			for(int j = i+1; j < rec.length; j++){
				if(rec[i].intersects(rec[j])){
					countInterect++;
				}
			}
		}
		System.out.println("How many pairs of rectangles intersect: " + countInterect);		
		if(countInterect == 0){
			int sumArea = 0;
			for (int i = 0; i < rec.length; i++) {
				sumArea = sumArea + rec[i].height * rec[i].width;
			}
			System.out.println("Total area covered by all rectangles: " + sumArea);
		}else{
			Rectangle[] recIntersection = new Rectangle[countInterect];
			int numberOfIntersect = 0;
			int sumArea = 0;			
			// Find total Area of all rectangles without minus intersection
			for(int i = 0; i< rec.length; i++){
				sumArea = sumArea + rec[i].height * rec[i].width;
			}
			int sumSmallArea = 0;
			// Find small rectangles (they are intersection parts of rectangles )
			for (int i = 0; i < rec.length -1; i++) {
				for(int j = i+1; j < rec.length; j++){					
					if(rec[i].intersects(rec[j])){
						recIntersection[numberOfIntersect++] = rec[i].intersection(rec[j]);						
					}
				}
			}
			
			for(int i = 0; i< recIntersection.length; i++){
				sumSmallArea = sumSmallArea + recIntersection[i].height * recIntersection[i].width;
			}
			Rectangle[] substractedIntersection = new Rectangle[numberOfIntersect];
			int numberOfSubstractedIntersection = 0;
			if(numberOfIntersect > 0){				
				for(int h = 0; h < numberOfIntersect - 1; h++){
					for(int k = h + 1; k < numberOfIntersect; k++)
						if(recIntersection[h].intersects(recIntersection[k])){
							if(numberOfSubstractedIntersection == 0){
								sumSmallArea = sumSmallArea - recIntersection[h].intersection(recIntersection[k]).width 
										* recIntersection[h].intersection(recIntersection[k]).height;
								recIntersection[numberOfSubstractedIntersection++] = recIntersection[h].intersection(recIntersection[k]);	
							}else{
								Rectangle rectSubtraction = new Rectangle();
								rectSubtraction = recIntersection[h].intersection(recIntersection[k]);
								for(int l = 0; l < numberOfSubstractedIntersection; l++){
									if(rectSubtraction.equals(substractedIntersection[l])){
										break;
									}
								}
								for(int m = 0; m <numberOfSubstractedIntersection; m++){
									sumSmallArea = sumSmallArea - recIntersection[m].height * recIntersection[m].width; 
								}
							}					
						}
				}
			}
			System.out.println("Total area covered by all rectangles: " +  (sumArea - sumSmallArea));
		}
	}
}