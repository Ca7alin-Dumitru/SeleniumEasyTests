package pageobjects.table_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class TableFilterPage extends PageObject {
    //these webelements are for Filter Records table
    @FindBy(xpath = "//button[@data-target='pagado']")
    private WebElement greenFilterRecordsButton;
    @FindBy(xpath = "//button[@data-target='pendiente']")
    private WebElement orangeFilterRecordsButton;
    @FindBy(xpath = "//button[@data-target='cancelado']")
    private WebElement redFilterRecordsButton;
    @FindBy(xpath = "//button[@data-target='all']")
    private WebElement allRecordsButton;

    public TableFilterPage(WebDriver driver){
        super(driver);
    }

    public TableFilterPage filterRecords(String color){
        if(color.equalsIgnoreCase("green")){
            this.greenFilterRecordsButton.click();
        } else if(color.equalsIgnoreCase("orange")){
            this.orangeFilterRecordsButton.click();
        } else if(color.equalsIgnoreCase("red")){
            this.redFilterRecordsButton.click();
        } else {
            this.allRecordsButton.click();
        }

        return new TableFilterPage(driver);
    }
}