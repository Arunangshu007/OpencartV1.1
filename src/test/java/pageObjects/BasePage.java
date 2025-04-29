package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;  //this.driver refers to the class-level variable, while the right-side driver is the method parameter.
		
		PageFactory.initElements(driver,this);  //Pagefactory is a helper method of Selenium which initialize WebElements by using  @FindBy annotations 
		                                       //this: Initialize the current class objects
	}

}
