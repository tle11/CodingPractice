package Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertData {
	 public static void main(String[] args) {
		 List<Person> pList = new ArrayList<Person>();
		 List<Customer> cList = new ArrayList<Customer>();
		 List<Product> prodList = new ArrayList<Product>();

		 pList = parsePerson();
		 cList = parseCustomer();
		 prodList = parseProduct();
		 
		 outputToXML.personXML(pList);
		 outputToXML.customerXML(cList);
		 outputToXML.productXML(prodList);
		 
		 outputToJSON.personJSON(pList);
		 
	 }
	 
	public static List<Person> parsePerson() {
		List<Person> pList = new ArrayList<Person>();
		Scanner scanner = null;
		try {
			scanner = new Scanner (new File("data/Persons.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int recordCount = Integer.parseInt(scanner.nextLine());
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			String[] token = line.split(";");
			String personCode = token[0];
			String[] nameToken = token[1].split(",");
			String lastName = nameToken[0];
			String firstName = nameToken[1];
			String [] addressToken = token[2].split(",");
			String street = addressToken[0];
			String city = addressToken[1];
			String state = addressToken[2];
			String zipCode = "";
			if(addressToken[3] != null){
				zipCode = addressToken[3];
			}
			String country = addressToken[4];
			String[] email = null;
			if(token.length > 3){
				email = token[3].split(",");
			}
			Address address = new Address(street, city, state, zipCode, country);
			Person person = new Person(personCode, lastName, firstName, address, email);
			pList.add(person);
		}	
		scanner.close();
		return pList;
	}
	public static List<Customer> parseCustomer(){
		List<Customer> cList = new ArrayList<Customer>();
		Scanner scanner = null;
		try{
			scanner = new Scanner(new File("data/Customers.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int recordCount = Integer.parseInt(scanner.nextLine());
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			String[] token = line.split(";");
			String customerCode = token[0];
			String type = token[1];
			String personCode = token[2];
			String customerName = token[3];
			String[] addressToken = token[4].split(",");
			String street = addressToken[0];
			String city = addressToken[1];
			String state = addressToken[2];
			String zipCode = addressToken[3];
			String country = addressToken[4];
			
			Address address = new Address(street,city, state, zipCode, country);
			Customer customer = new Customer(customerCode, type, personCode, customerName, address);
			cList.add(customer);
		}
		scanner.close();
		return cList;
	}
	
	public static List<Product> parseProduct(){
		List<Product> pList= new ArrayList<Product>();
		Scanner scanner = null;
		try{
			scanner = new Scanner(new File("data/Products.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int recordCount = Integer.parseInt(scanner.nextLine());
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			String[] token = line.split(";");
			String code = token[0];
			String type = token[1];
			String name = token[2];
			double pricePerUnit = 0.0;
			double serviceFee = 0.0;
			double annualLicenseFee = 0.0;
			String consultantPersonCode = "";
			double hourlyFee = 0.0;
			if(type.equals("E")){
				pricePerUnit = Double.parseDouble(token[3]);
				Equipment equipment = new Equipment(code, type, name, pricePerUnit);
				pList.add(equipment);
			}
			if(type.equals("L")){
				serviceFee = Double.parseDouble(token[3]);
				annualLicenseFee = Double.parseDouble(token[4]);
				License license = new License(code, type, name, serviceFee, annualLicenseFee);
				pList.add(license);
			}
			if(type.equals("C")){
				consultantPersonCode = token[3];
				hourlyFee = Double.parseDouble(token[4]);
				Consultation consultation = new Consultation(code, type, name, consultantPersonCode, hourlyFee);		
				pList.add(consultation);
			}	
		}
		scanner.close();
		return pList;
	}
	
	public static List<Invoice> parseInvoice(){
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Scanner scanner = null;
		try{
			scanner = new Scanner(new File("data/Invoices.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return invoiceList;
	}
}
