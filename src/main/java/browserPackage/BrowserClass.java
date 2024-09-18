package browserPackage;

import java.net.MalformedURLException;
import com.pages.HomeTest;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import com.DataProvider.ConfigClass;
import com.pages.HomeTest;

public class BrowserClass {
	
	
public static WebDriver driver;

public static WebDriver getDriver()
{
	return driver;
}

public static WebDriver getBrowser(String BrowserName,String URL,String region)
{
	if(BrowserName.equalsIgnoreCase("Chrome")||BrowserName.equalsIgnoreCase("chrome"))
	{
		//DesiredCapabilities cap=new DesiredCapabilities();
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
	
		try {
			driver=new RemoteWebDriver(new URL("http://43.205.98.42:4444/"),options);
			options.setCapability("browserName", "chrome");
			options.setCapability("browserVersion","123.0");
			options.setCapability("platformName", "linux");
			
		} catch (MalformedURLException e) {
			
			Reporter.log("Log:Info - Couldn't connect to seleniumGrid"+e.getMessage());
		}
		
		
		//driver=new ChromeDriver(options);
	}
	else if(BrowserName.equalsIgnoreCase("Firefox")||BrowserName.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BrowserName.equalsIgnoreCase("Edge")||BrowserName.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	
	HomeTest test=new HomeTest(driver);
	
	if(region.equalsIgnoreCase("America"))
	{
		test.NARegion();
		
		}
	else if(region.equalsIgnoreCase("Asia Apac"))
	{
	
	test.AUDregion();
	}
	return driver;
	
	
	
	}
	

public static void  quitDriver()
{
	driver.quit();
}

}
