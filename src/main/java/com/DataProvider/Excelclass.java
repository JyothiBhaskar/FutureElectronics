package com.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class Excelclass {
	
	
	
	public static Object[][] ExcelData(String SheetName)
	{
		XSSFWorkbook wb=null;
		
		
		try 
		{
			wb = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\hp\\Desktop\\PreparationprojectData.xlsx")));
		} catch (FileNotFoundException e) 
		{
			
			Reporter.log("LOG:FAIL - File not present "+ e.getMessage(),true);
			
		} catch (IOException e) 
		{
			Reporter.log("LOG:FAIL - Could not load the file "+ e.getMessage(),true);
		}
		
			int rowcount=wb.getSheet(SheetName).getPhysicalNumberOfRows();
			int colcount=wb.getSheet(SheetName).getRow(0).getPhysicalNumberOfCells();
			
			
			Object[][] arr=new Object[rowcount][colcount];
			  for(int i=0;i<rowcount;i++)
			  {
				  
					  for(int j=0;j<colcount;j++)
					  {
						  String value="";
						  CellType type=wb.getSheet(SheetName).getRow(i).getCell(j).getCellType();
						  
						 if(type==CellType.STRING)
						 {
							 value=wb.getSheet(SheetName).getRow(i).getCell(j).getStringCellValue();
						 }
						 else if(type==CellType.BOOLEAN) {
							 boolean booleanvalue=wb.getSheet(SheetName).getRow(i).getCell(j).getBooleanCellValue();
							 value=String.valueOf(booleanvalue);
						 }
						 else if(type==CellType.NUMERIC)
						 {
							 double db=wb.getSheet(SheetName).getRow(i).getCell(j).getNumericCellValue();
							 value=String.valueOf(db);
							 
						 }
						 else if(type==CellType.BLANK)
						 {
							 value="";
						 }
						 arr[i][j]=value;
					  }
					  
				  }
				  		
	
			return arr;

}}
