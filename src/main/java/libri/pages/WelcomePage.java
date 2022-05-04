package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class WelcomePage extends HeaderPage {

    private String pageUrl = "https://www.libri.hu/";

    private By cookieWindow = By.xpath("//*[@id='onetrust-banner-sdk']/div/div");
    private By acceptCookieLocator = By.id("onetrust-accept-btn-handler");



    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage(){
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened");
    }

    public void waitForAndAcceptCookies(){
        waitForVisibilityOf(cookieWindow);
        WebElement cookie = find(acceptCookieLocator);
        cookie.click();
    }

    public ResultListPage searchForBook(String title){
        click(searchBoxLocator);
        type(searchBoxLocator,title);
        pressKeyWithActions(Keys.ENTER);
        return new ResultListPage(driver,log);

    }
}
