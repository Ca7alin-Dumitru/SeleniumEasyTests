package pageobjects.common_elements.footer;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class FooterMenus extends PageObject {
    //these webelements are for Tutorials Menu
    @FindBy(css = "footer > div > div:nth-child(1) > ul > li:nth-child(1) > a")
    private WebElement seleniumTutorialsLink;
    @FindBy(css = "footer > div > div:nth-child(1) > ul > li:nth-child(2) > a")
    private WebElement testNGTutorialLink;
    @FindBy(css = "footer > div > div:nth-child(1) > ul > li:nth-child(3) > a")
    private WebElement jUnitTutorialsLink;
    @FindBy(css = "footer > div > div:nth-child(1) > ul > li:nth-child(4) > a")
    private WebElement jxlTutorialsLink;
    @FindBy(css = "footer > div > div:nth-child(1) > ul > li:nth-child(5) > a")
    private WebElement apachePOITutorialsLink;
    @FindBy(css = "footer > div > div:nth-child(1) > ul > li:nth-child(6) > a")
    private WebElement antTutorialsLink;
    @FindBy(css = "footer > div > div:nth-child(1) > ul > li:nth-child(7) > a")
    private WebElement mavenTutorialsLink;

    //these webelements are for Popular Posts
    @FindBy(css = "body > footer > div > div:nth-child(2) > ul > li:nth-child(1) > a")
    private WebElement geckoDriverSelenium3Link;
    @FindBy(css = "body > footer > div > div:nth-child(2) > ul > li:nth-child(2) > a")
    private WebElement pageFactoryPatternLink;
    @FindBy(css = "body > footer > div > div:nth-child(2) > ul > li:nth-child(3) > a")
    private WebElement executeTestsInJenkinsLink;
    @FindBy(css = "body > footer > div > div:nth-child(2) > ul > li:nth-child(4) > a")
    private WebElement testNGCustomReportLink;
    @FindBy(css = "body > footer > div > div:nth-child(2) > ul > li:nth-child(5) > a")
    private WebElement executeSeleniumTestsUsingMavenLink;
    @FindBy(css = "body > footer > div > div:nth-child(2) > ul > li:nth-child(6) > a")
    private WebElement viewAllSeleniumTutorialsLink;

    public FooterMenus(WebDriver driver){
        super(driver);
    }

    @Step
    public void goToApachePoi(){
        this.apachePOITutorialsLink.click();
    }
}
