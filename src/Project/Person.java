package Project;

public class Person {

	private String personCode;
	private String firstName;
	private String lastName;
	private String[] email;
	private Address address;
	
	public Person(String personCode, String lastName, String firstName, Address address, String[] email){
		this.personCode = personCode;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
	}
	
	public String getPersonCode(){
		return this.personCode;
	}
	

	public String getLastName(){
		return this.lastName;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String[] getEmail(){
		return this.email;
	}
	
	public Address getAddress(){
		return this.address;
	}
	
}
