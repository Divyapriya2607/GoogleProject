package pageActions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.Assert;

import pageObject.GoogleSearchPage;
import utility.BaseClass;

public class GoogleSearchPageActions {

	GoogleSearchPage googleSearchPage;
	BaseClass bc;

	public GoogleSearchPageActions(WebDriver driver) {
		PageFactory.initElements(driver, this);
		googleSearchPage = new GoogleSearchPage(driver);
		bc = new BaseClass(driver);
	}

	public void enter_search(String input) {
		bc.textBox(googleSearchPage.textBox_search, input);
	}

	public void get_listOfElements() {
		int count = 1;
		int countOfSuggestions = googleSearchPage.list_autosuggestions.size();
		System.out.println("Count of suggestions : " + countOfSuggestions);
		List<WebElement> suggestions = googleSearchPage.list_autosuggestions;
		if (suggestions != null && !suggestions.isEmpty()) {
			WebElement lastSuggestion = suggestions.get(googleSearchPage.list_autosuggestions.size() - 1);
			for (WebElement element : suggestions) {
				System.out.println(count + "." + bc.getText(element));
				if (lastSuggestion.equals(element)) {
					bc.click(element);
					break;
				}
				count++;
			}
		}

	}

	public void searchFunctionality() {
		List<WebElement> suggestions = googleSearchPage.list_autosuggestions;
		List<String> actualResults = new ArrayList<String>();
		for (WebElement result : suggestions) {
			actualResults.add(result.getText());
		}
		List<String> expectedResults = List.of("Selenium", "Selenium download", "Selenium Java");
		Assert.check(actualResults.isEmpty(), "No Results Found");
		for (String expected : expectedResults) {
			Assert.check(actualResults.contains(expected),
					"Expected result" + expected + "not found in actual results");
		}
	}

}
