package infra.homePage.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Kerens on 30/04/2017.
 */
public class homePage {
    protected WebDriver driver;

    private By loginLink = By.linkText("Login");
    private By loginUserdataForm = By.id("loginUserdataForm");

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public homePage clickLoginBtn() {
        System.out.println("clicking on the Login button");
        WebElement loginBtnElement=driver.findElement(loginLink);
        if(loginBtnElement.isDisplayed()||loginBtnElement.isEnabled())
            loginBtnElement.click(); //Need a more elegant way of presenting it...
        else System.out.println("Element not found");
        return new homePage(driver);
    }


//    public signInPage clickSignInBtn() {
//        System.out.println("clicking on sign in button");
//        WebElement signInBtnElement=driver.findElement(loginLink);
//        if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
//            signInBtnElement.click();
//        else System.out.println("Element not found");
//        return new signInPage(driver);
//    }

    public void clickImagesLink() {
        //It should have a logic to click on images link
        //And it should navigate to google images page
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyBasePageTitle(String expectedPageTitle ) {
        return getPageTitle().contains(expectedPageTitle);
    }
}
