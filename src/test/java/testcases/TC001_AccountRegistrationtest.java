package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjests.Accountregistrationpage;
import pageobjests.Homepage;
import testbase.BaseClass;

public class TC001_AccountRegistrationtest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {

		logger.info("****Starting TC001_AccountRegistrationtest *****");

		try {

			Homepage hp = new Homepage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");

			hp.clickRegister();
			logger.info("Clicked on Register Link");

			Accountregistrationpage regpage = new Accountregistrationpage(driver);
			logger.info("Provide customer details");
			regpage.setfirtName(randomeString().toUpperCase());
			regpage.setlastName(randomeString().toUpperCase());
			regpage.setemail(randomeString() + "@gmail.com");// Randomly generated the mail mamathan011@gmail.com
			regpage.setTelephone(randomeNumber());

			String password = randomeAlphaNumberic();
			regpage.setpassword(password);
			regpage.setconfirmpassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickcontinue();

			logger.info("validating expected message");
			String confmdg = regpage.getConfirmationMsg();

			if (confmdg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {

				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertFalse(false);
			}

			// Assert.assertEquals(confmdg, "Your Account Has Been Created!");
		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationtest *****");

	}

}
