package browser_Setup;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Launch_Browser {
	static WebDriver driver;
	public WebDriver Launch_Browser() {
		
		String Browser=null;
		String BrowserPath=null;
		String Url=null;
		FileReader reader;
		try {
			reader = new FileReader("user.properties");
			Properties uservalue=new Properties();  
			uservalue.load(reader);
			Browser= uservalue.getProperty("Browser");
			BrowserPath = uservalue.getProperty("BrowserPath");
			Url= uservalue.getProperty("url");		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      
	      	if(Browser.matches("chrome"))
	      	{
	      		driver = Chrome_Browser();
	      		
	      	}else if(Browser.matches("firefox"))
	      	{
	      		driver = FireFox_Browser(BrowserPath,Url);
	      	}else if (Browser.matches("InternetExplorer"))
	      	{
//	      		driver = FireFox_Browser();
	      	}
	      	
		return driver;
	}

	public static WebDriver FireFox_Browser(String BrowserPath,String Url)
	{
		System.setProperty("webdriver.gecko.driver",BrowserPath);
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to(Url);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		return driver;	
	}
	
	public static WebDriver Chrome_Browser()
	{
		System.setProperty("webdriver.gecko.driver","B:\\Automation\\software\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.nseindia.com/");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		return driver;	
	}
	
	
}
