package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement LoginEmail;
	
	@FindBy(id = "Password")
	WebElement loginPassword;
	
	@FindBy (css = "input[value='Log in']")
	WebElement loginButton;
	
	public void UserLogin(String email,String password) 
	{
		SendValueToText(LoginEmail,email );
		SendValueToText(loginPassword, password);
		click(loginButton);
	}

}
