package pageobjects.alerts_and_modals_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class WindowPopupModalPage extends PageObject {
    //these webelements are for Single Window Popup section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div.panel-body > div:nth-child(1) > a")
    private WebElement followOnTwitterButton;
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div.panel-body > div:nth-child(2) > a")
    private WebElement likeUsOnFacebookButton;

    //these webelements are for Multiple Window Modal section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div.panel-body > div.two-windows > a")
    private WebElement followTwitterAndFacebookButton;
    @FindBy(css = "#followall")
    private WebElement followAllButton;

    public WindowPopupModalPage(WebDriver driver){
        super(driver);
    }

    @Step
    public WindowPopupModalPage followOnTwitterActions(){
        this.followOnTwitterButton.click();

        return new WindowPopupModalPage(driver);
    }

    @Step
    public WindowPopupModalPage likeUsOnFacebookActions(){
        this.likeUsOnFacebookButton.click();

        return new WindowPopupModalPage(driver);
    }

    @Step
    public WindowPopupModalPage followTwitterAndFabeeokActions(){
        this.followTwitterAndFacebookButton.click();

        return new WindowPopupModalPage(driver);
    }

    @Step
    public WindowPopupModalPage followAllButton(){
        this.followAllButton.click();

        return new WindowPopupModalPage(driver);
    }
}