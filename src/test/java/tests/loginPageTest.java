package tests;

import com.applitools.eyes.selenium.Eyes;
import infra.baseClass;
import infra.homePage.pageObjects.homePage;
import infra.homePage.pageObjects.userLoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class loginPageTest extends baseClass {

    WebDriver driver;
    Eyes eyes;

    @Before
    public void setUp() {
        driver = getDriver();
        eyes = getEyes();
    }

    @Test
    public void headerEmailVerificationAfterLogin(){

        System.out.println("Navigating to site ...");
        driver.get("http://booking.uz.gov.ua/en/");

        System.out.println("Press the User Control Button ...");
        homePage hp = new homePage(driver);
        hp.pressUserControlPanelButton(driver);

        System.out.println("Setting user Name ...");
        userLoginPage loginPage = new userLoginPage(driver);
        loginPage.setEmail("greadinglist@gmail.com");

        System.out.println("Setting password ...");
        loginPage.setPassword("12345678");

        System.out.println("login in ...");
        loginPage.login();

        System.out.println("Verifying correct header user ...");
        Assert.assertTrue("Wrong Login User Name", loginPage.getuserLoginEmail().equals("greadinglist@gmail.com"));
    }

    @Test
    public void profileTabFieldEmailVerificationAfterLogin(){

        System.out.println("Navigating to site ...");
        driver.get("http://booking.uz.gov.ua/en/");

        System.out.println("Press the User Control Button ...");
        homePage hp = new homePage(driver);
        hp.pressUserControlPanelButton(driver);

        System.out.println("Setting user Name ...");
        userLoginPage loginPage = new userLoginPage(driver);
        loginPage.setEmail("greadinglist@gmail.com");

        System.out.println("Setting password ...");
        loginPage.setPassword("12345678");

        System.out.println("login in ...");
        loginPage.login();

        loginPage.pressProfileTab();

        System.out.println("Verifying correct email in Profile Tab email field ...");
        Assert.assertTrue("Wrong Login User Name", loginPage.getProfileEmail().equals("greadinglist@gmail.com"));
    }

    //Talk about test design the two tests above should not work like that - it is just an example
    //they should be initiate the same entry point status and continue from there

    @After
    public void cleanUp(){
        driver.quit();
    }

}
