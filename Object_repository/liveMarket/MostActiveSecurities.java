package liveMarket;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MostActiveSecurities {

	WebDriver driver;
	
	@FindBy(xpath="//h2[text()='Most Active Securities']")
	private WebElement  Heading;
	
	@FindBy(id="dataTime")
	private WebElement TimingInstance;

	@FindBy(xpath="//*[@id='tab7']")
	private WebElement ValueTab;
	
	@FindBy(id="tab8")
	private WebElement VolumeTab;
	
	@FindBy(xpath="//*[@id='topVolume']/tbody/tr")
	private List<WebElement> tabledata;

	public void MostActiveSecuritiesByValue(WebDriver driver,String inputvalue)
	{
	
		System.out.println(inputvalue);
	}
	
	
}
