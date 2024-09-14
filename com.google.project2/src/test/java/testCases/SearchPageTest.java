package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageActions.GoogleSearchPageActions;
import utility.BaseClass;
import utility.BrowserConfig;
import utility.GlobalVariables;

public class SearchPageTest {

//	Test cases
	
	private WebDriver driver = null;
	BrowserConfig browserConfig = new BrowserConfig();
	GoogleSearchPageActions searchPageActions;
	BaseClass bc;

	@BeforeSuite
	public void beforeSuite() {
		GlobalVariables.driver = browserConfig.browserLaunch(GlobalVariables.browser);
		this.driver = GlobalVariables.driver;
		searchPageActions = new GoogleSearchPageActions(driver);
		bc = new BaseClass(driver);
	}

	@Test(priority = 1)
	public void launchURL() {
		driver.get(GlobalVariables.URL);
		bc.implicitWait(10);
	}

	@Test(priority = 2)
	public void pageLogin() throws InterruptedException {
		searchPageActions.enter_search("Selenium");
		searchPageActions.get_listOfElements();
		Thread.sleep(6000);
	}
	@AfterSuite
	public void afterSuite() {
		this.driver = GlobalVariables.driver;
		driver.close();
	}

}