package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends HeaderPage{

    private String pageUrl = "https://www.libri.hu/megrendeles/kosar/";

    private By goAheadButtonLocator = By.xpath("//form[@id='form-checkout-cart']//button[@type='submit']");


    public BasketPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public LoginPage clickOnGoAhead(){
        waitForVisibilityOf(goAheadButtonLocator,5);
        click(goAheadButtonLocator);
        return new LoginPage(driver,log);
    }




}
