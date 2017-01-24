import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class FarmerSolverTester {

	public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException {
		System.out.println("This version of FarmerSolverTester checks the initial configuration where everything starts on the left bank.");
		// Read in FarmerSolver.java
		String source = null;
		try {
			source =  new String(Files.readAllBytes(Paths.get("src"+File.separator+"FarmerSolver.java")));
		} catch (Exception e) {
			System.out.println("Couldn't find FarmerSolver.java! Run this from the same Eclipse project as FarmerSolver.");
			return;
		}
		String initialComment = "/* Write code below to modify the positions */";
		int initialIndex = source.indexOf(initialComment);
		
		byte[][] initialHashes = {{-3, 15, 72, 98, 64, -100, -26, -98, 64, -32, 1, -96, 63, 111, -74, -106}};
		String finalComment = "/* Write code above to modify the positions */";
		int finalIndex = source.indexOf(finalComment);
		byte[] finalHash = {25, 14, 12, -105, 43, -106, -11, 53, 11, -79, -115, 37, 21, 38, -115, 97};
		if (initialIndex == -1) {
			System.out.println("I didn't find the comment that told you where to start writing code! It looks like this:");
			System.out.println(initialComment);
			System.out.println("Please begin with the FarmerSolver.java file found on Canvas. ");
			System.out.println("Your modifications should go after the initial commenet and before the 'write code above' comment.");
			System.exit(-1);
		}
		if (finalIndex == -1) {
			System.out.println("I didn't find the comment that told you where to stop writing code! It looks like this:");
			System.out.println(finalComment);
			System.out.println("Please begin with the FarmerSolver.java file found on Canvas and copy and paste your changes after the initial comment:");
			System.out.println(initialComment);
			System.out.println("and before the second comment shown above. Please don't delete the second comment!");
			System.exit(-1);
		}
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		int initialHashIndex;
		for (initialHashIndex = 0; initialHashIndex < initialHashes.length; initialHashIndex++) {
			if (Arrays.equals(md5.digest(source.substring(0, initialIndex).getBytes()), initialHashes[initialHashIndex])) {
				break;
			}
		}
		if (initialHashIndex == initialHashes.length) {
			System.out.println("It looks like you modified the first part of the program, before the initial comment that says:");
			System.out.println(initialComment);
			System.out.println("Please begin with the FarmerSolver.java file found on Canvas and copy and paste your changes after");
			System.out.println("the initial comment shown above, and before the second comment:");
			System.out.println(finalComment);
			System.exit(-1);
			
		}
		if (!Arrays.equals(md5.digest(source.substring(finalIndex).getBytes()), finalHash)) {
			System.out.println("It looks like you modified the second part of the program, after the comment that says:");
			System.out.println(finalComment);
			System.out.println("Please begin with the FarmerSolver.java file found on Canvas and copy and paste your changes after the initial comment:");
			System.out.println(initialComment);
			System.out.println("and before the second comment shown above.");
			System.exit(-1);
			
		}
		
		// Make sure that currentPosition variables are not being modified
		
		String userCode = source.substring(initialIndex, finalIndex);
		
		if (userCode.matches("(?s).*currentFarmerPosition\\s*=[^=].*")) {
			System.out.println("You are assigning to currentFarmerPosition! This is not allowed. Only assign to the nextPosition variables (e.g. nextFarmerPosition).");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*currentGoatPosition\\s*=[^=].*")) {
			System.out.println("You are assigning to currentGoatPosition! This is not allowed. Only assign to the nextPosition variables (e.g. nextGoatPosition).");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*currentWolfPosition\\s*=[^=].*")) {
			System.out.println("You are assigning to currentWolfPosition! This is not allowed. Only assign to the nextPosition variables (e.g. nextWolfPosition).");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*currentCabbagePosition\\s*=[^=].*")) {
			System.out.println("You are assigning to currentCabbagePosition! This is not allowed. Only assign to the nextPosition variables (e.g. nextCabbagePosition).");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*\\sbreak.*")) {
			System.out.println("It looks like you're breaking from the loop! Please solve the puzzle normally.");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*\\sreturn.*")) {
			System.out.println("It looks like you're returning from main! Please solve the puzzle normally.");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*\\scontinue.*")) {
			System.out.println("It looks like you're using the continue statement! This shouldn't be necessary. Please solve the puzzle normally.");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*\\sSystem\\.exit.*")) {
			System.out.println("It looks like you're exiting the program! Please solve the puzzle normally.");
			System.exit(-1);
		}
		if (userCode.matches("(?s).*\\sif\\s*\\([^)]*nextFarmerPosition.*")) {
			System.out.println("Warning: You probably shouldn't check the value of nextFarmerPosition in your if statements! Just check the currentPosition variables (e.g. currentFarmerPosition)");
		}
		if (userCode.matches("(?s).*\\sif\\s*\\([^)]*nextGoatPosition.*")) {
			System.out.println("Warning: You probably shouldn't check the value of nextGoatPosition in your if statements! Just check the currentPosition variables (e.g. currentGoatPosition)");
		}
		if (userCode.matches("(?s).*\\sif\\s*\\([^)]*nextWolfPosition.*")) {
			System.out.println("Warning: You probably shouldn't check the value of nextWolfPosition in your if statements! Just check the currentPosition variables (e.g. currentWolfPosition)");
		}
		if (userCode.matches("(?s).*\\sif\\s*\\([^)]*nextCabbagePosition.*")) {
			System.out.println("Warning: You probably shouldn't check the value of nextCabbagePosition in your if statements! Just check the currentPosition variables (e.g. currentCabbagePosition)");
		}
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream stream = new ByteArrayOutputStream(2048) {
			@Override
			public void write(int b) {
				if (count >= buf.length-1) {
					throw new UnsupportedOperationException();
				}
				super.write(b);
			}
			@Override
			public void write(byte[] b, int off, int len) {
				if (count + len >= buf.length-1) {
					throw new UnsupportedOperationException();
				}
				super.write(b, off, len);
			}
			
		};
		System.out.println("Running your solver...");
		System.setOut(new PrintStream(stream));
		try {
			FarmerSolver1.main(new String[0]);
		} catch (UnsupportedOperationException e) {
			System.setOut(oldOut);
			System.out.println("Your program produced too much output, so I think it is in a loop! This is your output:");
			System.out.print(new String(stream.toByteArray()));
			System.out.flush();
			System.exit(-1);
		} finally {
			System.setOut(oldOut);
		}
		
		String output = new String(stream.toByteArray());
		System.out.println("OK, it looks like your program finished running!");
		if (output.contains("!")) {
			System.out.println("I do see an error, however!");
		} else if (!output.contains("Farmer is now on right bank"+System.lineSeparator()+"Wolf is now on right bank"+System.lineSeparator()+"Goat is now on right bank"+System.lineSeparator()+"Cabbage is now on right bank")) {
			System.out.println("I don't see the winning condition! Here is your output: ");
			System.out.print(output);
		} else {
			System.out.println("Everything looks good!");
		}
	}

}
