package basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.DataProvider.ConfigClass;

import org.testng.Reporter;
import browserPackage.BrowserClass;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Log Info: Setting upthe Browser", true);
		
		driver=BrowserClass.getBrowser(ConfigClass.getproperties("BrowserName"),ConfigClass.getproperties("URL"));
		Reporter.log("Log Info : Browser is up and running");
		driver.findElement(By.xpath("//a[@id=\"CybotCookiebotDialogBodyButtonAccept\"]")).click();
		
	}
	
	@AfterClass
	public void tearDown()
	{

		
		BrowserClass.quitDriver();
		Reporter.log("Browser closed");
}
}