import java.util.Arrays;

/**
 * This class represents an arbitrary sized integer based on an array of byte
 * values representing the decimal digits of the number.
 * 
 * Author: Phuc Pham N
 *
 */
public class BigDigits {
	
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
	public BigDigits(){
		
	}
	
	/*
	 * Initial BigDigits 
	 */
	public BigDigits(String number) {		
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
	public BigDigits plus(BigDigits d) {
		BigDigits b = new BigDigits();
		
		if(this.arrDigits.length > d.arrDigits.length){
			// copy this
			b.arrDigits = new byte[this.arrDigits.length];	
			for (int i = 0; i < this.arrDigits.length; i++) {
				b.arrDigits[i] = this.arrDigits[i];
			}
			byte[] tmp = new byte[b.arrDigits.length];
			if(d.arrDigits[0] == 0 && b.arrDigits[0] == 0){
				for (int i = 0; i < d.arrDigits.length; i++) {					
					tmp[b.arrDigits.length - i - 1] = d.arrDigits[d.arrDigits.length - i - 1];					
				}
				for (int i = 0; i < b.arrDigits.length; i++) {
					b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] + tmp[b.arrDigits.length - i - 1]);					
					if(b.arrDigits[b.arrDigits.length - i - 1] > 9){												
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] + 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) (b.arrDigits[b.arrDigits.length - i - 1]%10);						
					}
				}											
			}else if(d.arrDigits[0] == -1 && b.arrDigits[0] == 0){
				tmp[0] = -1;
				for (int i = 1; i < d.arrDigits.length; i++) {					
					if((i+1) != d.arrDigits.length){
						tmp[b.arrDigits.length - i] = d.arrDigits[d.arrDigits.length - i];
					}					
				}
				for (int i = 0; i < b.arrDigits.length - 1; i++) {					
					if(b.arrDigits[b.arrDigits.length - i - 1] >= tmp[b.arrDigits.length - i - 1]){
						b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - tmp[b.arrDigits.length - i - 1]);
					}else{	
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - tmp[b.arrDigits.length - i - 1]);
					}
				}
			}else if(d.arrDigits[0] == 0 && b.arrDigits[0] == -1){							
				for (int i = 0; i < d.arrDigits.length; i++) {					
					tmp[b.arrDigits.length - i - 1] = d.arrDigits[d.arrDigits.length - i - 1];					
				}
				for (int i = 0; i < b.arrDigits.length-1; i++) {					
					if(b.arrDigits[b.arrDigits.length - i - 1] >= tmp[b.arrDigits.length - i - 1]){
						b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - tmp[b.arrDigits.length - i - 1]);
					}else{	
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - tmp[b.arrDigits.length - i - 1]);
					}
				}
			}else if(d.arrDigits[0] == -1 && b.arrDigits[0] == -1){
				tmp[0] = -1;
				for (int i = 1; i < d.arrDigits.length; i++) {					
					if((i+1) != d.arrDigits.length){
						tmp[b.arrDigits.length - i] = d.arrDigits[d.arrDigits.length - i];
					}					
				}
				for (int i = 0; i < b.arrDigits.length-1; i++) {
					b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] + tmp[b.arrDigits.length - i - 1]);					
					if(b.arrDigits[b.arrDigits.length - i - 1] > 9){												
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] + 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) (b.arrDigits[b.arrDigits.length - i - 1]%10);						
					}
				}			
			}			
		}else if(this.arrDigits.length < d.arrDigits.length){
			// copy d
			b.arrDigits = new byte[d.arrDigits.length];	
			for (int i = 0; i < d.arrDigits.length; i++) {
				b.arrDigits[i] = d.arrDigits[i];
			}
			
			byte[] tmp = new byte[b.arrDigits.length];
			if(this.arrDigits[0] == 0 && b.arrDigits[0] == 0){	
				for (int i = 0; i < this.arrDigits.length; i++) {					
					tmp[b.arrDigits.length - i - 1] = this.arrDigits[this.arrDigits.length - i - 1];					
				}
				for (int i = 0; i < b.arrDigits.length; i++) {
					b.arrDigits[d.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] + tmp[b.arrDigits.length - i - 1]);					
					if(b.arrDigits[b.arrDigits.length - i - 1] > 9){												
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] + 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) (b.arrDigits[b.arrDigits.length - i - 1]%10);						
					}
				}											
			}else if(this.arrDigits[0] == -1 && b.arrDigits[0] == 0){				
				tmp[0] = -1;
				for (int i = 1; i < this.arrDigits.length; i++) {					
					if((i+1) != this.arrDigits.length){
						tmp[b.arrDigits.length - i] = this.arrDigits[this.arrDigits.length - i];
					}					
				}
				for (int i = 0; i < b.arrDigits.length - 1; i++) {					
					if(b.arrDigits[b.arrDigits.length - i - 1] >= tmp[b.arrDigits.length - i - 1]){
						b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - tmp[b.arrDigits.length - i - 1]);
					}else{	
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - tmp[b.arrDigits.length - i - 1]);
					}
				}
			}else if(this.arrDigits[0] == 0 && b.arrDigits[0] == -1){							
				for (int i = 0; i < this.arrDigits.length; i++) {					
					tmp[b.arrDigits.length - i - 1] = this.arrDigits[this.arrDigits.length - i - 1];					
				}
				for (int i = 0; i < b.arrDigits.length-1; i++) {					
					if(b.arrDigits[b.arrDigits.length - i - 1] >= tmp[b.arrDigits.length - i - 1]){
						b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - tmp[b.arrDigits.length - i - 1]);
					}else{	
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - tmp[b.arrDigits.length - i - 1]);
					}
				}
			}else if(this.arrDigits[0] == -1 && b.arrDigits[0] == -1){
				tmp[0] = -1;
				for (int i = 1; i < this.arrDigits.length; i++) {					
					if((i+1) != this.arrDigits.length){
						tmp[b.arrDigits.length - i] = this.arrDigits[this.arrDigits.length - i];
					}					
				}
				for (int i = 0; i < b.arrDigits.length-1; i++) {
					b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] + tmp[b.arrDigits.length - i - 1]);					
					if(b.arrDigits[b.arrDigits.length - i - 1] > 9){												
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] + 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) (b.arrDigits[b.arrDigits.length - i - 1]%10);						
					}
				}			
			}
		}else if(this.arrDigits.length == d.arrDigits.length){
			if(d.arrDigits[0] == 0 && this.arrDigits[0] == 0){				
				b.arrDigits = new byte[this.arrDigits.length];	
				for (int i = 0; i < this.arrDigits.length; i++) {
					b.arrDigits[i] = this.arrDigits[i];
				}
				for (int i = 0; i < this.arrDigits.length; i++) {
					b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] + d.arrDigits[b.arrDigits.length - i - 1]);					
					if(b.arrDigits[b.arrDigits.length - i - 1] > 9){												
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] + 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) (b.arrDigits[b.arrDigits.length - i - 1]%10);						
					}
				}
			}else if(d.arrDigits[0] == -1 && this.arrDigits[0] == 0){
				byte checkGreater = -1;
				for (int i = 2; i < this.arrDigits.length; i++) {
					if(this.arrDigits[i] == d.arrDigits[i])
						continue;
					else{
						if(this.arrDigits[i] > d.arrDigits[i]){
							checkGreater = 1;
							break;
						}else{
							checkGreater = -1;
							break;
						}
					}
				}				
				if(checkGreater == 1){
					b.arrDigits = new byte[this.arrDigits.length];	
					for (int i = 0; i < this.arrDigits.length; i++) {
						b.arrDigits[i] = this.arrDigits[i];
					}
					for (int i = 0; i < b.arrDigits.length-1; i++) {					
						if(b.arrDigits[b.arrDigits.length - i - 1] >= d.arrDigits[b.arrDigits.length - i - 1]){
							b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - d.arrDigits[d.arrDigits.length - i - 1]);
						}else{	
							b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
							b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - d.arrDigits[d.arrDigits.length - i - 1]);
						}
					}
				}else if(checkGreater == -1){	
					b.arrDigits = new byte[d.arrDigits.length];	
					for (int i = 0; i < d.arrDigits.length; i++) {
						b.arrDigits[i] = d.arrDigits[i];
					}
					for (int i = 0; i < this.arrDigits.length-1; i++) {					
						if(b.arrDigits[b.arrDigits.length - i - 1] >= this.arrDigits[this.arrDigits.length - i - 1]){
							b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - this.arrDigits[this.arrDigits.length - i - 1]);
						}else{	
//							System.out.println(d.arrDigits[d.arrDigits.length - i - 2] - 1);
							b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
							b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - this.arrDigits[this.arrDigits.length - i - 1]);
						}
					}
