package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TC_1_2_PageObject;
import utils.TestContextSetUp;


public class TC_1_2 {
    TestContextSetUp testContextSetUp;
    TC_1_2_PageObject tc_101_01_01_02_pageObject;

    //Constructor
    public TC_1_2(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.tc_101_01_01_02_pageObject = testContextSetUp.pageObjectManager.getTC1_2PageObject();

    }
    // Steps
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        tc_101_01_01_02_pageObject.homePage();
        tc_101_01_01_02_pageObject.accountPage();

    }
    @When("the user enters a valid username or email address")
    public void the_user_enters_a_valid_username_or_email_address() {
        tc_101_01_01_02_pageObject.enterUserName();
    }
    @When("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        tc_101_01_01_02_pageObject.enterPassword();
    }
    @When("clicks the login button")
    public void clicks_the_login_button() {
        tc_101_01_01_02_pageObject.clickLoginButton();
    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        tc_101_01_01_02_pageObject.verifyDashBoard();
    }













}
