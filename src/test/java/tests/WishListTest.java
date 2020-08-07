package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class WishListTest extends TestBase {
	SearchPage searchObject;
	ProductDetailsPage prodectDetailObject;
	WishListPage wishListObject;
	
	@Test
	public void addToWishList()
	{
		searchObject= new SearchPage(driver);
		searchObject.searchforProductByAutoComplete("mac");
		prodectDetailObject= new ProductDetailsPage(driver);
		prodectDetailObject.ClickOnAddToWishListButton();
		Assert.assertTrue(prodectDetailObject.WishListButton.isDisplayed());
		
	}
	
	@Test(dependsOnMethods = {"addToWishList"})
	public void RemoveFromWishList()
	{
		prodectDetailObject= new ProductDetailsPage(driver);
		prodectDetailObject.ClickOnWishListButton();
		wishListObject = new WishListPage(driver);
		wishListObject.RemoveItemFromWishList();
		Assert.assertTrue(wishListObject.NoDataMessage.isDisplayed());
	}

}
