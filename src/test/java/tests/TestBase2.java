package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilitites.Helper;

public class TestBase2 {

	public static String BaseURl="https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> driver = null;
	@Parameters(value = {"browser"})
	@BeforeClass
	public void OpenBrowser(String browser) throws MalformedURLException
	{
		driver =new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver((new URL("http://localhost:4444/wd/hub")), caps));
		getdriver().navigate().to(BaseURl);
	}
	
	public WebDriver getdriver()
	{
		return driver.get();
	}
	@AfterClass
	public void CloseDriver()
	{
		getdriver().quit();
		driver.remove();
	}
	@AfterMethod
	public void AfterTestcase(ITestResult result ) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			Helper.CaptureScreenShots(getdriver(),result.getName());
		}

	}
	
}
