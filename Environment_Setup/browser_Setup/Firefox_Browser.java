package browser_Setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_Browser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","B:\\Automation\\software\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.nseindia.com/");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}

}
