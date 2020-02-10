package pageobjects.table_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class TableSortAndSearchPage extends PageObject {
    @FindBy(css = "#example > thead > tr > th:nth-child(4)")
    private WebElement ageSortingAsc;
    @FindBy(name = "example_length")
    private WebElement entriesPerPage;
    @FindBy(xpath = "//option[@value = '100']")
    private WebElement oneHundredPerPage;

    public TableSortAndSearchPage(WebDriver driver){
        super(driver);
    }

    public TableSortAndSearchPage sortByAgeTable(int perPage){
        this.ageSortingAsc.click();

        if(perPage == 100){
            this.entriesPerPage.click();
            this.oneHundredPerPage.click();
        }

        return new TableSortAndSearchPage(driver);
    }
}