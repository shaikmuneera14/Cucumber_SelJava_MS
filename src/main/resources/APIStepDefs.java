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


public class ApiStepDefs {
    final Logger logger = LoggerFactory.getLogger(ApiStepDefs.class);
    public class APIStepDefs {
        Given("user requests ids for given currency types {string}")
        public void userRequestsIdsForGivenCurrencyTypes(String arg0) {
        }
    }
}
