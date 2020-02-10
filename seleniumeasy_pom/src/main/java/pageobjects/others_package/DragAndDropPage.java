package pageobjects.others_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

import java.awt.*;
import java.awt.event.InputEvent;

public class DragAndDropPage extends PageObject {
    //these webelements are for Drag and Drop page
    @FindBy(css = "#todrag > span:nth-child(2)")
    private WebElement draggableFirstTextBox;
    @FindBy(css = "#todrag > span:nth-child(3)")
    private WebElement draggableSecondTextBox;
    @FindBy(css = "#todrag > span:nth-child(4)")
    private WebElement draggableThirdTextBox;
    @FindBy(css = "#todrag > span:nth-child(5)")
    private WebElement draggableFourthTextBox;
    @FindBy(css = "#mydropzone")
    private WebElement dropHereZone;

    public DragAndDropPage(WebDriver driver){
        super(driver);
    }

    public DragAndDropPage dragAndDropItems(String [] items) throws Exception {
        for(String item : items){
            if(item.equalsIgnoreCase("drag1")){
                /*Robot bot = new Robot();
                bot.mouseMove(draggableFirstTextBox.getLocation().getX(), draggableFirstTextBox.getLocation().getY()+300);
                bot.mouseMove(dropHereZone.getLocation().getX()+200, dropHereZone.getLocation().getY()+300);*/

                /*(new Actions(driver)).dragAndDrop(draggableFirstTextBox, dropHereZone).perform();*/
                /*Actions action = new Actions(driver);
                action.clickAndHold(draggableFirstTextBox).moveToElement(dropHereZone).release().build().perform();*/
                new Actions(driver).dragAndDrop(draggableFirstTextBox, dropHereZone).build().perform();
                /*System.out.println(draggableFirstTextBox.getLocation().getX() + " " + draggableFirstTextBox.getLocation().getY());
                System.out.println(draggableFirstTextBox.getSize().height + " " + draggableFirstTextBox.getSize().width);
                System.out.println(dropHereZone.getLocation().getX() + " " + dropHereZone.getLocation().getY());
                System.out.println(dropHereZone.getSize().height + " " + dropHereZone.getSize().width);*/
            } else if(item.equalsIgnoreCase("drag2")){
                new Actions(driver).dragAndDrop(draggableSecondTextBox, dropHereZone).perform();
            } else if(item.equalsIgnoreCase("drag3")){
                new Actions(driver).dragAndDrop(draggableThirdTextBox, dropHereZone).perform();
            } else if(item.equalsIgnoreCase("drag4")){
                new Actions(driver).dragAndDrop(draggableFourthTextBox, dropHereZone).perform();
            }
        }

        return new DragAndDropPage(driver);
    }
}