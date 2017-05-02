package infra;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Kerens on 30/04/2017.
 */

//http://www.seleniumeasy.com/selenium-tutorials/simple-page-object-model-framework-example

public class baseTestClass {

    private WebDriver driver;
    private Eyes eyes;

    static String driverPath = "C:" + "\\" + "Program Files" + "\\" + "Selenium" + "\\"; //C:\Program Files\Selenium

    public WebDriver getDriver() {
        return driver;
    }

    public Eyes getEyss(){
        return eyes;
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath
                + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private Eyes setEyes(){
        eyes = new Eyes();
        // This is your api key, make sure you use it in all your tests.
        eyes.setApiKey("ZEdZCu103x105Vz4Qu45Gv3rej8tbWWkIQ6isdq8Xf2DPjA110");
        // Start visual testing with browser viewport set to 1024x768.
        // Make sure to use the returned driver from this point on.
        eyes.open(driver, "Applitools", "Test Web Page", new RectangleSize(1024, 768));
        return eyes;
    }

    //@Parameterized.Parameters({ "browserType", "appURL" })
    @Before
//    public void initializeTestBaseSetup(String browserType, String appURL){
//        try {
//            setDriver(browserType, appURL);
//
//        } catch (Exception e) {
//            System.out.println("Error....." + e.getStackTrace());
//        }
//    }
    public  void initializeTestBaseSetup(){
        try {
            setDriver("chrome", "http:" + "\\" + "blank");

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
