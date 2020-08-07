package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilitites.Helper;
import utilitites.WebDriverEventLis;

public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	public static EventFiringWebDriver EventDriver;
	public static WebDriverEventLis webDriverEvwntListnerObject;
	//@Parameters({"browser"})
	@BeforeSuite
	public void StartDriver()// if @parameter   then this method should take String browserName
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		//	in case of @parameters
		//		if (browserName.equalsIgnoreCase("chrome")) {
		//			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		//			driver= new ChromeDriver();
		//		}
		//		else if (browserName.equalsIgnoreCase("firefox")) {
		//			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		//			driver= new FirefoxDriver();
		//   	}
		EventDriver = new EventFiringWebDriver(driver);
		webDriverEvwntListnerObject = new WebDriverEventLis();
		EventDriver.register(webDriverEvwntListnerObject);
		driver=EventDriver;
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void AfterTestcase(ITestResult result ) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			Helper.CaptureScreenShots(driver,result.getName());
		}

	}


	@AfterSuite
	public void CloseDriver()
	{
		driver.quit();
	}


}
