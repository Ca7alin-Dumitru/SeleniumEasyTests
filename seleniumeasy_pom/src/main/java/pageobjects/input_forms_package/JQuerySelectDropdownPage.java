package pageobjects.input_forms_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class JQuerySelectDropdownPage extends PageObject {
    //this webelement is for Drop Down with Search Box section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div.panel-body > span > span.selection > span")
    private WebElement selectCountryDropdown;
    @FindBy(css = "body > span > span > span.select2-search.select2-search--dropdown > input")
    private WebElement selectCountrySearchField;


    //this webelement is for Drop Down with Search Box section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div.panel-body > span > span.selection > span")
    private WebElement selectMultipleStateDropdown;

    //this webelement is for Drop Down with Disabled valued Section
    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > div.panel-body > span > span.selection > span")
    private WebElement selectUSTerritoriesDropdown;
    @FindBy(css = "body > span > span > span.select2-search.select2-search--dropdown > input")
    private WebElement searchUSTerritoriesDropdown;

    //this webelement is for Drop Down with Disabled valued Section
    @FindBy(css = "#files")
    private WebElement selectAFileDropDownWithCategoryRelatedOptions;

    public JQuerySelectDropdownPage(WebDriver driver){
        super(driver);
    }

    public JQuerySelectDropdownPage dropDownWithSearchBoxsection(String country){
        this.selectCountryDropdown.click();
        this.selectCountrySearchField.sendKeys(country);
        this.selectCountrySearchField.sendKeys(Keys.ENTER);

        return new JQuerySelectDropdownPage(driver);
    }

    public JQuerySelectDropdownPage selectMultipleValueSection(String [] states){
        for(String state : states){
            new Actions(driver).sendKeys(selectMultipleStateDropdown, state).perform();
            this.selectMultipleStateDropdown.sendKeys(Keys.ENTER);
        }

        for(int i = 0; i < states.length; i++){
            driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div >" +
                    " div.panel-body > span > span.selection > span > ul > li:nth-child(1) > span")).click();
        }

        return new JQuerySelectDropdownPage(driver);
    }

    public JQuerySelectDropdownPage dropdownWithDisabledValuesSection(String usOutlyingTerritories){
        this.selectUSTerritoriesDropdown.click();
        this.searchUSTerritoriesDropdown.sendKeys(usOutlyingTerritories);
        this.searchUSTerritoriesDropdown.sendKeys(Keys.ENTER);

        return new JQuerySelectDropdownPage(driver);
    }

    public JQuerySelectDropdownPage dropdownWithCategoryRelatedOptions(String selectAFile){
        this.selectAFileDropDownWithCategoryRelatedOptions.click();
        this.selectAFileDropDownWithCategoryRelatedOptions.sendKeys(selectAFile);
        this.selectAFileDropDownWithCategoryRelatedOptions.sendKeys(Keys.ENTER);

        return new JQuerySelectDropdownPage(driver);
    }
}