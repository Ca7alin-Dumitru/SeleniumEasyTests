package layer.higher.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import layer.middle.SeleniumeasyTests;
import pageobjects.input_forms_package.InputFormSubmitPage;

public class StepDefinitions {
    SeleniumeasyTests test;
    int count = 0;

    //createAnUser.feature
    @Given("^I have (\\w+) browser$")
    public void i_have_chrome_browser(String arg1) throws Exception{
        test = new SeleniumeasyTests();
        test.startFlow(arg1);
    }

    @When("^I am on the Input form with validations page$")
    public void i_am_on_the_input_form_with_validation_page() throws Exception {
        test.goTo("https://www.seleniumeasy.com/test/input-form-demo.html");
    }

    @And("^I fill the form fields with some inputs$")
    public void i_fill_the_form_fields_with_some_inputs() throws Exception {
        test.verifyInputFormSubmitPageTests();
    }

    @Then("^I click on the Send button$")
    public void i_click_on_the_send_button() {
        test.tearDown();
    }

    @Then("^The fields contains the text inputted$")
    public void the_fields_contains_the_text_inputted() {
        test.tearDown();
    }

    //viewChartsDemo.feature
    @When("^I open the Others menu$")
    public void i_open_the_others_menu() throws Exception {
            test.verifyMainMenu();
    }

    @And("^The drop down displays me a Charts Demo button$")
    public void the_drop_down_displays_me_a_charts_demo_button() throws Exception {
        test.goTo("https://www.seleniumeasy.com/test/charts-mouse-hover-demo.html");
    }

    @Then("^I click on the Charts Demo button$")
    public void i_click_on_the_charts_demo_button() {
        test.tearDown();
    }

    @And("^The url is changed with https://www.seleniumeasy.com/test/charts-mouse-hover-demo.html$")
    public void the_url_is_changed() {
    }
}
