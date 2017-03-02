import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1234567";
		byte[] digits = new byte[number.length() - 1];

for (int i = 1; i < digits.length; i++) {

  digits[i] = (byte)(number.charAt(i-1) - '0');

}
		System.out.println(Arrays.toString(digits));
	}

}
