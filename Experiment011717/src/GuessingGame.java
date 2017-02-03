import java.util.Arrays;

public class GuessingGame {
	public static int[] generateSecretCode(int length, int numberOfSymbols){
		int[] secretCode = new int[length];
		for(int i = 0; i< length; i++){			 
			secretCode[i] = (int)(Math.random()*numberOfSymbols) + 1;
		}
		
		return secretCode;
	}
	public static void main(String[] args) {
		
			System.out.println(Arrays.toString(generateSecretCode(4,6)));
		

	}

}
