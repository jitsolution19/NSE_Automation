package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pre_Open_Market {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver","B:\\Automation\\software\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.nseindia.com/");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		WebElement menu =driver.findElement(By.linkText("Live Market"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Actions builder = new Actions(driver);		
		builder.moveToElement(menu).build().perform();		
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Pre-Open Market")));
		driver.findElement(By.linkText("Pre-Open Market")).click();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.id("time")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='status']/span")).getText());
		System.out.println(driver.findElement(By.xpath("//li[@class='active']/span[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//li[@class='active']/span[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//li[@class='active']/i")).getText());
		System.out.println(driver.findElement(By.xpath("//li[@class='active']/i")).getAttribute("style"));
		Select view_active_preopen = new Select(driver.findElement(By.id("selId")));
		view_active_preopen.selectByVisibleText("FO Stocks");
		System.out.println("Symbol|CA|Pre-Open|Price|Chng|% Chng|Prev. Close|Quantity|Value(in lakhs)|FFM Cap(crs.)|NM 52w H|NM 52w L|");
		List<WebElement> preOpenNiftyTab =driver.findElements(By.xpath("//table[@id='preOpenNiftyTab']/tbody/tr"));
		for(int j=3;j<=preOpenNiftyTab.size();j++)
		{
			List<WebElement> preOpenNiftyTab_column =driver.findElements(By.xpath("//table[@id='preOpenNiftyTab']/tbody/tr["+j+"]/td"));
			for(int k=0;k<preOpenNiftyTab_column.size();k++)
			{
				System.out.print(preOpenNiftyTab_column.get(k).getText()+"|");		
			}
			System.out.println("");
		}
	}
}
