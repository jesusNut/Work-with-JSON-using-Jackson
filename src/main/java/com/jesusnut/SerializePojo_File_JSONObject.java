package com.jesusnut;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Employee;

public class SerializePojo_File_JSONObject {
	
	
	//6. Serialize JSON Object from POJO to JSON and save it on external file. (Serialization using Jackson)

	public static void main(String[] args) throws IOException {

		Employee emp = new Employee(12, 122, "Mastani", "Bajirao", Arrays.asList("Sewing", "Aquascaping"));

		ObjectMapper om = new ObjectMapper();

		// convert Employee Class Type object 'emp' to JSON and print on console

		//System.out.println(om.writeValueAsString(emp));

		// convert Employee Class Type object 'emp' to JSON and save it on external file

		om.writeValue(new File(System.getProperty("user.dir") + "/SerializedEmployeeObject.json"), emp);

	}

}
