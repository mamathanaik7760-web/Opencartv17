package pageobjests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {

	public Loginpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemailaddres;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;

	public void setemail(String email) {
		txtemailaddres.sendKeys(email);
	}

	public void setpassword(String pass) {
		txtpassword.sendKeys(pass);
	}

	public void clicklogin() {
		btnlogin.click();
	}
}
