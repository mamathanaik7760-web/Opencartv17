package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjests.Homepage;
import pageobjests.Loginpage;
import pageobjests.Myaccountpage;
import testbase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="datadriven")//getting data provider from different class
	public void  verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		
		logger.info("******** Starting TC003_LoginDDT*********");
		try 
		{
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clicklogin();

		// loginpage
		Loginpage lp = new Loginpage(driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clicklogin();

		// myaccount page
		Myaccountpage mcc = new Myaccountpage(driver);
		boolean targetpage = mcc.isMyaccountpageExists();
		
		/*Data  is valid -login sucess- test pass-logout
		 * Data  is  valid  -- login  failed -test fail
		 * 
		 * Data is invalid -login sucess- test fail-logout
		 * Data is invalid -- login failed - test pass
		 */

		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				mcc.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertFalse(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				mcc.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		Thread.sleep(5000);
		logger.info("******** Finished TC003_LoginDDT*********");
		
		
	}

}
