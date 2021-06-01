package com.framework.datadriven.utils;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {
	private static final String EMPLOYEEJSONFILE = System.getProperty("user.dir") + "\\testdata\\user.json";
	static JSONArray details;

	public static void main(String[] args) throws Exception {

		details = parseJsonFile(EMPLOYEEJSONFILE);
		System.out.println("Firstname: " + getFirstName(1));
		System.out.println("Lastname: " + getLastName(1));
		System.out.println("Firstname: " + getFirstName(0));
		System.out.println("Lastname: " + getLastName(0));
	}

	static JSONArray parseJsonFile(String employeejsonfile2) throws Exception {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(EMPLOYEEJSONFILE);
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		details = (JSONArray) jsonObject.get("Userdetails");
		return details;
	}

	static String getFirstName(int id) {
		JSONObject jsonObject = (JSONObject) details.get(id);
		return (String) jsonObject.get("Firstname");
	}

	static String getLastName(int id) {
		JSONObject jsonObject = (JSONObject) details.get(id);
		return (String) jsonObject.get("Lastname");
	}
}
