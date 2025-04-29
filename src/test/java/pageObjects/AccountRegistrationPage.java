package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Your Account Has Been Created!
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_Firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txt_Lastname;
		
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement num_Tele;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_Cnfpwd;
	
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txt_Firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_Lastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		num_Tele.sendKeys(tel);

	}

	public void setPassword(String pwd) {
		txt_Pwd.sendKeys(pwd);

	}

	public void setConfirmPassword(String pwd) {
		txt_Cnfpwd.sendKeys(pwd);

	}

	public void clickPrivacyPolicy() {
		checkBox.click();

	}
	
	public void clickContinue()
	{
		btn_Continue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
}
	
	public String getConfirmationMsg()
	{
		try {
		return msgConfirmation.getText();
	}
		
		catch(Exception e)
		{
			return e.getMessage();
		}
	
	}
	
}
	
	


