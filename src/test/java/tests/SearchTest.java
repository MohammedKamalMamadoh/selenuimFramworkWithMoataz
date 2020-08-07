package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchTest extends TestBase{
	SearchPage searchObject;
	SearchResultPage searchresultObject;
	ProductDetailsPage productObject;
	String ProductName="Apple MacBook Pro 13-inch";

	// we use the first method in searchPage
	//	@Test
	//	public void SearchForMAcItem() throws InterruptedException
	//	{
	//		searchObject= new SearchPage(driver);
	//		searchObject.SearchForMac(ProductName);
	//		searchresultObject =new SearchResultPage(driver);
	//		searchresultObject.ClickOnSearchResultItem();
	//		productObject= new ProductDetailsPage(driver);
	//		Assert.assertEquals(productObject.productitem.getText(),ProductName);
	//	}

	@Test
	public void searcForItemWithAuto()
	{
		searchObject= new SearchPage(driver);
		productObject= new ProductDetailsPage(driver);
		searchObject.searchforProductByAutoComplete(ProductName);
		Assert.assertEquals(productObject.productitem.getText(),ProductName);
		
	}
}
