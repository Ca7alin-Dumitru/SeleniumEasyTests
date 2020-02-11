package pageobjects.list_box_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class JQueryListBoxPage extends PageObject {
    //these webelements are for JQuery Dual List Box Demo page
    //left list

    //middle buttons between the left and right lists
    @FindBy(css = "button.pAdd")
    private WebElement addButton;
    @FindBy(css = "button.pAddAll")
    private WebElement addAllButton;
    @FindBy(css = "button.pRemove")
    private WebElement removeButton;
    @FindBy(css = "button.pRemoveAll")
    private WebElement removeAllButton;

    //right list


    public JQueryListBoxPage(WebDriver driver){
        super(driver);
    }

    @Step
    public JQueryListBoxPage addAndRemoveAll(){
        this.addAllButton.click();
        this.removeAllButton.click();

        return new JQueryListBoxPage(driver);
    }
}