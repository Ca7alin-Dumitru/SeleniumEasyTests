package pageobjects.common_elements.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class HeaderObject extends PageObject {
    //these webelements are for header left side
    @FindBy(css = "div.logo")
    private WebElement seleniumEasyLogo;
    @FindBy(css = "div#site-name > a")
    private WebElement seleniumEasyNameAndSloganLink;

    //this webelement is for header right side
    @FindBy(css = "div.top-banner > a > img")
    private WebElement sponsorSmartBearCrossBrowserTestingLink;

    public HeaderObject(WebDriver driver){
        super(driver);
    }

    public void goToSeleniumEasyHome(){
        this.seleniumEasyLogo.click();
    }
}
