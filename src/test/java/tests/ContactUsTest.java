package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	
	HomePage homeObject;
	ContactUsPage contactObject;
	String name="test";
	String Email="test@test.com";
	String Message="tttttttttttttttttttttttttttttttttttt";
	
	@Test
	public void SubmitContactUs()
	{
		homeObject = new HomePage(driver);
		homeObject.scrollTocontactus();
		homeObject.GoToContactUsPage();
		contactObject= new ContactUsPage(driver);
		contactObject.SubmitContactus(name, Email, Message);
		Assert.assertTrue(contactObject.assertonCOntactus.getText().contains(" successfully"));
		
	}
}
