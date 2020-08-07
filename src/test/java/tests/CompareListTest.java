package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareListTest extends TestBase {
	
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	CompareListPage compareObject;
	@Test 
	public void CompareTwoProducts()
	{
		searchObject = new SearchPage(driver);
		searchObject.searchforProductByAutoComplete("mac");
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.ClickOnAddToCompareListButton();
		searchObject.searchforProductByAutoComplete("asus");
		productDetailsObject.ClickOnAddToCompareListButton();
		productDetailsObject.ClickOnCompareListButton();
		compareObject = new CompareListPage(driver);
    	Assert.assertTrue(compareObject.FirstProductimg.isDisplayed());
	//	Assert.assertTrue(compareObject.SecondProductimg.isDisplayed());
		
	}

}
