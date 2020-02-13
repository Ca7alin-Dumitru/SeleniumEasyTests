package pageobjects.common_elements.main_menu;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;
import pageobjects.others_package.ChartsDemoPage;

public class MainMenu extends PageObject {
    //this webelement is for Input Forms drop down button
    @FindBy(css = "#navbar-brand-centered > ul:nth-child(1) > li:nth-child(1) > a")
    private WebElement inputFormsDropDownToggleButton;

    //this webelement is for Date pickers drop down button
    @FindBy(css = "#navbar-brand-centered > ul:nth-child(1) > li:nth-child(2) > a")
    private WebElement datePickersDropDownToggleButton;

    //this webelement is for Table drop down button
    @FindBy(css = "#navbar-brand-centered > ul:nth-child(1) > li:nth-child(3) > a")
    private WebElement tableDropDownToggleButton;

    //this webelement is for Demo Home button
    @FindBy(css = "div.navbar-header > div.navbar-brand-centered > a")
    private WebElement demoHomeButton;

    //this webelement is for Progress Bars button
    @FindBy(css = "#navbar-brand-centered > ul.nav.navbar-nav.navbar-right > li:nth-child(1) > a")
    private WebElement progressBarsDropDownToggleButton;

    //this webelement is for Alerts & Modals button
    @FindBy(css = "#navbar-brand-centered > ul.nav.navbar-nav.navbar-right > li:nth-child(2) > a")
    private WebElement alertsAndModalsDropDownToggleButton;

    //this webelement is for List Box button
    @FindBy(css = "#navbar-brand-centered > ul.nav.navbar-nav.navbar-right > li:nth-child(3) > a")
    private WebElement listBoxDropDownToggleButton;

    //this webelement is for List Box button
    @FindBy(css = "#navbar-brand-centered > ul.nav.navbar-nav.navbar-right > li:nth-child(4) > a")
    private WebElement othersDropDownToggleButton;
    @FindBy(css = "#navbar-brand-centered > ul.nav.navbar-nav.navbar-right > li.dropdown.open > ul > li:nth-child(3) > a")
    private WebElement chartsDemoSubMenu;

    public MainMenu(WebDriver driver){
        super(driver);
    }

    @Step
    public ChartsDemoPage goToChartsDemoPage(){
        this.othersDropDownToggleButton.click();
        this.waitForElementToBeClickable(chartsDemoSubMenu);
        this.chartsDemoSubMenu.click();
        //new Actions(driver).click(chartsDemoSubMenu).perform();

        return new ChartsDemoPage(driver);
    }
}
