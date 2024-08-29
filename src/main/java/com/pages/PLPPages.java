package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.com.HelperClass;

public class PLPPages {
	
	protected WebDriver driver;
	
	public PLPPages(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By categorylink=By.xpath("//nav[3]//div//div//button//following-sibling::ul//span//a[@title='Products']");
	private By L1Category= By.xpath("//nav[3]//following-sibling::a");
	private By products=By.xpath("//a[@class='product__list--code']");
	private By productlisttab=By.xpath("//a[contains(text(),'Product Listing')]");

	public void Categories()
	{
		HomeTest test=new HomeTest(driver);
		test.FELogodispaly();
		HelperClass.Expilictwait(driver, categorylink).click();
		HelperClass.sleepMethod(2);
		List<WebElement> lst=driver.findElements(L1Category);
		
	for(int i=0;i<lst.size();i++)
	{
		String value=lst.get(i).getText();
		System.out.println("Listed Categories are: "+value);
		if(value.equalsIgnoreCase("Analog"))
		{
			HelperClass.sleepMethod(2);

         lst.get(i).click();	
         break;
		}
		
	}	
	
	HelperClass.Expilictwait(driver, productlisttab).click();
	HelperClass.sleepMethod(2);
	HelperClass.scrollTo(driver, products);
	HelperClass.sleepMethod(2);

	List<WebElement> lst1=driver.findElements(products);
	for(int i=0;i<lst1.size();i++)
	{

		String value=lst1.get(i).getText();
		System.out.println(value);
		
		if(value.equalsIgnoreCase("CAP1126-1-AP-TR"))
		{
			lst1.get(i).click();
			break;
		}
	}
		
	}}