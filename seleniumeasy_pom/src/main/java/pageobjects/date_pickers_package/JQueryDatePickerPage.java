package pageobjects.date_pickers_package;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class JQueryDatePickerPage extends PageObject {
    //these webelements are for JQuery Date Picker Demo page
    @FindBy(css = "#from")
    private WebElement fromDateRangerPickerDropDown;
    @FindBy(css = "#to")
    private WebElement toDateRangerPickerDropDown;

    public JQueryDatePickerPage(WebDriver driver){
        super(driver);
    }

    public JQueryDatePickerPage dateRangePicker(String from, String to){
        this.fromDateRangerPickerDropDown.sendKeys(from);
        this.toDateRangerPickerDropDown.sendKeys(to);
        this.toDateRangerPickerDropDown.sendKeys(Keys.ENTER);

        return new JQueryDatePickerPage(driver);
    }
}