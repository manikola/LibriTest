package libri;

import libri.base.TestUtilities;
import libri.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchItemTest extends TestUtilities {


    @Test
    void searchingForABook() {
        log.info("Starting searchingForABookTest");
//        create driver
        //    open page https://www.libri.hu/

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        welcomePage.waitForAndAcceptCookies();

        sleep(5);


//    find searchbox, and enter "száz év magány" in search-box
        ResultListPage resultListPage = welcomePage.searchForBook("száz év magány");

        sleep(5);


//        verify new page
        String expectedResultsUrl = "https://www.libri.hu/talalati_lista/";
        resultListPage.waitForNewUrlContains("talalati");
        String actualResultsUrl = resultListPage.getCurrentUrl();

        Assert.assertTrue(actualResultsUrl.contains(expectedResultsUrl), "\nExpected: " + expectedResultsUrl + "\nActual: " + actualResultsUrl);


        //      choose first item on the result list
        resultListPage.putFirstItemToBasket();
        resultListPage.acceptMessage();

        sleep(10);


//        go to cashier, click on it
        BasketPage basketPage = resultListPage.goToCashier();
        takeScreenshot("basket page opened");

        sleep(10);


        String expectedBasket = basketPage.getPageUrl();
        String actualBasket = basketPage.getCurrentUrl();

        Assert.assertTrue(actualBasket.contains(expectedBasket), "\nExpected: " + expectedBasket + "\nActual: " + actualBasket);

        LoginPage loginPage = basketPage.clickOnGoAhead();
        takeScreenshot("login page opened");

        sleep(10);


//    execute login and click
        PaymentPage paymentPage = loginPage.executeLogin("testelek@sharklasers.com", "testelek0000$$$$");
        takeScreenshot("delivery page opened");





    }


}


