package com.jesusnut;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Employee;

public class SerializePojo_File_JSONArray {
	
	//7.	Serialize JSON Array from POJO to JSON and save it on external file. (Serialization using Jackson)

	public static void main(String[] args) throws IOException {

		Employee emp1 = new Employee(20, 770, "Paglaith", "Baitha", Arrays.asList("Sewing", "Aquascaping"));
		Employee emp2 = new Employee(21, 771, "Janam", "Cherma", Arrays.asList("BoothLooting", "Kidnapping"));
		Employee emp3 = new Employee(22, 772, "some", "Name", Arrays.asList("Laster", "Blaster"));
		
		List<Employee> empObject = Arrays.asList(emp1,emp2,emp3);

		ObjectMapper om = new ObjectMapper();

		// convert Employee Class Type object 'emp' to JSON and save it on external file

		om.writeValue(new File(System.getProperty("user.dir") + "/SerializedEmployeeArray.json"), empObject);

	}

}
