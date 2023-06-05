package com.jesusnut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SerializeJacksonObj {
	
	//5. Create a JSON payload using ObjectMapper, ObjectNode and ArrayNode class objects (Serialization using Jackson)

	// In this class, we will create a json representation using Jackson libraray
	// classes [AND NOT USING POJO]
	// and then print it on console.

	// To be constructed:

//	{
//		  "age": 14,
//		  "rollno": 101,
//		  "firstName": "Amuthan",
//		  "lastName": "Sakthivel",
//		  "course": [
//		    {
//		      "subject": "stone pelting",
//		      "instructor": "deadman"
//		    },
//		    {
//		      "subject": "gun assembly",
//		      "instructor": "boogeyman"
//		    }
//		  ]
//		}

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper om = new ObjectMapper();

		ObjectNode outerNode = om.createObjectNode();

		outerNode.put("age", 14);
		outerNode.put("rollno", 101);
		outerNode.put("firstName", "Amuthan");
		outerNode.put("lastName", "Sakthivel");
	

		ObjectNode innernode1 = om.createObjectNode();
		innernode1.put("subject", "stone pelting");
		innernode1.put("instructor", "deadman");

		ObjectNode innernode2 = om.createObjectNode();
		innernode2.put("subject", "gun assembly");
		innernode2.put("instructor", "boogeyman");
		
		ArrayNode course = om.createArrayNode();
		
		course.add(innernode1);
		course.add(innernode2);
		
		outerNode.set("course", course);
		
		System.out.println(om.writeValueAsString(outerNode));

	}

}
