package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends HeaderPage{

    private String pageUrl = "https://www.libri.hu/megrendeles/ekonyv/fizetes/";

    public PaymentPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }
}
