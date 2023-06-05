package com.jesusnut;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//understanding TypeReference concept :: refer below video ::
//https://www.youtube.com/watch?v=97glUcWs5z0&list=PL-a9eJ2NZlbT0Hoo_Hj43utwgq2VusPyN&index=59

public class ReadJSONObject_FileToCustomClassMapping {

	// 8. Read Json Object kept in a file and map it to a MAP<String,Object>
	// .[deserialization using Jackson]
	// Since, by seeing the file 'SimpleJSONObjectData.json',
	// user can read the values and map it to a Java Map type (instead of POJO as in
	// example 3 )

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();

		Map<String, Object> data = om.readValue(new File(System.getProperty("user.dir") + "/SimpleJSONObjectData.json"),
				new TypeReference<Map<String, Object>>() {
				});
		
		//Iterate the values below:

		Set<Entry<String, Object>> entrySet = data.entrySet();

		for (Entry<String, Object> entry : entrySet) {

			System.out.println(entry.getKey() + "------" + entry.getValue());

		}

	}

}
