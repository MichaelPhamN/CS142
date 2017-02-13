import java.util.Arrays;
import java.util.Scanner;

public class GuessingGame {

	public static int[] createSecretCode(int length, int numColors) {
		int[] code = new int[length];
		for (int i = 0; i < length; i++) {
			code[i] = (int)(Math.random()*numColors)+1;
		}
		return code;
	}
	
	public static int countBlackPegs(int[] code, int[] guess) {
		// Assume arrays are the same length.
		// Loop through the elements of the arrays and
		// count the ones that match.
		int count = 0;
		for (int i = 0; i < code.length; i++) {
			if (code[i] == guess[i]) {
				count = count + 1;
			}
		}
		return count;
	}
	
	public static int countWhitePegs(int[] code, int[] guess) {
		boolean[] wasCodeDigitMatched = new boolean[code.length];
		int count = 0;
		// For each guess digit
		for (int i = 0; i < guess.length; i++) {
			// For each code digit
			if (guess[i] == code[i]) continue; // Skip guess digits with black peg matches
			for (int j = 0; j < code.length; j++) {
				if (guess[i] == code[j] // If code and guess digit match 
				&& !wasCodeDigitMatched[j] // This code digit wasn't matched
				&& code[j] != guess[j]) { // Code digit doesn't have black peg match
					wasCodeDigitMatched[j] = true; // Now that code digit is matched
					count++; // Add one to the count
					break; // Stop looking for matches! Go on to the next guess digit.
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		int length = 4;
		int differentDigits = 6;
		int[] secretCode = createSecretCode(length, differentDigits);
		Scanner s = new Scanner(System.in);
		// Loop forever
		while (true) {
			System.out.println("Please enter a guess ("+length+" digits ranging 1-"+differentDigits+")");
			
			String input = s.nextLine();
			if (input.length() == length) {
				char[] characters = input.toCharArray();
				int[] guess = new int[length];
				boolean allValid = true;
				for (int i = 0; i < characters.length; i++) {
					if (characters[i] >= '1' && characters[i] <= '0'+differentDigits) {
						guess[i] = characters[i] -'0';
					} else {
						System.out.println(characters[i]+" is not a valid digit!");
						allValid = false;
					}
				}
				if (allValid) {
					System.out.println("# of black pegs: "+countBlackPegs(secretCode, guess));
					System.out.println("# of white pegs: "+countWhitePegs(secretCode, guess));
					if (countBlackPegs(secretCode, guess) == secretCode.length) {
						System.out.println("You won!");
						break;
					}
				}
			} else {
				System.out.println("Your input was the wrong length!");
			}
		}		
	}
}
