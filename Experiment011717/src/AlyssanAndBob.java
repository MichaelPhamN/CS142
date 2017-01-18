
public class AlyssanAndBob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double moneyOfAlyssa = 2;
		double moneyOfBob = 3;
		if(moneyOfAlyssa > moneyOfBob){
			System.out.println("Alyssa has much more " + (moneyOfAlyssa- moneyOfBob) + " than Bod.");
		}else if(moneyOfAlyssa < moneyOfBob){
			System.out.println("Bod has much more " + (moneyOfBob - moneyOfAlyssa) + " than Alyssa.");
		}else{
			System.out.println("Two of them have the same money in the pocket.");
		}
	}

}
