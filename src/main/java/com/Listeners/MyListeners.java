package com.Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.DataProvider.ConfigClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browserPackage.BrowserClass;
import utility.com.HelperClass;

public class MyListeners implements ITestListener {

	ExtentReports reports=Extent.getInstance();
	ExtentTest test;
	
	public void onTestSuccess(ITestResult result)
	{
		
		//WebDriver driver=BrowserClass.getDriver();
		//String screenshot=HelperClass.TakeScreenshot(driver);
		
		if(ConfigClass.getproperties("screenshotOnSuccess").equalsIgnoreCase("true"))
		{
			test.pass("Test pass ", MediaEntityBuilder.createScreenCaptureFromBase64String(HelperClass.TakeScreenshot(BrowserClass.getDriver())).build());
		}
		else {
		test.pass("Test Passed"+result.getTestName());}
		}
	
	
	public void onTestFailure(ITestResult result)
	{
	
		test.fail("Test fail" +result.getThrowable().getMessage());
	}
	public void onTestStart(ITestResult result)
	{
		test = reports.createTest(result.getMethod().getMethodName());
	}
	public void onFinish(ITestContext context)
	{
		reports.flush();

	}
	
	public void onTestSkipped(ITestResult result)
	{
		test.skip("Test Skipped " + result.getThrowable().getMessage());

	}
}
