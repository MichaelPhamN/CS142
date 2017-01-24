
public class primeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 101;
		boolean check = true;
		if(a == 1)
			System.out.println(a + " is a prime");
		else
		{
			int b = a - 1;
			
			while(b > 1){
				
				if(a % b == 0){					
					check = false;
					break;
				}
				b--;
			}
			
			if(check)
				System.out.println(a + " is a prime");
			else
				System.out.println(a + " is not a prime");
		}
	}

}
