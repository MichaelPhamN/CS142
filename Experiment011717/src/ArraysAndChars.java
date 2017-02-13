
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
	public static void main(String[] args){		
		String s = "";
		s = "Hi, how are you?";
		System.out.println(reverse(s));
		
	}

}
