package Project;
public class Consultation extends Product{

	private String consultantPersonCode;
	private double hourlyFee;
	
	public Consultation(String code, String type, String name, String consultantPersonCode, double hourlyFee) {
		super(code, type, name);
		this.consultantPersonCode = consultantPersonCode;
		this.hourlyFee = hourlyFee;
	}

	@Override
	public String getConsultantPersonCode() {
		return consultantPersonCode;
	}
	
	@Override
	public double getHourlyFee() {
		return hourlyFee;
	}
}
