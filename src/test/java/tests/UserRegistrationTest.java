package tests;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest  extends TestBase{
	HomePage homeObject;
	UserRegistrationPage userRegisterObject; 
	SoftAssert softassert;
	LoginPage loginObject;
	@Test(priority = 1)
	public void UserCanRegisterSuccess()
	{
		homeObject= new HomePage(driver);
		homeObject.CLickONRegisterButton();
		userRegisterObject=new UserRegistrationPage(driver);
		userRegisterObject.UserRegisteration("mohammed", "kamal", "test111@gmail.com", "12345678");
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));
		
	}
	@Test(dependsOnMethods = {"UserCanRegisterSuccess"})
	public void UserLogOut()
	{
		userRegisterObject.ClickOnLOgOut();
	}
	@Test(dependsOnMethods = {"UserLogOut"}) 
	public void RegisterUserCanLogin()  
	{
		homeObject.ClickOnLoginLink();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin("test111@gmail.com", "12345678");
		softassert.assertTrue(userRegisterObject.logoutButton.isDisplayed());
	}

}
