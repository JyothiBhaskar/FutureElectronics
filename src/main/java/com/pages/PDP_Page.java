package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.com.HelperClass;

public class PDP_Page {
	

	protected WebDriver driver;
	
	public PDP_Page (WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By increasequantity=By.xpath("//span[@class='input-group-btn plus']");
	private By decreasequantity=By.xpath("//span[@class='input-group-btn minus']");
	private By addtocart=By.xpath("//button[@id='addToCartButton']");
	private By minicart=By.cssSelector("#productDetails > ul.nav__links--primary.pull-right.right-sec-site > li.nav-cart.cart.selected > a > span.mini-cart-icon > span");
	private By checkout=By.xpath("//button[@data-cbox-title='Login']");
	private By cvalidation=By.xpath("//h1[text()='Checkout']");
	private By Fname=By.xpath("//input[@id='billing-firstName']");
	
	
	
	public boolean addtocart()
	{
		PLPPages plp=new PLPPages(driver);
		plp.Categories();
		plp.produtclick();
		HelperClass.sleepMethod(3);
		
		HelperClass.Expilictwait(driver, increasequantity).click();
		HelperClass.sleepMethod(2);

		HelperClass.Expilictwait(driver, decreasequantity).click();
		HelperClass.sleepMethod(2);

		HelperClass.scroll(driver, driver.findElement(addtocart));
		HelperClass.clickmethod(driver, driver.findElement(addtocart));
		HelperClass.sleepMethod(2);
        HelperClass.clickmethod(driver, driver.findElement(minicart));
		HelperClass.sleepMethod(3);
		HelperClass.Expilictwait(driver, checkout).click();
		HelperClass.sleepMethod(3);
		HelperClass.Expilictwait(driver, Fname).sendKeys("Jyothi");
		boolean status =HelperClass.Expilictwait(driver, cvalidation).isDisplayed();
		return status;
	}
	
	
	
}
