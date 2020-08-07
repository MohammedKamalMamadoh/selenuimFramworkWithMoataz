package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productitem;
	
	@FindBy(css = "input[value='Email a friend']")
	WebElement EmailToFriendButton;
	
	@FindBy(id = "price-value-4")
	public WebElement productPrice;
	
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewButton;
	
	@FindBy (id = "add-to-wishlist-button-4")
	WebElement AddToWishListButton;
	
	@FindBy(linkText = "wishlist")
    public WebElement WishListButton;
	
	@FindBy (css = "input[value='Add to compare list']")
	WebElement AddToCompareLIstButton;
	
	@FindBy(linkText = "product comparison")
	public WebElement CompareListButton;
	
	
	public void ClickOnEmailToFriendButton()
	{
		click(EmailToFriendButton);
	}
	
	public void clickONAddReviewButton()
	{
		click(addReviewButton);
	}
	

	public void ClickOnAddToWishListButton()
	{
		click(AddToWishListButton);
	}
	
	public void ClickOnWishListButton()
	{
		click(WishListButton);
	}
	public void ClickOnAddToCompareListButton()
	{
		click(AddToCompareLIstButton);
	}
	public void ClickOnCompareListButton()
	{
		click(CompareListButton);
		
	}
	

}
