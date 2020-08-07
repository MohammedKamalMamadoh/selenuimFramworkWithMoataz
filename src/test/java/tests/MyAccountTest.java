package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage userRegisterObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	SoftAssert softassert;
	String oldpassword ="123456789";
	String Newpassword=  "123456";
	String Email= "kimo31@gmail.com";
	@Test(priority = 1)
	public void UserCanRegisterSuccess() throws InterruptedException
	{
		homeObject= new HomePage(driver);
		homeObject.CLickONRegisterButton();
		Thread.sleep(2000);
		userRegisterObject=new UserRegistrationPage(driver);
		userRegisterObject.UserRegisteration("mohammed", "kamal", Email, oldpassword);
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));

		
	}
	
	@Test(priority = 2)
	public void RegisterUserCanChangePassword()
	{
		myAccountObject= new MyAccountPage(driver);
		userRegisterObject.ClickOnMyAccount();
		myAccountObject.userClickOnChangePasswordLink();
		myAccountObject.UserChangePassword(oldpassword, Newpassword);
	}
	@Test (priority = 3)
	public void userlogoutAfterChangePassword() throws InterruptedException
	{
		userRegisterObject.ClickOnLOgOut();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void UserCanLoginAfterChangePassword()
	{
		homeObject.ClickOnLoginLink();
		loginObject= new LoginPage(driver);;
		loginObject.UserLogin(Email, Newpassword);
		softassert.assertTrue(userRegisterObject.logoutButton.getText().contains("logout"));
	}

}
