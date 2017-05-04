package infra.homePage.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;


/**
 * Created by Kerens on 30/04/2017.
 */
public class homePage {
    protected WebDriver driver;

    //    private By loginLink = By.linkText("Login");
//    private By loginUserdataForm = By.id("loginUserdataForm");
    private By stationDepartureField = By.cssSelector("input[name=\"station_from\"]");
    private By stationDestinationField = By.cssSelector("input[name=\"station_till\"]");
    private By trainsNotFoundField = By.id("ts_res_not_found");
    private By searchButton = By.cssSelector("button[name=\"search\"]");
    private By departureKievskaiaFromSelectionList = By.cssSelector("#ui-id-3");
    private By destinationDebaltseveFromSelectionList = By.cssSelector("#ui-id-5");
    private By datesDialog = By.id("ui-datepicker-div");


    public homePage(WebDriver driver) {
        this.driver = driver;
    }

//    public homePage clickLoginBtn() {
//        System.out.println("clicking on the Login button");
//        WebElement loginBtnElement=driver.findElement(loginLink);
//        if(loginBtnElement.isDisplayed()||loginBtnElement.isEnabled())
//            loginBtnElement.click(); //Need a more elegant way of presenting it...
//        else System.out.println("Element not found");
//        return new homePage(driver);
//    }


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

    public void setDepartureLocation(String departureLocation,
                                     boolean closeSelectionDropDown,
                                     boolean moveToDestinationField,
                                     boolean pressEnterAfterSettingLocation) {
        System.out.println("Setting Departure Location...");
        WebElement departure  = driver.findElement(stationDepartureField);
        if (departure.isDisplayed()){
            departure.click();
            departure.sendKeys(departureLocation);
        }
        if (closeSelectionDropDown) {
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Really bad practice!
            //departure.sendKeys(Keys.ARROW_DOWN);
            //departure.click();
            //departure.sendKeys(Keys.ESCAPE);
            //departure.sendKeys(Keys.RETURN);
            //clickOnIteminSelectionList(departureKievskaiaFromSelectionList);
            departure.sendKeys(Keys.TAB);
        }
        else if (moveToDestinationField) {
            departure.sendKeys(Keys.TAB);
        }
        if (pressEnterAfterSettingLocation) {
            departure.sendKeys(Keys.RETURN);
        }
    }

    public void setDestinationLocation(String destinationLocationL,
                                       boolean closeSelectionDropDown) {
        System.out.println("Setting Destination...");
        WebElement destination = driver.findElement(stationDestinationField);
        if (destination.isDisplayed()) {
            destination.click();
            destination.sendKeys(destinationLocationL);
        }
        if (closeSelectionDropDown) {
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Really bad practice!
            //destination.sendKeys(Keys.ARROW_DOWN);
            //destination.click();
            //destination.sendKeys(Keys.ESCAPE);
            //destination.sendKeys(Keys.RETURN);
            //clickOnIteminSelectionList(destinationDebaltseveFromSelectionList);
            destination.sendKeys(Keys.TAB);
        }
    }

    public void switchFields(WebElement webElement){
        driver.switchTo().frame(webElement);
    }

    public void pressEnter(WebElement webElement){
        WebElement pressEnterOnElement = webElement;
        pressEnterOnElement.sendKeys(Keys.RETURN);
    }

    public void pressSearchButton(){
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }

    public void closeSelectDatesDialog(){
        //driver.switchTo().frame(driver.findElement(datesDialog));
        WebElement selectDateDialog = driver.findElement(datesDialog);
        selectDateDialog.click();
        //selectDateDialog.sendKeys(Keys.ESCAPE);
    }

    public String getTrainAvailblityMessage(){
        WebElement trainAvailabilityMessage = driver.findElement(trainsNotFoundField);
        return trainAvailabilityMessage.getText();
    }

    public void clickOnIteminSelectionList(By itemSelected){
        WebElement selectionList = driver.findElement(itemSelected);
        selectionList.click();
    }
//    public boolean verifyBasePageTitle(String expectedPageTitle ) {
//        return getPageTitle().contains(expectedPageTitle);
//    }
}
