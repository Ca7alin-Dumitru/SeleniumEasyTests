package pageobjects.alerts_and_modals_package;

import io.qameta.allure.Step;
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
    @FindBy(xpath = "//div[@id='myModal0']//a[@class='btn btn-primary'][contains(text(),'Save changes')]")
    private WebElement saveChangesButton;
    @FindBy(xpath = "//div[@id='myModal0']//a[@class='btn'][contains(text(),'Close')]")
    private WebElement closeButton;


    //this webelements are for Multiple Modal Example section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div > div.panel-body > a")
    private WebElement launchMultipleModalButton;
    @FindBy(xpath = "//div[@class='modal-body']//a[@class='btn btn-primary'][contains(text(),'Launch modal')]")
    private WebElement launchChildModalButton;
    @FindBy(xpath = "//div[@id='myModal2']//a[@class='btn'][contains(text(),'Close')]")
    private WebElement closeChildButton;

    public BootstrapModalsPage(WebDriver driver){
        super(driver);
    }

    @Step
    public BootstrapModalsPage singleModalExampleSection(String modalOption){
        if(modalOption.equalsIgnoreCase("close")){
            this.launchSingleModalButton.click();
            new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(closeButton)).click();
        }else{
            this.launchSingleModalButton.click();
            this.saveChangesButton.click();
        }

        return new BootstrapModalsPage(driver);
    }

    @Step
    public BootstrapModalsPage multipleModalExampleSection(String modalOption){
        if(modalOption.equalsIgnoreCase("close")){
            this.launchMultipleModalButton.click();
            new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(launchChildModalButton));
            new Actions(driver).click(launchChildModalButton).perform();
            new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(closeChildButton));
            new Actions(driver).click(closeChildButton).perform();
            this.launchChildModalButton.sendKeys(Keys.ESCAPE);
        }

        return new BootstrapModalsPage(driver);
    }
}