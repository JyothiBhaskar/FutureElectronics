package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import utility.com.HelperClass;

public class Login_Page {
	
	
	protected WebDriver driver;
	
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By cookibot=By.xpath("//a[@id=\"CybotCookiebotDialogBodyButtonAccept\"]");
	private By loginmenu=By.xpath("//a[@class='userSign']");
	private By Register=By.xpath("//button[@class='btn btn-submit home-register-button']");
	private By Firstname=By.xpath("//input[@name='firstName']");
	private By Lastnamme=By.xpath("//input[@name='lastName']");
	private By email_id=By.xpath("//input[@name='email']");
	private By password=By.xpath("//input[@id='password']");
	private By ConfirmPwd=By.xpath("//input[@name='checkPwd']");
	private By Registerbtn=By.xpath("//button[contains(text(),'Register')]");
	private By Search=By.xpath("//input[@id=\"js-site-search-input\"]");
	private By dashboard=By.xpath("//h1[normalize-space(text()=\"Dashboard\")]");
	private By checkbox1=By.xpath("//input[@type='checkbox'][@id='terms_check']");
	private By checkbox=By.cssSelector("#china-section-mobile > div.terms_check > label");
	
	
	public void cookiebot()
	{
		HelperClass.sleepMethod(2);
		HelperClass.clickmethod(driver, driver.findElement(cookibot)).click();
		
	}
	
	public void registration(String Fname,String Lname, String mailid,String pwd,String Cpwd)
	{
		HelperClass.sleepMethod(2);
		
		driver.findElement(cookibot).click();
		HelperClass.sleepMethod(2);

		driver.findElement(loginmenu).click();
		driver.findElement(Register).click();
		//HelperClass.Expilictwait(driver,loginmenu).click();
		driver.findElement(Firstname).sendKeys(Fname);
		driver.findElement(Lastnamme).sendKeys(Lname);
		driver.findElement(email_id).sendKeys(mailid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(ConfirmPwd).sendKeys(Cpwd);
		WebElement ele=driver.findElement(checkbox);

		JavascriptExecutor ext=(JavascriptExecutor)driver;
		ext.executeScript("arguments[0].scrollIntoView(true);",ele );
		System.out.println("is enabled checking"+ele.isEnabled());
		ext.executeScript("arguments[0].removeAttribute('disabled','disbaled')", ele);
		
		System.out.println("is enabled checking"+ele.isEnabled());

		
		HelperClass.sleepMethod(3);
		

	}
	
	public boolean Dashboard()
	{
	
		HelperClass.sleepMethod(2);
		boolean status=driver.findElement(dashboard).isDisplayed();
		Reporter.log("Dashboard reported");		
		return status;
		
		
		
}
}
