package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement ReviewTitleTbox;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement ReviewMessage;
	
	@FindBy (id = "addproductrating_5")
	WebElement RateButton;
	
	@FindBy(css = "input[value='Submit review']")
	WebElement SubmitReviewButton;
	
	@FindBy(css = "div.result")
	public WebElement reviewResult;

	
	
	public void SubmitReview(String Reviewtitle,String reviewMessage)
	{
		SendValueToText(ReviewTitleTbox, Reviewtitle);
		SendValueToText(ReviewMessage, reviewMessage);
		click(RateButton);
		click(SubmitReviewButton);
		
	}


}
