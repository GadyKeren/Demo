package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifiers extends baseClass{

    protected WebDriver driver;

    public verifiers() {

        this.driver=getDriver();
    }

    public verifiers(WebDriver driver) {

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

    public boolean verifyTitleText(String expectedPageTitle, WebDriver webDriver) {

        String title = webDriver.getTitle();
        if (title.equals(expectedPageTitle)){
            return true;
        } else {
            return false;
        }
    }

}
