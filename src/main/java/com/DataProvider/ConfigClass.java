package com.DataProvider;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ConfigClass {
	
	
	public WebDriver driver;
	public static String getproperties(String key)
	{
		
		Properties prop=new Properties();
		
		try {
			prop.load(new FileInputStream(new File(".\\ConfigProperties\\ConfigFiles")));
		} catch (IOException e) {
			
			Reporter.log("Log info: Confile File not found Exception " +e.getMessage());
		}
		
		String value=prop.getProperty(key);
		return value;
		
		
	}
	

}