//					System.out.println(Arrays.toString(d.arrDigits));
//					System.exit(0);
				}
			}else if(d.arrDigits[0] == 0 && this.arrDigits[0] == -1){	
				byte checkGreater = -1;
				for (int i = 2; i < this.arrDigits.length; i++) {
					if(this.arrDigits[i] == d.arrDigits[i])
						continue;
					else{
						if(this.arrDigits[i] > d.arrDigits[i]){
							checkGreater = 1;
							break;
						}else{
							checkGreater = -1;
							break;
						}
					}
				}				
				if(checkGreater == 1){
					b.arrDigits = new byte[this.arrDigits.length];	
					for (int i = 0; i < this.arrDigits.length; i++) {
						b.arrDigits[i] = this.arrDigits[i];
					}
					for (int i = 0; i < b.arrDigits.length-1; i++) {					
						if(b.arrDigits[b.arrDigits.length - i - 1] >= d.arrDigits[b.arrDigits.length - i - 1]){
							b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - d.arrDigits[d.arrDigits.length - i - 1]);
						}else{	
							b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
							b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - d.arrDigits[d.arrDigits.length - i - 1]);
						}
					}
				}else if(checkGreater == -1){	
					b.arrDigits = new byte[d.arrDigits.length];	
					for (int i = 0; i < d.arrDigits.length; i++) {
						b.arrDigits[i] = d.arrDigits[i];
					}
					for (int i = 0; i < this.arrDigits.length-1; i++) {					
						if(b.arrDigits[b.arrDigits.length - i - 1] >= this.arrDigits[this.arrDigits.length - i - 1]){
							b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] - this.arrDigits[this.arrDigits.length - i - 1]);
						}else{	
//							System.out.println(d.arrDigits[d.arrDigits.length - i - 2] - 1);
							b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] - 1);
							b.arrDigits[b.arrDigits.length - i - 1] = (byte) ((b.arrDigits[b.arrDigits.length - i - 1] + 10) - this.arrDigits[this.arrDigits.length - i - 1]);
						}
					}
