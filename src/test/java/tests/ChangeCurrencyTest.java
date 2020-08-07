package tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	
	SearchPage SearchObject;
	HomePage homeObject;
	ProductDetailsPage productDetailsObject;
	String productName="Apple MacBook Pro 13-inch";
	SoftAssert softassert;
	@Test
	public void ChangeCurrency() throws InterruptedException
	{
		softassert= new SoftAssert();
		productDetailsObject= new ProductDetailsPage(driver);
		SearchObject = new SearchPage(driver);
		SearchObject.searchforProductByAutoComplete(productName);
		Thread.sleep(1000);
		homeObject= new HomePage(driver);
		homeObject.SelectCurrency();
		softassert.assertTrue(productDetailsObject.productPrice.getText().contains("Ђ"));
		softassert.assertAll();
		
		
	}
	

}
