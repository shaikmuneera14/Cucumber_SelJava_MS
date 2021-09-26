package pages;

import Utils.CommonUiUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static eleLocators.uiConstantsPg.*;

public class HomePage {
    final Logger logger = LoggerFactory.getLogger(HomePage.class);
    CommonUiUtils commonUiUtils = new CommonUiUtils();

    public void selectRowsToDisplay(String numOfRows,WebDriver driver){
        commonUiUtils.scrollInToView(showRowsEle,driver);
        WebElement showRowsDropdown = driver.findElement(showRowsDd);
        showRowsDropdown.click();
        commonUiUtils.waitInSec(2,driver);
        WebElement numOfRowsToShow = driver.findElement(By.xpath(numOfRowsEle.replace("tmpVal",numOfRows)));
        numOfRowsToShow.click();
        commonUiUtils.waitInSec(2,driver);
        logger.info("numOfRowsToShow selected successfully");
    }

    public void verifynumberOfRowsDisplayed(String numOfRows,WebDriver driver){
        commonUiUtils.scrollInToView(showRowsEleBtm,driver);
        WebElement we = driver.findElement(numOfRowsDisplayedTxt);
        String numOfRowsSelectedEle = we.getText();
        System.out.println(numOfRowsSelectedEle);
        String rows[]=numOfRowsSelectedEle.split(" ");;
        String rowsText=rows[3];
        int numOfRowsExpected = Integer.parseInt(numOfRows);
        int noOfRowsDispayed = Integer.parseInt(rowsText);
        Assert.assertEquals("Number of rows selected matches with expected number of rows Displayed",numOfRowsExpected,noOfRowsDispayed);
    }

    public void clickFilterButton(WebDriver driver) {
        WebElement clickFilter = driver.findElement(filterEle);
        commonUiUtils.scrollInToView(filterEle,driver);
        commonUiUtils.clickJS(driver,clickFilter);
        commonUiUtils.waitInSec(2, driver);
        WebElement addFilters = driver.findElement(addFileter);
        addFilters.click();
        commonUiUtils.waitInSec(2, driver);
    }

    public void selectFilter(WebDriver driver,String filterToSelect) {
        WebElement selectFilter = driver.findElement(By.xpath(filterOptionToClk.replace("tmpVal",filterToSelect)));
        selectFilter.click();
        commonUiUtils.waitInSec(3, driver);
    }

    public void selectfilterInputs(WebDriver driver,String inputMin,String inputMax){
        WebElement we3 = driver.findElement(inputMinBy);
        we3.click();
        we3.sendKeys(inputMin);
        WebElement we4 = driver.findElement(inputMaxBy);
        we4.click();
        we4.sendKeys(inputMax);
    }

    public void applyFilter(WebDriver driver){
        WebElement we = driver.findElement(applyFilter);
        commonUiUtils.scrollInToView(applyFilter,driver);
        commonUiUtils.clickJS(driver,we);
    }

    public void showResults(WebDriver driver){
        commonUiUtils.waitInSec(5,driver);
        WebElement we = driver.findElement(showResBy);
        commonUiUtils.scrollInToView(showResBy,driver);
        commonUiUtils.clickJS(driver,we);
        commonUiUtils.waitInSec(5,driver);
    }

    public void valiateResultsAfterFiltersApplied(WebDriver driver,By by,String val1, String val2){
        commonUiUtils.scrollInToView(priceHeaderBy,driver);
        commonUiUtils.waitInSec(5,driver);
        List<WebElement> weList;
        try{
            weList = driver.findElements(by);
        }catch(Exception e){
            weList = driver.findElements(by);
        }
        commonUiUtils.waitInSec(5,driver);
        Set<BigDecimal> mySet = new HashSet<>();
        for(int i =0;i<weList.size();i++){
            String temp = weList.get(i).getText().replace("$","").replace(",","");
            BigDecimal price = new BigDecimal(temp);
            mySet.add(price);
        }
        BigDecimal expectedMin = new BigDecimal(val1);
        BigDecimal expectedMax = new BigDecimal(val2);
        BigDecimal actualMin = Collections.min(mySet);
        BigDecimal actualMax = Collections.max(mySet);
        Boolean flag;
        if((expectedMin.max(actualMin).equals(actualMin)) && (expectedMax.min(actualMax).equals(actualMax))){
            flag=true;
        }else{
            flag=false;
        }
        Assert.assertTrue("The values displayed after applying filters are as expected in given range ",flag);
    }
}
