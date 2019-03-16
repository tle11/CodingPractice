package Project;
public class Product {

	private String code;
	private String type;
	private String name;
	
	public Product (String code, String type, String name){
		this.code = code;
		this.type = type;
		this.name = name;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getPricePerUnit(){
		return 0.0;
	}
	
	public double getServiceFee(){
		return 0.0;
	}
	
	public double getAnnualLicenseFee(){
		return 0.0;
	}
	
	public String getConsultantPersonCode() {
		return "";
	}
	
	public double getHourlyFee() {
		return 0.0;
	}
}
