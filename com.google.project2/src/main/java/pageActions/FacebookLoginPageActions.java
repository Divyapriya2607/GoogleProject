package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObject.FacebookLoginPage;
import utility.BaseClass;

public class FacebookLoginPageActions {

	FacebookLoginPage facebookLoginPage;
	BaseClass bc;

	public FacebookLoginPageActions(WebDriver driver) {
		PageFactory.initElements(driver, this);
		facebookLoginPage = new FacebookLoginPage(driver);
		bc = new BaseClass(driver);
	}

	public void check_FacebookLogo() {
		try {
			if (bc.isDisplayed(facebookLoginPage.img_facebooklogo)) {
				System.out.println("Facebook logo is available on the page");
			} else {
				System.out.println("Facebook logo is not avaiable on the page");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
