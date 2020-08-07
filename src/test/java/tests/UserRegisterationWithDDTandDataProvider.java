package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTandDataProvider  extends TestBase{

	
	HomePage homeObject;
	UserRegistrationPage userRegisterObject; 
	SoftAssert softassert;
	LoginPage loginObject;
	
	
	@DataProvider
	public Object[][] MyData()
	{
		Object[][] data= new Object[2][4];
		data [0][0]="mohammed";
		data [0][1]="kamal";
		data [0][2]="data1@test.com";
		data [0][3]="12345678";
		data [1][0]="mo";
		data [1][1]="salah";
		data [1][2]="data1@driven.com";
		data [1][3]="123456";
		return data;
	}
	
	
	@Test(priority = 1,dataProvider = "MyData")
	public void UserCanRegisterSuccess(String fname, String Lname,String email,String password)
	{
		homeObject= new HomePage(driver);
		homeObject.CLickONRegisterButton();
		userRegisterObject=new UserRegistrationPage(driver);
		userRegisterObject.UserRegisteration(fname, Lname, email, password);
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));
		userRegisterObject.ClickOnLOgOut();
		
	}
	@Test(dependsOnMethods = {"UserCanRegisterSuccess"},enabled = false)
	public void UserLogOut()
	{
		userRegisterObject.ClickOnLOgOut();
	}
	
	@Test(dependsOnMethods = {"UserLogOut"},enabled = false) 
	public void RegisterUserCanLogin()  
	{
		homeObject.ClickOnLoginLink();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin("test111@gmail.com", "12345678");
		softassert.assertTrue(userRegisterObject.logoutButton.isDisplayed());
	}
}