//					System.out.println(Arrays.toString(d.arrDigits));
//					System.exit(0);
				}
			}else if(d.arrDigits[0] == -1 && this.arrDigits[0] == -1){	
				
				b.arrDigits = new byte[this.arrDigits.length];	
				for (int i = 0; i < this.arrDigits.length; i++) {
					b.arrDigits[i] = this.arrDigits[i];
				}
				for (int i = 0; i < b.arrDigits.length-1; i++) {
					b.arrDigits[b.arrDigits.length - i - 1] = (byte)(b.arrDigits[b.arrDigits.length - i - 1] + d.arrDigits[b.arrDigits.length - i - 1]);					
					if(b.arrDigits[b.arrDigits.length - i - 1] > 9){												
						b.arrDigits[b.arrDigits.length - i - 2] = (byte) (b.arrDigits[b.arrDigits.length - i - 2] + 1);
						b.arrDigits[b.arrDigits.length - i - 1] = (byte) (b.arrDigits[b.arrDigits.length - i - 1]%10);						
					}
				}			
			}
		}		
//		System.out.println("a");
//		System.exit(0);
		return b;
	}

	/**
	 * Create a String representation of the number as it would normally be
	 * written out (similar to the constructor argument)
	 */
	public String toString() {
//		System.out.println(Arrays.toString(this.arrDigits));
		String strNumber = "";
		if(this.arrDigits[0] == -1)
		{
			strNumber = strNumber + "-";
			int i;
			for (i = 1; i < this.arrDigits.length ; i++) {
				if(this.arrDigits[i] == 0)
					continue;
				else
					break;				 
			}
			for(int j = i; j < this.arrDigits.length; j++)
				strNumber = strNumber + arrDigits[j];
		}else{
			int i;
			for (i = 1; i < this.arrDigits.length ; i++) {
				if(this.arrDigits[i] == 0)
					continue;
				else
					break;				 
			}
//			System.out.println(i);
			for(int j = i; j < this.arrDigits.length; j++)
				strNumber = strNumber + arrDigits[j];
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
	public byte compareTo(BigDigits d) {
		byte compare = 1;
		if(this.arrDigits[0] == 0 && d.arrDigits[0] == -1){
			compare = 1;
		}else if(this.arrDigits[0] == 0 && d.arrDigits[0] == 0){
			int i;
			for ( i = 2; i < this.arrDigits.length; i++) {
				if(this.arrDigits[i] == d.arrDigits[i])
					continue;
				else{
					if(this.arrDigits[i] > d.arrDigits[i]){
						compare = 1;
						break;
					}else{
						compare = -1;
						break;
					}
				}
			}
			if( i == this.arrDigits.length){
				compare = 0;
			}
		}else if(this.arrDigits[0] == -1 && d.arrDigits[0] == -1){
			int i;
			for ( i = 2; i < this.arrDigits.length; i++) {
				if(this.arrDigits[i] == d.arrDigits[i])
					continue;
				else{
					if(this.arrDigits[i] > d.arrDigits[i]){
						compare = -1;
						break;
					}else{
						compare = 1;
						break;
					}
				}
			}
			if( i == this.arrDigits.length){
				compare = 0;
			}
		}else if(this.arrDigits[0] == -1 && d.arrDigits[0] == 0){
			compare = -1;
		}
			
		return compare;
	}

	/**
	 * EXTRA CREDIT 5 POINTS: Compute the product of two BigDigits numbers. As
	 * with plus, don't modify this or d, create a new BigDigits object.
	 */
	public BigDigits times(BigDigits d) {
		BigDigits b = new BigDigits();
		
		byte[][] tmp = new byte[d.arrDigits.length][(d.arrDigits.length + this.arrDigits.length) + 1];
		for (int j = d.arrDigits.length - 1; j >= 2 ; j--) {	
			byte carry = 0;
			for (int i = this.arrDigits.length - 1; i >= 2 ; i--) {
					tmp[j][i+j] = (byte)(this.arrDigits[i] * d.arrDigits[j] + carry);
					if(tmp[j][i+j] > 9){	
						carry = 1;
						tmp[j][i+j] = (byte) (tmp[j][i+j]%10);
					}else{
						carry = 0;
					}					
			}
			
		}
		for(int i = 0; i < d.arrDigits.length; i++){
			for(int j = 0; j< d.arrDigits.length + this.arrDigits.length + 1; j++){
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
		System.exit(0);
		
		for(int i = 0; i < (d.arrDigits.length+this.arrDigits.length+1);i++ )
		{
			for(int j=0; j<d.arrDigits.length; j++){
				b.arrDigits[i] = (byte)(b.arrDigits[i] +  tmp[i][j]);
			}
		}
		
		return b;
	}

}
