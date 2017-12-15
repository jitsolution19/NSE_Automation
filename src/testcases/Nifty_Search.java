package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nifty_Search {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "B:\\Automation\\software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.nseindia.com/");
		Thread.sleep(5000);
//		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		System.out.println("Normal Market Status :: "+driver.findElement(By.xpath("//span[@id='status1']")).getText().trim());
		System.out.println("Nifty 50 Today's Price :: "+driver.findElement(By.xpath("//p[@class='right']//nobr")).getText().trim());
		System.out.println("Nifty 50 Today's Price Change :: "+driver.findElement(By.xpath("//nobr/span[1]")).getText().trim());
		System.out.println("Nifty Arrow Color :: "+driver.findElement(By.xpath("//nobr/span[2]")).getText());		
		System.out.println("Nifty 50 Today's Price change Percentage :: "+driver.findElement(By.xpath("//nobr/span[3]")).getText().trim());
//		System.out.println("Nifty 50 Today's Price change Percentage :: "+driver.findElement(By.cssSelector("#niftyDiv nobr>.red,.green")).getText().trim());
	}

}
