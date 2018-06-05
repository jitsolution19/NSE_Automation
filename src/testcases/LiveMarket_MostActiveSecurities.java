package testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import browser_Setup.Launch_Browser;
import liveMarket.MostActiveSecurities;

public class LiveMarket_MostActiveSecurities extends  testing {
WebDriver driver;
	@Test
	public void LiveMarket_MostActiveSecurities_ByValue()
	{
		Launch_Browser browser = new Launch_Browser();
		this.driver =  browser.Launch_Browser();
		MostActiveSecurities MASBYU = new MostActiveSecurities();
		String Value = "Value";
		MASBYU.MostActiveSecuritiesByValue(driver, Value);
		
	}
	
}
