package Project;
public class Equipment extends Product{

	private double pricePerUnit;
	
	public Equipment(String code, String type, String name, double pricePerUnit) {
		super(code, type, name);
		this.pricePerUnit = pricePerUnit;
	}
	
	@Override
	public double getPricePerUnit(){
		return this.pricePerUnit;
	}
}
