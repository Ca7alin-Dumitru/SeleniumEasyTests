package pageobjects.alerts_and_modals_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class ProgressBarModalPage extends PageObject {
    //these webelements are for Progress Bar Modal page
    //simple dialog
    @FindBy(css = "button.btn.btn-primary")
    private WebElement showSimpleDialogButton;

    //dialog with custom message
    @FindBy(css = "button.btn.btn-success")
    private WebElement showCustomDialogButton;

    //dialog with custom settings
    @FindBy(css = "button.btn.btn-warning")
    private WebElement showCustomSettingsDialogButton;

    public ProgressBarModalPage(WebDriver driver){
        super(driver);
    }

    public ProgressBarModalPage showSimpleDialog(){
        this.showSimpleDialogButton.click();

        return new ProgressBarModalPage(driver);
    }

    public ProgressBarModalPage showDialogWithCustomMessage(){
        this.showCustomDialogButton.click();

        return new ProgressBarModalPage(driver);
    }

    public ProgressBarModalPage showDialogWithCustomSetting(){
        this.showCustomSettingsDialogButton.click();

        return new ProgressBarModalPage(driver);
    }
}
