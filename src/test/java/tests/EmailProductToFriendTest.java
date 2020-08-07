package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.EmailProductToFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailProductToFriendTest extends TestBase{
	
	
	HomePage homeObject;
	UserRegistrationPage userRegisterObject; 
	SoftAssert softassert;
	LoginPage loginObject;
	SearchPage searcObject;
	String productName="Apple MacBook Pro 13-inch";
	String FriendEmail="test@friend.com";
	String Email="test@me.com";
	String message="ttttttttttttttttttttttt";
	ProductDetailsPage productDetailsObject;
	EmailProductToFriendPage emailProductToFriendObject;

	

	@Test(priority = 1)
	public void UserCanRegisterSuccess()
	{
		homeObject= new HomePage(driver);
		homeObject.CLickONRegisterButton();
		userRegisterObject=new UserRegistrationPage(driver);
		userRegisterObject.UserRegisteration("mohammed", "kamal", Email, "12345678");
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));
		
	}
	@Test ( dependsOnMethods = {"UserCanRegisterSuccess"})
	public void SendProductToFriend()
	{
		searcObject= new SearchPage(driver);
		searcObject.searchforProductByAutoComplete(productName);
		productDetailsObject= new ProductDetailsPage(driver);
		productDetailsObject.ClickOnEmailToFriendButton();
		emailProductToFriendObject= new EmailProductToFriendPage(driver);
		emailProductToFriendObject.EmailProductToFriend(FriendEmail, Email, message);
		
		
	}
}
