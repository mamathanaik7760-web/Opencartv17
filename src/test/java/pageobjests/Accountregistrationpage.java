package pageobjests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends Basepage {
	WebDriver driver;

	public Accountregistrationpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtconfimpassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfigaration;

	public void setfirtName(String fname) {
		txtfirstname.sendKeys(fname);
	}

	public void setlastName(String lname) {
		txtlastname.sendKeys(lname);
	} 

	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	

	public void setTelephone(String Tel) {
		txtTelephone.sendKeys(Tel);
	}
	

	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}

	
	public void setconfirmpassword(String password) {
		txtconfimpassword.sendKeys(password);
	}
	
	
	public void setPrivacyPolicy() {
		chkPrivacyPolicy.click();
	}

	public void clickcontinue() {
		btncontinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgconfigaration.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
