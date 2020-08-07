package tests;



import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import data.LoadDataFromExcelSheet;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTbyExecl  extends TestBase{
	HomePage homeObject;
	UserRegistrationPage userRegisterObject; 
	SoftAssert softassert;
	LoginPage loginObject;

	

	@DataProvider
	public Object[][] mydata() throws IOException
	{
		Object data[][]= LoadDataFromExcelSheet.getDataFromExcel();
		return data;
	}
	
	@Test(priority = 1,dataProvider = "mydata")
	public void UserCanRegisterSuccess(String firstname,String lastname,String email,String password)
	{
		homeObject= new HomePage(driver);
		homeObject.CLickONRegisterButton();
		userRegisterObject=new UserRegistrationPage(driver);
		userRegisterObject.UserRegisteration( firstname, lastname, email, password);
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));
		
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
		loginObject.UserLogin("test@tt.com","12345678" );
		softassert.assertTrue(userRegisterObject.logoutButton.isDisplayed());
	}

}
