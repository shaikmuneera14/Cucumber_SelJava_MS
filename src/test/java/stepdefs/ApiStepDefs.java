package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.restApiTest;


public class ApiStepDefs {
    final Logger logger = LoggerFactory.getLogger(ApiStepDefs.class);
    restApiTest rtest = new restApiTest();


    @Given("user requests ids using get call provided")
    public void userRequestsIdsUsingGetCallProvided() {
        rtest.getRequest();
    }

    @When("ids are retrieved for given currency types {string},{string},{string}")
    public void idsAreRetrievedForGivenCurrencyTypes(String arg0, String arg1, String arg2) {
        rtest.retrieveJsonResponse(arg0,arg1,arg2);
    }


    @Then("the ids must be successfully converted to {string} type")
    public void theIdsMustBeSuccessfullyConvertedToType(String arg0) {
        rtest.convertIdsToBoli(arg0);
    }

    @Given("user issues the cryptocurrency info call for {string}")
    public void userIssuesTheCryptocurrencyInfoCallFor(String arg0) {
        rtest.getRequestForGivenId(arg0);
    }

    @Then("user must verify technical documentation website and confirms {string},{string},{string},{string},{string} are present as expected")
    public void userMustVerifyTechnicalDocumentationWebsiteAndConfirmsArePresentAsExpected(String arg0, String arg1, String arg2, String arg3, String arg4) {
        rtest.valiateJsonResponseforID(arg0,arg1,arg2,arg3,arg4);
    }

    @Given("user issues the cryptocurrency info call for first {int} currencies")
    public void userIssuesTheCryptocurrencyInfoCallForFirstCurrencies(int arg0) {
        rtest.getFirstTenCryptoCurrencies();
    }

    @Then("user must fetch and verify currencies with mineable tag and their cryptocurrencies")
    public void userMustFetchAndVerifyCurrenciesWithMineableTagAndTheirCryptocurrencies() {
        rtest.cryptocurrencyValidation();
    }
}
