import java.util.Arrays;

//import java.util.Arrays;

public class BigDigitsTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		BigDigits a = new BigDigits("-123");
		BigDigits b = new BigDigits("-4445");
		byte[] tmp = new byte[10];

//		System.out.println(Arrays.toString(tmp));
		BigDigits c = a.times(b);
		System.out.println(c.toString());
//		System.out.println(c.toString());
//		System.out.println(b.toString());
//		byte a = 23;
//		byte b = 34;
//		System.out.println((byte)(a+b));
	}

}
