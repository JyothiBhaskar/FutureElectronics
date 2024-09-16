package com.testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DataProvider.ConfigClass;
import com.DataProvider.GetData;
import com.pages.HomeTest;
import com.pages.RegisteredUser;

import basePackage.BaseClass;

public class Homepage extends BaseClass {
	
	
	@Test(priority =1,dataProvider="Search",dataProviderClass=GetData.class)
	public void RegionTest(String search)
	{
		HomeTest test=new HomeTest(driver);
		Assert.assertTrue(test.FELogodispaly());
		test.RegionDropdow(ConfigClass.getproperties("region"));
		test.LangDropdown();
		test.search(search);
		Assert.assertTrue(test.searchvalid());
		
	}
	
	@Test(priority = 2,dataProvider="logindata",dataProviderClass=GetData.class)
	public void Login(String Uname,String Pwd)
	{
		RegisteredUser user=new RegisteredUser(driver);
		Assert.assertTrue(user.Logintext());
		user.Login(Uname, Pwd);
		
	}
	
	
	
	}


