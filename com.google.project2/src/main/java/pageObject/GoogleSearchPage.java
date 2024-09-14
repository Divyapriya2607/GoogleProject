package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	public GoogleSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@name='q']")
	public WebElement textBox_search;
	
	@FindBy(xpath="//ul[@role='listbox']//li")
	public List<WebElement> list_autosuggestions;
	
}
