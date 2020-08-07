package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[text()='Change password']")
	WebElement clickonChangePassword;
	
	@FindBy (id="OldPassword")
	WebElement oldpassword;
	
	@FindBy (id = "NewPassword")
	WebElement newpassword;
	
	@FindBy (id = "ConfirmNewPassword")
	WebElement ConfirmNewPassword;
	
	@FindBy (css = "input[value='Change password']")
	WebElement confirmChangePasswordButton;
	
	public void userClickOnChangePasswordLink()
	{
		click(clickonChangePassword);
	}
	
	public void UserChangePassword(String oldPass, String newPass)
	{
		SendValueToText(oldpassword, oldPass);
		SendValueToText(newpassword, newPass);
		SendValueToText(ConfirmNewPassword, newPass);
		click(confirmChangePasswordButton);
	}

}
