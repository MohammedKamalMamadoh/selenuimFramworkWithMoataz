package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class ProductReviewTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage userRegisterObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ProductReviewPage productReviewObject;
	String firstname="mo";
	String lastname="kamal";
	String email="test@32.com";
	String password="123456789";
	String productName= "mac";
	String Reviewtitle= "title";
	String reviewMessage="testttststst";
	@Test
	public void AddReviewToProduct()
	{
		homeObject= new HomePage(driver);
		userRegisterObject= new UserRegistrationPage(driver);
		searchObject= new SearchPage(driver);
		productDetailsObject= new ProductDetailsPage(driver);
		productReviewObject= new ProductReviewPage(driver);
		homeObject.CLickONRegisterButton();
		userRegisterObject.UserRegisteration("mo", "kamal", "test@32.com", "123456789");
		searchObject.searchforProductByAutoComplete("mac");
		productDetailsObject.clickONAddReviewButton();
		productReviewObject.SubmitReview("title", "testtttt");
		Assert.assertTrue(productReviewObject.reviewResult.getText().contains("successfully added"));
	}

}
