package pageobjects.table_package;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class TableDataSearchPage extends PageObject {
    //this webelement is for Tasks table
    @FindBy(css = "#task-table-filter")
    private WebElement filterByTaskAssigneeStatusField;

    //these webelements are for Listed Users table
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div > div > button")
    private WebElement filterButton;
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > table > thead > tr > th:nth-child(1) > input")
    private WebElement indexNumberUsersField;
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > table > thead > tr > th:nth-child(2) > input")
    private WebElement userNameField;
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > table > thead > tr > th:nth-child(3) > input")
    private WebElement firstNameField;
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > table > thead > tr > th:nth-child(3) > input")
    private WebElement lastNameField;


    public TableDataSearchPage(WebDriver driver){
        super(driver);
    }

    public TableDataSearchPage tasksSection(String tasks){
        this.filterByTaskAssigneeStatusField.sendKeys(tasks);

        return new TableDataSearchPage(driver);
    }

    public TableDataSearchPage tasksSection(){
        this.filterByTaskAssigneeStatusField.clear();
        this.filterByTaskAssigneeStatusField.sendKeys(Keys.ENTER);

        return new TableDataSearchPage(driver);
    }

    public TableDataSearchPage listedUsersSection(String index){
        this.filterButton.click();
        this.indexNumberUsersField.sendKeys(index);

        return new TableDataSearchPage(driver);
    }

    public TableDataSearchPage listedUsersSection(){
        this.filterButton.click();

        return new TableDataSearchPage(driver);
    }
}