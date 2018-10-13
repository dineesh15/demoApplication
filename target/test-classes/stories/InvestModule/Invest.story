Narrative:Test the Invest module of weinvest model portfolio using Test A and Test B steps given in PDF.

Scenario: Verify the sucessfull page load of weinvest model portfolio.

Given User launch the application
Then Verify whether user can see the login button in the screen

Scenario: Verify the successfull navigation of weather portfolio.
Then User clicks on Explore Investment Ideas button under All Weather Strategy section.
When Clicking Explore Investment Ideas button user should see the Customize Portfolio button in the next screen.

Scenario: Verify the successfull navigation of Explore Portfolio section and can customize the portfolio.
Then User clicks on the Customize Portfolio button.
Then Verify user can see the Customise button.
Then Verify user can see the SPDR S&P 500 ETF TRUST SPY US EQUITY text under US Equities section.
Then Verify user can not slide the slidebar of  SPDR S&P 500 ETF TRUST SPY US EQUITY
Then Click the Customise button.
Then Verify whether the Customise button text changed as Reset
Then Verify user can slide the slidebar of  SPDR S&P 500 ETF TRUST SPY US EQUITY to 50 percentage
Then Click Rebalance button.

Scenario: Verify the SPDR equity allocation percentage in Invest suggestion page.
Then User clicks on Invest Now button
Then Verify whether the user can see the SPDR value as 50 percentage
