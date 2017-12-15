package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Hello");
	System.setProperty("webdriver.ie.driver", "B:\\Automation\\software\\IEDriverServer\\IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();
	driver.navigate().to("https://www.nseindia.com/");
	driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	driver.findElement(By.id("keyword")).sendKeys("HDFC");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//	System.out.println("Normal Market Status :: "+driver.findElement(By.xpath("//span[@id='status1']")).getText().trim());

	}

}
