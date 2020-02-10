package pageobjects.list_box_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class BootstrapListBoxPage extends PageObject {
    //these webelements are for Bootstrap List Box page
    //left list
    @FindBy(css = "div.list-left input")
    private WebElement searchLeftListField;
    @FindBy(css = "div.list-left a")
    private WebElement selectAllLeftListButton;

    //move list to left and to right buttons
    @FindBy(css = "button.move-left")
    private WebElement moveToLeftTheRightListButton;
    @FindBy(css = "button.move-right")
    private WebElement moveToRightTheLeftListButton;

    //right list
    @FindBy(css = "div.list-right input")
    private WebElement searchRightListField;
    @FindBy(css = "div.list-right a")
    private WebElement selectAllRightListButton;


    public BootstrapListBoxPage(WebDriver driver){
        super(driver);
    }

    public BootstrapListBoxPage moveItemsBetweenLeftAndRight(){
        this.selectAllLeftListButton.click();
        this.moveToRightTheLeftListButton.click();
        this.selectAllRightListButton.click();
        this.moveToLeftTheRightListButton.click();

        return new BootstrapListBoxPage(driver);
    }
}