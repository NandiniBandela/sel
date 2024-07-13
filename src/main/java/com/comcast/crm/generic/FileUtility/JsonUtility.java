package com.comcast.crm.generic.FileUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJSONFile(String key) throws Throwable {
		FileReader fr=new FileReader("./ConfigAppData/appCommonData.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fr);
		JSONObject map= (JSONObject)obj;
		String data =(String)map.get(key);	
		return data;
	}

}
