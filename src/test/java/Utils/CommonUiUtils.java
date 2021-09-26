package Utils;

import coontroller.SeleniumTst;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class CommonUiUtils extends SeleniumTst{
    final Logger logger = LoggerFactory.getLogger(CommonUiUtils.class);
    public void openURL(String url,WebDriver driver){
        driver.get(url);
        driver.manage().window().maximize();
        waitInSec(2,driver);
    }

    public void waitInSec(long num,WebDriver driver){
        driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
    }

    public void scrollInToView(By by,WebDriver driver){
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitInSec(2,driver);
    }

    public void clickJS(WebDriver driver,WebElement we){
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",we);
    }
}
