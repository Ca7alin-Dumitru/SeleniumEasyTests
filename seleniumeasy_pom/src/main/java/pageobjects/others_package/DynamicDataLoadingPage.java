package pageobjects.others_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class DynamicDataLoadingPage extends PageObject {
    //this webelement is for Dynamic Data Loading page
    @FindBy(css = "#save")
    private WebElement getNewUserButton;

    public DynamicDataLoadingPage(WebDriver driver){
        super(driver);
    }

    @Step
    public DynamicDataLoadingPage getNewUser(){
        this.getNewUserButton.click();

        return new DynamicDataLoadingPage(driver);
    }
}