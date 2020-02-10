package pageobjects.alerts_and_modals_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class JavaScriptAlertsPage extends PageObject {
    //this webelement is for Java Script Alert Box section
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > button")
    private WebElement clickMeJSAlertBoxButton;

    //this webelement is for Java Script Alert Box section
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > button")
    private WebElement clickMeJSConfirmBoxButton;

    //this webelement is for Java Script Prompt Box
    @FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(6) > div.panel-body > button")
    private WebElement clickForPromptBoxButton;

    public JavaScriptAlertsPage(WebDriver driver){
        super(driver);
    }

    public JavaScriptAlertsPage alertBoxDialog(){
        this.clickMeJSAlertBoxButton.click();

        return new JavaScriptAlertsPage(driver);
    }

    public JavaScriptAlertsPage confirmBoxDialog(){
        this.clickMeJSConfirmBoxButton.click();

        return new JavaScriptAlertsPage(driver);
    }

    public JavaScriptAlertsPage promptBoxDialog(){
        this.clickForPromptBoxButton.click();

        return new JavaScriptAlertsPage(driver);
    }
}
