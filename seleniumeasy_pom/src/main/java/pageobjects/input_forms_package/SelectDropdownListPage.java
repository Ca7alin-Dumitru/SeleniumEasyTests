package pageobjects.input_forms_package;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.PageObject;

public class SelectDropdownListPage extends PageObject {
    //this webelement is for Select List Demo section
    @FindBy(css = "#select-demo")
    private WebElement daySelectDropDown;
    @FindBy(xpath = "//option[@value='Sunday']")
    private WebElement sunday;
    @FindBy(xpath = "//option[@value='Monday']")
    private WebElement monday;
    @FindBy(xpath = "//option[@value='Tuesday']")
    private WebElement tuesday;
    @FindBy(xpath = "//option[@value='Wednesday']")
    private WebElement wednesday;
    @FindBy(xpath = "//option[@value='Thursday']")
    private WebElement thursday;
    @FindBy(xpath = "//option[@value='Friday']")
    private WebElement friday;
    @FindBy(xpath = "//option[@value='Saturday']")
    private WebElement saturday;

    //these webelements are for Multi Select List Demo section
    @FindBy(css = "#multi-select")
    private WebElement multiValuesSelectionBox;
    @FindBy(xpath = "//option[@value='California']")
    private WebElement california;
    @FindBy(xpath = "//option[@value='Florida']")
    private WebElement florida;
    @FindBy(xpath = "//option[@value='New Jersey']")
    private WebElement newJersey;
    @FindBy(xpath = "//option[@value='New York']")
    private WebElement newYork;
    @FindBy(xpath = "//option[@value='Ohio']")
    private WebElement ohio;
    @FindBy(xpath = "//option[@value='Texas']")
    private WebElement texas;
    @FindBy(xpath = "//option[@value='Pennsylvania']")
    private WebElement pennsylvania;
    @FindBy(xpath = "//option[@value='Washington']")
    private WebElement washington;
    @FindBy(id = "printMe")
    private WebElement firstSelectedButton;
    @FindBy(id = "printAll")
    private WebElement getAllSelectedButton;

    public SelectDropdownListPage(WebDriver driver){
        super(driver);
    }

    @Step
    public SelectDropdownListPage selectListDemoSection(String day){
        if(day.equalsIgnoreCase("sunday")){
            this.sunday.click();
        } else if(day.equalsIgnoreCase("monday")){
            this.monday.click();
        } else if(day.equalsIgnoreCase("tuesday")){
            this.tuesday.click();
        } else if(day.equalsIgnoreCase("wednesday")){
            this.wednesday.click();
        } else if(day.equalsIgnoreCase("thursday")){
            this.thursday.click();
        } else if(day.equalsIgnoreCase("friday")){
            this.friday.click();
        } else if(day.equalsIgnoreCase("saturday")){
            this.saturday.click();
        }

        return new SelectDropdownListPage(driver);
    }

    @Step
    public SelectDropdownListPage multiSelectListDemoSection(String [] states){
        Select stat = new Select(multiValuesSelectionBox);
        for (String state : states){
            if(state.equalsIgnoreCase("california")){
                stat.selectByVisibleText("California");
                //((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.california);
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='California']\"); element.click()");
            }
            if(state.equalsIgnoreCase("florida")){
                stat.selectByVisibleText("Florida");
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='Florida']\"); element.click()");
            }
            if(state.equalsIgnoreCase("new jersey")){
                stat.selectByVisibleText("New Jersey");
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='New Jersey']\"); element.click()");
            }
            if(state.equalsIgnoreCase("new york")){
                stat.selectByVisibleText("New York");
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='New York']\"); element.click()");
            }
            if(state.equalsIgnoreCase("ohio")){
                stat.selectByVisibleText("Ohio");
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='Ohio']\"); element.click()");
            }
            if(state.equalsIgnoreCase("texas")){
                stat.selectByVisibleText("Texas");
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='Texas']\"); element.click()");
            }
            if(state.equalsIgnoreCase("pennsylvania")){
                stat.selectByVisibleText("Pennsylvania");
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='Pennsylvania']\"); element.click()");
            }
            if(state.equalsIgnoreCase("washington")){
                stat.selectByVisibleText("Washington");
                ((JavascriptExecutor) driver).executeScript("element = document.querySelector(\"option[value='Washington']\"); element.click()");//without this line in mozilla doesn't work
            }

            this.firstSelectedButton.click();
            this.getAllSelectedButton.click();
        }

        return new SelectDropdownListPage(driver);
    }


}