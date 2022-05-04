package libri.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultListPage extends HeaderPage{


    private By toTheBasketButton = By.xpath("//div[@id='tab_content_authorPrList']/section/section[@class='box-general']/article[1]//a[@class='button large']");
    private By messageLocator = By.id("libriMessagePanelContent");

    public ResultListPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    //      choose first item on the result list
    public void putFirstItemToBasket(){
        click(toTheBasketButton);
    }

    //        go to cashier, click on it
    public BasketPage goToCashier(){
        click(cashierButtonLocator);
        return new BasketPage(driver,log);

    }



    public void acceptMessage(){
        click(messageLocator);
    }
}
