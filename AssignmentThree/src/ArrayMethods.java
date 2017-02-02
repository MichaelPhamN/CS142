import java.util.Arrays;

public class ArrayMethods {
	public static void squareArray(int[] a){
		for(int i = 0; i< a.length; i++){
			a[i] = a[i]*a[i];
		}		
	}
	public static int sumArray(int[] arr){
		int s = 0;
		for(int i = 0 ; i< arr.length;i ++){
			s = s + arr[i];
		}
		return s;
	}
	public static void main(String[] args) {
		int[] arr = {3, -7, 5, 22};
		//First, modify the array to contain its squares
		//Then, sum up the elements of the array
		squareArray(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(sumArray(arr));
	}

}
