package pageobjects.others_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class ChartsDemoPage extends PageObject {
    //these webelements are for Charts Demo page
    @FindBy(css = "#pie-chart-widget > div.panel-footer > div.btn-group.btn-group-justified.text-uppercase.text-center > a:nth-child(1)")
    private WebElement videoFilesButton;
    @FindBy(css = "#pie-chart-widget > div.panel-footer > div.btn-group.btn-group-justified.text-uppercase.text-center > a:nth-child(2)")
    private WebElement picturesButton;
    @FindBy(css = "#pie-chart-widget > div.panel-footer > div.btn-group.btn-group-justified.text-uppercase.text-center > a:nth-child(3)")
    private WebElement audioFilesButton;


    public ChartsDemoPage(WebDriver driver){
        super(driver);
    }
}