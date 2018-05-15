package corporateHome;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporateHome {
	@FindBy(id="combo_company")
	static WebElement SearchCompany;
	
	@FindBy(xpath="//div[@id='ext-gen96']")
	static WebElement SearchCompanyDropdown;
	
	@FindBy(xpath="//iframe[@src='/corporates/listDir/listDirectory.html\']")
	static WebElement frameCount;
	
	@FindBy(id="ext-gen18")
	static WebElement SearchButton;
	
	@FindBy(id="ext-gen20")
	static WebElement ResetButton;
	
	
	public void ListedSecurities_Search(WebDriver driver)
	{
		CorporateHome page = PageFactory.initElements(driver, CorporateHome.class);
		
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		
		String Windowvalue= tabs.get(1).toString();
		//Use the list of window handles to switch between windows
		WebDriver driverNew = driver.switchTo().window(Windowvalue);

		//Switch back to original window
//		driver.switchTo().window(mainWindowHandle);
		try
		{
			WebDriverWait PageLoadWait = new WebDriverWait(driverNew,60);
			PageLoadWait.until(ExpectedConditions.visibilityOf(frameCount));			
//			driverNew.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
		System.out.println("Issue with Loading Page :: "+e);	
		}
		
		System.out.println(driverNew.getTitle());
				
		try
		{
//			int size = driverNew.findElements(By.xpath("//iframe[@src='/corporates/listDir/listDirectory.html\']")).size();
			driverNew.switchTo().frame(1);
			driverNew.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		catch(Exception eth)
		{
			System.out.println(eth);
		}

		String valuecheck = driverNew.findElement(By.xpath("//label[@id='ext-gen80']")).getText();
		System.out.println(valuecheck);
		SearchCompany.clear();
		SearchCompany.sendKeys("LEMONTREE");
		WebDriverWait dynamicwait = new WebDriverWait(driverNew,30);
		try 
		{
		dynamicwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ext-gen96']")));
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		SearchCompanyDropdown.click();


	}

}
