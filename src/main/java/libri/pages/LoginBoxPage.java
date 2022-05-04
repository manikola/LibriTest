package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBoxPage extends BasePageObject{

    private By emailFieldLocator = By.xpath("//div[@id='topLoginBox']/form[@name='loginForm']//input[@name='member_email']");
    private By passwordFieldLocator = By.xpath("//div[@id='topLoginBox']/form[@name='loginForm']//input[@name='passwd']");
    private By loginButtonLocator = By.xpath("//div[@id='topLoginBox']/form[@name='loginForm']//input[@value='Belépés']");

    public LoginBoxPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void loginWithCredentials(String email, String pw){
        type(emailFieldLocator,email);
        type(passwordFieldLocator,pw);
        click(loginButtonLocator);
    }
}
