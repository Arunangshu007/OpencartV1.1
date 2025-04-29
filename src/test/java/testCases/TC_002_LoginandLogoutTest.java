package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginandLogoutTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"}, priority=2)
	public void VerifyLoginTest()
	{
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		
		try {
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on myaccount link on the home page..");
		
		hp.clickLogin();   //Login link under MyAccount tab
		logger.info("clicked on login link under myaccount..");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		
		logger.info("Entering valid email and password..");
		lp.setEmailID(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button..");
		
		
		//MyAccount Page
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetPage=myacc.isMyaccountPageexists();
		
		Assert.assertEquals(targetPage, true, "Login failed");
		//Assert.assertTrue(targetPage);
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
		
	}
	
	@Test(priority=2, dependsOnMethods={"VerifyLoginTest"})
	public void Verify_LogoutTest()
	{
		try 
		{
		LogoutPage logout=new LogoutPage(driver);
		logout.clickLogout();
		
		boolean targetlogoutpage=logout.isLogoutisDisplayed();
		
		Assert.assertEquals(targetlogoutpage, true, "Logout is failed");
		
		logger.info("**** Logout is Successfull ****");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}


}
