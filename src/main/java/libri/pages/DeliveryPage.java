package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DeliveryPage extends BasePageObject{

    private String pageUrl = "https://www.libri.hu/megrendeles/szallitas/";



    public DeliveryPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }
}
