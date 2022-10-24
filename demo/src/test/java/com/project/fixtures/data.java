package com.project.fixtures;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class data {

    // JSONParser
	static JSONParser jsonParser = new JSONParser();
    
    public static String getData(String data) throws IOException, ParseException{
        //Read Json file
        Object obj = jsonParser.parse(new FileReader(".src/test/java/com/project/fixtures/testingData.json"));
        // Creates object
		JSONObject jsonObject = (JSONObject)obj;
        // Looks for object inside Json file
        data = (String)jsonObject.get(data);
        // returns for data with the expected value
		return data;
	}


}
