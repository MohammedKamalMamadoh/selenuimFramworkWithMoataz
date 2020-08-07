package tests;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.inject.spi.InjectionRequest;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTbyPropertiesFile  extends TestBase{
	HomePage homeObject;
	UserRegistrationPage userRegisterObject; 
	SoftAssert softassert;
	LoginPage loginObject;
	public 	String firstname = LoadProperties.userdata.getProperty("FirstName");
	public  String lastname  = LoadProperties.userdata.getProperty("LastName");
	public	String email  = LoadProperties.userdata.getProperty("Email");
	public	String password =LoadProperties.userdata.getProperty("password");



	@Test(priority = 1)
	public void UserCanRegisterSuccess() throws InterruptedException
	{
		homeObject= new HomePage(driver);
		homeObject.CLickONRegisterButton();
		userRegisterObject=new UserRegistrationPage(driver);
		userRegisterObject.UserRegisteration(firstname, lastname, email, password);
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));
		Thread.sleep(1000);
	}
	@Test(dependsOnMethods = {"UserCanRegisterSuccess"})
	public void UserLogOut() throws InterruptedException
	{
		userRegisterObject.ClickOnLOgOut();
		Thread.sleep(1000);
	}
	@Test(dependsOnMethods = {"UserLogOut"}) 
	public void RegisterUserCanLogin()  
	{
		homeObject.ClickOnLoginLink();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, password);
		softassert.assertTrue(userRegisterObject.logoutButton.isDisplayed());
	}

}
