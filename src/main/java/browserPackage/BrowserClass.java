package browserPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserClass {
	
	
public static WebDriver driver;

public static WebDriver getDriver()
{
	return driver;
}

public static WebDriver getBrowser(String BrowserName,String URL)
{
	if(BrowserName.equalsIgnoreCase("Chrome")||BrowserName.equalsIgnoreCase("chrome"))
	{
		//DesiredCapabilities cap=new DesiredCapabilities();
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		driver=new ChromeDriver(options);
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
	
	
	return driver;
	
}

public static void  quitDriver()
{
	driver.quit();
}

}
