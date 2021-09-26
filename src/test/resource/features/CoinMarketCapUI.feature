Feature: CoinMarketCap UI Tasks

Background: user navigates to given application
    Given user navigates to CoinMarketCap URL

Scenario: 1 - Open CoinMarketCap application and verify number of rows displayed
    When user selects Show rows dropdown and selects Value
    Then selected number of rows must be displayed

Scenario Outline: 2 - Open CoinMarketCap application and verify data based on filters
        When user clicks filter button
        And Filter records with "<MarketCapfilter>" range from "<MarketCapFrom>" to "<MarketCapTo>"
        And with filter "<Pricefilter>" range from "<PriceFrom>" to "<PriceTo>"
        Then records on page must be displayed correctly as per the filters applied using "<MarketCapFrom>","<MarketCapTo>","<PriceFrom>","<PriceTo>"
        Examples:
          | MarketCapfilter | Pricefilter | MarketCapFrom | MarketCapTo | PriceFrom | PriceTo |
          | Market Cap      | Price       | 1000000000    | 10000000000 | 101       | 1000    |


