package weinvest.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIHelper {

	public static final int HIGHLIGHTERINT = 5;

	public static void highlightElement(final WebDriver driver, final WebElement element) {

		try {

			for (int i = 0; i < HIGHLIGHTERINT; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: #800000; border: 2px solid blue;");
			}
		} catch (Exception e) {

		}
	}
}
