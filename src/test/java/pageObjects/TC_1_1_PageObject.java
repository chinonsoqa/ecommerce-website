package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Random;

public class TC_1_1_PageObject {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public TC_1_1_PageObject(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By accountPage = By.linkText("Account");
    By userName = By.id("reg_username");
    By emailAddress = By.id("reg_email");
    By password = By.id("reg_password");
    By registerButton = By.name("register");
    By dashBoard = By.xpath("//*[@class='woocommerce-MyAccount-content']");


    public void homePage() throws InterruptedException {
        String ExpectedTitle = "AskOmDch – Become a Selenium automation expert!";
        driver.get("https://askomdch.com");
        String ActualTitle = driver.getTitle();
        Thread.sleep(3000);

        // Verify you are on the correct web page
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println("The Title of the Application is: " + ActualTitle);
    }

    public void accountPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement accountPage = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account")));

        // Assert the element is displayed
        Assert.assertTrue("The 'Account' menu is not displayed on the page.", accountPage.isDisplayed());

        // Click on the 'Account' menu
        accountPage.click();
    }

    // Method to generate a random userName
    private String generateRandomUsername() {
        String[] userName = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
                "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson",
                "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King", "Wright", "Peter"};
        Random random = new Random();
        int randomIndex = random.nextInt(userName.length);
        return userName[randomIndex] + random.nextInt(1000); // Adds a number to ensure uniqueness
    }

    public void userName() {

        // Generate a new random surname
        String randomUsername = generateRandomUsername();

        // Locate the surname input field and send the random userName
        WebElement userNameField = driver.findElement(By.id("reg_username"));
        userNameField.sendKeys(randomUsername);

        // Assert that the ID of the element is correct
        Assert.assertEquals("reg_username", userNameField.getAttribute("id"));
    }

    // Method to generate a random email
    private String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "testmail.com"};
        Random random = new Random();
        int randomIndex = random.nextInt(domains.length);
        return "user" + random.nextInt(10000) + "@" + domains[randomIndex];
    }

    public void emailAddress() {
            String randomEmail = generateRandomEmail();
            WebElement emailField = driver.findElement(By.id("reg_email"));
            emailField.sendKeys(randomEmail);
            Assert.assertEquals("reg_email", emailField.getDomProperty("id"));
        }

    // Method to generate a strong random password
    private String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 12; i++) { // Password length: 12 characters
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public void password() {
            String randomPassword = generateRandomPassword();
            WebElement passwordField = driver.findElement(By.id("reg_password"));
            passwordField.sendKeys(randomPassword);
            Assert.assertEquals("reg_password", passwordField.getDomProperty("id"));
        }

    public void registerButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("register")));

        // Assert the element is clickable
        Assert.assertTrue("The 'register' button is not clickable on the page.", registerButton.isDisplayed());

        // Click on the 'register' button
        registerButton.click();
    }

    public void dashBoard() {
        WebElement dashBoard = driver.findElement(By.xpath("//*[@class='woocommerce-MyAccount-content']"));
        dashBoard.getText();

        Assert.assertTrue("My Account was not registered", dashBoard.isDisplayed());
    }
}
















