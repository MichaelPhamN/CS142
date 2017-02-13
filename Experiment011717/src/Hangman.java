import java.io.IOException;

/**
 * A guessing game where you must guess a word. Please fill out your name below:
 * 
 * Author:
 * 
 * Please fill out the methods below and remove the "todo" comments. Then you'll
 * be able to play Hangman! The existing return values are stubs to make the
 * program compile and you should change them to follow the Javadoc
 * documentation.
 */
public class Hangman {

	/**
	 * Choose a word randomly among the array of words. Each word in the array
	 * should have roughly the same chance of being chosen. You should use the
	 * Math.random method, multiply and cast it appropriately. The method should
	 * work no matter what the array length is. Try it on a short one!
	 * 
	 * @param words
	 *            Array of words
	 * @return A randomly selected word
	 */
	public static String chooseWord(String[] words) {
		// TODO Auto-generated method stub
		return "";
	}

	/**
	 * Return true if you can still play the game (there are some letters that
	 * haven't been revealed and you have zero or more mistakes left)
	 * 
	 * @param mistakesLeft
	 *            Mistakes you have left (zero means you're still alive but
	 *            can't make any more mistakes!)
	 * @param revealedLetters
	 *            Boolean array with one entry for each character position in
	 *            the word (true for each position that has been revealed)
	 * @return True if you can still play the game because it hasn't been solved
	 *         and you are still alive. False if you can't play!
	 */
	public static boolean canStillPlay(int mistakesLeft, boolean[] revealedLetters) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Create a visual representation of the word revealed so far. Each letter
	 * that has been revealed should be included in the string. Each letter that
	 * has not been revealed should be replaced with a dash (-).
	 * 
	 * @param word
	 *            Secret word that player is trying to guess
	 * @param revealedLetters
	 *            Boolean array with one entry for each character position in
	 *            the word (true for each position that has been revealed)
	 * @return String representation of partially revealed word. Use
	 *         concatenation to build it!
	 */
	public static String wordSoFar(char[] word, boolean[] revealedLetters) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Perform key actions that a person hosting a Hangman game would do in
	 * order to respond to a player guessing a letter. Modify revealedLetters
	 * according to the guess. Each position in revealedLetters that corresponds
	 * to a position in the word that matches the letter guessed should be
	 * revealed (set to true). Don't set any letters to false!
	 * 
	 * @param guess
	 *            Letter that player is guessing
	 * @param word
	 *            Secret word that player is trying to guess
	 * @param revealedLetters
	 *            Boolean array with one entry for each character position in
	 *            the word (true for each position that has been revealed)
	 * @return true if guess was correct (revealed at least one letter), false
	 *         otherwise
	 */
	public static boolean makeGuess(char guess, char[] word, boolean[] revealedLetters) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Main method to implement the game of Hangman using the methods above.
	 * This code only works for lower case English words (does not allow
	 * accented characters or capital letters).
	 * 
	 * You can modify the code if you're doing the extra credit or to
	 * experiment, but if so, make sure it doesn't change the way that the
	 * methods above are supposed to work.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// A small dictionary of short words to guess.
		String[] possibleWords = { "acorns", "baker", "camels", "denim", "embers", "fauna", "grapes", "heist", "igloos",
				"jumpy", "koalas", "llamas", "mocha", "never", "otters", "pride", "quite", "rocky", "salads", "truck",
				"under", "violas", "wrist", "yachts", "zebra" };
		String chosenWord = chooseWord(possibleWords);
		int mistakesLeft = 7;
		boolean[] revealedLetters = new boolean[chosenWord.length()];
		boolean[] guessedLetters = new boolean[26];
		while (canStillPlay(mistakesLeft, revealedLetters)) {
			char guess;
			System.out.println("Word so far: " + wordSoFar(chosenWord.toCharArray(), revealedLetters));
			System.out.println("You may make " + mistakesLeft + " more mistake" + (mistakesLeft == 1 ? "" : "s") + ".");
			while (true) {
				System.out.print("Make a guess: ");
				guess = (char) System.in.read();
				// Read extra characters
				while (guess != '\n' && System.in.read() != '\n')
					;
				if (guess < 'a' || guess > 'z') {
					System.out.println("Guess must be between 'a' and 'z' (lower case). Try again!");
				} else if (guessedLetters[guess - 'a']) {
					System.out.println("You already guessed that letter!");
				} else {
					break;
				}
			}
			guessedLetters[guess - 'a'] = true;
			if (makeGuess(guess, chosenWord.toCharArray(), revealedLetters)) {
				System.out.println("Correct guess!");
			} else {
				System.out.println("Incorrect guess.");
				mistakesLeft--;
			}
		}
		if (mistakesLeft < 0) {
			// We made a mistake when we weren't allowed to, so we lost.
			System.out.println("You lost. The word was: " + chosenWord);
		} else {
			System.out.println("You won! (The word was " + chosenWord + ")");
		}
	}
}
