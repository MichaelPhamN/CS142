
public class Person {
	protected String firstName;
	protected String lastName;
	protected long id;
	protected static int numberOfPeople;
	public Person(){
		this.firstName = "";
		this.lastName = "";		
		this.id = 0;
		numberOfPeople++;
	}
	
	public String toString(){
		return firstName + " " + lastName;
	}
	
	public Person(String firstName){
		this(firstName, null, -1);
	}
		
	public Person(String firstName, String lastName, long id){
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		numberOfPeople++;
	}
	
	

}
