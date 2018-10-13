package weinvest.stepdefinitions;
import org.jbehave.core.annotations.*;

import net.thucydides.core.annotations.Steps;
import weinvest.pageObjects.AddNewStockPageObjects;
public class AddNewStockSteps{
	
	@Steps
	AddNewStockPageObjects addNewStockObj;
	
	
	@Then("Clicks on Add Stock Button for US Equities")
	public void clickaddStockButtonForUSEquities(){
		 addNewStockObj.clickAddStockButton();
	}
	
	
	@Then("Scroll down to the pop up windows and click Add stock button of BT Group plc stock")
	public void clickAddStockButtonOfBTGroupPlcStock(){
		addNewStockObj.clickAddStockButtonOfBTGroup();
	}
	
	@Then("Click Done button")
	public void clickDoneButton(){
		addNewStockObj.clickDoneButton(); 
	}
	
	
	@Then("Verify whether new stock BT Group plc added to portfolio")
	public void newStockBTGroupPlcAddedToPortfolio(){
		addNewStockObj.verifyNewStockInPortfolio();
	}
	
	
}