package infra.homePage.pageVerifiers;

import infra.homePage.pageObjects.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

/**
 * Created by Kerens on 30/04/2017.
 */
public class pageVerifiers {

    protected WebDriver driver;
    private By loginUserdataForm = By.id("loginUserdataForm");

    public pageVerifiers(WebDriver driver) {

        this.driver = driver;
    }

    public boolean isVisible (WebElement expextedWebElement){
        System.out.println("Looking for:" + expextedWebElement);
        if (expextedWebElement.isDisplayed())
        { return true;
        }
        else
        {
            return false;
        }
    }

    public boolean verifyTitleText(String expectedPageTitle, WebDriver webDriver) {

        String title = webDriver.getTitle();
        if (title.equals(expectedPageTitle)){
            return true;
        } else {
            return false;
        }
    }

    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 120);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
}
