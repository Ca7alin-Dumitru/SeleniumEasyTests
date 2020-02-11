package pageobjects.common_elements.left_menu;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;
import pageobjects.table_package.TablePaginationPage;

public class MenuListLeftSide extends PageObject {
    //these webelements are for tree menu
    @FindBy(css = "#treemenu > li > a")
    private WebElement allExamplesButton;

    //this webelement is for Input Forms drop down button
    @FindBy(css = "#treemenu > li > ul > li:nth-child(1) > a")
    private WebElement inputFormsButton;

    //this webelement is for Date pickers drop down button
    @FindBy(css = "#treemenu > li > ul > li:nth-child(2) > a")
    private WebElement datePickersButton;

    //this webelement is for Table drop down button
    @FindBy(css = "#treemenu > li > ul > li:nth-child(3) > a")
    private WebElement tableButton;
    @FindBy(css = "#treemenu > li > ul > li:nth-child(3) > ul > li:nth-child(3) > a")
    private WebElement tableFilterSubMenu;

    //this webelement is for Progress Bars & Sliders drop down button
    @FindBy(css = "#treemenu > li > ul > li:nth-child(4) > a")
    private WebElement progressBarsAndSlidersButton;

    //this webelement is for Alerts & Modals drop down button
    @FindBy(css = "#treemenu > li > ul > li:nth-child(5) > a")
    private WebElement alertsAndModalsButton;

    //this webelement is for List Box drop down button
    @FindBy(css = "#treemenu > li > ul > li:nth-child(6) > a")
    private WebElement listBoxButton;

    //this webelement is for Others drop down button
    @FindBy(css = "#treemenu > li > ul > li:nth-child(7) > a")
    private WebElement othersButton;

    public MenuListLeftSide(WebDriver driver){
        super(driver);
    }

    @Step
    public TablePaginationPage leftMenuExpandAndGoToAPage(){
        this.allExamplesButton.click();
        this.allExamplesButton.click();
        this.tableButton.click();
        this.tableFilterSubMenu.click();

        return new TablePaginationPage(driver);
    }
}
