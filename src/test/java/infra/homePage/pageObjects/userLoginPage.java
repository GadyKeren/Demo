package infra.homePage.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userLoginPage {

    protected WebDriver driver;

    private By emailField = By.cssSelector("input[name=\"login\"]");
    private By passwordField = By.cssSelector("input[name=\"passwd\"]");
    private By enterButton = By.cssSelector("button.button");
    private By userLoginEmail = By.cssSelector("#helloUser > span > a");
    private By loggedInHeaderMessage = By.cssSelector("#helloUser > span");

    public userLoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void setEmail(String emailAddrs){
        WebElement email = driver.findElement(emailField);
        if (email.isDisplayed()) {
            email.click();
            email.sendKeys(emailAddrs);
        }
    }

    public void setPassword(String password){
        WebElement psd = driver.findElement(passwordField);
        if (psd.isDisplayed()){
            psd.click();
            psd.sendKeys(password);
        }
    }

    public String getuserLoginEmail(){
        WebElement userEmail = driver.findElement(userLoginEmail);
        if (userEmail.isDisplayed()) {
            return userEmail.getText();
        }
        return null;
    }

    public void login(){
        WebElement lgn = driver.findElement(enterButton);
        if (lgn.isDisplayed()) {
            lgn.click();
        }
    }
}
