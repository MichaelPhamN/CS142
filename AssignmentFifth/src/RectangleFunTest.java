import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class RectangleFunTest {
	public static void main(String[] args) {
		int[][][] rects = { { { 2, 2, 0, 0 }, { 0, 0, 2, 2 }, { 1, 1, 3, 3 }, { 2, 2, 4, 4 } }, { { 10, 10, 20, 20 } },
				{ { 4, 6, 9, 10 }, { 2, 0, 10, 11 }, { 0, 5, 10, 11 } },
				{ { 1, 1, 5, 5 }, { 2, 2, 6, 6 }, { 3, 3, 7, 7 }, { 4, 4, 8, 8 } } };
		String[][] answers = {
				{ "How many rectangles would you like to enter?", "Please enter rectangle 1:",
						"Sorry, that rectangle was entered incorrectly.", "Please enter rectangle 1:",
						"Please enter rectangle 2:", "Please enter rectangle 3:",
						"The bounds of the smallest rectangle containing the above rectangles: (0,0)-(4,4)",
						"How many pairs of rectangles intersect: 2", "Total area covered by all rectangles: 10" },
				{ "How many rectangles would you like to enter?", "Please enter rectangle 1:",
						"The bounds of the smallest rectangle containing the above rectangles: (10,10)-(20,20)",
						"How many pairs of rectangles intersect: 0", "Total area covered by all rectangles: 100" },
				{ "How many rectangles would you like to enter?", "Please enter rectangle 1:",
						"Please enter rectangle 2:", "Please enter rectangle 3:",
						"The bounds of the smallest rectangle containing the above rectangles: (0,0)-(10,11)",
						"How many pairs of rectangles intersect: 3", "Total area covered by all rectangles: 100" },
				{ "How many rectangles would you like to enter?", "Please enter rectangle 1:",
						"Please enter rectangle 2:", "Please enter rectangle 3:", "Please enter rectangle 4:",
						"The bounds of the smallest rectangle containing the above rectangles: (1,1)-(8,8)",
						"How many pairs of rectangles intersect: 6", "Total area covered by all rectangles: 37" } };
		boolean noec = false;
		boolean noerr = true;
		for (int i = 0; i < rects.length; i++) {
			int[][] r = rects[i];
			StringBuffer buf = new StringBuffer(1024);
			int len = 0;
			for (int[] rect : r) {
				if (rect[0] < rect[2] && rect[1] < rect[3]) {
					len++;
				}
			}
			buf.append(len);
			buf.append('\n');
			for (int[] rect : r) {
				buf.append(rect[0]);
				buf.append(' ');
				buf.append(rect[1]);
				buf.append(' ');
				buf.append(rect[2]);
				buf.append(' ');
				buf.append(rect[3]);
				buf.append('\n');
			}
			System.out.println("Testing with the following rectangle inputs:");
			System.out.print(buf);
			InputStream Systemin = System.in;
			PrintStream Systemout = System.out;
			try {
				InputStream is = new ByteArrayInputStream(buf.toString().getBytes());
				System.setIn(is);
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				System.setOut(new PrintStream(stream));
				try {
					RectangleFun.main(new String[0]);
				} catch (Exception e) {
					System.out.println("Uh oh, your program crashed!");
					e.printStackTrace(Systemout);
					break;
				}
				System.setOut(Systemout);
				Scanner s = new Scanner(new String(stream.toByteArray()));
				String[] ans = answers[i];
				boolean err = false;
				for (int j = 0; j < ans.length; j++) {
					if (!s.hasNextLine()) {
						if (j == ans.length - 1) {
							noec = true;
							break;
						}
						System.out.println("Expected " + ans.length + " lines of output, only saw " + j);
						err = true;
						break;
					}
					String line = s.nextLine();
					if (!line.equals(ans[j])) {
						System.out.println("Line " + (j + 1) + " expected \"" + ans[j] + "\", got \"" + line + "\"");
						err = true;
					}
				}
				if (err) {
					System.out.println("Please fix your program so that the above outputs match for this example.");
					noerr = false;
					break;
				} else {
					System.out.println("All outputs looked good for this example, great!");
				}
			} finally {
				System.setIn(Systemin);
				System.setOut(Systemout);
			}
		}
		if (noerr) {
			if (noec) {
				System.out.println("No errors found! You should try the extra credit, the tester will check it!");
			} else {
				System.out.println("No errors found with the extra credit, outstanding!");
			}
		}
	}

}
