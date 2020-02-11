package pageobjects.alerts_and_modals_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

import java.io.File;

public class FileDownloadPage extends PageObject {
    //this webelement is for File Download page
    @FindBy(css = "#textbox")
    private WebElement enterDataAreaField;
    @FindBy(css = "#create")
    private WebElement generateFileButton;
    @FindBy(css = "#link-to-download")
    private WebElement downloadLink;

    public FileDownloadPage(WebDriver driver){
        super(driver);
    }

    @Step
    public FileDownloadPage fileDownload(String input, String pathFile){
        this.enterDataAreaField.sendKeys(input);
        this.generateFileButton.click();
        File f = new File(pathFile);
        f.delete();
        /*boolean b = f.delete();
        if(b){
            System.out.println("The old file was deleted!");
        }*/

        this.downloadLink.click();

        return new FileDownloadPage(driver);
    }
}
