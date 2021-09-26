package eleLocators;

import org.openqa.selenium.By;

public class uiConstantsPg {

    public static By showRowsEle = By.xpath("//p[@class='sc-1eb5slv-0 UxWjr' and contains(text(),'Show rows')]");
    public static By showRowsDd = By.xpath("//p[@class='sc-1eb5slv-0 UxWjr' and contains(text(),'Show rows')]/..//div");
    public static String numOfRowsEle = "//div[@class='sc-16r8icm-0 sc-1f0grbq-0 cEoyCq']/button[contains(text(),'"+"tmpVal"+"')]";
    public static By  showRowsEleBtm = By.xpath("//p[@class='sc-1eb5slv-0 htiVYl' and contains(text(),'Show rows')]");
    public static By numOfRowsDisplayedTxt = By.xpath("//div[@class='sc-16r8icm-0 sc-4r7b5t-0 gJbsQH']/descendant::p[@class='sc-1eb5slv-0 hykWbK']");
    public static By filterEle = By.xpath("//div[@class='sc-1hxnufv-5 fmuRvw']/button[contains(@class,'x0o17e-0') and contains(text(),'Filters')]");
//    By.xpath("//div[@class='sc-1hxnufv-5 fmuRvw']/button[contains(@class,'x0o17e-0') and contains(text(),'Filters')]")
    public static By addFileter = By.xpath("//ul/li/button[contains(@class,'x0o17e-0 ewuQaX sc-1hxnufv-0 sc-1k1om8k-0 dNBOZt')]");
    public static String filterOptionToClk = "//div[@class='kvv4j3-0 kChfNS']/button[contains(text(),'" + "tmpVal" + "')]";
    public static By inputMinBy = By.xpath("//input[@data-qa-id='range-filter-input-min']");
    public static By inputMaxBy = By.xpath("//input[@data-qa-id='range-filter-input-max']");
    public static By applyFilter = By.xpath("//button[@data-qa-id='filter-dd-button-apply']");
    public static By showResBy = By.xpath("//button[@class='x0o17e-0 lgnbfA cmc-filter-button' and contains(text(),'Show results')]");
    public static By priceHeaderBy = By.xpath("//table/thead//p[@class='sc-1eb5slv-0 iKUzJY' and contains(text(),'Price')]");
    public static By priceListBy = By.cssSelector("tbody > tr > td:nth-child(4)");
    public static By marketcapListBy = By.cssSelector("tbody > tr > td:nth-child(7)");

}
