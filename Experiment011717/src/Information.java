
public class Information extends Person {
	public static void main(String[] args){
		Person p1 = new Person("Bob", "Smith", 41532132);	
		Person p2 = new Person();
		p2.firstName = "Jane";
		p2.lastName = "Doe";		
		System.out.println("Person 1: " + p1.toString() + ". ID: " + p1.id);
		System.out.println("Person 2: " + p2.firstName + " " + p2.lastName );
		
		
		
	}
}
