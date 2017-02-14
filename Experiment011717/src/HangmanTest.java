import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HangmanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// chooseWord
		boolean error = false;
		System.out.println("Testing chooseWord method on the dictionary {\"one\", \"two\"}...");
		try {
			String[] test = {"one", "two"};
			HashSet<String> invalidStrings = new HashSet<String>();
			int[] count = {0, 0};
			for (int i = 0; i < 100; i++) {
				String s = Hangman.chooseWord(test);
				if ("one".equals(s)) {
					count[0]++;
				} else if ("two".equals(s)) {
					count[1]++;
				} else {
					if (invalidStrings.add(s)) {
						if (s == null) {
							System.out.println("chooseWord returned a null string!");
						} else {
							System.out.println("chooseWord returned an invalid string \""+s+"\"!");
						}
						error = true;
					}
				}
			}
			if (count[0] == 0) {
				System.out.println("Out of 100 trials, I never saw the first word!");
				error = true;
			} else if (count[1] == 0) {
				System.out.println("Out of 100 trials, I never saw the second word!");
				error = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
		}
		// canStillPlay
		System.out.println("Testing canStillPlay method on some examples...");
		try {
			if (!Boolean.FALSE.equals(Hangman.canStillPlay(1, new boolean[]{true, true, true, true}))) {
				System.out.println("Should not be able to play if 1 mistake left and all letters revealed!");
				error = true;
			} else if (!Boolean.TRUE.equals(Hangman.canStillPlay(0, new boolean[]{true, false}))) {
				System.out.println("Should be able to play if 0 mistakes left and last letter not revealed!");
				error = true;
			} else if (!Boolean.FALSE.equals(Hangman.canStillPlay(-1, new boolean[]{false, false, false, false, false}))) {
				System.out.println("Should not be able to play if -1 mistakes left (one too many mistakes)!");
				error = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
		}
		// wordSoFar
		System.out.println("Testing wordSoFar method on some examples...");
		try {
			if (!"-----".equals(Hangman.wordSoFar("12345".toCharArray(), new boolean[]{false, false, false, false, false}))) {
				System.out.println("Should print all dashes for an all false array!");
				error = true;
			} else if (!"12345".equals(Hangman.wordSoFar("12345".toCharArray(), new boolean[]{true, true, true, true, true}))) {
				System.out.println("Should print no dashes for an all true array!");
				error = true;
			} else if (!"-2-4".equals(Hangman.wordSoFar("1234".toCharArray(), new boolean[]{false, true, false, true}))) {
				System.out.println("Should print a mix of dashes and letters according to the array!");
				error = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
		}
		System.out.println("Testing makeGuess method on the word \"apple\". Guessing 'a' followed by 'p' followed by 'g'...");
		try {
			boolean[] letters = new boolean[5];
			if (!Boolean.TRUE.equals(Hangman.makeGuess('a', "apple".toCharArray(), letters))) {
				System.out.println("First guess should return true!");
				error = true;
			} else if (!Arrays.equals(letters, new boolean[]{true, false, false, false, false})) {
				System.out.println("First guess should set the first entry true in the boolean array and leave the rest as false!");
				error = true;
			} else if (!Boolean.TRUE.equals(Hangman.makeGuess('p', "apple".toCharArray(), letters))) {
				System.out.println("Second guess should return true!");
				error = true;
			} else if (!Arrays.equals(letters, new boolean[]{true, true, true, false, false})) {
				System.out.println("Second guess's array should leave first entry as true and set second two entries to true and leave the rest as false!");
				error = true;
			} else if (!Boolean.FALSE.equals(Hangman.makeGuess('g', "apple".toCharArray(), letters))) {
				System.out.println("Third guess should return false!");
				error = true;
			} else if (!Arrays.equals(letters, new boolean[]{true, true, true, false, false})) {
				System.out.println("Third guess's array should leave first three entries as true and leave the rest false!");
				error = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
		}
		if (!error) {
			System.out.println("Good job, I didn't see any errors! The grading program may test some more cases, though!");
			System.out.println("Have you thought about the extra credit? This program doesn't test for that, sorry!");
		} else {
			System.out.println("Please fix the above and run this test again! There may be other problems.");
		}

	}

}
