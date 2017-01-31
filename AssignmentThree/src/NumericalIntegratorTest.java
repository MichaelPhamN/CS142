import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NumericalIntegratorTest {

	public static int getCount(String source, String countVar) {
		int offset = source.indexOf(countVar);
		if (offset == -1) {
			System.out.println("Couldn't find "+countVar+" declaration!");
			System.exit(-1);
		}
		
		if (source.lastIndexOf(countVar) != offset) {
			System.out.println("Detected multiple "+countVar+" declarations!");
		}
		String remainingSource = source.substring(offset);
		remainingSource = remainingSource.substring(remainingSource.indexOf('=')+1);
		remainingSource = remainingSource.substring(0, remainingSource.indexOf(";"));
		remainingSource = remainingSource.trim();
		try {
			return Integer.parseInt(remainingSource);
		} catch (Exception e) {
			System.out.println("Couldn't recognize "+countVar+" value '"+remainingSource+"' as an integer!");
		}
		System.exit(-2);
		return 0; // Unreachable statement
	}

	public static double getDouble(String source, String doubleVar) {
		int offset = source.indexOf(doubleVar);
		if (offset == -1) {
			System.out.println("Couldn't find "+doubleVar+" declaration!");
			System.exit(-1);
		}
		
		if (source.lastIndexOf(doubleVar) != offset) {
			System.out.println("Detected multiple "+doubleVar+" declarations!");
			System.exit(-1);
		}
		String remainingSource = source.substring(offset);
		remainingSource = remainingSource.substring(remainingSource.indexOf('=')+1);
		remainingSource = remainingSource.substring(0, remainingSource.indexOf(";"));
		remainingSource = remainingSource.trim();
		try {
			return Double.parseDouble(remainingSource);
		} catch (Exception e) {
			System.out.println("Couldn't recognize "+doubleVar+" value '"+remainingSource+"' as an integer!");
		}
		System.exit(-2);
		return 0; // Unreachable statement
	}
	
	public static String getMathExpression(String source, String doubleVar) {
		int offset = source.indexOf(doubleVar);
		if (offset == -1) {
			System.out.println("Couldn't find "+doubleVar+" declaration! Please declare it as its own statement.");
			System.exit(-1);
		}
		
		if (source.lastIndexOf(doubleVar) != offset) {
			System.out.println("Detected multiple "+doubleVar+" declarations!");
			System.exit(-1);
		}
		String remainingSource = source.substring(offset);
		remainingSource = remainingSource.substring(remainingSource.indexOf('=')+1);
		remainingSource = remainingSource.substring(0, remainingSource.indexOf(";"));
		String expr = remainingSource.replaceAll("\\s", "");
		String smushed = source.replaceAll("\\s", "");
		if (smushed.indexOf(expr) != smushed.lastIndexOf(expr)) {
			System.out.println("It looks like you are repeating your function calculation of "+expr+"! Please only calculate it in one place in your program.");
			System.exit(-3);
		}
		return expr;
	}
	
	public static final String[] exprs = {"x*x", "Math.pow(x,3)-x*x+3", "Math.sin(x)*Math.sin(x)", "x-x"};
	public static final double[] minXs = {-2, -1, 0, 1};
	public static final double[] maxXs = {2, 1, 314.159, 2};
	public static final int[] pointCounts = {3, 5, 10000, 2};
	public static final double[] answers = {8, 5.25, 157.0796326358, 0};
	public static void main(String[] args) {
		// Read in NumericalIntegrator.java
		String source = null;
		try {
			source = new String(Files.readAllBytes(Paths.get("src"+File.separator+"NumericalIntegrator.java")));
		} catch (Exception e) {
			System.out.println("Couldn't find NumericalIntegrator.java! Run this from the same Eclipse project as NumericalIntegrator.");
			return;
		}
		
		double minX = getDouble(source, "double minX");
		double maxX = getDouble(source, "double maxX");
		int numPoints = getCount(source, "int numPoints");
		String expr = getMathExpression(source, "double y");
		System.out.println("Parameters detected:");
		System.out.println("double minX = "+minX+";");
		System.out.println("double maxX = "+maxX+";");
		System.out.println("int numPoints = "+numPoints+";");
		System.out.println("double y = "+expr+";");
		int i = 0;
		for (; i < exprs.length; i++) {
			if (exprs[i].equals(expr) && minX == minXs[i] && maxX == maxXs[i] && numPoints == pointCounts[i]) {
				PrintStream oldOut = System.out;
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				System.setOut(new PrintStream(stream));
				try {
					NumericalIntegrator.main(new String[0]);
				} finally {
					System.setOut(oldOut);
				}
				Scanner scanner = new Scanner(new String(stream.toByteArray()));
				String ans = "nothing!";
				double answer = Double.NaN;
				try {
					ans = scanner.nextLine();
					answer = Double.parseDouble(ans);
				} catch (Exception e) {
					System.out.println("First line of output didn't look like a double! Instead, I saw: "+ans);
					System.exit(-3);
				}
				if (answer == answers[i] || Math.abs(answer - answers[i]) < 1.0/65536) { 
					System.out.println("Answer of "+answer+" looks good.");
					if (i == exprs.length-1) {
						System.out.println("You tried all the combinations I know! Make sure you tried the first combination too:");
						i = -1;
					} else {
						System.out.println("Try the next combination I know:");
					}
					System.out.println("double minX = "+minXs[i+1]+";");
					System.out.println("double maxX = "+maxXs[i+1]+";");
					System.out.println("int numPoints = "+pointCounts[i+1]+";");
					System.out.println("double y = "+exprs[i+1]+";");
					
				} else {
					System.out.println("Your answer doesn't look good! Expected "+answers[i]+", got "+answer);
				}
				break;
			}
		}
		if (i == exprs.length) {
			System.out.println("I don't know that combination of parameters! Start from the beginning:");
			System.out.println("double minX = "+minXs[0]+";");
			System.out.println("double maxX = "+maxXs[0]+";");
			System.out.println("int numPoints = "+pointCounts[0]+";");
			System.out.println("double y = "+exprs[0]+";");
		}
	}

}
