package infra.homePage.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class homePage {

    protected WebDriver driver;

    private By stationDepartureField = By.cssSelector("input[name=\"station_from\"]");
    private By stationDestinationField = By.cssSelector("input[name=\"station_till\"]");
    private By trainsNotFoundField = By.id("ts_res_not_found");
    private By searchButton = By.cssSelector("button[name=\"search\"]");
    private By datesDialog = By.id("ui-datepicker-div");
    private By userControlPanelButton = By.cssSelector("a.linkBtn");


    public homePage(WebDriver driver) {
        this.driver = driver;
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
        if (trainAvailabilityMessage.isDisplayed()) {
            return trainAvailabilityMessage.getText();
        } else {
            //Bad Practice- need to talk about this. It should be wait for element to be displayed
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return trainAvailabilityMessage.getText();
        }
    }

    public void clickOnIteminSelectionList(By itemSelected){
        WebElement selectionList = driver.findElement(itemSelected);
        selectionList.click();
    }

    public void userControlPanelButton(WebDriver driver) {
        WebElement  userCtrlPanelBtn = driver.findElement(userControlPanelButton);
        userCtrlPanelBtn.click();
    }

}
