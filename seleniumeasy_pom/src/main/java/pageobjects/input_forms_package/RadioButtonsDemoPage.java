package pageobjects.input_forms_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class RadioButtonsDemoPage extends PageObject {
    //these webelements are for Radio Button Demo section
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > label:nth-child(2)")
    private WebElement maleRadioButton;
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > label:nth-child(3)")
    private WebElement femaleRadioButton;
    @FindBy(css = "#buttoncheck")
    private WebElement getCheckedValueButton;

    //these webelements are for Group Radio Buttons Demo section
    //Sex butons groups
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(2) > label:nth-child(2)")
    private WebElement maleSexRadioButton;
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(2) > label:nth-child(3)")
    private WebElement femaleSexRadioButton;
    //Age button groups
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(2)")
    private WebElement zeroToFiveRadioButton;
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(3)")
    private WebElement fiveToFifteenRadioButton;
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(4)")
    private WebElement fifteenToFiftyRadioButton;
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > button")
    private WebElement getValuesButton;

    public RadioButtonsDemoPage(WebDriver driver){
        super(driver);
    }

    public RadioButtonsDemoPage radioButtonDemoSection(String sex){
        if(sex.equalsIgnoreCase("male")){
            this.maleRadioButton.click();
        } else if(sex.equalsIgnoreCase("female")){
            this.femaleRadioButton.click();
        }

        this.getCheckedValueButton.click();

        return new RadioButtonsDemoPage(driver);
    }

    public RadioButtonsDemoPage groupRadioButtonsDemoSection(String sex, int age){
        if(sex.equalsIgnoreCase("male")){
            this.maleSexRadioButton.click();
        } else if(sex.equalsIgnoreCase("female")){
            this.femaleSexRadioButton.click();
        }

        if(age < 5 && age >= 0){
            this.zeroToFiveRadioButton.click();
        } else if(age < 15){
            this.fiveToFifteenRadioButton.click();
        } else if(age < 50){
            this.fifteenToFiftyRadioButton.click();
        }

        this.getValuesButton.click();

        return new RadioButtonsDemoPage(driver);
    }
}