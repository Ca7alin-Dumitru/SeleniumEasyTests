package pageobjects.input_forms_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.PageObject;

public class InputFormSubmitPage extends PageObject {
    //these webelements are for Input Form Submit page
    @FindBy(css = "#contact_form > fieldset > div:nth-child(2) > div > div > input")
    private WebElement firstNameField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(3) > div > div > input")
    private WebElement lastNameField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(4) > div > div > input")
    private WebElement eMailField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(5) > div > div > input")
    private WebElement phoneField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(6) > div > div > input")
    private WebElement addressField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(7) > div > div > input")
    private WebElement cityField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(8) > div > div > select")
    private WebElement stateDropDown;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(9) > div > div > input")
    private WebElement zipCodeField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(10) > div > div > input")
    private WebElement websiteOrDomianNameField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(11) > div > div:nth-child(1) > label")
    private WebElement yesHostingRadioButton;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(11) > div > div:nth-child(2) > label")
    private WebElement noHostingRadioButton;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(12) > div > div > textarea")
    private WebElement projectDescriptionField;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(14) > div > button")
    private WebElement sendFormButton;

    public InputFormSubmitPage(WebDriver driver){
        super(driver);
    }

    @Step
    public InputFormSubmitPage inputFormAndSubmit(String firstName,
                                                  String lastName,
                                                  String eMail,
                                                  String phone,
                                                  String address,
                                                  String city,
                                                  String state,
                                                  String zipCode,
                                                  String websiteOrDomainName,
                                                  String hosting,
                                                  String projectDescription){
        Select stat = new Select(stateDropDown);
        this.firstNameField.sendKeys(firstName);
        this.lastNameField.sendKeys(lastName);
        this.eMailField.sendKeys(eMail);
        this.phoneField.sendKeys(phone);
        this.addressField.sendKeys(address);
        this.cityField.sendKeys(city);
        stat.selectByVisibleText(state);
        this.zipCodeField.sendKeys(zipCode);
        this.websiteOrDomianNameField.sendKeys(websiteOrDomainName);
        if(hosting.equalsIgnoreCase("yes")){
            this.yesHostingRadioButton.click();
        } else if(hosting.equalsIgnoreCase("no")){
            this.noHostingRadioButton.click();
        }
        this.projectDescriptionField.sendKeys(projectDescription);
        this.sendFormButton.click();

        return new InputFormSubmitPage(driver);
    }
}