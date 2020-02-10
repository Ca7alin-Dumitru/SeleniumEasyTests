package pageobjects.input_forms_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class AjaxFormSubmitPage extends PageObject {
    //these webelements are for Ajax Form Submit page
    @FindBy(css = "#title")
    private WebElement nameField;
    @FindBy(css = "#description")
    private WebElement commentAreaField;
    @FindBy(id = "btn-submit")
    private WebElement submitButton;

    public AjaxFormSubmitPage(WebDriver driver){
        super(driver);
    }

    public AjaxFormSubmitPage inputFormWithLoadingIcon(String name, String comment){
        this.nameField.sendKeys(name);
        this.commentAreaField.sendKeys(comment);
        this.submitButton.click();
        this.waitForElementToAppear(By.id("submit-control"));

        return new AjaxFormSubmitPage(driver);
    }
}