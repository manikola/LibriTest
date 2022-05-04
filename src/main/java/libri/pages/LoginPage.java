package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HeaderPage{

    private final String pageUrl = "https://www.libri.hu/megrendeles/ekonyv/belepes/";

    private final By emailLocator = By.xpath("//form[@id='loginForm']//input[@name='member_email']");
    private final By pwLocator = By.xpath("//form[@id='loginForm']//input[@name='passwd']");
    private final By loginLocator = By.xpath("/html//form[@id='loginForm']//button[@type='submit']");



    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }


    public void openPage(){
        openUrl(pageUrl);
    }

    public PaymentPage executeLogin(String email, String password){
        type(emailLocator,email);
        type(pwLocator,password);
        click(loginLocator);

        return new PaymentPage(driver,log);
    }
}
