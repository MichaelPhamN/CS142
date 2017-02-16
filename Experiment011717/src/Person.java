
public class Person {
	private String firstName;
	private String lastName;
	private long id;
	private static int numberOfPeople;
	public Person(){
		this.firstName = "";
		this.lastName = "";		
		this.numberOfPeople++;
	}
	
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;		
		this.numberOfPeople++;
	}
	
	public static void main(String[] args){
		Person p1 = new Person("Bob", "Smith");		
		
		Person p2 = new Person();
		p2.firstName = "Jane";
		p2.lastName = "Doe";		
		System.out.println("Person 1: " + p1.firstName + " " + p1.lastName );
		System.out.println("Person 2: " + p2.firstName + " " + p2.lastName );
		
		
		
	}

}
