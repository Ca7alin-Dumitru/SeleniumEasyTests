package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.progress_bars_package.DragAndDropSlidersPage;

public class DemoHomePage extends PageObject{
    //these webelements are for carousel slider
    @FindBy(css = "i.fa.fa-angle-left")
    private WebElement leftCaruselControlButon;
    @FindBy(css = "i.fa.fa-angle-right")
    private WebElement rightCaruselControlButton;
    @FindBy(xpath = "//*[@class='carousel-indicators']/li[@data-slide-to=0]")
    private WebElement firstCarulesControlButton;
    @FindBy(xpath = "//*[@class='carousel-indicators']/li[@data-slide-to=1]")
    private WebElement secondCarulesControlButton;
    @FindBy(xpath = "//*[@class='carousel-indicators']/li[@data-slide-to=2]")
    private WebElement thirdCarulesControlButton;
    @FindBy(xpath = "//*[@class='carousel-indicators']/li[@data-slide-to=3]")
    private WebElement fourthCarulesControlButton;

    //these webelements are for Selenium wizard level
    //wizard step - welcome to selenium easy demo => title
    @FindBy(css = "a#home_bar")
    private WebElement homeWizzardButton;
    @FindBy(css ="a#btn_basic_example")
    private WebElement startPractisingButton;

    //wizard step - basic examples to start with selenium => title
    @FindBy(css = "a#basic_example")
    private WebElement basicWizzardButton;
    @FindBy(css = "a#btn_inter_example")
    private WebElement proceedNextWizzardButtonFromBasic;
    //list group displayed at this step
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './basic-first-form-demo.html']")
    private WebElement simpleFormDemoItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './basic-checkbox-demo.html']")
    private WebElement checkBoxDemoItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './basic-radiobutton-demo.html']")
    private WebElement radioButtonsDemoItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './basic-select-dropdown-demo.html']")
    private WebElement selectDropdownListItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './javascript-alert-box-demo.html']")
    private WebElement javascriptAlertsItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './window-popup-modal-demo.html']")
    private WebElement windowPopupModalItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './bootstrap-alert-messages-demo.html']")
    private WebElement bootstrapAlertsItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './bootstrap-modal-demo.html']")
    private WebElement bootstrapModalsItem;

    //wizard step => intermediate examples with most popular components => title
    @FindBy(css = "a#inter_example")
    private WebElement intermediateWizzardButton;
    @FindBy(css = "a#btn_advanced_example")
    private WebElement proceedNextWizzardButtonFromIntermediate;
    //list group displayed at this step
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './input-form-demo.html']")
    private WebElement inputFormWithValidationItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './ajax-form-submit-demo.html']")
    private WebElement ajaxFormSubmitItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './jquery-dropdown-search-demo.html']")
    private WebElement jquerySelectDropdownItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './bootstrap-dual-list-box-demo.html']")
    private WebElement bootstrapListBoxItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './jquery-dual-list-box-demo.html']")
    private WebElement jqueryListBoxItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './data-list-filter-demo.html']")
    private WebElement dataListFilterItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './bootstrap-progress-bar-dialog-demo.html']")
    private WebElement progressBarModalItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './generate-file-to-download-demo.html']")
    private WebElement fileDownloadItem;

    //wizard step => advanced examples with components => title
    @FindBy(css = "a#advanced_example")
    private WebElement advancedWizzardButton;
    @FindBy(css = "a#btn_done_example")
    private WebElement proceedNextWizzardButtonFromAdvanced;
    //list group displayed at this step
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './table-pagination-demo.html']")
    private WebElement tablePaginationItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './table-search-filter-demo.html']")
    private WebElement tableDataSearchItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './table-records-filter-demo.html']")
    private WebElement tableFilterItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './table-sort-search-demo.html']")
    private WebElement tableSortAndSearchItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './table-data-download-demo.html']")
    private WebElement tableDataDownloadItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './jquery-download-progress-bar-demo.html']")
    private WebElement jqueryDownloadProgressBarsItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './bootstrap-download-progress-demo.html']")
    private WebElement bootstrapDownloadProgressBarItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './drag-drop-range-sliders-demo.html']")
    private WebElement dragAndDropSlidersItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './drag-and-drop-demo.html']")
    private WebElement dragAndDropItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './dynamic-data-loading-demo.html']")
    private WebElement dynamicDataLoadingItem;
    @FindBy(xpath = "//div[@class='list-group']/a[@href = './charts-mouse-hover-demo.html']")
    private WebElement chartsDemoItem;

    //wizard step => thanks for staying tuned! we are done => title
    @FindBy(css = "a#done_example")
    private WebElement finishWizzardButton;

    public DemoHomePage(WebDriver driver){
        super(driver);
    }

    public DemoHomePage doThingsWithCarusel(){
        this.fourthCarulesControlButton.click();
        this.leftCaruselControlButon.click();
        this.leftCaruselControlButon.click();
        this.rightCaruselControlButton.click();
        this.firstCarulesControlButton.click();

        return new DemoHomePage(driver);
    }

    public DemoHomePage usingTheWizardProceedButtons(){
        this.startPractisingButton.click();
        this.proceedNextWizzardButtonFromBasic.click();
        this.proceedNextWizzardButtonFromIntermediate.click();
        this.proceedNextWizzardButtonFromAdvanced.click();

        return new DemoHomePage(driver);
    }

    public DemoHomePage usingTheWizardMainButtons(){
        this.advancedWizzardButton.click();
        this.intermediateWizzardButton.click();
        this.basicWizzardButton.click();
        this.homeWizzardButton.click();

        return new DemoHomePage(driver);
    }

    public DragAndDropSlidersPage goToDragAndDropPage(){
        this.advancedWizzardButton.click();
        this.dragAndDropSlidersItem.click();

        return new DragAndDropSlidersPage(driver);
    }
}