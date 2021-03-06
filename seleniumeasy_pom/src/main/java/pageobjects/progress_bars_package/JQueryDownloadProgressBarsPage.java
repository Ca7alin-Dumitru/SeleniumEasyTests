package pageobjects.progress_bars_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class JQueryDownloadProgressBarsPage extends PageObject {
    //this webelement is for JQuery Download Progress bars page
    @FindBy(css = "#downloadButton")
    private WebElement startDownloadButton;
    @FindBy(css = ".ui-dialog-buttonset button")
    private WebElement closeDialogButton;

    public JQueryDownloadProgressBarsPage(WebDriver driver){
        super(driver);
    }

    @Step
    public JQueryDownloadProgressBarsPage startDownloadProcess(){
        this.startDownloadButton.click();

        return new JQueryDownloadProgressBarsPage(driver);
    }

    @Step
    public JQueryDownloadProgressBarsPage closeDownloadProcess(){
        this.closeDialogButton.click();

        return new JQueryDownloadProgressBarsPage(driver);
    }
}