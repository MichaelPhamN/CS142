import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BigDigitsSimpleTest {

	public static boolean checkForbiddenWords(String source) {
		String[] forbidden = { "double", "boolean", "char", "float", "int", "long", "short", "Double", "Float", "Integer", "Long",
				"Short", "Char", "Boolean" };
		for (String s : forbidden) {
			if (source.matches("(?s).*\\s" + s + "[\\s\\w]*\\[.*")) {
				System.out.println("No " + s + " arrays allowed!");
				return false;
			}
		}
		if (source.contains("import") || source.contains("java.") || source.contains("javax.")) {
			System.out.println("No imports allowed! (Please let me know if this message is in error.)");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		BigDigits a = new BigDigits("123");
		BigDigits a2 = new BigDigits("123");
		BigDigits b = new BigDigits("456");
		BigDigits c = new BigDigits("678");
		BigDigits d = new BigDigits("789");
		BigDigits e = new BigDigits("-293874289724398987234987249877403298427381");
		BigDigits f = new BigDigits("39842098423098324098324098329843209834509");
		BigInteger eBI = new BigInteger("-293874289724398987234987249877403298427381");
		BigInteger fBI = new BigInteger("39842098423098324098324098329843209834509");
		BigDigits apb = a.plus(b);
		if (!"579".equals(String.valueOf(apb))) {
			System.out.println("123 + 456 = 579 but your code says " + apb);
		}
		if (!"123".equals(String.valueOf(a))) {
			System.out.println("a should equal 123 but instead it's " + a);
		}
		if (!"456".equals(String.valueOf(b))) {
			System.out.println("b should equal 456 but instead it's " + b);
		}
		BigDigits cpd = c.plus(d);
		if (!"1467".equals(String.valueOf(cpd))) {
			System.out.println("678 + 789 = 1467 but your code says " + cpd);
		}
//		if (a.compareTo(a2) != 0) {
//			System.out.println("Your code says 123 does not equal 123");
//		}
//		if (b.compareTo(a) != 1) {
//			System.out.println("Your code says 456 is not greater than 123");
//		}
//		BigDigits epf = e.plus(f);
//		if (!eBI.add(fBI).toString().equals(String.valueOf(epf))) {
//			System.out.println(eBI + " + " + fBI + " = " + eBI.add(fBI) + " but your code says " + epf);
//		}
//		if (e.compareTo(f) != -1) {
//			System.out.println("Your code says " + eBI + " is not less than " + fBI);
//		}
		String source = null;
		try {
			source = new String(Files.readAllBytes(Paths.get("src" + File.separator + "BigDigits.java")));
		} catch (Exception ex) {
			System.out.println("Couldn't find BigDigits.java! Run this from the same Eclipse project as BigDigits.");
			return;
		}
		checkForbiddenWords(source);

	}

}
