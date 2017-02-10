import java.util.Arrays;

public class ArrayComparison {
	public static boolean equals(int[] a, int[] b){		
		if(a == b) return true;
		if(a == null || b == null) return false;
		// check length of array A and B
		if(a.length != b.length)
			return false;
		
		// compare values in arrays
		for(int i=0; i< a.length; i++)
			if(a[i] != b[i])			
				return false;
		return true;
	}
	
	public static boolean equals(boolean[] a, boolean[] b){
		if(a == b) return true;
		if(a == null || b == null) return false;
		// check length of array A and B
		if(a.length != b.length)
			return false;
		
		// compare values in arrays
		for(int i=0; i< a.length; i++)
			if(a[i] != b[i])			
				return false;
		return true;
	}
	
	public static boolean contains(int[] a, int i){
		if(a == null) return false;
		if(a.length == 0) return false;
		
		for(int j = 0; j< a.length;j++)
			if(a[j] == i) return true;
		return false;
	}
	
	public static void main(String[] args) {
		boolean[] a = {true,false,true};
		boolean[] b = {true,false,true};
		
//		if(Arrays.equals(a, b)){
//			System.out.println("A Equal B");
//		}else{
//			System.out.println("Not Equal");			
//		}
		
		if(equals(a, b)){
			System.out.println("A Equal B");
		}else{
			System.out.println("Not Equal");			
		}
		
		int[] c = {1,2,3};
		System.out.println(contains(c,4));
	}

}
