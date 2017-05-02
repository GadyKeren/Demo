package tests;

import com.applitools.eyes.selenium.Eyes;
import infra.homePage.pageObjects.homePage;
import infra.baseTestClass;
import infra.homePage.pageVerifiers.pageVerifiers;
import org.junit.*;
import org.openqa.selenium.WebDriver;


/**
 * Created by Kerens on 30/04/2017.
 */
public class HomePageTest extends baseTestClass {

    private WebDriver driver;
    private Eyes eyes;

    @Before
    public void setUp() {
        driver=getDriver();
        eyes=getEyss();
    }

    @Test //TBD
    public void movingToLoginPageWhenClickingTheLoginLink() {
        driver.navigate().to("https://www.lufthansa.com/");
        System.out.println("Home page test...");
        homePage homePage = new homePage(driver);
        homePage.clickLoginBtn();
        Assert.assertTrue(homePage.verifyBasePageTitle("Home page title doesn't match"));
//        Assert.assertTrue(homePage.verifyTitleText("Home page title doesn't match"));
    }

    @Test
    public void pageTitleTest() {
        driver.navigate().to("https://www.lufthansa.com/");
        System.out.println("Checking for the page title...");
        pageVerifiers hpVer = new pageVerifiers(driver);
        hpVer.waitForPageLoad();
        Assert.assertTrue("Home page title doesn't match", hpVer.verifyTitleText(
                "Book flights, offers, Miles & More and more - Lufthansa ® Germany", driver));
    }

}
