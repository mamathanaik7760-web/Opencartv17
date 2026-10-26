package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjests.Homepage;
import pageobjests.Loginpage;
import pageobjests.Myaccountpage;
import testbase.BaseClass;

public class TC002_Logintest extends BaseClass {

	@Test(groups={"sanity","Master"})
	public void verify_login() {
		logger.info("******** Starting TC002_Logintest*********");
		try {
			// homepage
			Homepage hp = new Homepage(driver);
			hp.clickMyAccount();
			hp.clicklogin();

			// loginpage
			Loginpage lp = new Loginpage(driver);
			lp.setemail(p.getProperty("email"));
			lp.setpassword(p.getProperty("password"));
			lp.clicklogin();

			// myaccount page
			Myaccountpage mcc = new Myaccountpage(driver);
			boolean targetpage = mcc.isMyaccountpageExists();

			// Assert.assertEquals(targetpage,true,"Login faill");
			Assert.assertTrue(targetpage);
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("******* Finished TC002_Logintest********");
	}

}
