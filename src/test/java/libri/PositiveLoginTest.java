package libri;

import libri.base.TestUtilities;
import libri.pages.DeliveryPage;
import libri.pages.LoginBoxPage;
import libri.pages.LoginPage;
import libri.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestUtilities {


    //    positive login on welcome page
    //    go to welcome page
   @Test
    void positiveLoginTest() {
       WelcomePage welcomePage = new WelcomePage(driver,log);
       welcomePage.openPage();

    //accept notification
       welcomePage.waitForAndAcceptCookies();

       sleep(5);
    //    go to login-button and click
       LoginBoxPage loginBoxPage = welcomePage.loginFromHeader();

       loginBoxPage.loginWithCredentials("testelek@sharklasers.com","testelek0000$$$$");

       welcomePage.waitForLoginExecution();

       sleep(5);



    //verifications
    //    logout button visible
       String actualText = welcomePage.getTextFromBox();

       Assert.assertEquals(actualText,"Kilépés", "\nActual: " + actualText + "\nExpected: Kilépés");




    }
}