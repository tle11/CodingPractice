package Project;
public class Customer {

	private String customerCode;
	private String type;
	private String personCode;
	private String customerName;
	private Address address;
	
	public Customer(String customerCode, String type, String personCode,  String customerName, Address address){
		this.customerCode = customerCode;
		this.type = type;
		this.personCode = personCode;
		this.customerName = customerName;
		this.address = address;
	}
	
	public String getCustomerCode(){
		return this.customerCode;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getPersonCode(){
		return this.personCode;
	}
	
	public String getCustomerName(){
		return this.customerName;
	}
	
	public Address getAddress(){
		return this.address;
	}
	
	
}
