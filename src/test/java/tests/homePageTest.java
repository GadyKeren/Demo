package tests;

import com.applitools.eyes.selenium.Eyes;
import infra.baseClass;
import infra.homePage.pageObjects.homePage;
import infra.actions;
import infra.verifiers;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class homePageTest extends baseClass {

    private WebDriver driver;
    private Eyes eyes;

    @Before
    public void setUp() {
        driver = getDriver();
        eyes = getEyes();
    }


    @Test
    public void verifyCurrctHomePagePageTitle() {
        System.out.println("Navigating to site ...");
        driver.navigate().to("http://booking.uz.gov.ua/en/");

        System.out.println("Waiting for page to load ...");
        actions actions = new actions(driver);
        actions.waitForPageLoad();
        verifiers verifiers = new verifiers(driver);

        System.out.println("Verifying title text ...");
        Assert.assertTrue("Home page title doesn't match", verifiers.verifyTitleText(
                "Покупка - Online reservation and purchase tickets - Ukrzaliznytsia", driver));
    }

    @Test
    public void verifyNoTrainsOnDirectionFlow(){

        System.out.println("Navigating to site ...");
        driver.navigate().to("http://booking.uz.gov.ua/en/ ");

        System.out.println("Waiting for page to load ...");
        homePage hp = new homePage(driver);
        actions actions = new actions(driver);
        actions.waitForPageLoad();

        System.out.println("Setting up departure location ...");
        hp.setDepartureLocation("Kievskaia", true, true, false);

        System.out.println("Setting up destination location ...");
        hp.setDestinationLocation("Kiana", true);
        hp.closeSelectDatesDialog();

        System.out.println("Pressing the search button ...");
        actions.scrollPage(300, driver);
        hp.pressSearchButton();

        System.out.println("Verifying 'No trains in this direction message ...");
        Assert.assertEquals("Incorrect Message","No trains in this direction", hp.getTrainAvailblityMessage());
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}
