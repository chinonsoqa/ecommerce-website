package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TC_1_1B_PageObject;
import pageObjects.TC_1_1_PageObject;
import utils.TestContextSetUp;

public class TC_1_1B {
    TestContextSetUp testContextSetUp;
    TC_1_1B_PageObject tc_101_01_01_01b_pageObject;

    //Constructor
    public TC_1_1B(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.tc_101_01_01_01b_pageObject = testContextSetUp.pageObjectManager.getTC1_1bPageObject();

    }
    // Steps

    @Given("the user has completed the signup form")
    public void the_user_has_completed_the_signup_form() throws InterruptedException {
        tc_101_01_01_01b_pageObject.homePage();
        tc_101_01_01_01b_pageObject.accountPage();
        tc_101_01_01_01b_pageObject.userName();
        tc_101_01_01_01b_pageObject.emailAddress();
        tc_101_01_01_01b_pageObject.password();
    }
    @When("the user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button() {
        tc_101_01_01_01b_pageObject.registerButton();
    }
    @Then("the user should get an error message")
    public void the_user_should_get_an_error_message() {
        tc_101_01_01_01b_pageObject.alreadyRegisteredErrorAlert();
    }













}
