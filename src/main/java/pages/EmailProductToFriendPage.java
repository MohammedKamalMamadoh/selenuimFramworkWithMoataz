package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailProductToFriendPage extends PageBase {

	public EmailProductToFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "FriendEmail")
	WebElement MyFriendEmail;
	
	@FindBy (id = "YourEmailAddress")
	WebElement MyEmail;
	
	@FindBy (id = "PersonalMessage")
	WebElement EmailMessage;
	
	@FindBy(css = "input[value='Send email']")
	WebElement SendEmailToFriendButton;
	
	
	public void EmailProductToFriend(String FriendEmail,String Email,String message)
	{
		SendValueToText(MyFriendEmail, FriendEmail);
		SendValueToText(MyEmail, Email);
		SendValueToText(EmailMessage, message);
		click(SendEmailToFriendButton);
	}
	
	

}
