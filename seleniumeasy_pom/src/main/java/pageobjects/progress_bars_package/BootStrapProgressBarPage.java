package pageobjects.progress_bars_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class BootStrapProgressBarPage extends PageObject {
    //this webelement is for Bootstrap Progress bar page
    @FindBy(css = "#cricle-btn")
    private WebElement downloadButton;

    public BootStrapProgressBarPage(WebDriver driver){
        super(driver);
    }

    public BootStrapProgressBarPage progressBarForDownloadCheck(){
        this.downloadButton.click();

        return new BootStrapProgressBarPage(driver);
    }
}