package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	WebElement Acclogout;
	
	public void clickLogout() 
	{
		lnkLogout.click();
    }
	
	public boolean isLogoutisDisplayed()
	{
		try 
		{
		return Acclogout.isDisplayed();
		}
		
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	

}
