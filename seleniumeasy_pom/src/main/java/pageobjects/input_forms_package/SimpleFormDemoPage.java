package pageobjects.input_forms_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class SimpleFormDemoPage extends PageObject {
    //these webelements are for Single Input Field
    @FindBy(css = "input#user-message")
    private WebElement pleaseEnterYourMessageField;
    @FindBy(xpath = "//form[@id='get-input']/button")
    private WebElement showMessageButton;

    //these webelements are for Two Input Fields
    @FindBy(xpath = "//form[@id='gettotal']/div[1]/input")
    private WebElement enterValueForAField;
    @FindBy(xpath = "//form[@id='gettotal']/div[2]/input")
    private WebElement enterValueForBField;
    @FindBy(xpath = "//form[@id='gettotal']/button")
    private WebElement getTotalButton;

    public SimpleFormDemoPage(WebDriver driver){
        super(driver);
    }

    public SimpleFormDemoPage singleInputFieldSection(String message){
        this.pleaseEnterYourMessageField.sendKeys(message);
        this.showMessageButton.click();
        return new SimpleFormDemoPage(driver);
    }

    public SimpleFormDemoPage twoInputFieldsSection(String valueA, String valueB){
        this.enterValueForAField.sendKeys(valueA);
        this.enterValueForBField.sendKeys(valueB);
        this.getTotalButton.click();
        return new SimpleFormDemoPage(driver);
    }
}
