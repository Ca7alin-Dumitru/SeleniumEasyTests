package pageobjects.input_forms_package;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class CheckboxDemoPage extends PageObject {
    //this webelement is for Single Checkbox Demo section
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > div.checkbox > label")
    private WebElement clickOnThisCheckBox;

    //these webelements are for Multiple Checkbox Demo section
    @FindBy(css ="#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label")
    private WebElement option1CheckBox;
    @FindBy(css ="#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(4) > label")
    private WebElement option2CheckBox;
    @FindBy(css ="#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(5) > label")
    private WebElement option3CheckBox;
    @FindBy(css ="#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(6) > label")
    private WebElement option4CheckBox;
    @FindBy(xpath = "//input[@id='check1']")
    private WebElement checkAllButton;


    public CheckboxDemoPage(WebDriver driver){
        super(driver);
    }

    @Step
    public CheckboxDemoPage singleCheckboxDemoSection(){
        this.clickOnThisCheckBox.click();
        return new CheckboxDemoPage(driver);
    }

    @Step
    public CheckboxDemoPage multipleCheckboxDemoSection(int option){
        if(option == 1){
            this.option1CheckBox.click();
        } else if(option == 2){
            this.option2CheckBox.click();
        } else if(option == 3){
            this.option3CheckBox.click();
        } else if(option == 4){
            this.option4CheckBox.click();
        } else if(option == 5){
            /*this.waitForElementToBeClickable(this.checkAllButton);
            this.checkAllButton.click();*/
            //new Actions(driver).click(checkAllButton).perform();
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkAllButton);
        } else {
            System.out.println("The chosen option is not in range from 1 to 6!");
            System.out.println("From 1 to 4 are the Option 1 to the Option 4 checkboxes!");
            System.out.println("The 5 value is for the final button");
        }
        return new CheckboxDemoPage(driver);
    }
}
