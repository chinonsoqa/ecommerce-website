package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {
    public WebDriver driver;

    public TC_1_1_PageObject tc_1_1_pageObject;
    public TC_1_1B_PageObject tc_1_1b_pageObject;
    public TC_1_2_PageObject tc_1_2_pageObject;

    //Constructor
    public pageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public TC_1_1_PageObject getTC1_1PageObject()
    {
        tc_1_1_pageObject = new TC_1_1_PageObject(driver);
        return tc_1_1_pageObject;
    }

    public TC_1_1B_PageObject getTC1_1bPageObject()
    {
        tc_1_1b_pageObject = new TC_1_1B_PageObject(driver);
        return tc_1_1b_pageObject;
    }

    public TC_1_2_PageObject getTC1_2PageObject()
    {
        tc_1_2_pageObject = new TC_1_2_PageObject(driver);
        return tc_1_2_pageObject;
    }















}
