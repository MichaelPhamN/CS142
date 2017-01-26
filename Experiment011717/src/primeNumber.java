
public class primeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 101;		
		for(int i = 1; i <= n; i ++){
			boolean hasFactor = true;
			if(i == 1)
				System.out.println(i + " is a prime");
			else
			{
				int b = i - 1;				
				while(b > 1){
					
					if(i % b == 0){					
						hasFactor = false;
						break;
					}
					b--;
				}
				if(hasFactor)
					System.out.println(i + " is a prime");
				else
					System.out.println(i + " is not a prime");
			}
		}
		
	}

}
