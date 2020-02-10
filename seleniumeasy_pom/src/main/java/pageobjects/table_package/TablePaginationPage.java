package pageobjects.table_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class TablePaginationPage extends PageObject {
    //these webelements are for Table with Pagination Example page
    @FindBy(className = "prev_link")
    private WebElement prevPageButton;
    @FindBy(className = "next_link")
    private WebElement nextPageButton;
    @FindBy(xpath = "//a[text() = 1]")
    private WebElement firstPage;
    @FindBy(xpath = "//a[text() = 2]")
    private WebElement secondPage;
    @FindBy(xpath = "//a[text() = 3]")
    private WebElement thirdPage;

    public TablePaginationPage(WebDriver driver){
        super(driver);
    }

    public TablePaginationPage tablePaginationChanges(){
        this.secondPage.click();
        this.thirdPage.click();
        this.prevPageButton.click();
        this.nextPageButton.click();
        this.firstPage.click();

        return new TablePaginationPage(driver);
    }
}