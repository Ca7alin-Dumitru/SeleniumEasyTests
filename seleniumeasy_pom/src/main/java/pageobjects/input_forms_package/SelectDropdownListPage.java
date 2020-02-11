package pageobjects.input_forms_package;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    /*@FindBy(css = "#multi-select")
    private WebElement multiValuesSelectionBox;*/
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
        for (String state : states){
            if(state.equalsIgnoreCase("california")){
                this.california.click();
            }
            if(state.equalsIgnoreCase("florida")){
                this.florida.click();
            }
            if(state.equalsIgnoreCase("new jersey")){
                this.newJersey.click();
            }
            if(state.equalsIgnoreCase("new york")){
                this.newYork.click();
            }
            if(state.equalsIgnoreCase("ohio")){
                this.ohio.click();
            }
            if(state.equalsIgnoreCase("texas")){
                this.texas.click();
            }
            if(state.equalsIgnoreCase("pennsylvania")){
                this.pennsylvania.click();
            }
            if(state.equalsIgnoreCase("washington")){
                this.washington.click();
            }

            this.firstSelectedButton.click();
            this.getAllSelectedButton.click();
        }

        return new SelectDropdownListPage(driver);
    }


}