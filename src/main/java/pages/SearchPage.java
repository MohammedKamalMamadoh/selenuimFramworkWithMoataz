package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchField;
	
	@FindBy(xpath = "//span[text()='Apple MacBook Pro 13-inch']")
			WebElement macElement;
	
	@FindBy(css = "input[value='Search']")
	WebElement SearchButton;
	
	@FindBy(id="ui-id-2")
	List<WebElement> searchresult;
	
	public void SearchForMac(String productName) throws InterruptedException
	{
		SendValueToText(searchField, productName);
		click(SearchButton);
		Thread.sleep(1000);
	}
	
	public void searchforProductByAutoComplete(String productName)
	{
		SendValueToText(searchField, productName);
		searchresult.get(0).click();
		
	}
	

}
