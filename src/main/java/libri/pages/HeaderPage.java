package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePageObject{

    protected By searchBoxLocator= By.xpath("//input[@id='topsearch_input']");
    protected By cashierButtonLocator = By.xpath("//div[@id='basketBox']//a[@href='/megrendeles/kosar/']");
    protected By loginLocator = By.xpath("//div[@id='headUserHelpMenu']//a[@href='javascript:void(0);']");
    protected By exitButtonLocator= By.xpath("//div[@id='headUserHelpMenu']/div/a[3]");


    public HeaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public LoginBoxPage loginFromHeader(){
        click(loginLocator);
        return new LoginBoxPage(driver,log);

    }
    public String getTextFromBox(){
        String text = find(exitButtonLocator).getText();
        return text;
    }

    public void waitForLoginExecution(){
       waitForLoginExecuted(exitButtonLocator,"Kilépés");
    }
}
