package weinvest.stepdefinitions;

import org.jbehave.core.annotations.*;
import net.thucydides.core.annotations.Steps;
import weinvest.pageObjects.InvestModulePageObjects;

public class InvestSteps {
	@Steps
	InvestModulePageObjects investPageobj;

	@Then("User clicks on the Customize Portfolio button.")
	public void givenUserClicksOnTheCustomizePortfolioButton() {
		investPageobj.clickCustomisePortfolioButton();
	}

	@Then("Click the Customise button.")
	public void thenClickTheCustomiseButton() throws InterruptedException {
		investPageobj.clickCustomizeButton();
	}

	@Given("User launch the application")
	public void givenUserLaunchTheApplication() {
		String url = System.getProperty("WeInvestURL");
		investPageobj.getURLAndLaunchAppURL(url);
	}

	@Then("Verify whether the Customise button text changed as Reset")

	public void CustomiseButtonTextChangedAsReset() {

		try {
			investPageobj.verifyResetButton();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Verify whether user can see the login button in the screen")
	public void VerifyLoginButtonInTheScreen() {
		try {
			investPageobj.verifyLoginButtonPresent();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("Verify user can slide the slidebar of  SPDR S&P 500 ETF TRUST SPY US EQUITY to 50 percentage")
	public void SlidebarOfSPDRTo50Percentage() throws InterruptedException {
		investPageobj.Slide50PercentForSpdr();
	}


	@Then("Verify whether the user can see the SPDR value as 50 percentage")
	public void thenSPDRValueAs50Percentage() {
		investPageobj.sPDRAs50Percent();
	}

	@Then("User clicks on Invest Now button")
	public void clicksOnInvestNowButton() throws InterruptedException {
		investPageobj.clickInvestNowButton();
	}

	@Then("User clicks on Explore Investment Ideas button under All Weather Strategy section.")
	public void ClickExploreInvestmentIdeasButton() {

		investPageobj.clickExploreInvestmentIdeasButton();
	}

	@Then("Verify user can not slide the slidebar of  SPDR S&P 500 ETF TRUST SPY US EQUITY")
	public void CanNotSlideTheSlidebarOfSPDRSP500() throws InterruptedException {
		investPageobj.verifySlideBarPresentForSpdr();
	}

	@When("Clicking Explore Investment Ideas button user should see the Customize Portfolio button in the next screen.")
	public void SeeTheCustomizePortfolioButtonInTheNextScreen() {
		try {
			Thread.sleep(1000);
			investPageobj.verifyCustomizePortfolioButtonPresent();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Verify user can see the SPDR S&P 500 ETF TRUST SPY US EQUITY text under US Equities section.")
	public void UserCanSeeSPDRSP500() {
		try {
			investPageobj.scrollAndGetTextOfSPDRLink();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Verify user can see the Customise button.")
	public void UserCanSeeTheCustomiseButton() {
		try {
			investPageobj.scrollAndGetTextOfCustomiseButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Click Rebalance button.")
	public void thenClickRebalanceButton() {
		try {
			Thread.sleep(1000);
			investPageobj.clickRebalanceButton();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}