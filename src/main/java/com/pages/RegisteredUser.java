package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.com.HelperClass;

public class RegisteredUser {
	
	
	
	protected WebDriver driver;
	
	public RegisteredUser(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By loginmenu=By.xpath("//a[@class='userSign']");
	private By Username=By.xpath("//input[@id='j_username']");
	private By Password=By.xpath("//input[@id='j_password']");
	private By logintext=By.xpath("//h2[contains(text(),'	Login')]");
	private By submitbtn=By.xpath("//button[contains(text(),'	Login')]");
	private By cookibot=By.xpath("//a[@id=\"CybotCookiebotDialogBodyButtonAccept\"]");
	
	public boolean Logintext()
	{
		HelperClass.sleepMethod(2);
		HelperClass.Expilictwait(driver, loginmenu).click();
		HelperClass.sleepMethod(2);

		//HelperClass.cookiebutton(driver, driver.findElement(cookibot));
		return HelperClass.Expilictwait(driver, logintext).isDisplayed();
		
	}
	
	
	public void Login(String Uname,String Pword)
	{
	
	HelperClass.Expilictwait(driver, Username).sendKeys(Uname);
	HelperClass.Expilictwait(driver, Password).sendKeys(Pword);
	HelperClass.sleepMethod(2);

	HelperClass.Expilictwait(driver, submitbtn).click();
}
	
	
	
}