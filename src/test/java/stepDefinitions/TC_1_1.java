package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TC_1_1_PageObject;
import utils.TestContextSetUp;

public class TC_1_1 {

    TestContextSetUp testContextSetUp;
    TC_1_1_PageObject tc_101_01_01_01_pageObject;

    //Constructor
    public TC_1_1(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.tc_101_01_01_01_pageObject = testContextSetUp.pageObjectManager.getTC1_1PageObject();

    }
    // Steps

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() throws InterruptedException {
        tc_101_01_01_01_pageObject.homePage();
    }
    @When("the user clicks on the accounts link")
    public void the_user_clicks_on_the_accounts_link() {
        tc_101_01_01_01_pageObject.accountPage();
    }
    @When("the user enters a username")
    public void the_user_enters_a_username() {
        tc_101_01_01_01_pageObject.userName();
    }
    @When("the user enters an email address")
    public void the_user_enters_an_email_address() {
        tc_101_01_01_01_pageObject.emailAddress();
    }
    @When("the user enters a password")
    public void the_user_enters_a_password() {
        tc_101_01_01_01_pageObject.password();
    }
    @When("the user clicks on the register button")
    public void the_user_clicks_on_the_register_button() {
        tc_101_01_01_01_pageObject.registerButton();
    }
    @Then("the user should be registered and navigated to the dashboard")
    public void the_user_should_be_registered_and_navigated_to_the_dashboard() {
        tc_101_01_01_01_pageObject.dashBoard();
    }







}
