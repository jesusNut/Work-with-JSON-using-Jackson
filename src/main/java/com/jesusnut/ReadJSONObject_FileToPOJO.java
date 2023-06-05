package com.jesusnut;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Employee;

public class ReadJSONObject_FileToPOJO {
	
	//3.	Read Json Object kept in a file and map it to a POJO .[deserialization using Jackson]

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();

//		Employee readValue = om.readValue(new File(System.getProperty("user.dir") + "/EmployeeJSONData.json"),
//				Employee.class);

		Employee readValue = om.readValue(new File(System.getProperty("user.dir") + "/EmployeeJSONObjectData.json"),
				new TypeReference<Employee>() {
				});
		
		

		System.out.println(readValue.getAge());
		System.out.println(readValue.getRollno());
		System.out.println(readValue.getFirstName());
		System.out.println(readValue.getLastName());
		System.out.println(readValue.getCourse());
		System.out.println(readValue.getCourse().get(0));
		System.out.println(readValue.getCourse().get(1));
		
		
	}

}
