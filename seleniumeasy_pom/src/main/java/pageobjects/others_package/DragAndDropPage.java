package pageobjects.others_package;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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

    @Step
    public DragAndDropPage dragAndDropItems(String [] items) throws Exception {
        for(String item : items){
            if(item.equalsIgnoreCase("drag1")){
                /*(new Actions(driver)).dragAndDrop(draggableFirstTextBox, dropHereZone).perform();*/
                /*Actions action = new Actions(driver);
                action.clickAndHold(draggableFirstTextBox).moveToElement(dropHereZone).release(dropHereZone).build().perform();*/
                //new Actions(driver).dragAndDrop(draggableFirstTextBox, dropHereZone).build().perform();
                /*new Actions(driver).moveToElement(draggableFirstTextBox).build().perform();
                new Actions(driver).clickAndHold(draggableFirstTextBox).build().perform();
                new Actions(driver).moveToElement(dropHereZone).build().perform();*/
                driver.manage().window().setSize(new Dimension(1004,748));
                Robot robot = new Robot();
                new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
                robot.delay(1500);
                robot.mouseMove(150,440); //at work 850, 680 it is needed
                robot.delay(1500);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(450,440); // at work 600, 500 it is needed
                robot.delay(1500);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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
    /* it is not finished
    @Step
    public DragAndDropPage dragAndDropItems() throws Exception {
        this.dragDrop(driver,draggableFirstTextBox,dropHereZone);

        return new DragAndDropPage(driver);
    }*/
}