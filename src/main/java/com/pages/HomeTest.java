package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.DataProvider.ConfigClass;

import lombok.experimental.Helper;
import utility.com.HelperClass;

public class HomeTest {
	
	
	WebDriver driver;
	
	public HomeTest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	 By FELogo=By.xpath("//img[@title='Future Electronics Logo']");
	 By geodropdown=By.xpath("//nav[1]//following-sibling::li[@data-automation-ref='GL_Geo']");
   By LanDropdown=By.xpath("//nav[1]//following-sibling::li[@data-automation-ref='GL_Language']");
   By Region=By.xpath("//nav[1]//following-sibling::li[@data-automation-ref='GL_Geo']//a[@class='selected-curr currnet-selected-curr']");
   By cookibot=By.xpath("//a[@id=\"CybotCookiebotDialogBodyButtonAccept\"]");
 By currency=By.xpath("//nav[1]//following-sibling::li[@data-automation-ref='GL_Geo']//li[@class='region'][1]//ul[1]//li[2]//a[@data-anonym-selectedisocode='AUD']/span");
	//private By listcurrencies=By.xpath("//nav[1]//following-sibling::li[@data-automation-ref='GL_Geo']//li[@class='region'][1]//ul//a/span");
	 By search=By.xpath("//input[@id='js-site-search-input']");
	By searchsuggestion=By.xpath("//div[contains(text( ), 'Schottky ')]//span");
	By searchvalidation=By.xpath("//h1[contains(text(),'Search Results')]");
	By searchbutton=By.xpath("//button[@class='btn btn-link']");
	By NAlink=By.xpath("//nav[1]//ul//li[@class='region']//a[contains(text(),'Americas')]");
	By CAD=By.xpath("//nav[1]//ul//li[@class='region']//a[contains(text(),'Americas')]//following-sibling::ul//li[2]//a");
	 By CAD1=By.cssSelector("#homepage > ul.nav__links--primary.pull-left.left-sec-site > li:nth-child(1) > div.dropdown.fe-theme.country-select.top-fixed-select > ul > li.region.active > ul > li:nth-child(2) > a > span");
	 By regionswitch=By.xpath("//span[contains(text(),'Region Switching')]");
	 By confirmBtn=By.xpath("//div[@id='cboxContent']//button[contains(text(),' Confirm')]");
	By AUD=By.cssSelector("#homepage > ul.nav__links--primary.pull-left.left-sec-site > li:nth-child(1) > div.dropdown.fe-theme.country-select.top-fixed-select.open > ul > li.region.active > ul:nth-child(2) > li:nth-child(2) > a > span");
	
	public boolean FELogodispaly()
	{
		HelperClass.sleepMethod(3);
		
		return driver.findElement(FELogo).isDisplayed();		
	}
	
	public void RegionDropdow()
	{
		HelperClass.sleepMethod(2);
		driver.findElement(geodropdown).click();
		WebElement value1=driver.findElement(geodropdown);
		System.out.println(value1.getText());	
		HelperClass.sleepMethod(2);}
	
	//if(region.equalsIgnoreCase("America"))
		
		public void NARegion()
		{
			HelperClass.sleepMethod(2);
			driver.findElement(geodropdown).click();
			WebElement value1=driver.findElement(geodropdown);
			System.out.println(value1.getText());	
			HelperClass.sleepMethod(2);
	//{
		HelperClass.Expilictwait(driver, NAlink).click();
		HelperClass.sleepMethod(2);
		driver.findElement(CAD1).click();
		HelperClass.sleepMethod(3);
	
		String Regionsweitch=HelperClass.Expilictwait(driver, regionswitch).getText();
		System.out.println("Regionswitch heading is "+" " +Regionsweitch);
		HelperClass.clickmethod(driver, driver.findElement(confirmBtn));
		HelperClass.sleepMethod(3);
	}
	//}
	//else if(region.equalsIgnoreCase("Asia Apac"))
	//{
		public void AUDregion()
		{
			HelperClass.sleepMethod(2);
			driver.findElement(geodropdown).click();
			WebElement value1=driver.findElement(geodropdown);
			System.out.println(value1.getText());	
			HelperClass.sleepMethod(2);
		HelperClass.Expilictwait(driver,Region).click();
		HelperClass.Expilictwait(driver, AUD).click();
		HelperClass.sleepMethod(3);

	}
	
	
		
	public void LangDropdown()
	{
		
		driver.findElement(LanDropdown).click();
		
		WebElement value=driver.findElement(LanDropdown);
		System.out.println(value.getText());	
	}

	public void search(String searchkeyword)
	{
		
	HelperClass.Expilictwait(driver, search).sendKeys(searchkeyword);
	HelperClass.Expilictwait(driver,searchbutton).click();

	}
	
	public boolean searchvalid()
	{
		String text=driver.findElement(searchvalidation).getText();
		System.out.println(text);
		return HelperClass.Expilictwait(driver, searchvalidation).isDisplayed();

	}
	
	
	
	
}
	
	
	

