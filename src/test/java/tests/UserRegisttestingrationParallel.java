package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisttestingrationParallel extends TestBase2 {
	
	HomePage homeObject;
	UserRegistrationPage userRegisterObject; 
	SoftAssert softassert;
	LoginPage loginObject;
	Faker fakedata= new Faker();
	String firstname= fakedata.name().firstName();
	String lastname= fakedata.name().lastName();
	String email= fakedata.internet().emailAddress();
	String password= fakedata.number().digits(8).toString();
	@Test(priority = 1)
	public void UserCanRegisterSuccess() throws InterruptedException
	{
		homeObject= new HomePage(getdriver());
		homeObject.CLickONRegisterButton();
		userRegisterObject=new UserRegistrationPage(getdriver());
		userRegisterObject.UserRegisteration(firstname, lastname, email, password);
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));
		Thread.sleep(1000);
		userRegisterObject.ClickOnLOgOut();
		Thread.sleep(1000);
		homeObject.ClickOnLoginLink();
		loginObject= new LoginPage(getdriver());
		loginObject.UserLogin(email, password);
		softassert.assertTrue(userRegisterObject.logoutButton.isDisplayed());
	}


}
