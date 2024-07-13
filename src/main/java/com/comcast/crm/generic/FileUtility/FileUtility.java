package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./ConfigAppData/commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);

		return data;
	}

}
