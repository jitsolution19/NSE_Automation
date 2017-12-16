package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopGainer_And_Looser {

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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Top Ten Gainers / Losers")));
		driver.findElement(By.linkText("Top Ten Gainers / Losers")).click();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);		
		driver.findElement(By.linkText("Gainers")).click();
		System.out.println(driver.findElement(By.id("dataTime")));
		driver.findElement(By.linkText("Nifty 50")).click();
		List<WebElement> TabelRow= driver.findElements(By.xpath("//table[@id='topGainers']/tbody/tr"));
		System.out.println(TabelRow.size());
		System.out.println("Symbol|LTP|% Change|Traded Qty|Value(in Lakhs)|Open|High|Low|Prev. Close|Latest Ex Date|Corporate Action|");
		for(int i =1;i<TabelRow.size();i++)
		{
			List<WebElement> TabelColumn= driver.findElements(By.xpath("//table[@id='topGainers']/tbody/tr["+i+"]/td"));
			for(int j =0;j<TabelColumn.size();j++)
			{
				System.out.print(TabelColumn.get(j).getText()+"|");
			}
			System.out.println();
		}
	}

}
