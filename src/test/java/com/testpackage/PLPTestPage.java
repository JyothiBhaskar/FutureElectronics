package com.testpackage;

import org.testng.annotations.Test;

import com.pages.PLPPages;

import basePackage.BaseClass;

public class PLPTestPage extends BaseClass{

	
	
	@Test
	public void PLP()
	{
		PLPPages plp=new PLPPages(driver);
		plp.Categories();
		
	}
	
}
