package pageobjects.date_pickers_package;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PageObject;
import pageobjects.input_forms_package.JQuerySelectDropdownPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BootstrapDatePickerPage extends PageObject {
    //this webelement is for Date Example section
    @FindBy(css = "#sandbox-container1 .form-control")
    private WebElement selectDateField;
    @FindBy(css = ".input-group-addon")
    private WebElement selectDateButton;
    @FindBy(css = ".datepicker-days .prev")
    private WebElement prevDateButton;
    @FindBy(css = ".datepicker-days .datepicker-switch")
    private WebElement monthsYearsPickerbutton;
    @FindBy(css = ".datepicker-days .next")
    private WebElement nextDateButton;
    @FindBy(css = ".datepicker-days .today.day")
    private WebElement todayDaysButton;
    @FindBy(css = ".datepicker-days .today[colspan='7']")
    private WebElement todayButton;
    @FindBy(css = ".datepicker-days .clear")
    private WebElement clearButton;


    //these webelements are for Date Range Example section
    @FindBy(css = "#datepicker > input:nth-child(1)")
    private WebElement selectStartDateDropDown;
    @FindBy(css = "#datepicker > input:nth-child(3)")
    private WebElement selectEndDateDropDown;

    public BootstrapDatePickerPage(WebDriver driver){
        super(driver);
    }

    @Step
    public BootstrapDatePickerPage dateExampleSection(String date){
        this.selectDateField.click();
        this.selectDateField.sendKeys(date);
        this.selectDateField.sendKeys(Keys.ENTER);

        this.selectDateButton.click();
        this.waitForElementToBeClickable(prevDateButton);
        this.prevDateButton.click();
        this.waitForElementToBeClickable(nextDateButton);
        this.nextDateButton.click();
        this.monthsYearsPickerbutton.click();
        //span[text() = 'Mar']
        //th[text() = 1995]
        new Actions(driver).click(driver.findElement(By.xpath("//span[text() = '" + (currentMonth()) + "']"))).perform();
        //this.waitForElementToBeClickable(driver.findElement(By.xpath("//span[text() = 'Feb']")));
        this.todayDaysButton.click();

        this.selectDateButton.click();
        this.todayButton.click();

        this.selectDateButton.click();
        this.clearButton.click();

        this.selectDateField.click();
        this.selectDateField.sendKeys(date);
        this.selectDateField.sendKeys(Keys.ENTER);

        return new BootstrapDatePickerPage(driver);
    }

    @Step
    public BootstrapDatePickerPage dateRangeExampleSection(String start, String end){
        this.selectStartDateDropDown.click();
        this.selectStartDateDropDown.sendKeys(start);
        this.selectEndDateDropDown.click();
        this.selectEndDateDropDown.sendKeys(end);
        new Actions(driver).click(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > ul > li:nth-child(1)"))).perform();

        return new BootstrapDatePickerPage(driver);
    }

    public String currentMonth(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String month = formatter.format(calendar.getTime());
        switch (month){
            case "01": month = "Jan"; break;
            case "02": month = "Feb"; break;
            case "03": month = "Mar"; break;
            case "04": month = "Apr"; break;
            case "05": month = "May"; break;
            case "06": month = "Jun"; break;
            case "07": month = "Jul"; break;
            case "08": month = "Aug"; break;
            case "09": month = "Sep"; break;
            case "10": month = "Oct"; break;
            case "11": month = "Nov"; break;
            case "12": month = "Dec"; break;
        }
        return month;
    }
}
