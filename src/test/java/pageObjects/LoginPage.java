package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_emailID;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_logIn;
	
	
	public void setEmailID(String email)
	{
		txt_emailID.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btn_logIn.click();
	}
}
