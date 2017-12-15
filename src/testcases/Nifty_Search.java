package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Nifty_Search {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver","B:\\Automation\\software\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.nseindia.com/");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		System.out.println("Normal Market Status :: "+driver.findElement(By.xpath("//span[@id='status1']")).getText().trim());
		System.out.println("Nifty 50 Today's Price :: "+driver.findElement(By.xpath("//p[@class='right']//nobr")).getText().trim());
		System.out.println("Nifty 50 Today's Price Change :: "+driver.findElement(By.xpath("//nobr/span[1]")).getText().trim());
		System.out.println("Nifty Arrow Color :: "+driver.findElement(By.xpath("//nobr/span[2]")).getText());		
		System.out.println("Nifty 50 Today's Price change Percentage :: "+driver.findElement(By.xpath("//nobr/span[3]")).getText().trim());
		
	}

}
