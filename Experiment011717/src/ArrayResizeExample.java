import java.util.Arrays;

public class ArrayResizeExample {

	public static int[] resize(int[] numbers, int newNumber){
		int[] newNumbers = new int[numbers.length + 1];
		for(int i = 0; i < numbers.length; i++){
			newNumbers[i] = numbers[i];			
		}
		
		newNumbers[numbers.length] = newNumber;
		
		numbers = newNumbers;
		
		return numbers;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3};
		
		resize(numbers,4);
		
		System.out.println(Arrays.toString(resize(numbers, 4)));

	}

}
