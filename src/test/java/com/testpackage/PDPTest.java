package com.testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DataProvider.ConfigClass;
import com.pages.PDP_Page;
import com.pages.RegisteredUser;

import basePackage.BaseClass;

public class PDPTest extends BaseClass {
	
	@Test
	public void PDP_Addtocart()
	{
		RegisteredUser user=new RegisteredUser(driver);
		user.Logintext();
		user.Login(ConfigClass.getproperties("Username"), ConfigClass.getproperties("pwd"));
		
		PDP_Page pdp=new PDP_Page(driver);
		Assert.assertTrue(pdp.addtocart());
		
		
	}


}
