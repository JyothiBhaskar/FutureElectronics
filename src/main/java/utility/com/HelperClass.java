package utility.com;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.DataProvider.ConfigClass;


public class HelperClass {

	/*
	 * 	
	 * waits - completed
	 * scroll - completed
	 * screenshot-completed
	 * highlighter - completed
	 * actions - completed
	 * click and sendKeys - Completed
	 * switch - completed
	 * javascript - completed
	 * select - completed
	 * WindowHandles-completed
	
	/* complete this utility with below methods
	 * 	
	 * 		doubleclick
	 * 		rightclick
	 * 		dragDrop
	 * 		mouseHover
	 *
	 */
	
	
	
	
	
	public static WebElement  clickmethod(WebDriver driver,WebElement ele)
	{
		
		try {
			ele.click();
		} catch (Exception e) {
			
			Reporter.log("Log Info: Unable to click using click method, hence using Action click"+ e.getMessage());
			Actions act=new Actions(driver);
		
		try
		{
			act.moveToElement(ele).click().perform();
		
		}
		catch(Exception e1)
		{			Reporter.log("Log Info: Unable to click using click method, hence using javascript click"+ e.getMessage());
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].click()", ele);
			
			}
		}
		
		return ele;
		
	}
	
	public static void scroll(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(ele).perform();
				
	}
	
	public static void scrollTo(WebDriver driver,By Locator)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(driver.findElement(Locator)).click().build().perform();
	}
	
	public static String TakeScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String value=ts.getScreenshotAs(OutputType.BASE64);
		
		return value;
	}
	
	public static void sleepMethod(int Timeinsec )
	{
		
	try {
		Thread.sleep(Timeinsec*1000);
	} catch (InterruptedException e) {
		Reporter.log("Log info Thread interrupted " + e.getMessage());
		
	}}
	
	public static WebElement  Expilictwait(WebDriver driver,By locator)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	  WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(locator));
	     
	   String highlight=ConfigClass.getproperties("HighElement");
		
		if(highlight.equalsIgnoreCase("true"))
		{
			HelperClass.Highlighter(driver, ele);
		}
		return ele;
	   
	}
	public static WebElement Highlighter(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor ext=(JavascriptExecutor)driver;
		ext.executeScript("arguments[0].setAttribute('style','background:yellow;border:solid 2px Red)", ele);
		
		return ele;
		
	}
	
	
	
	public static String getCurrentDate()
	{
		SimpleDateFormat myformat=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		
		String newFormat=myformat.format(new Date());
		return newFormat;
	}
	
	}
	
	
	

