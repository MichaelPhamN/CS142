import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BakingCalculatorTestForSpecialValues {

	public static int getCount(String source, String countString) {
		int offset = source.indexOf(countString);
		if (offset == -1) {
			System.out.println("Couldn't find "+countString+" declaration!");
			System.exit(-1);
		}
		
		if (source.lastIndexOf(countString) != offset) {
			System.out.println("Detected multiple "+countString+" declarations!");
		}
		String remainingSource = source.substring(offset);
		remainingSource = remainingSource.substring(remainingSource.indexOf('=')+1);
		remainingSource = remainingSource.substring(0, remainingSource.indexOf(";"));
		remainingSource = remainingSource.trim();
		try {
			return Integer.parseInt(remainingSource);
		} catch (Exception e) {
			System.out.println("Couldn't recognize "+countString+" value '"+remainingSource+"' as an integer!");
		}
		System.exit(-2);
		return 0; // Unreachable statement
	}
	
	public static void main(String[] args) throws IOException {
		int[] cookieCounts = {24, 39, 80, 96};
		int[] loafCounts = {1, 1, 8, 10};
		int[][] ingredientCounts = {{1, 1, 1, 1, 1, 1, 1, 2, 1},
				{1, 1, 1, 1, 1, 1, 1, 2, 2},
				{1, 1, 1, 2, 1, 5, 3, 16, 3},
				{2, 1, 1, 2, 2, 6, 3, 20, 3}
		};
		double[] finalPrices = {24.16, 28.35, 57.65, 67.20};
		
		
		// Read in BakingCalculator.java
		String source = null;
		try {
			source =  new String(Files.readAllBytes(Paths.get("src"+File.separator+"BakingCalculator.java")));
		} catch (Exception e) {
			System.out.println("Couldn't find BakingCalculator.java! Run this from the same Eclipse project as BakingCalculator.");
			return;
		}
		
		int cookieCount = getCount(source, "int cookieCount");
		int loafCount = getCount(source, "int loafCount");
		int[] ingredientsCount = null;
		double finalPrice = -1;
		int comboIndex;
		for (comboIndex = 0; comboIndex < cookieCounts.length; comboIndex++) {
			if (cookieCount == cookieCounts[comboIndex] && loafCount == loafCounts[comboIndex]) {
				ingredientsCount = ingredientCounts[comboIndex];
				finalPrice = finalPrices[comboIndex];
				break;
			}
		}
		if (ingredientsCount == null) {
			System.out.println("Sorry, I don't have a test for those values of cookieCount = "+cookieCount+" and loafCount = "+loafCount+"! Start with the default ones from the homework!");
			return;
		}
		System.out.println("Testing with your values of cookieCount = "+cookieCount+" and loafCount = "+loafCount);
		String[] lines = { "Shopping list for "+cookieCount+" cookie(s) and "+loafCount+" loaf(s) of bread:", ingredientsCount[0]+" bag(s) of flour",
				ingredientsCount[1]+" package(s) of salt", ingredientsCount[2]+" box(s) of baking soda", ingredientsCount[3]+" bottle(s) of vanilla extract",
				ingredientsCount[4]+" carton(s) of eggs", ingredientsCount[5]+" bag(s) of sugar", ingredientsCount[6]+" package(s) of butter", ingredientsCount[7]+" banana(s)",
				ingredientsCount[8]+" bag(s) of chocolate chips", "Total cost: " };
		
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
		BakingCalculator.main(new String[0]);
		System.setOut(oldOut);
		Scanner scanner = new Scanner(new String(stream.toByteArray()));
		scanner.useDelimiter("[$]");
		boolean error = false;
		for (int i = 0; i < lines.length; i++) {
			if (!scanner.hasNext()) {
				if (i == 0) {
					System.out.println("Your program doesn't output anything! Please look at the assignment.");
				} else {
					System.out.println("Your program only outputs "+i+" line(s), it should output "+lines.length);
				}
				error = true;
				break;
			}
			if (i < lines.length-1) {
				String line = scanner.nextLine();
				if (!lines[i].equals(line)) {
					System.out.println("Line " + (i + 1) + ": expected '" + lines[i] + "', got '" + line + "'");
					error = true;
				}
			} else {
				String line = scanner.next();
				if (!scanner.hasNext()) {
					System.out.println("Missing dollar sign on last line!");
					error = true;
					break;
				}
				String price = scanner.next();
				if (!lines[i].equals(line)) {
					System.out.println("Final line before dollar sign: expected '" + lines[i] + "', got '" + line + "'");
					error = true;
				}
				try {
					double d = Double.parseDouble(price);
					if (Math.abs(d-finalPrice) > 0.01) {
						System.out.println("Price off by more than a cent: expected "+finalPrice+", got "+price);
						error = true;
					}
				} catch (Exception e) {
					System.out.println("Price does not look like a valid number!");
					error = true;
				}
			}
		}
		if (!error) {
			System.out.println("No errors found!");
			if (comboIndex < cookieCounts.length-1) {
				System.out.println("Now try with cookieCount = "+cookieCounts[comboIndex+1]+" and loafCount = "+loafCounts[comboIndex+1]);
			} else {
				System.out.println("You tried all the values I know about!");
			}
			System.out.println("IMPORTANT: Your program must also correctly calculate quantities and price for other values which this program isn't testing!");
		}

	}

}
