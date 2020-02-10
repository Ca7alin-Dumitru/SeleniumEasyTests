package pageobjects.alerts_and_modals_package;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PageObject;

public class BootstrapModalsPage extends PageObject {
    //this webelements are for Single Modal Example section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div > div.panel-body > a")
    private WebElement launchSingleModalButton;
    @FindBy(css = "#myModal0 > div > div > div.modal-footer > a.btn.btn-primary")
    private WebElement saveChangesButton;
    @FindBy(css = "#myModal0 > div > div > div.modal-footer > a:nth-child(1)")
    private WebElement closeButton;


    //this webelements are for Multiple Modal Example section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div > div.panel-body > a")
    private WebElement launchMultipleModalButton;
    @FindBy(css = "#myModal > div > div > div.modal-body > a")
    private WebElement launchChildModalButton;
    @FindBy(css = "#myModal2 > div > div > div.modal-footer > a:nth-child(1)")
    private WebElement closeChildButton;

    public BootstrapModalsPage(WebDriver driver){
        super(driver);
    }

    public BootstrapModalsPage singleModalExampleSection(String modalOption){
        if(modalOption.equalsIgnoreCase("close")){
            this.launchSingleModalButton.click();
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(closeButton)).click();
        }else{
            this.launchSingleModalButton.click();
            this.saveChangesButton.click();
        }

        return new BootstrapModalsPage(driver);
    }

    public BootstrapModalsPage multipleModalExampleSection(String modalOption){
        if(modalOption.equalsIgnoreCase("close")){
            this.launchMultipleModalButton.click();
            this.launchChildModalButton.click();
            this.closeChildButton.click();
            this.launchChildModalButton.sendKeys(Keys.ESCAPE);
        }

        return new BootstrapModalsPage(driver);
    }
}