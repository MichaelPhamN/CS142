
public class Staff extends Person {
	public double salary;
	public Staff(String firstName, String lastName, long id, double salary){
		super(firstName,lastName, id);
		this.salary = salary;
	}
	
	public String toString(){
		return super.toString() + " ,salary: " + this.salary;
	}
}
