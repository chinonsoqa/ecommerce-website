package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;


public class TC_1_2_PageObject {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public TC_1_2_PageObject(WebDriver driver) {
        this.driver = driver;
    }

    //Locators Added from TC_1_1B_PageObject Start
    By accountPage = By.linkText("Account");
    //Locators Added from TC_1_1B_PageObject End

    By userName = By.id("username");
    By password = By.id("password");
    By loginButton = By.name("login");
    By dashBoard = By.linkText("Dashboard");

    //Actions

    //Methods Added from TC_1_1_PageObject Start
    public void homePage() throws InterruptedException {
        String ExpectedTitle = "AskOmDch – Become a Selenium automation expert!";
        driver.get("https://askomdch.com");
        String ActualTitle = driver.getTitle();
        Thread.sleep(3000);

        // Verify you are on the correct web page
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("The Title of the Application is: " + ActualTitle);
    }
    //Methods Added from TC_1_1_PageObject End


    //Methods Added from TC_1_1B_PageObject Start
    public void accountPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement accountPage = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account")));

        // Assert the element is displayed
        assertTrue("The 'Account' menu is not displayed on the page.", accountPage.isDisplayed());

        // Click on the 'Account' menu
        accountPage.click();
    }
    //Methods Added from TC_1_1B_PageObject End

    public void enterUserName() {
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("user1");
        assert userName.getAttribute("value").equals("user1");
    }

    public void enterPassword() {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("testing1");
        Assert.assertEquals("testing1", password.getAttribute("value"));
        //Assert.assertEquals("testing1", password.getAttribute("id"));
        //assert password.getAttribute("value").equals("testing1");
    }


    public void clickLoginButton() {
        WebElement LoginButton = driver.findElement(By.name("login"));
        LoginButton.click();

        //assert LoginButton.getAttribute("value").equals("login");
        assert driver.getCurrentUrl().equals("https://askomdch.com/account/");
    }

    public void verifyDashBoard() {
        try {
            WebElement dashBoard = driver.findElement(By.linkText("Dashboard"));

            // Check that the element is displayed
            assertTrue("Dashboard is not displayed", dashBoard.isDisplayed());

            // Check that the text is correct
            assertEquals("Dashboard text is incorrect", "Dashboard", dashBoard.getText());
        } catch (NoSuchElementException e) {
            fail("Dashboard element not found: " + e.getMessage());
        }
    }





}







