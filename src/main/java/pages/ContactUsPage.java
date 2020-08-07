package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement userFullName;
	
	@FindBy(id = "Email")
	WebElement userEmail;
	
	@FindBy(id = "Enquiry")
	WebElement userEnquiry;
	
	@FindBy(css = "input[value='Submit']")
	WebElement submitButton;
	
	@FindBy(css = "div.result")
	public WebElement assertonCOntactus;
	
	public void SubmitContactus (String name, String Email, String Message)
	{
		SendValueToText(userFullName, name);
		SendValueToText(userEmail, Email);
		SendValueToText(userEnquiry, Message);
		click(submitButton);
	}
	

}
