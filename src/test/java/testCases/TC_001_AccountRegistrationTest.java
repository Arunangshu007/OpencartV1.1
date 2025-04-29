package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("***** Clicked on MyAccount Link *****");
		
		hp.clickRegister();
		logger.info("***** Clicked on Registration Link *****");
		
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		
		logger.info("***** Providing customer details *****");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone(randomNumber());	
		String Password=randomAlphaNumeric();
		regPage.setPassword(Password);
		regPage.setConfirmPassword(Password);
		regPage.clickPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("***** Validating expected message *****");
		String message=regPage.getConfirmationMsg();

		if(message.equals("Your Account Has Been Created!"))
				{
			      Assert.assertTrue(true);
				}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug log....");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(message, "Your Account Has Been Created!");
	}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}

}
