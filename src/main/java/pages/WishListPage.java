package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "removefromcart")
	WebElement RemoveFromWishLIstButton;
	
	@FindBy(name = "updatecart")
	WebElement updateWishList;
	
	@FindBy(css = "div.no-data")
	public WebElement NoDataMessage;
	
	public void RemoveItemFromWishList()
	{
		click(RemoveFromWishLIstButton);
		click(updateWishList);
	}
	
	

}
