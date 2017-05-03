package tests;

import com.applitools.eyes.selenium.Eyes;
import infra.baseClass;
import infra.homePage.pageObjects.homePage;
import infra.verifiers;
import org.junit.*;
import org.openqa.selenium.WebDriver;


/**
 * Created by Kerens on 30/04/2017.
 */
public class HomePageTest extends baseClass {

    private WebDriver driver;
    private Eyes eyes;

    @Before
    public void setUp() {
        driver = getDriver();
        eyes = getEyes();
    }


    @Test
    public void pageTitleTest() {
        driver.navigate().to("http://booking.uz.gov.ua/en/");
        System.out.println("Checking for the page title...");
        verifiers verifiers = new verifiers(driver);
        verifiers.waitForPageLoad();
        Assert.assertTrue("Home page title doesn't match", verifiers.verifyTitleText(
                "Покупка - Online reservation and purchase tickets - Ukrzaliznytsia", driver));
    }

    @Test
    public void verifyTrainSelection(){
        driver.navigate().to("http://booking.uz.gov.ua/en/ ");
        homePage hp = new homePage(driver);
        verifiers verifiers = new verifiers(driver);
        verifiers.waitForPageLoad();
        hp.setDepartureLocation("Kievska", true, true, false);
        hp.setDestinationLocation("Debaltseve", true);
        hp.pressSearchButton();
        //Assert.assertTrue("Incorrect trains availability message",  hp.getTrainAvailblityMessage());
        Assert.assertEquals(hp.getTrainAvailblityMessage(), "Incorrect trains availability message");
    }



}
