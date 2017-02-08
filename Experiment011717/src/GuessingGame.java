import java.util.Arrays;
import java.util.Scanner;

public class GuessingGame {
	public static int[] generateSecretCode(int length, int numberOfSymbols){
		int[] secretCode = new int[length];
		for(int i = 0; i< length; i++){			 
			secretCode[i] = (int)(Math.random()*numberOfSymbols) + 1;
		}
		
		return secretCode;
	}
	
	public static int numCorrectDigitsPosition(int[] code, int[] guess){
		//Run through the two arrays
		//If they have the same element in the same position, that's one more correct digit.
		int count = 0;
		for(int i = 0; i < code.length; i++){			
			if(code[i] == guess[i]){
				count++;
			}
		}
		return count;
	}
	
	public static int numCorrectDigitsInWrongPosistion(int[] code, int[] guess){
		// Was this code element matched?
		boolean[] wasMatched = new boolean[code.length];  
		int count = 0;
		// Look at each of the guess elements 
		for(int i = 0; i< guess.length; i++){
			// If this guess was a perfect match, skip it
			if(guess[i] == code[i]) continue;
			for(int j = 0; j < code.length; j++){
				if(guess[i] == code[j] 
						&& code[j] != guess[j]
						&& !wasMatched[j]){
					
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {		
		int numColors = 6;
		int length = 4;
		int[] secretCode = generateSecretCode(4,6);
		System.out.println(Arrays.toString(generateSecretCode(4,6)));
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a guess (" + length + " digits 1-" + numColors + ")");
		String input = s.nextLine();
		if(input.length() == length){
			char[] characters = input.toCharArray();
			int[] guess = new int[length];
			boolean isValid = true;
			for(int i = 0; i< length; i++){
				if(characters[i] >= '1' && characters[i] < '0'+numColors){

				}else{
					System.out.println("Character " + characters[i] + " is not a valid code digit !!!");
					isValid = true;
				}
			}
			if(isValid){
				System.out.println("# of black pegs: " + numCorrectDigitsPosition(secretCode, guess));
				System.out.println("# of white pegs: " + numCorrectDigitsInWrongPosistion(secretCode, guess));
			}
		}else{
			System.out.println("Your guess was not the correct length");
		}
	}

}
