package Project;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	
	public Address(String street, String city, String state, String zipCode, String country){
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", country=" + country + "]";
	}

	public String getStreet(){
		return this.street;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public String getState(){
		return this.state;
	}
	
	public String getZipCode(){
		return this.zipCode;
	}
	
	public String getCountry(){
		return this.country;
	}
}
