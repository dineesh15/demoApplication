package weinvest.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import weinvest.utils.CommonMethods;
import weinvest.utils.UIHelper;

public class InvestModulePageObjects extends CommonMethods {

	@FindBy(xpath = ".//*[contains(@class,'btn btn-default btn-login')]")
	@CacheLookup
	private WebElementFacade loginButton;

	@FindBy(xpath = ".//div[text()='All Weather Strategy']/following::div/a[@href='weather_portfolio' and text()='Explore Investment Ideas']")
	@CacheLookup
	private WebElementFacade ExploreInvestmentButton;

	@FindBy(xpath = ".//div[@class='model-portfolio-header']//a[text()='Customize Portfolio']")
	@CacheLookup
	private WebElementFacade CustomisePortfolioButton;

	@FindBy(xpath = ".//*[@id='customise-portfolio']//a[text()='Customise']")
	@CacheLookup
	private WebElementFacade CustomiseButton;

	@FindBy(xpath = "//div[@class='col-md-2']/a[@class='model-portfolio-btn btn btn-dange btn-black btn-md invest pull-right']")
	@CacheLookup
	private WebElementFacade ResetButton;

	@FindBy(css = ".model-portfolio-btn.btn.btn-dange.btn-black.btn-md.invest.pull-right")
	@CacheLookup
	private WebElementFacade ResetButtonCSS;

	@FindBy(xpath = "(.//*[@id='customise-portfolio']//div/a[contains(text(),'SPDR S&P')])[2]")
	@CacheLookup
	private WebElementFacade SpdrEquity;

	@FindBy(xpath = ".//*[@id='customise-portfolio']//div/input[@data-isin='SPY']")
	@CacheLookup
	private WebElementFacade slideBarSPDR;

	@FindBy(xpath = ".//*[@id='customise-portfolio']//a[text()='Rebalance']")
	@CacheLookup
	private WebElementFacade RebalanceButton;

	@FindBy(xpath = ".//*[@id='customise-portfolio']//a[text()='Invest Now']")
	@CacheLookup
	private WebElementFacade InvestNowButton;

	@FindBy(xpath = "//*[@id=\"suggestion-page-body\"]//span[contains(text(),'What does your portfolio')]")
	@CacheLookup
	private WebElementFacade WhatPortfolioContain;

	@FindBy(xpath = "//*[@id=\"suggestion-page-body\"]//span[contains(text(),'SPDR')]/following::div[1]/span[1]")
	@CacheLookup
	private WebElementFacade SPDRPercentage;

	public void getURLAndLaunchAppURL(String url) {

		getDriver().manage().deleteAllCookies();

		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);

		getDriver().manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);

		getDriver().get(WeInvestURL);

	}

	public boolean verifyLoginButtonPresent() throws InterruptedException {

		Thread.sleep(100);
		UIHelper.highlightElement(getDriver(), loginButton);

		if (loginButton.isPresent()) {

			String ActualText = loginButton.getText();
			String ExpectedText = "LOG IN";
			Assert.assertEquals(ExpectedText, ActualText);
			Thread.sleep(10);
			return true;
		} else {
			return false;
		}

	}

	public boolean verifySlideBarPresentForSpdr() throws InterruptedException {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();", slideBarSPDR);
		 */
		Actions actions = new Actions(getDriver());
		actions.moveToElement(slideBarSPDR);
		actions.perform();

		if (slideBarSPDR.isEnabled()) {
			Thread.sleep(10);
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyCustomiseButtonPresent() throws InterruptedException {

		if (CustomiseButton.isPresent()) {
			Thread.sleep(10);
			UIHelper.highlightElement(getDriver(), CustomiseButton);
			String Actualtext = CustomiseButton.getText();
			String expectedText = "Customise";
			Assert.assertEquals(expectedText, Actualtext);
			return true;
		} else {
			return false;
		}

	}

	public boolean scrollAndGetTextOfCustomiseButton() throws InterruptedException {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();", CustomiseButton);
		 */
		Actions actions = new Actions(getDriver());
		actions.moveToElement(CustomiseButton);
		actions.perform();
		if (CustomiseButton.isPresent()) {
			Thread.sleep(10);
			return true;
		} else {
			return false;
		}
	}

	public boolean scrollAndGetTextOfSPDRLink() throws InterruptedException {

		Actions actions = new Actions(getDriver());
		actions.moveToElement(SpdrEquity);
		actions.perform();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();", SpdrEquity);
		 */
		if (SpdrEquity.isPresent()) {
			Thread.sleep(10);
			return true;
		} else {
			return false;
		}

	}

	public void clickCustomisePortfolioButton() {
		if (CustomisePortfolioButton.isPresent()) {
			CustomisePortfolioButton.click();
		}
	}

	public void clickCustomizeButton() throws InterruptedException {

		/*
		 * Actions actions = new Actions(getDriver());
		 * actions.moveToElement(CustomiseButton); actions.perform();
		 */
		CustomiseButton.click();
		ResetButton.waitUntilVisible();

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();", CustomiseButton);
		 * if(CustomiseButton.isPresent()) { CustomiseButton.click(); }
		 */
	}

	public void clickExploreInvestmentIdeasButton() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", ExploreInvestmentButton);
		UIHelper.highlightElement(getDriver(), ExploreInvestmentButton);
		if (ExploreInvestmentButton.isPresent()) {
			ExploreInvestmentButton.click();
		}
	}

	public boolean verifyCustomizePortfolioButtonPresent() throws InterruptedException {
		if (CustomisePortfolioButton.isPresent()) {
			UIHelper.highlightElement(getDriver(), CustomisePortfolioButton);
			Thread.sleep(10);
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyResetButton() throws InterruptedException {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();", ResetButton); Actions
		 * actions = new Actions(getDriver()); actions.moveToElement(ResetButton);
		 * actions.perform();
		 */

		if (ResetButton.isPresent()) {
			UIHelper.highlightElement(getDriver(), ResetButton);
			String Actualtext = ResetButton.getText();
			String expectedText = "Reset";
			Assert.assertEquals(expectedText, Actualtext);
			return true;
		} else {
			return false;
		}

	}

	public void Slide50PercentForSpdr() throws InterruptedException {
		slideBarSPDR.waitUntilEnabled();
		Actions action = new Actions(getDriver());
		UIHelper.highlightElement(getDriver(), slideBarSPDR);
		action.clickAndHold(slideBarSPDR);
		action.dragAndDropBy(slideBarSPDR, 80, 11).release().build().perform();
		slideBarSPDR.click();

	}

	public void clickRebalanceButton() throws InterruptedException {

		if (RebalanceButton.isPresent()) {
			Thread.sleep(10);
			UIHelper.highlightElement(getDriver(), RebalanceButton);
			RebalanceButton.click();
		}
	}

	public void clickInvestNowButton() throws InterruptedException {
		if (InvestNowButton.isPresent()) {
			Thread.sleep(10);
			UIHelper.highlightElement(getDriver(), InvestNowButton);
			InvestNowButton.click();
		}
	}

	public void sPDRAs50Percent() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(SPDRPercentage);
		actions.perform();
		UIHelper.highlightElement(getDriver(), SPDRPercentage);
		String Actualtext = SPDRPercentage.getText();
		String expectedText = "50";
		Assert.assertEquals(expectedText, Actualtext);
	}
}
