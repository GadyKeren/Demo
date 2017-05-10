package tests;

import com.applitools.eyes.selenium.Eyes;
import infra.baseClass;
import infra.homePage.pageObjects.homePage;
import infra.homePage.pageObjects.userLoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class visualTest extends baseClass {

    WebDriver driver;
    Eyes eyes;

    @Before
    public void setUp() {
        driver = getDriver();
        eyes = getEyes();
    }

    @Test
    public void visualizationExample(){

        System.out.println("Navigating to site ...");
        driver.get("http://booking.uz.gov.ua/en/");

        homePage hp = new homePage(driver);
        hp.pressUserControlPanelButton(driver);

        System.out.println("Setting user Name ...");
        userLoginPage loginPage = new userLoginPage(driver);
        loginPage.setEmail("JamesBond@gmail.com");

        System.out.println("Setting password ...");
        loginPage.setPassword("111111");

        System.out.println("logning in ...");
        loginPage.login();

        // Visual validation point #1
        eyes.checkWindow("Login Error message");

        // End visual testing. Validate visual correctness.
        eyes.close();
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}
