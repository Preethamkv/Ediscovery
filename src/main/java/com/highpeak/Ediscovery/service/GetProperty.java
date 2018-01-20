package com.highpeak.Ediscovery.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class GetProperty {
	
	public String getPropValues() throws IOException {
		String filepath=" ";
		 
		try {
			Properties prop = new Properties();
			File f1 = new File("config.properties");  
			String path = f1.getPath(); 
			prop.load(new FileInputStream(path));
			// get the property value and print it out
			filepath = prop.getProperty("filepath");
			
		
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
		return filepath;
	}

}
