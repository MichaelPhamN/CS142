import java.util.Arrays;

/**
 * This class represents an arbitrary sized integer based on an array of byte
 * values representing the decimal digits of the number.
 * 
 * Author: Phuc Pham N
 *
 */
public class BigDigits2 {
	
	public byte[] arrDigits;
	
	/**
	 * Create a new BigDigits number based on a string representation resembling
	 * the way humans write integers (starting with the most significant digit).
	 * The constructor should be able to work with a string containing any
	 * number of decimal digits in the range 0-9. It may also begin with a minus
	 * sign (-). No commas, decimal points, spaces, etc. are allowed.
	 * 
	 * @param number
	 *            String representation of a number
	 */
	
	/*
	 * Initial BigDigits 
	 */
	public BigDigits2(){
		
	}
	
	/*
	 * Initial BigDigits 
	 */
	public BigDigits2(String number) {		
		if(number.length() == 0)
			this.arrDigits[0] = 0;
		else{		
			byte[] arrNumber;
			if(number.charAt(0) == '-'){	
				arrNumber = new byte[number.length() + 1];	
				arrNumber[0] = -1;
				arrNumber[1] = 0;
				for (int i = 1; i < number.length(); i++) {					
					arrNumber[i + 1] = Byte.valueOf(Character.toString(number.charAt(i)));
				}
			}else{				
				arrNumber = new byte[number.length() + 2];	
				arrNumber[0] = 0;
				arrNumber[1] = 0;
				for (int i = 0; i < number.length(); i++) {
					arrNumber[i + 2] = Byte.valueOf(Character.toString(number.charAt(i)));
				}			
			}		
			this.arrDigits = arrNumber;
		}
	}

	/**
	 * Compute the sum of two BigDigits numbers. You shouldn't modify either of
	 * the BigDigits objects. Instead, create and return a new BigDigits object
	 * representing the sum.
	 */
	public BigDigits2 plus(BigDigits2 d) {		
		if(this.arrDigits.length > d.arrDigits.length){
			byte[] tmp = new byte[this.arrDigits.length];			
			if(d.arrDigits[0] == -1){				
				tmp[0] = -1;
				for (int i = 1; i < d.arrDigits.length; i++) {					
					if((i+1) != d.arrDigits.length){
						tmp[this.arrDigits.length - i] = d.arrDigits[d.arrDigits.length - i - 1];
					}					
				}
			}else{
				for (int i = 0; i < d.arrDigits.length; i++) {					
					tmp[this.arrDigits.length - i - 1] = d.arrDigits[d.arrDigits.length - i - 1];					
				}
//				byte[] arrSum = new byte[this.arrDigits.length];
//				System.err.println(Arrays.toString(this.arrDigits));
//				System.out.println(Arrays.toString(tmp));
				for (int i = 0; i < this.arrDigits.length; i++) {
//					System.out.print(this.arrDigits[this.arrDigits.length - i - 1]);
//					System.err.print(tmp[this.arrDigits.length - i - 1]);
					this.arrDigits[this.arrDigits.length - i - 1] = (byte)(this.arrDigits[this.arrDigits.length - i - 1] + tmp[this.arrDigits.length - i - 1]);
//					System.out.println(this.arrDigits[this.arrDigits.length - i - 1]);					
					if(this.arrDigits[this.arrDigits.length - i - 1] > 9){												
						this.arrDigits[this.arrDigits.length - i - 2] = (byte) (this.arrDigits[this.arrDigits.length - i - 2] + 1);
						this.arrDigits[this.arrDigits.length - i - 1] = (byte) (this.arrDigits[this.arrDigits.length - i - 1]%10);
						
					}
				}				
				
			}			
			
		}
//		System.out.println(Arrays.toString(this.arrDigits));
		System.exit(0);
		return this;
	}

	/**
	 * Create a String representation of the number as it would normally be
	 * written out (similar to the constructor argument)
	 */
	public String toString() {
		String strNumber = "";
		if(this.arrDigits[0] == -1)
		{
			strNumber = strNumber + "-";
			for (int i = 1; i < this.arrDigits.length ; i++) {
				strNumber = strNumber + arrDigits[i]; 
			}
		}else{
			for (int i = 1; i < this.arrDigits.length ; i++) {
				strNumber = strNumber + arrDigits[i]; 
			}
		}		
		return strNumber;
	}

	/**
	 * Numerically compare this BigDigits object to the argument d. If this
	 * BigDigit is less than d, return -1. If this BigDigits object is equal,
	 * return 0. If this BigDigits object is greater than d, return 1.
	 * 
	 * @return -1, 0, or 1
	 */
	public byte compareTo(BigDigits2 d) {
		// FIXME This method should only return 0 if this is equal to d!
		return 0;
	}

	/**
	 * EXTRA CREDIT 5 POINTS: Compute the product of two BigDigits numbers. As
	 * with plus, don't modify this or d, create a new BigDigits object.
	 */
	public BigDigits2 times(BigDigits2 d) {
		// FIXME This method should never return null if you're implementing the
		// extra credit!
		return null;
	}

}
