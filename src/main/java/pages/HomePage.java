package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);	
		 js= ((JavascriptExecutor) driver);
		 actions= new Actions(driver);
	}
	
	
	@FindBy(linkText = "Register")
	WebElement registerlink;
	
	@FindBy (linkText = "Log in")
	WebElement loginLink;
	
	@FindBy (linkText = "Contact us")
	WebElement contactUsButton;
	
	@FindBy (id = "customerCurrency")
	public WebElement customerCurrencyDropList;
	
	@FindBy (xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement ComputerMenu;
	
	@FindBy (linkText = "Notebooks")
	WebElement nootbooksButton;
	
	
	
	
	public void CLickONRegisterButton()
	{
		click(registerlink);
		
	}

	public void ClickOnLoginLink()
	{
		click(loginLink);
	}
	
	public void scrollTocontactus()
	{
		ScrollToButton();
	}
	
	public void GoToContactUsPage()
	{
		click(contactUsButton);
	}
	public  void SelectCurrency()
	{
		select= new Select(customerCurrencyDropList);
		select.selectByVisibleText("Euro");
	}
	
	public void ClickOnNootbooksButton()
	{
		actions.moveToElement(ComputerMenu).build().perform();
	    actions.click(nootbooksButton).build().perform();
	}
}
