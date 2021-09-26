package stepdefs;

import Utils.CommonUiUtils;
import coontroller.SeleniumTst;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import static eleLocators.uiConstantsPg.marketcapListBy;
import static eleLocators.uiConstantsPg.priceListBy;


public class UiStepDefinitions {
    final Logger logger = LoggerFactory.getLogger(UiStepDefinitions.class);
    WebDriver driver = SeleniumTst.getDriver("CHROME");

    String COINM_URL = "https://coinmarketcap.com/";
    HomePage homePage = new HomePage();

    CommonUiUtils commonUiUtils = new CommonUiUtils();

    @Given("user navigates to CoinMarketCap URL")
    public void userNavigatesToCoinMarketCapURL() {
        commonUiUtils.openURL(COINM_URL,driver);
    }

    @When("user selects Show rows dropdown and selects Value")
    public void userSelectsShowRowsDropdownAndSelectsValue() {
        homePage.selectRowsToDisplay("100",driver);
    }

    @Then("selected number of rows must be displayed")
    public void selectedNumberOfRowsMustBeDisplayed() {
        homePage.verifynumberOfRowsDisplayed("100",driver);
    }


    @When("user clicks filter button")
    public void userClicksFilterButton() {
        homePage.clickFilterButton(driver);
    }

    @And("Filter records with {string} range from {string} to {string}")
    public void filterRecordsWithRangeFromTo(String arg0, String arg1, String arg2) {
        homePage.selectFilter(driver,arg0);
        homePage.selectfilterInputs(driver,arg1,arg2);
        homePage.applyFilter(driver);
    }

    @And("with filter {string} range from {string} to {string}")
    public void withFilterRangeFromTo(String arg0, String arg1, String arg2) {
        homePage.selectFilter(driver,arg0);
        homePage.selectfilterInputs(driver,arg1,arg2);
        homePage.applyFilter(driver);
    }

    @Then("records on page must be displayed correctly as per the filters applied using {string},{string},{string},{string}")
    public void recordsOnPageMustBeDisplayedCorrectlyAsPerTheFiltersAppliedUsing(String arg0, String arg1, String arg2, String arg3) {
        homePage.showResults(driver);
        homePage.valiateResultsAfterFiltersApplied(driver, priceListBy,arg2,arg3);
        homePage.valiateResultsAfterFiltersApplied(driver, marketcapListBy,arg0,arg1);
        driver.quit();
    }
}
