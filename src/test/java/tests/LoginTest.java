package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {
	
	HomePage homeObject;
	LoginPage loginObject;
	@Test
	public void UserCanLogin() 
	{
	homeObject= new HomePage(driver);
	homeObject.ClickOnLoginLink();
	loginObject= new LoginPage(driver);
	loginObject.UserLogin("test@gmail.com", "12345678");	
	}

}
