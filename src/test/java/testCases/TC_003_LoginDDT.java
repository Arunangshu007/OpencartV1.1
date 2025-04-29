package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="Datadriven")
	public void Verify_LoginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
	
		try {
	//Home page
	HomePage hp=new HomePage(driver);
	hp.clickMyaccount();
	hp.clickLogin();
	
	//Login
	LoginPage lp=new LoginPage(driver);
	lp.setEmailID(email);
	lp.setPassword(password);
	lp.clickLogin();
	
	//My Account Page
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyaccountPageexists();
	
	//Logout Page
	LogoutPage lout=new LogoutPage(driver);
	
	/*Data is valid  - login success - test pass  - logout
	Data is valid -- login failed - test fail
	*/
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage==true)
		{
			lout.clickLogout(); 
			Assert.assertTrue(true);
			
		}
		
		else
		{
			Assert.assertTrue(false);
		}
	}
	

      /*Data is invalid - login success - test fail  - logout
      Data is invalid -- login failed - test pass
       */
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			lout.clickLogout(); 
			Assert.assertTrue(false);
		}
		
		else
		{
			//Assert.assertFalse(false);
			Assert.assertTrue(true);
			
		}
	}
	   
	     logger.info("**** Finished TC_003_LoginDDT *****");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
