package utils;

import pageObjects.pageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetUp {
    public WebDriver driver;
    public pageObjectManager pageObjectManager;
    public TestBase testBase;



    //Constructor
    public TestContextSetUp() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new pageObjectManager(testBase.WebdriverManager());


    }
}
