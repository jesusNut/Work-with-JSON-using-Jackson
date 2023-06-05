package com.jesusnut;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//understanding TypeReference concept :: refer below video ::
//https://www.youtube.com/watch?v=97glUcWs5z0&list=PL-a9eJ2NZlbT0Hoo_Hj43utwgq2VusPyN&index=59

public class ReadJSONArray_FileToCustomClassMapping {

	// 9. Read Json Array kept in a file and map it to a List<Map<String,Object>> &
	// [deserialization using Jackson]

	// Since, by seeing the file 'SimpleJSONArrayData.json',
	// user can read the values and map it to a Java LIST type (instead of POJO as
	// in
	// example 4 )

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();

		List<Map<String, Object>> data = om.readValue(
				new File(System.getProperty("user.dir") + "/SimpleJSONArrayData.json"),
				new TypeReference<List<Map<String, Object>>>() {
				});
		
		
		//Iterate the values below:

		Iterator<Map<String, Object>> iterator = data.iterator();

		while (iterator.hasNext()) {

			Map<String, Object> next = iterator.next();

			for (Entry<String, Object> temp : next.entrySet()) {

				System.out.println(temp.getKey() + "***************" + temp.getValue());

			}

			System.out.println("--------------------------------------------------------------");

		}

	}

}
