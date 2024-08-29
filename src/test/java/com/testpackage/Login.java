package com.testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DataProvider.GetData;
import com.pages.Login_Page;

import basePackage.BaseClass;

public class Login extends BaseClass{
	
	
	
	@Test(dataProvider="TestingData",dataProviderClass=GetData.class)
	public void Registration(String Fname,String Lname,String email,String pwd,String cpwd)
	{
		Login_Page L=new Login_Page(driver );
		
		L.registration(Fname,Lname,email,pwd,cpwd);
	Assert.assertTrue(L.Dashboard(), "Captured dashboard heading");
	Assert.assertEquals(true, L.Dashboard());
	}
	

}
