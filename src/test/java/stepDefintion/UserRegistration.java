package stepDefintion;

import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{

	HomePage homeObject;
	UserRegistrationPage userRegisterObject; 
	SoftAssert softassert;
	LoginPage loginObject;

	@Given("^in home page   user click on register$")
	public void in_home_page_user_click_on_register() throws Throwable {
		homeObject= new HomePage(driver);
		homeObject.CLickONRegisterButton();
		Thread.sleep(1000);
	}

	/*
	 * @When("^in registeration page user enter the required data$") public void
	 * in_registeration_page_user_enter_the_required_data() throws Throwable {
	 * 
	 * userRegisterObject=new UserRegistrationPage(driver);
	 * userRegisterObject.UserRegisteration("mohammed", "kamal",
	 * "tesst111@gmail.com", "12345678"); Thread.sleep(1000); }
	 */
	@When("^in registeration page user enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void in_registeration_page_user_enter(String firstname,
			String lastname, String email, String password) throws Throwable {
		userRegisterObject=new UserRegistrationPage(driver);
		userRegisterObject.UserRegisteration(firstname, lastname,email, password);
		Thread.sleep(1000); 
	}

	@Then("^registration page displayed successfully$")
	public void registration_page_displayed_successfully() throws Throwable {
		softassert= new SoftAssert();
		softassert.assertTrue(userRegisterObject.registerComplete.getText()
				.contains("Your registration completed"));
		userRegisterObject.ClickOnLOgOut();

	}


}
