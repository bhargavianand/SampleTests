package com.simpletests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property_Test {
	
	public static void main(String[] args) throws IOException {
	
	//	FileReader reader = new FileReader(System.getProperty("user.dir")+"\\config.properties");
	// or
	 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		Properties config = new Properties();
		
		config.load(fis);
		
	System.out.println(config.getProperty("browser"));
	System.out.println(config.getProperty("name"));
		
	}

}
