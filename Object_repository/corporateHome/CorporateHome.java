package corporateHome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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
			
		String Mainwindow = driver.getWindowHandle();
		WebDriver driverNew = null;
		//Get the list of window handles
		Iterator<String> Windowcounter= driver.getWindowHandles().iterator();
		while(Windowcounter.hasNext())
		{
			String Childwindow = Windowcounter.next();
			if(!Mainwindow.equalsIgnoreCase(Childwindow))
			{
				driverNew = driver.switchTo().window(Childwindow);
				break;
			}
		}
		
		CorporateHome page = PageFactory.initElements(driverNew, CorporateHome.class);
		
		try
		{
			WebDriverWait PageLoadWait = new WebDriverWait(driverNew,1200);
			PageLoadWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameCount));			
		}
		catch(Exception e)
		{
		System.out.println("Issue with Loading Page :: "+e);	
		}
		
		System.out.println(driverNew.getTitle());
				
		String valuecheck = driverNew.findElement(By.xpath("//label[@id='ext-gen80']")).getText();
		System.out.println(valuecheck);
		SearchCompany.clear();
		String Input="LEMONTREE";
		SearchCompany.sendKeys(Input);
		WebDriverWait dynamicwait = new WebDriverWait(driverNew,30);
		dynamicwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='x-combo-list-inner']//a[text()='"+Input+"']")));
		driverNew.findElement(By.xpath("//*[@class='x-combo-list-inner']//a[text()='"+Input+"']")).click();
//		SearchCompanyDropdown.click();
		try
		{
			driverNew.findElement(By.xpath("//img[@id='ext-gen92']")).click();
			
		}catch(Exception e)
		{
			System.out.println("Issue with Selection ::"+e);
		}
		
	}

}
