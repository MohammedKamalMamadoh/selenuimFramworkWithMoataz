package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage  extends PageBase{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement searchResultItem;
	
	public void ClickOnSearchResultItem() throws InterruptedException
	{
		click(searchResultItem);
		Thread.sleep(1000);
	}

}
