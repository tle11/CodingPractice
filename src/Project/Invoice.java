package Project;
import java.util.List;

public class Invoice {

	private String invoiceCode;
	private String customerCode;
	private String salesPersonCode;
	private List<Product> prodList;
	
	public Invoice(String invoiceCode, String customerCode, String salesPersonCode, List<Product> prodList){
		this.invoiceCode = invoiceCode;
		this.customerCode = customerCode;
		this.salesPersonCode = salesPersonCode;
		this.prodList = prodList;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getSalesPersonCode() {
		return salesPersonCode;
	}

	public List<Product> getProdList() {
		return prodList;
	}

	
	
	
}
