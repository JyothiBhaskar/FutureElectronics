package com.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.com.HelperClass;

public class Extent {
	
	public static ExtentReports reports;
	
	public static ExtentReports getInstance()
	{
		if(reports==null)
		{
			return CreateInstance();
		}
		else {
		return reports;}
		
	}
		public static ExtentReports CreateInstance()
		{
			ExtentSparkReporter reporter=new ExtentSparkReporter("./Reports/ExtentReports_"+HelperClass.getCurrentDate()+".html");
			reporter.config().setDocumentTitle("Automation Reports");
			reporter.config().setReportName("Sprint 1");
			reporter.config().setTheme(Theme.DARK);
			
			reports=new ExtentReports();
			reports.attachReporter(reporter);

			return reports;
			
		}
		
		
	}


