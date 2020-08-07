package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class HoverToProductTest extends TestBase{
	
	HomePage homeObject;
	
	@Test
	public void HoverToComputerMenuAndSelectProduct() throws InterruptedException
	{
		homeObject= new HomePage(driver);
		Thread.sleep(2000);
		homeObject.ClickOnNootbooksButton();
		
	}

}
