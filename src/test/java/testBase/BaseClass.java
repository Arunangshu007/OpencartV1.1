package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;   //log4j
import org.apache.logging.log4j.Logger;     //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

		public static WebDriver driver;
	     //public WebDriver driver;   //for parallel execution
	
		public Logger logger;
		public Properties p;
		
		    
			@BeforeClass (groups={"Sanity","Regression", "Master"})	
			@Parameters({"os", "browser"})
			public void setup(String os, String br) throws IOException
			
			{
			
				//loading properties file
				 FileReader file=new FileReader(".//src//test//resources//config.Properties");
				 p=new Properties();
				 p.load(file);
				
				
				logger=LogManager.getLogger(this.getClass());//Log4j
			
				
				
				if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
				{
					DesiredCapabilities capabilities=new DesiredCapabilities();
					
					//OS
					
					if(os.equalsIgnoreCase("Windows"))
					{
						capabilities.setPlatform(Platform.WIN11);
					}
					
					else if(os.equalsIgnoreCase("mac"))
					{
						capabilities.setPlatform(Platform.MAC);
					}
					
					else
					{
						System.out.println("no matching os");
						return;
					}
					
					//browser
					
					switch(br.toLowerCase())
				    {
					case "chrome": capabilities.setBrowserName("Chrome"); return;
					case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
					case "firefox": capabilities.setBrowserName("firefox"); break;
					default: System.out.println("No matching browser"); return;
					
				    }
					
					driver=new RemoteWebDriver(new URL ("http://192.168.0.103:4444/wd/hub"),capabilities);
	
				}
				
				
				
				if(p.getProperty("execution_env").equalsIgnoreCase("local"))
				{
					switch(br.toLowerCase())
					{
					case "chrome": driver=new ChromeDriver(); break;
					case "edge": driver=new EdgeDriver(); break;
					case "firefox": driver=new FirefoxDriver(); break;
					default: System.out.println("No matching browser..");
								return;
					}
					
				}
				
				
				
				
				
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				driver.get("https://tutorialsninja.com/demo/");
				
				//driver.get(p.getProperty("appURL"));
				driver.manage().window().maximize();
			}

	
	@AfterClass(groups={"Sanity","Regression", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
	    return generatedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedAlphaNum=RandomStringUtils.randomAlphanumeric(8);
	    return generatedAlphaNum;
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		
		File targetFile =new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	

}
