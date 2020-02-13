package pageobjects;

import org.openqa.selenium.By;
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
}
