package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected static  WebDriver driver;
	public static JavascriptExecutor js;
	public Select select;
	public Actions actions;
	
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	protected static void click(WebElement element)
	{
		element.click();
	}
	protected static void SendValueToText(WebElement field,String value)
	{
		field.sendKeys(value);
	}
	
	protected static void IsItemDisplayed(WebElement item)
	{
		item.isDisplayed();
	}
	public static void ScrollToButton()
	{
		
		js.executeScript("scrollBy(0,2000)");
	}
}
