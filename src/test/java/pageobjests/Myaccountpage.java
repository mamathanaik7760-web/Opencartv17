package pageobjests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage  extends Basepage{

	public Myaccountpage(WebDriver driver)  // consutuctor add
	{
		super(driver);
	}
	

	@FindBy(xpath="//h2[text()='My Account']") //myaccount page heading //element 
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group-item']//a[text()='Logout']")
	WebElement lnklogout;
	
	public boolean isMyaccountpageExists()  // verifying element present or not 
	{
		try
		{
			return msgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public void clicklogout()
	{
		lnklogout.click();
	}
}
