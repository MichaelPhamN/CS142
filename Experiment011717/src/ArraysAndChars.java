
public class ArraysAndChars {
	public static String reverse(String s){
		char[] c = s.toCharArray();
		String revStr = "";
		// Form a new string in a loop
		for(int i = 0; i < c.length; i++){
			revStr = revStr + c[c.length - i - 1]; 
		}
		return revStr;
	}
	
	public static boolean isPalindrome(String s){
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length/2; i++){
			if(c[i] != c[c.length - i - 1])
				return false;
		}
		return true;
//		if(s.equals(reverse(s))) return true; return false;
		/*
		 * for(int i = 0; i < s.length(); i++){
		 * 		if(s.charAt(i) != s.charAt(s.length() - i - 1))
		 * 			return false
		 * return true;
		 * }
		 */
	}
	
	public static void main(String[] args){		
		String s = "";
		s = "racecar";		
		System.out.println(reverse(s));
		System.out.println(isPalindrome(s));
	}

}
