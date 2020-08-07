package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement genderRadioBut;

	@FindBy(id = "FirstName")
	WebElement firstnameTbox;

	@FindBy(id = "LastName")
	WebElement lastnameTbox;

	@FindBy (id = "Email")
	WebElement emailTbox;

	@FindBy(id = "Password")
	WebElement passwordTbox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTbox;

	@FindBy (id = "register-button")
	WebElement registerBut;

	@FindBy (xpath = "//div[@class='result']")
	public  WebElement registerComplete;

	@FindBy (linkText = "Log out")
	public WebElement logoutButton;

	@FindBy(linkText = "My account")
	WebElement myAccountButton;
	
	public void UserRegisteration(String firstname,String lastname, String email, String password)
	{
		click(genderRadioBut);
		SendValueToText(firstnameTbox, firstname);
		SendValueToText(lastnameTbox, lastname);
		SendValueToText(emailTbox, email);
		SendValueToText(passwordTbox, password);
		SendValueToText(confirmPasswordTbox, password);
		click(registerBut);
	}

	public void ClickOnLOgOut()
	{
		click(logoutButton);
	}
	
	public void ClickOnMyAccount()
	{
		click(myAccountButton);
	}
}
