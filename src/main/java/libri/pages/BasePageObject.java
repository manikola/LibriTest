package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    protected void openUrl(String url){
        driver.get(url);
    }

    public void click(By locator){
        waitForVisibilityOf(locator,5);
        find(locator).click();
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void type(By locator, String text){
        waitForVisibilityOf(locator,5);
        find(locator).sendKeys(text);
    }
    public void pressKeyWithActions(Keys key){
        log.info("Pressing " + key.name() + " using Actions class");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void waitForNewUrlContains(String text){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.urlContains(text));
    }

    public void waitForLoginExecuted(By locator,String text){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }





    protected void  waitForVisibilityOf(By locator, Integer...timeOutInSeconds){
        int attempts = 0;
        while (attempts < 2) {

            try {
                if (timeOutInSeconds.length > 0) waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds[0]);
                else waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        null);
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        if (timeOutInSeconds != null) timeOutInSeconds = timeOutInSeconds;
        else timeOutInSeconds = 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }




}
