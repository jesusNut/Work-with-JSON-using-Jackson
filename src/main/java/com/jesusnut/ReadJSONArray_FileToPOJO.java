package com.jesusnut;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Employee;

public class ReadJSONArray_FileToPOJO {
	
	//4.	Read Json Array kept in a file and map it to a POJO .[deserialization using Jackson]

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();

		// way 1: specifying Employee[].class

//		 Employee[] readValue = om.readValue(new File(System.getProperty("user.dir") + "/EmployeeJSONArrayData.json"),
//				Employee[].class);

//		System.out.println(readValue[0].getAge());
//		System.out.println(readValue[0].getRollno());
//		System.out.println(readValue[0].getFirstName());
//		System.out.println(readValue[0].getLastName());
//		System.out.println(readValue[0].getCourse());
//		System.out.println(readValue[0].getCourse().get(0));
//		System.out.println(readValue[0].getCourse().get(1));
//		System.out.println("------------------------------");
//		
//		System.out.println(readValue[1].getAge());
//		System.out.println(readValue[1].getRollno());
//		System.out.println(readValue[1].getFirstName());
//		System.out.println(readValue[1].getLastName());
//		System.out.println(readValue[1].getCourse());
//		System.out.println(readValue[1].getCourse().get(0));
//		System.out.println(readValue[1].getCourse().get(1));
//        System.out.println("------------------------------");
//		
//		System.out.println(readValue[2].getAge());
//		System.out.println(readValue[2].getRollno());
//		System.out.println(readValue[2].getFirstName());
//		System.out.println(readValue[2].getLastName());
//		System.out.println(readValue[2].getCourse());
//		System.out.println(readValue[2].getCourse().get(0));
//		System.out.println(readValue[2].getCourse().get(1));

		// way 2: using TypeReference type

		List<Employee> readValue1 = om.readValue(
				new File(System.getProperty("user.dir") + "/EmployeeJSONArrayData.json"),
				new TypeReference<List<Employee>>() {
				});
		
	
		for (Employee emp : readValue1) {

			System.out.println(" The age is : " + emp.getAge());
			System.out.println(" The rollno is : " + emp.getRollno());
			System.out.println(" The firstName is : " + emp.getFirstName());
			System.out.println(" The firstName is : " + emp.getLastName());
			System.out.println(" The firstName is : " + emp.getCourse().get(0));
			System.out.println(" The firstName is : " + emp.getCourse().get(1));
			System.out.println("--------------------------");

		}

	}

}
