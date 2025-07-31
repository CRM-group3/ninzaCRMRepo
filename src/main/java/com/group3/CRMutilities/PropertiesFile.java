package com.group3.CRMutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesFile {
	

	
		FileInputStream fileinput;
		
		public String getProperty(String nameOfFile,String Key)  {
			
			String userDir = System.getProperty("user.dir");
			String fileseparator = System.getProperty("file.separator");

			String filepath = userDir + fileseparator + "src/main/resources/properties" + fileseparator + nameOfFile;

			try {
				fileinput = new FileInputStream(filepath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Properties prop = new Properties();
			try {
				prop.load(fileinput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return (String) prop.getProperty(Key);	
		}

}
