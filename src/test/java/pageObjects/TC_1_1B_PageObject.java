package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_1_1B_PageObject {

        public WebDriver driver;
        public WebDriverWait wait;

        //Constructor
        public TC_1_1B_PageObject(WebDriver driver) {
            this.driver = driver;
        }

        //Locators Added from TC_1_1_PageObject Start
        By accountPage = By.linkText("Account");
        By userName = By.id("reg_username");
        By emailAddress = By.id("reg_email");
        By password = By.id("reg_password");
        By registerButton = By.name("register");
        By alreadyRegisteredErrorAlert = By.xpath("//*[@class='woocommerce-error']");
        //Locators Added from TC_1_1_PageObject End

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

        public void accountPage()  {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement accountPage = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account")));

                // Assert the element is displayed
                Assert.assertTrue("The 'Account' menu is not displayed on the page.", accountPage.isDisplayed());

                // Click on the 'Account' menu
                accountPage.click();
        }

        public void userName(){
                WebElement userName = driver.findElement(By.id("reg_username"));
                userName.sendKeys("user1");
                Assert.assertEquals("reg_username", userName.getDomProperty("id"));
        }

        public void emailAddress() {
                WebElement emailAddress = driver.findElement(By.id("reg_email"));
                emailAddress.sendKeys("email4automatedtesting@gmail.com");
                Assert.assertEquals("reg_email", emailAddress.getDomProperty("id"));
        }

        public void password() {
                WebElement password = driver.findElement(By.id("reg_password"));
                password.sendKeys("testing1");
                Assert.assertEquals("reg_password", password.getDomProperty("id"));
        }

        public void registerButton()  {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("register")));

                // Assert the element is clickable
                Assert.assertTrue("The 'register' button is not clickable on the page.", registerButton.isDisplayed());

                // Click on the 'register' button
                registerButton.click();
        }
        //Methods Added from TC_1_1_PageObject End

        public void alreadyRegisteredErrorAlert() {
                // Wait for the alert to appear (use explicit wait)
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement alreadyRegisteredErrorAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='woocommerce-error']")));

                // Get the actual alert text
                String actualAlertText = alreadyRegisteredErrorAlert.getText();

                // Define the expected messages
                String expectedErrorAlertText = " An account is already registered with your email address.";

                // Validate the alert text
                Assert.assertTrue(" An account is already registered with your email address.", actualAlertText.contains(expectedErrorAlertText));
                System.out.println(expectedErrorAlertText);
        }

























    }









