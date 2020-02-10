package pageobjects.progress_bars_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class DragAndDropSlidersPage extends PageObject {
    //these webelements are for Drag & Drop Sliders page
    //left sliders
    @FindBy(css = "#slider1 > div > input[type=range]")
    private WebElement firstLeftSlider;
    @FindBy(css = "#slider3 > div > input[type=range]")
    private WebElement secondLeftSlider;
    @FindBy(css = "#slider5 > div > input[type=range]")
    private WebElement thirdLeftSlider;
    //right slider
    @FindBy(css = "#slider2 > div > input[type=range]")
    private WebElement firstRightSlider;
    @FindBy(css = "#slider4 > div > input[type=range]")
    private WebElement secondRightSlider;
    @FindBy(css = "#slider6 > div > input[type=range]")
    private WebElement thirdRightSlider;

    public DragAndDropSlidersPage(WebDriver driver){
        super(driver);
    }

    public DragAndDropSlidersPage firstLeftSliderMoves(int positionFirstLeftSlider, int positionSecondLeftSlider, int positionThirdLeftSlider,
                                                       int positionFirstRightSlider, int positionSecondRightSlider, int positionThirdRightSlider){
        Actions actions = new Actions(driver);
        actions.moveToElement(this.firstLeftSlider, positionFirstLeftSlider,0).click().perform();
        actions.moveToElement(this.secondLeftSlider,positionSecondLeftSlider,0).click().perform();
        actions.moveToElement(this.thirdLeftSlider,positionThirdLeftSlider,0).click().perform();
        actions.moveToElement(this.firstRightSlider,positionFirstRightSlider,0).click().perform();
        actions.moveToElement(this.secondRightSlider,positionSecondRightSlider,0).click().perform();
        actions.moveToElement(this.thirdRightSlider,positionThirdRightSlider,0).click().perform();
        //System.out.println(this.thirdLeftSlider.getSize().width);

        return new DragAndDropSlidersPage(driver);
    }
}