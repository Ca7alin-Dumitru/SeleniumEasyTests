package layer.middle;

import data.generator.Address;
import data.generator.Name;
import io.github.bonigarcia.wdm.WebDriverManager;
import library.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.DemoHomePage;
import pageobjects.alerts_and_modals_package.*;
import pageobjects.common_elements.footer.FooterMenus;
import pageobjects.common_elements.header.HeaderObject;
import pageobjects.common_elements.left_menu.MenuListLeftSide;
import pageobjects.common_elements.main_menu.MainMenu;
import pageobjects.date_pickers_package.BootstrapDatePickerPage;
import pageobjects.date_pickers_package.JQueryDatePickerPage;
import pageobjects.input_forms_package.*;
import pageobjects.list_box_package.BootstrapListBoxPage;
import pageobjects.list_box_package.DataListFilterPage;
import pageobjects.list_box_package.JQueryListBoxPage;
import pageobjects.others_package.DragAndDropPage;
import pageobjects.others_package.DynamicDataLoadingPage;
import pageobjects.progress_bars_package.BootStrapProgressBarPage;
import pageobjects.progress_bars_package.DragAndDropSlidersPage;
import pageobjects.progress_bars_package.JQueryDownloadProgressBarsPage;
import pageobjects.table_package.TableDataSearchPage;
import pageobjects.table_package.TableFilterPage;
import pageobjects.table_package.TablePaginationPage;
import pageobjects.table_package.TableSortAndSearchPage;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SeleniumeasyTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    @Parameters({"browserName"})
    public void startFlow(String browser) throws Exception{
        //Check if parameter passed as 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //set path to firefoxdriver.exe
            WebDriverManager.firefoxdriver().setup();
            // Creating firefox profile
            FirefoxProfile profile = new FirefoxProfile();
            // Instructing firefox to use custom download location
            profile.setPreference("browser.download.folderList", 2);
            // Setting custom download directory
            profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources");
            // Skipping Save As dialog box for types of files with their MIME
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                    "text/csv, application/java-archive, application/x-msexcel, application/excel, application/vnd.openxmlformats-officedocument.wordprocessingml.document, " +
                            "application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml," +
                            "application/vnd.microsoft.portable-executable");
            // Creating FirefoxOptions to set profile
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            // Launching browser with desired capabilities
            driver = new FirefoxDriver(options);
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            Map<String, Object> prefs = new HashMap<String, Object>();
            // Use File.separator as it will work on any OS
            prefs.put("download.default_directory",
                    System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources");
            // Adding cpabilities to ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            //create chrome instance
            driver = new ChromeDriver(options);
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("edge")){
            //set path to Edge.exe
            WebDriverManager.edgedriver().setup();
            //create Edge instance
            driver = new EdgeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        //driver.get("https://www.seleniumeasy.com/test/");
    }

    @Test
    public void verifyAjaxFormSubmitPageTestsWithDataGenerator() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
        AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage(driver);
        assertTrue(driver.findElement(By.id("btn-submit")).isDisplayed());

        String name = Name.fullName();
        String comment = Name.lastName() + " from " + Address.fullAddress() + " automation";

        ajaxFormSubmitPage.inputFormWithLoadingIcon(name,comment);
        assertTrue(driver.findElement(By.id("submit-control")).isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("submit-control")), "Ajax Request is Processing!"));
        assertEquals("Ajax Request is Processing!",driver.findElement(By.id("submit-control")).getText());
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("submit-control")), "Form submited Successfully!"));
        assertEquals("Form submited Successfully!",driver.findElement(By.id("submit-control")).getText());
    }

    @Test(dataProvider="formValuesWithExcel", dataProviderClass = dataprovider.InputFormExcel.class)
    public void verifyInputFormSubmitPageTestsWithDataProviderExcel(String firstName,
                                                               String lastName,
                                                               String eMail,
                                                               String phone,
                                                               String address,
                                                               String city,
                                                               String state,
                                                               String zipCode,
                                                               String websiteOrDomainName,
                                                               String hosting,
                                                               String projectDescription) throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        InputFormSubmitPage inputFormSubmitPage = new InputFormSubmitPage(driver);
        inputFormSubmitPage.
                inputFormAndSubmit(firstName,
                        lastName,
                        eMail,
                        phone,
                        address,
                        city,
                        state,
                        zipCode,
                        websiteOrDomainName,
                        hosting,
                        projectDescription);
    }

    @Test(dataProvider="formValuesWithClass", dataProviderClass = dataprovider.InputFormClass.class)
    public void verifyInputFormSubmitPageTestsWithDataProviderClass(String firstName,
                                                               String lastName,
                                                               String eMail,
                                                               String phone,
                                                               String address,
                                                               String city,
                                                               String state,
                                                               String zipCode,
                                                               String websiteOrDomainName,
                                                               String hosting,
                                                               String projectDescription) throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        InputFormSubmitPage inputFormSubmitPage = new InputFormSubmitPage(driver);
        inputFormSubmitPage.
                inputFormAndSubmit(firstName,
                        lastName,
                        eMail,
                        phone,
                        address,
                        city,
                        state,
                        zipCode,
                        websiteOrDomainName,
                        hosting,
                        projectDescription);
    }

    @Test
    public void verifyHeaderLogo() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/");
        HeaderObject headerObject = new HeaderObject(driver);
        headerObject.goToSeleniumEasyHome();
        assertEquals("Learn Selenium with Best Practices and Examples | Selenium Easy",driver.getTitle());
        driver.navigate().back();
        assertEquals("Selenium Easy - Best Demo website to practice Selenium Webdriver Online", driver.getTitle());
    }

    @Test
    public void verifyFooterMenus() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/");
        FooterMenus footerMenus = new FooterMenus(driver);
        footerMenus.goToApachePoi();
        assertEquals("https://www.seleniumeasy.com/apachepoi-tutorials",driver.getCurrentUrl());
        driver.navigate().back();
        assertEquals("Selenium Easy - Best Demo website to practice Selenium Webdriver Online", driver.getTitle());
    }

    @Test
    public void verifyLeftMenu() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/");
        MenuListLeftSide menuListLeftSide = new MenuListLeftSide(driver);
        menuListLeftSide.leftMenuExpandAndGoToAPage();

        assertEquals("Selenium Easy - Table Data Filter Demo", driver.getTitle());
    }

    @Test
    public void verifyMainMenu() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/");
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.goToChartsDemoPage();

        assertEquals("Selenium Easy - Charts Mouse Hover",driver.getTitle());
    }

    @Test
    public void verifyDemoHomePageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/");
        DemoHomePage demoHomePage = new DemoHomePage(driver);
        demoHomePage.doThingsWithCarusel();
        assertTrue(driver.findElement(By.xpath("//*[@class='carousel-indicators']/li[@data-slide-to=0]")).isDisplayed());

        demoHomePage.usingTheWizardProceedButtons().usingTheWizardMainButtons().goToDragAndDropPage();
        assertEquals("Selenium Easy - Drag and Drop Range Sliders",driver.getTitle());
    }

    @Test
    public void verifyChartsDemoPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/charts-mouse-hover-demo.html");
        assertEquals("Selenium Easy - Charts Mouse Hover", driver.getTitle());
    }

    @Test
    public void verifyDynamicDataLoading() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        DynamicDataLoadingPage dynamicDataLoadingPage = new DynamicDataLoadingPage(driver);
        dynamicDataLoadingPage.getNewUser();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#loading > img"))));
        assertTrue(driver.findElement(By.cssSelector("#loading > img")).isDisplayed());
    }

    @Test
    public void verifyDragAndDropPageTests() throws Exception{
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        String [] items = {"drag1"};
        dragAndDropPage.dragAndDropItems(items);
        assertTrue(driver.findElement(By.cssSelector("#droppedlist > span")).isDisplayed());
    }

    @Test
    public void verifyDataListFilterPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/data-list-filter-demo.html");
        DataListFilterPage dataListFilterPage = new DataListFilterPage(driver);
        dataListFilterPage.searchAttendees("test3");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text() = 'Email: test1@company.com']"))));
        assertTrue(driver.findElement(By.xpath("//span[text() = 'Email: test3@company.com']")).isDisplayed());

        dataListFilterPage.searchAttendees();
        assertTrue(driver.findElement(By.xpath("//span[text() = 'Email: test1@company.com']")).isDisplayed());
    }

    @Test
    public void verifyJQueryListBoxPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
        JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage(driver);
        jQueryListBoxPage.addAndRemoveAll();
    }

    @Test
    public void verifyBootstrapListBoxPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");
        BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(driver);
        bootstrapListBoxPage.moveItemsBetweenLeftAndRight();
    }

    @Test
    public void verifyFileDownloadPageTests() throws Exception{
        driver.get("https://www.seleniumeasy.com/test/generate-file-to-download-demo.html");
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        String actualResult = "";
        String fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "easyinfo.txt";

        fileDownloadPage.fileDownload("This is a test for automation!", fileName);
        Thread.sleep(5000);
        try{
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)
                    )
            );

            String line = null;

            while((line = in.readLine()) != null){
                //System.out.println(line);
                actualResult += line;
            }

            in.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals("This is a test for automation!", actualResult);
    }

    @Test
    public void verifyJavaScriptALertsPageTests(){
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.alertBoxDialog();
        Alert alert = driver.switchTo().alert();
        assertEquals("I am an alert box!", alert.getText());
        alert.accept();

        javaScriptAlertsPage.confirmBoxDialog();
        alert = driver.switchTo().alert();
        assertEquals("Press a button!", alert.getText());
        alert.dismiss();
        assertEquals("You pressed Cancel!",driver.findElement(By.id("confirm-demo")).getText());

        javaScriptAlertsPage.promptBoxDialog();
        alert = driver.switchTo().alert();
        assertEquals("Please enter your name", alert.getText());
        alert.sendKeys("automation");
        alert.accept();
        assertEquals("You have entered 'automation' !",driver.findElement(By.id("prompt-demo")).getText());
    }

    @Test
    public void verifyProgressBarModalPageTests(){
        driver.get("https://www.seleniumeasy.com/test/bootstrap-progress-bar-dialog-demo.html");
        ProgressBarModalPage progressBarModalPage = new ProgressBarModalPage(driver);
        progressBarModalPage.showSimpleDialog();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.modal.fade > div > div")));

    }

    @Test
    public void verifyWindowPopupModalPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);
        windowPopupModalPage.followOnTwitterActions().likeUsOnFacebookActions().followTwitterAndFabeeokActions().followAllButton();
        String mainWindow = driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext()) {
            String ChildWindow=i1.next();
            if(!mainWindow.equalsIgnoreCase(ChildWindow)){
                driver.switchTo().window(ChildWindow);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    @Test
    public void verifyBoostrapModalsPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
        BootstrapModalsPage bootstrapModalsPage = new BootstrapModalsPage(driver);
        bootstrapModalsPage.singleModalExampleSection();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='myModal0']/div/div"))));
        assertTrue(driver.findElement(By.xpath("//*[@id='myModal0']/div/div")).isDisplayed());
        bootstrapModalsPage.singleModalExampleSection("close");
    }

    @Test
    public void verifyBootstrapAlertsPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
        BootstrapAlertsPage bootstrapAlertsPage = new BootstrapAlertsPage(driver);
        bootstrapAlertsPage.alertMessages("success");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".alert.alert-success.alert-autocloseable-success")));
        assertFalse(driver.findElement(By.cssSelector(".alert.alert-success.alert-autocloseable-success")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".alert.alert-success.alert-normal-success")).isDisplayed());
    }

    @Test
    public void verifyDragAndDropSlidersPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        DragAndDropSlidersPage dragAndDropSlidersPage = new DragAndDropSlidersPage(driver);
        dragAndDropSlidersPage.firstLeftSliderMoves(25,
                0,
                -44,
                44,
                -30,
                80);
        assertNotEquals("50",driver.findElement(By.id("rangeDanger")).getText());
    }

    @Test
    public void verifyBootstrapProgressBarPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        BootStrapProgressBarPage bootStrapProgressBarPage = new BootStrapProgressBarPage(driver);
        assertTrue(driver.findElement(By.id("cricle-btn")).isDisplayed());
        assertEquals("0%",driver.findElement(By.className("percenttext")).getText());
        bootStrapProgressBarPage.progressBarForDownloadCheck();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("percenttext")), "100%"));
    }

    @Test
    public void verifyJQueryDownloadProgressBarsPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        JQueryDownloadProgressBarsPage jQueryDownloadProgressBarsPage = new JQueryDownloadProgressBarsPage(driver);
        jQueryDownloadProgressBarsPage.startDownloadProcess();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("progress-label")), "Complete!"));
        assertTrue(driver.findElement(By.className("progress-label")).isDisplayed());
        jQueryDownloadProgressBarsPage.closeDownloadProcess();
        assertFalse(driver.findElement(By.className("progress-label")).isDisplayed());
    }

    @Test
    public void verifyTableDataDownloadPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
        assertEquals("Selenium Easy - Download Table Data to CSV, Excel, PDF and Print", driver.getTitle());
    }

    @Test
    public void verifyTableSortAndSearchPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
        TableSortAndSearchPage tableSortAndSearchPage = new TableSortAndSearchPage(driver);
        assertTrue(driver.findElement(By.xpath("//td[text() = 'A. Cox']")).isDisplayed());
        tableSortAndSearchPage.sortByAgeTable(0);
        assertTrue(driver.findElement(By.xpath("//td[text() = '19']")).isDisplayed());
        tableSortAndSearchPage.sortByAgeTable(100);
        assertTrue(driver.findElement(By.xpath("//td[text() = 'A. Cox']")).isDisplayed());
    }

    @Test
    public void verifyTableFilterPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/table-records-filter-demo.html");
        TableFilterPage tableFilterPage = new TableFilterPage(driver);
        tableFilterPage.filterRecords("green");
        assertTrue(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-sm-7.text-left > section > " +
                "div > div > div.panel-body > div.table-container > table > tbody > tr:nth-child(1)")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-sm-7.text-left > section > " +
                "div > div > div.panel-body > div.table-container > table > tbody > tr:nth-child(2)")).isDisplayed());
        tableFilterPage.filterRecords("all");
        assertTrue(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-sm-7.text-left > section > " +
                "div > div > div.panel-body > div.table-container > table > tbody > tr:nth-child(2)")).isDisplayed());
    }

    @Test
    public void verifyTableDataSearchPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage(driver);
        tableDataSearchPage.tasksSection("in progress").listedUsersSection("2");
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//td[text() = 'in progress']")), "in progress"));
        assertTrue(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > " +
                "div.col-md-6.text-left > div:nth-child(3) > div > table > thead > tr > th:nth-child(1) > input")).isEnabled());
        assertTrue(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > " +
                "div > table > tbody > tr:nth-child(2)")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > " +
                "div.col-md-6.text-left > div:nth-child(3) > div > table > tbody > tr:nth-child(1)")).isDisplayed());

        tableDataSearchPage.tasksSection().listedUsersSection();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//td[text() = 'completed']")), "completed"));
        assertFalse(driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > " +
                "div.col-md-6.text-left > div:nth-child(3) > div > table > thead > tr > th:nth-child(1) > input")).isEnabled());

    }

    @Test
    public void verifyTablePaginationPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
        TablePaginationPage tablePaginationPage = new TablePaginationPage(driver);

        tablePaginationPage.tablePaginationChanges();
        assertTrue(driver.findElement(By.xpath("//a[text() = 1]")).getAttribute("class").equals("page_link active"));
    }

    @Test
    public void verifyJQueryDatePickerPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
        JQueryDatePickerPage jQueryDatePickerPage = new JQueryDatePickerPage(driver);

        jQueryDatePickerPage.dateRangePicker("04/03/2020","05/03/2020");

    }

    @Test
    public void verifyBootstrapDatePickerPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        BootstrapDatePickerPage bootstrapDatePickerPage = new BootstrapDatePickerPage(driver);

        assertEquals("dd/mm/yyyy",driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).getAttribute("placeholder"));
        bootstrapDatePickerPage.dateExampleSection("02/02/2020");
        new Actions(driver).click(driver.findElement(By.cssSelector(".input-group-addon"))).perform();
        assertEquals("2",driver.findElement(By.xpath("//td[contains(@class,'active')]")).getText());

        bootstrapDatePickerPage.dateRangeExampleSection("02/02/2020","08/09/2020");
    }

    @Test
    public void verifyJQuerySelectDropdownPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage(driver);

        String [] states = {"Alaska", "Colorado", "Alabama", "Kansas", "Louisiana"};
        jQuerySelectDropdownPage.
                dropDownWithSearchBoxsection("japan").
                selectMultipleValueSection(states).
                dropdownWithDisabledValuesSection("Virgin Islands").
                dropdownWithCategoryRelatedOptions("c");
        assertEquals("Japan",driver.findElement(By.id("select2-country-container")).getText());
        assertEquals("Select state(s)", driver.findElement(By.className("select2-search__field")).getAttribute("placeholder"));
        assertEquals("Virgin Islands", driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > div.panel-body > span > span.selection > span > span")).getText());
        assertTrue(driver.findElement(By.cssSelector("#files > optgroup:nth-child(2) > option:nth-child(1)")).isSelected());
    }

    @Test
    public void verifyAjaxFormSubmitPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
        AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage(driver);
        assertTrue(driver.findElement(By.id("btn-submit")).isDisplayed());
        ajaxFormSubmitPage.inputFormWithLoadingIcon("test","Say hello for my test!");
        assertTrue(driver.findElement(By.id("submit-control")).isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("submit-control")), "Ajax Request is Processing!"));
        assertEquals("Ajax Request is Processing!",driver.findElement(By.id("submit-control")).getText());
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("submit-control")), "Form submited Successfully!"));
        assertEquals("Form submited Successfully!",driver.findElement(By.id("submit-control")).getText());
    }

    @Test
    public void verifyInputFormSubmitPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        InputFormSubmitPage inputFormSubmitPage = new InputFormSubmitPage(driver);
        inputFormSubmitPage.
                inputFormAndSubmit("test1",
                        "test2",
                        "test2@test1.com",
                        "(845)111-999",
                        "Street Hello, No. 1",
                        "My City",
                        "New Mexico",
                        "99999",
                        "www.automation.com",
                        "no",
                        "this is a test form project");
    }

    @Test
    public void verifySelectDropdownListPagePositiveTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        String [] states = {"California", "Florida", "New Jersey", "New York"}; //{"California", "Florida", "New Jersey", "New York", "Ohio", "Texas", "Pennsylvania", "Washington"}
        String day = "Friday";
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        assertFalse(driver.findElement(By.className("selected-value")).isDisplayed());
        assertFalse(driver.findElement(By.className("getall-selected")).isDisplayed());
        selectDropdownListPage.
                selectListDemoSection(day).
                multiSelectListDemoSection(states);
        assertTrue(driver.findElement(By.className("selected-value")).isDisplayed());
        assertTrue(driver.findElement(By.className("getall-selected")).isDisplayed());
        assertEquals("Day selected :- " + day,driver.findElement(By.className("selected-value")).getText());
        assertEquals("Options selected are : " + states[states.length-1],driver.findElement(By.className("getall-selected")).getText());
    }

    @Test
    public void verifyRadioButtonsDemoPagePositiveTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);
        radioButtonsDemoPage.radioButtonDemoSection("male");
        assertTrue(driver.findElement(By.className("radiobutton")).isDisplayed());
        assertEquals("Radio button 'Male' is checked",driver.findElement(By.className("radiobutton")).getText());

        radioButtonsDemoPage.radioButtonDemoSection("female");
        assertEquals("Radio button 'Female' is checked",driver.findElement(By.className("radiobutton")).getText());

        String sex = "female";
        int age = 5;
        String concat = "Sex : ";
        radioButtonsDemoPage.groupRadioButtonsDemoSection(sex,age);
        assertTrue(driver.findElement(By.className("groupradiobutton")).isDisplayed());

        if(sex.equalsIgnoreCase("male")){
            concat += "Male";
        } else if(sex.equalsIgnoreCase("female")){
            concat += "Female";
        } else {
            concat = "Sex : ";
        }

        if(age < 5 && age >= 0){
            concat += "\nAge group: 0 - 5";
        } else if(age < 15){
            concat += "\nAge group: 5 - 15";
        } else if(age < 50){
            concat += "\nAge group: 15 - 50";
        } else {
            concat = "Sex :\nAge group:" ;
        }

        assertEquals(concat,driver.findElement(By.className("groupradiobutton")).getText());
    }

    @Test
    public void verifyCheckboxDemoPageTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        //Single CheckBox Demo section tests
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);

        checkboxDemoPage.singleCheckboxDemoSection();
        //verify the 'click on this check box' is checked, displayed and shows the correct message
        assertTrue(driver.findElement(By.id("txtAge")).getCssValue("display").equalsIgnoreCase("block"));
        assertTrue(driver.findElement(By.id("txtAge")).isDisplayed());
        assertEquals("Success - Check box is checked",driver.findElement(By.id("txtAge")).getText());
        //verify the 'click on this check box' is unchecked
        checkboxDemoPage.singleCheckboxDemoSection();
        assertTrue(driver.findElement(By.id("txtAge")).getCssValue("display").equalsIgnoreCase("none"));

        //Multiple Checkbox Demo section tests
        checkboxDemoPage.
                multipleCheckboxDemoSection(1).
                multipleCheckboxDemoSection(2).
                multipleCheckboxDemoSection(3).
                multipleCheckboxDemoSection(4);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("check1")),"value","Uncheck All"));
        assertTrue(driver.findElement(By.id("check1")).getAttribute("value").contains("Uncheck All"));
        checkboxDemoPage.multipleCheckboxDemoSection(5);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("check1")),"value","Check All"));
        assertTrue(driver.findElement(By.id("check1")).getAttribute("value").contains("Check All"));
        checkboxDemoPage.multipleCheckboxDemoSection(5);
        assertTrue(driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label > input")).isSelected());
        assertTrue(driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(4) > label > input")).isSelected());
        assertTrue(driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(5) > label > input")).isSelected());
        assertTrue(driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(6) > label > input")).isSelected());
    }

    @Test
    public void verifySimpleFormDemoPageNegativeTests() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);
        simpleFormDemoPage.singleInputFieldSection("").
                twoInputFieldsSection("","");
        assertEquals("",driver.findElement(By.cssSelector("#display")).getText());
        assertEquals("NaN",driver.findElement(By.cssSelector("#displayvalue")).getText());
    }

    @Parameters({"message", "valueA", "valueB"})
    @Test
    public void verifySimpleFormDemoPagePositiveTests(@Optional ("I started to love automation since last year!") String message,
                                                      @Optional ("4") String valueA,
                                                      @Optional ("5") String valueB) throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        SimpleFormDemoPage sfmp = new SimpleFormDemoPage(driver);
        sfmp.singleInputFieldSection(message).
                twoInputFieldsSection(valueA,valueB);
        int a = Integer.parseInt(valueA);
        int b = Integer.parseInt(valueB);
        assertEquals(message,driver.findElement(By.cssSelector("#display")).getText());
        assertEquals(Integer.toString(a + b),driver.findElement(By.cssSelector("#displayvalue")).getText());
    }

    @Parameters({"browserName"})
    @AfterMethod
    public void tearDown(ITestResult result, String browser){
        if(ITestResult.SUCCESS != result.getStatus()){
            try{
                Utility.captureScreenshot(driver,browser + "_" + result.getName());
            }catch (Exception e) {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        driver.close();
    }
}
