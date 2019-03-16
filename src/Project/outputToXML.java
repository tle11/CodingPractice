package Project;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class outputToXML {
	 
	//*****Methods to convert to XML******
	 public static void personXML(List<Person> pList){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		 try{
			 db = dbFactory.newDocumentBuilder();
			 Document doc = db.newDocument();
			 Element rootElement = doc.createElement("Persons");
			 doc.appendChild(rootElement);
			 
			 for(Person p: pList){
				 if(p != null){
					 rootElement.appendChild(getPersonElement(doc, p.getPersonCode(), p.getLastName(), p.getFirstName(), p.getAddress(), p.getEmail()));
				 } 
			 }
			 Transformer transformer = TransformerFactory.newInstance().newTransformer();
			 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			 DOMSource source = new DOMSource(doc);
	         StreamResult file = new StreamResult(new File("data/Persons.xml"));
	         transformer.transform(source, file); 
			 }catch (Exception e){
				 e.printStackTrace();
			 }
		 
	 }
	 
	 public static void customerXML(List<Customer> cList){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		 try{
			 db = dbFactory.newDocumentBuilder();
			 Document doc = db.newDocument();
			 Element rootElement = doc.createElement("Customers");
			 doc.appendChild(rootElement);
			 
			 for(Customer c: cList){
				rootElement.appendChild(getCustomerElement(doc, c.getCustomerCode(), c.getType(), c.getPersonCode(), c.getCustomerName(), c.getAddress()));
			 }
			 Transformer transformer = TransformerFactory.newInstance().newTransformer();
			 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			 DOMSource source = new DOMSource(doc);
	         StreamResult file = new StreamResult(new File("data/Customers.xml"));
	         transformer.transform(source, file);
			 }catch (Exception e){
				 e.printStackTrace();
			 } 
	 }
	 
	 public static void productXML(List<Product> prodList){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		 try{
			 db = dbFactory.newDocumentBuilder();
			 Document doc = db.newDocument();
			 Element rootElement = doc.createElement("Products");
			 doc.appendChild(rootElement);
			 
			 for(Product p: prodList){
				 if(p.getType().equalsIgnoreCase("E")){
					 rootElement.appendChild(getProductElement(doc, p.getCode(), p.getType(), p.getName(), p.getPricePerUnit()));
				 }
				 if(p.getType().equalsIgnoreCase("L")){
					 rootElement.appendChild(getProductElement(doc, p.getCode(), p.getType(), p.getName(), p.getServiceFee(), p.getAnnualLicenseFee()));
				 }
				 if(p.getType().equalsIgnoreCase("C")){
					 rootElement.appendChild(getProductElement(doc, p.getCode(), p.getType(), p.getName(), p.getConsultantPersonCode(), p.getHourlyFee()));
				 } 
			 }
			 
			 Transformer transformer = TransformerFactory.newInstance().newTransformer();
			 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			 DOMSource source = new DOMSource(doc);
	         StreamResult file = new StreamResult(new File("data/Products.xml"));
	         transformer.transform(source, file);
			 }catch (Exception e){
				 e.printStackTrace();
			 }
			 
	}
	 
	 //******Methods to create XML Element Categories*******
	 private static Node getPersonElement(Document doc, String personCode, String lastName, String firstName, Address address, String[] email){
		 Element person = doc.createElement("Person");
		 person.appendChild(getElements(doc, person, "personCode", personCode));
		 person.appendChild(getElements(doc, person, "lastName", lastName));
		 person.appendChild(getElements(doc, person, "firstName", firstName));
		 person.appendChild(getElements(doc, person, "address", address.toString()));
		 if(email != null){
			 person.appendChild(getElements(doc, person, "email", String.join(", ", email))); 
		 }
		 return person;
	 }
	 
	 private static Node getCustomerElement(Document doc, String customerCode, String type, String personCode,  String customerName, Address address){
		 Element customer = doc.createElement("Customer");
		 customer.appendChild(getElements(doc, customer, "customerCode", customerCode));
		 customer.appendChild(getElements(doc, customer, "type", type));
		 customer.appendChild(getElements(doc, customer, "personCode", personCode));
		 customer.appendChild(getElements(doc, customer, "customerName", customerName));
		 customer.appendChild(getElements(doc, customer, "address", address.toString()));
		 return customer;
	 }
	 
	 //creates Consultation elements
	 private static Node getProductElement(Document doc, String code, String type, String name, String consultantPersonCode, double hourlyFee){
		 Element product = doc.createElement("Product");
		 product.appendChild(getElements(doc, product, "productCode", code));
		 product.appendChild(getElements(doc, product, "type", type));
		 product.appendChild(getElements(doc, product, "productName", name));
		 product.appendChild(getElements(doc, product, "consultantPersonCode", consultantPersonCode));
		 product.appendChild(getElements(doc, product, "hourlyFee", Double.toString(hourlyFee)));
		 return product;
	 }

	 //creates Equipment elements
	 private static Node getProductElement(Document doc, String code, String type, String name, double pricePerUnit){
		 Element product = doc.createElement("Product");
		 product.appendChild(getElements(doc, product, "productCode", code));
		 product.appendChild(getElements(doc, product, "type", type));
		 product.appendChild(getElements(doc, product, "productName", name));
		 product.appendChild(getElements(doc, product, "pricePerUnit", Double.toString(pricePerUnit)));
		 return product;
	 }
	 
	 //creates License elements
	 private static Node getProductElement(Document doc, String code, String type, String name, double serviceFee, double annuaLicenseFee){
		 Element product = doc.createElement("Product");
		 product.appendChild(getElements(doc, product, "productCode", code));
		 product.appendChild(getElements(doc, product, "type", type));
		 product.appendChild(getElements(doc, product, "productName", name));
		 product.appendChild(getElements(doc, product, "serviceFee", Double.toString(serviceFee)));
		 product.appendChild(getElements(doc, product, "annuaLicenseFee", Double.toString(annuaLicenseFee)));
		 return product;
	 }
	 
	 private static Node getElements (Document doc, Element element, String name, String value){
		    Element node = doc.createElement(name);
			node.appendChild(doc.createTextNode(value));
			return node;
	 }
}
