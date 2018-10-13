package weinvest.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import weinvest.utils.CommonMethods;
import weinvest.utils.UIHelper;

public class AddNewStockPageObjects extends CommonMethods {

	@FindBy(xpath = "(.//a[@class='modal-trigger' and contains(text(),'Add')])[1]")
	@CacheLookup
	private WebElementFacade AddStockButtonUSEquities;

	@FindBy(xpath = ".//*[@id='modal-1']//div/button[@data-isin='BT' and contains(text(),'Add')]")
	@CacheLookup
	private WebElementFacade AddStockButtonBTGroup;

	@FindBy(xpath = ".//*[@id='modal-1']//div/button[text()='Done']")
	@CacheLookup
	private WebElementFacade DoneButton;

	@FindBy(xpath = "(.//*[@id='customise-portfolio']//div/a[contains(text(),'BT Group')])[2]")
	@CacheLookup
	private WebElementFacade BTStock;

	public void clickAddStockButton() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(AddStockButtonUSEquities);
		actions.perform();

		if (AddStockButtonUSEquities.isPresent()) {
			try {
				Thread.sleep(10);
				UIHelper.highlightElement(getDriver(), AddStockButtonUSEquities);
				AddStockButtonUSEquities.click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void clickAddStockButtonOfBTGroup() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(AddStockButtonBTGroup);
		actions.perform();

		if (AddStockButtonBTGroup.isPresent()) {
			try {
				Thread.sleep(10);
				UIHelper.highlightElement(getDriver(), AddStockButtonBTGroup);
				AddStockButtonBTGroup.click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void clickDoneButton() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(DoneButton);
		actions.perform();

		if (DoneButton.isPresent()) {
			try {
				Thread.sleep(10);
				UIHelper.highlightElement(getDriver(), DoneButton);
				DoneButton.click();
				BTStock.waitUntilVisible();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void verifyNewStockInPortfolio() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(BTStock);
		actions.perform();

		if (BTStock.isPresent()) {
			try {
				Thread.sleep(10);
				UIHelper.highlightElement(getDriver(), BTStock);
				String Actualtext = BTStock.getText();
				String expectedText = "BT Group plc";
				Assert.assertEquals(expectedText, Actualtext);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
