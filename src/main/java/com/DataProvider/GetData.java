package com.DataProvider;

import org.testng.annotations.DataProvider;

public class GetData {

	
	@DataProvider(name="TestingData")
	public static Object[][] getExcelData()
	{
		Object arr[][]=Excelclass.ExcelData(ConfigClass.getproperties("sheetname"));
		
		return arr;
		
	}
	
	@DataProvider(name="Search")
	public static Object[][] getExcelData1()
	{
		Object arr[][]=Excelclass.ExcelData(ConfigClass.getproperties("sheetname1"));
		return arr;
		
	}
	@DataProvider(name="logindata")
	public static Object[][] getExcelData2()
	{
		Object arr[][]=Excelclass.ExcelData(ConfigClass.getproperties("sheetname2"));
		return arr;
		
	}
	@DataProvider(name="Region")
	public static Object[][] getExcelData3()
	{
		Object arr[][]=Excelclass.ExcelData(ConfigClass.getproperties("sheetname3"));
		return arr;
		
	}
}
