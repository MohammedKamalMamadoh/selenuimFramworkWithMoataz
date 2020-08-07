package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends PageBase{

	public CompareListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "img[alt='Picture of Apple MacBook Pro 13-inch']")
	public WebElement FirstProductimg;
	
	@FindBy(xpath = "img[alt='Picture of Asus N551JK-XO076H Laptop']")
	public WebElement SecondProductimg;

}
