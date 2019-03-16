package Project;
public class License extends Product{

	private double serviceFee;
	private double annualLicenseFee;
	
	public License(String code, String type, String name, double serviceFee, double annuaLicenseFee) {
		super(code, type, name);
		this.serviceFee = serviceFee;
		this.annualLicenseFee = annuaLicenseFee;
	}

	@Override
	public double getServiceFee(){
		return this.serviceFee;
	}
	
	@Override
	public double getAnnualLicenseFee(){
		return this.annualLicenseFee;
	}
	
}
