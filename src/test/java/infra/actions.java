package infra;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

public class actions extends baseClass{

    protected WebDriver driver;


    public actions() {
        this.driver=getDriver();
    }

    public actions(WebDriver driver) {
        this.driver=driver;
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

    public void scrollPage (int pixels, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("scroll(0," + String.valueOf(pixels) + ")");
        //((JavascriptExecutor) driver).executeScript("scroll(0,300)");
    }
}
