package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfig {

	private WebDriver driver=null;
	
	public WebDriver browserLaunch(String browserName) {
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("start-maximized");
			driver=new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fireFoxOptions=new FirefoxOptions();
			fireFoxOptions.addArguments("start-maximized");
			driver=new FirefoxDriver(fireFoxOptions);
			break;
		default:
			System.out.println("Browser value missing!");
		}
		return driver;
	}
}
