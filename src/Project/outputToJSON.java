package Project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class outputToJSON {

	@SuppressWarnings("unchecked")
	public static void personJSON(List<Person> pList){
		JSONObject obj = null;
		JSONArray objList = new JSONArray();
		for(Person p: pList){
			obj = new JSONObject();
			obj.put("personCode", p.getPersonCode());
			obj.put("firstName", p.getFirstName());
			obj.put("lastName", p.getLastName());
			
			JSONObject address = new JSONObject();
			address.put("street", p.getAddress().getStreet());
			address.put("city", p.getAddress().getCity());
			address.put("state", p.getAddress().getState());
			address.put("zipCode", p.getAddress().getZipCode());
			address.put("country", p.getAddress().getCountry());
			obj.put("address", address);
			
			JSONArray emailList = new JSONArray();
			emailList.add(p.getEmail());
			obj.put("email", emailList); 
			objList.add(obj);
		}
		try(FileWriter file = new FileWriter("data/Persons.json")){
			file.write(objList.toJSONString());
			file.flush();
		}catch (IOException e){
			 e.printStackTrace();
		 }
		
	}
}
