package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageActions.FacebookLoginPageActions;
import pageActions.GoogleSearchPageActions;
import utility.BaseClass;
import utility.BrowserConfig;
import utility.GlobalVariables;

public class FacebookLoginPageTest {

	private WebDriver driver = null;
	BrowserConfig browserConfig = new BrowserConfig();
	FacebookLoginPageActions facebookLoginPageActions;
	BaseClass bc;
	@BeforeSuite
	public void beforeSuite() {
		GlobalVariables.driver = browserConfig.browserLaunch(GlobalVariables.browser);
		this.driver = GlobalVariables.driver;
		facebookLoginPageActions = new FacebookLoginPageActions(driver);
		bc = new BaseClass(driver);
	}

	@Test(priority = 1)
	public void launchURL() {
		driver.get(GlobalVariables.URL);
		bc.implicitWait(10);
	}

	@Test(priority = 2)
	public void pageLogin() throws InterruptedException {
		facebookLoginPageActions.check_FacebookLogo();
		Thread.sleep(6000);
	}
	@AfterSuite
	public void afterSuite() {
		this.driver = GlobalVariables.driver;
		driver.close();
	}
}
