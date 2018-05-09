package testcases;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser_Setup.Launch_Browser;

public class Corporates_ListingDirectoryEquity {
	@FindBy(id="main_corporate")
	static WebElement Corporates;	
	
	@FindBy(linkText="Listed Securities")
	static WebElement ListedSecurities;
	
	@FindBy(id="combo_company")
	static WebElement SearchCompany;
	
	@FindBy(id="ext-gen103")
	static WebElement SearchCompanyDropdown;

	@Test	
	public void Corporates_ListingDirectoryEquitymethod() {
		Launch_Browser Browse = new Launch_Browser();
		WebDriver driver= Browse.Launch_Browser();
		Corporates_ListingDirectoryEquity page = PageFactory.initElements(driver, Corporates_ListingDirectoryEquity.class);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Actions builder = new Actions(driver);		
		builder.moveToElement(Corporates).build().perform();		
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Listed Securities")));		
		ListedSecurities.click();		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		SearchCompany.sendKeys("LEMONTREE");
		SearchCompanyDropdown.click();
		}
}
