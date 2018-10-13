package weinvest.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CommonMethods extends PageObject {

	protected String WeInvestURL = "https://beta.weinvest.net/model-portfolio";

	public void click(WebElementFacade element) {
		element.click();
	}

	public void scrollAndClick(WebElementFacade element) {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void getWebElementText(String element) throws Exception {
		try {
			WebElement element1 = getDriver().findElement(By.xpath(element));
			element1.getText();

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isElementPresent(By by) {
		try {
			getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
