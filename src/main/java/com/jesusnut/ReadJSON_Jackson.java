package com.jesusnut;

import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSON_Jackson {
	
//	1.	Read a JSON string – starting with JSON Object ‘{}’ and fetch its values.[deserialization using Jackson]
//	2.	Read a JSON string – starting with JSON Array‘[]’ and fetch its values.
//	    [ deserialization using Jackson]


	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		//ReadJSON_Jackson.readingJSONArray();
		ReadJSON_Jackson.readingJSONObject();

	}

	private static void readingJSONObject() throws JsonMappingException, JsonProcessingException {

		String jsonString = "{\r\n" + "  \"id\": 1,\r\n" + "  \"first_name\": \"Claire\",\r\n"
				+ "  \"last_name\": null,\r\n" + "  \"email\": \"cdennerley0@uol.com.br\",\r\n"
				+ "  \"gender\": \"Male\",\r\n" + "  \"skills\": [\r\n" + "    {\r\n"
				+ "      \"name\": \"Testing\",\r\n" + "      \"proficiency\": \"Medium\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"name\": \"Aquascaper\",\r\n" + "      \"proficiency\": \"High\"\r\n"
				+ "    }\r\n" + "  ],\r\n" + "  \"bookings\": [\r\n" + "    \"Delhi\",\r\n" + "    \"Dubai\",\r\n"
				+ "    \"IndiaOccupiedPakistan\"\r\n" + "  ]\r\n" + "}";

		ObjectMapper om = new ObjectMapper();

		JsonNode readTree = om.readTree(jsonString);

		// Fetching first level values - way 1

		System.out.println(readTree.findValue("id").asInt());
		System.out.println(readTree.findValue("first_name").asText());
		System.out.println(readTree.findValue("last_name").asText());
		System.out.println(readTree.findValue("email").asText());
		System.out.println(readTree.findValue("gender").asText());

		System.out.println(readTree.findValue("skills"));
		System.out.println(readTree.findValue("skills").get(0));
		System.out.println(readTree.findValue("skills").get(1));
		System.out.println(readTree.findValue("skills").get(0).get("name").asText());
		System.out.println(readTree.findValue("skills").get(0).get("proficiency").asText());
		System.out.println(readTree.findValue("skills").get(1).get("name").asText());
		System.out.println(readTree.findValue("skills").get(1).get("proficiency").asText());

		System.out.println(readTree.findValue("bookings").get(0).asText());
		System.out.println(readTree.findValue("bookings").get(1).asText());
		System.out.println(readTree.findValue("bookings").get(2).asText());

		System.out.println("---------------------------");

		// iterating arrays

		Iterator<JsonNode> iterator = readTree.findValue("skills").iterator();

		int counter = 0;

		while (iterator.hasNext()) {
			JsonNode tempJSONNode = iterator.next();
			System.out.println(
					"The name for object number - " + (counter + 1) + " is : " + tempJSONNode.findValue("name"));
			System.out.println("The proficiency for object number - " + (counter + 1) + " is : "
					+ tempJSONNode.findValue("proficiency"));
			counter++;
		}

		// todo: same for Bookings

		// Fetching first level values - way 2

		System.out.println("-----------------------------------------");

		System.out.println(readTree.get("id").asInt());
		System.out.println(readTree.get("first_name").asText());
		System.out.println(readTree.get("last_name").asText());
		System.out.println(readTree.get("email").asText());
		System.out.println(readTree.get("gender").asText());
		System.out.println(readTree.get("skills"));

		System.out.println(readTree.get("skills").get(0));
		System.out.println(readTree.get("skills").get(1));
		System.out.println(readTree.get("skills").get(0).get("name").asText());
		System.out.println(readTree.get("skills").get(0).get("proficiency").asText());
		System.out.println(readTree.get("skills").get(1).get("name").asText());
		System.out.println(readTree.get("skills").get(1).get("proficiency").asText());

		System.out.println(readTree.get("bookings").get(0).asText());
		System.out.println(readTree.get("bookings").get(1).asText());
		System.out.println(readTree.get("bookings").get(2).asText());

	}

	public static void readingJSONArray() throws JsonMappingException, JsonProcessingException {

		String jsonString = "	[\r\n" + "	    {\r\n" + "	        \"id\": 1,\r\n"
				+ "	        \"first_name\": \"Sebastian\",\r\n" + "	        \"last_name\": \"Eschweiler\",\r\n"
				+ "	        \"email\": \"sebastian@codingthesmartway.com\"\r\n" + "	    },\r\n" + "	    {\r\n"
				+ "	        \"id\": 2,\r\n" + "	        \"first_name\": \"Steve\",\r\n"
				+ "	        \"last_name\": \"Palmer\",\r\n" + "	        \"email\": \"steve@codingthesmartway.com\"\r\n"
				+ "	    },\r\n" + "	    {\r\n" + "	        \"id\": 3,\r\n" + "	        \"first_name\": \"Ann\",\r\n"
				+ "	        \"last_name\": \"Smith\",\r\n" + "	        \"email\": \"ann@codingthesmartway.com\"\r\n"
				+ "	    }\r\n" + "	]";

		ObjectMapper om = new ObjectMapper();

		JsonNode readTree = om.readTree(jsonString);

		// read properties of id of 1st JSON Object in Array

		System.out.println(readTree.get(0).get("id").asText());

		// iterating over array

		if (readTree.isArray()) {

			Iterator<JsonNode> it = readTree.iterator();

			while (it.hasNext()) {

				JsonNode innerNode = it.next();

				System.out.println(innerNode.get("id").asText());
				System.out.println(innerNode.get("first_name").asText());
				System.out.println(innerNode.get("last_name").asText());
				System.out.println(innerNode.get("email").asText());

			}

		}

		else {

			System.out.println("NOT AN ARRAY..BUGGER OFF HOOMAN....");
		}

	}

}
