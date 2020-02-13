package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    private static final int TIMEOUT = 60;
    private static final int POLLING = 10000;

    protected final WebDriver driver;
    private static WebDriverWait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, TIMEOUT);
        PageFactory.initElements(this.driver, this);
    }

    protected void waitForElementToAppear(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator,text)));
    }

    protected void waitForElementToBeClickable(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForTextToBePresentInElementLocated(By locator, String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }

    protected void waitForUrlContains(String fraction){
        wait.until(ExpectedConditions.urlContains(fraction));
    }

    /*it is not finished
    public void dragDrop(WebDriver driver,WebElement elementToDrag, WebElement target) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {" +
                "var event = document.createEvent(\"CustomEvent\");" +
                "event.initCustomEvent(typeOfEvent, true, true, null);" +
                "event.dataTransfer = {" +
                "data: {},setData: function (key, value) {" +
                "this.data[key] = value;},getData: function (key) {" +
                "return this.data[key];}};return event;}" +
                "function dispatchEvent(element, event,transferData) {" +
                "   if (transferData !== undefined) {" +
                "       event.dataTransfer = transferData;" +
                "   }" +
                "   if (element.dispatchEvent) {" +
                "       element.dispatchEvent(event);" +
                "   } else if (element.fireEvent) {" +
                "       element.fireEvent(\"on\" + event.type,event);}}" +
                "function simulateHTML5DragAndDrop(element,target) {" +
                "   var dragStartEvent =createEvent(\"dragstart\");" +
                "   dispatchEvent(element, dragStartEvent);" +
                "   var dropEvent = createEvent(\"drop\");" +
                "   dispatchEvent(target, dropEvent,dragStartEvent.dataTransfer);" +
                "   var dragEndEvent = createEvent(\"dragend\");" +
                "   dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);}" +
                "var elementToDrag = arguments[0];" +
                "var target = arguments[1];" +
                "simulateHTML5DragAndDrop(elementToDrag,target);", elementToDrag, target);
    }*/
}
