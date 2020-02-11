package pageobjects.list_box_package;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class DataListFilterPage extends PageObject {
    //this weblement is for Data List Filter page
    @FindBy(css = "#input-search")
    private WebElement searchAttendeesField;

    public DataListFilterPage(WebDriver driver){
        super(driver);
    }

    @Step
    public DataListFilterPage searchAttendees(String attendee){
        this.searchAttendeesField.sendKeys(attendee);

        return new DataListFilterPage(driver);
    }

    @Step
    public DataListFilterPage searchAttendees(){
        this.searchAttendeesField.clear();
        this.searchAttendeesField.sendKeys(Keys.ENTER);

        return new DataListFilterPage(driver);
    }
}