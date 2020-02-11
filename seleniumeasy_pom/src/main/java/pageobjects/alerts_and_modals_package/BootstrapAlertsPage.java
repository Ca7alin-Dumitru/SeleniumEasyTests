package pageobjects.alerts_and_modals_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class BootstrapAlertsPage extends PageObject {
    //these webelements are for Bootstrap Alerts page
    //success buttons and messages
    @FindBy(css = "#autoclosable-btn-success")
    private WebElement autoClosableSuccessButton;
    @FindBy(css = "#normal-btn-success")
    private WebElement normalSuccessButton;

    //warning buttons and messages
    @FindBy(css = "#autoclosable-btn-warning")
    private WebElement autoClosableWarningButton;
    @FindBy(css = "#normal-btn-warning")
    private WebElement normalWarningButton;

    //danger buttons and messages
    @FindBy(css = "#autoclosable-btn-danger")
    private WebElement autoClosableDangerButton;
    @FindBy(css = "#normal-btn-danger")
    private WebElement normalDangerButton;

    //info buttons and messages
    @FindBy(css = "#autoclosable-btn-info")
    private WebElement autoClosableInfoButton;
    @FindBy(css = "#normal-btn-info")
    private WebElement normalInfoButton;

    public BootstrapAlertsPage(WebDriver driver){
        super(driver);
    }

    @Step
    public BootstrapAlertsPage alertMessages(String typeOfMessage){
        if(typeOfMessage.equalsIgnoreCase("success")){
            this.autoClosableSuccessButton.click();
            this.normalSuccessButton.click();
        } else if(typeOfMessage.equalsIgnoreCase("warning")){
            this.autoClosableWarningButton.click();
            this.normalWarningButton.click();
        } else if(typeOfMessage.equalsIgnoreCase("danger")){
            this.autoClosableDangerButton.click();
            this.normalDangerButton.click();
        } else {
            this.autoClosableInfoButton.click();
            this.normalInfoButton.click();
        }

        return new BootstrapAlertsPage(driver);
    }
}
