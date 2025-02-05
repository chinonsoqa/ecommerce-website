package stepDefinitions;

import utils.TestBase;
import utils.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    TestContextSetUp testContextSetUp;

    private static TestBase dr =  new TestBase(); // This method is for the screenshot

    public Hooks(TestContextSetUp testContextSetUp){
        this.testContextSetUp=testContextSetUp;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("scenario name = " + scenario.getName());
        System.out.println("scenario line = " + scenario.getLine());
        System.out.println("scenario uri = " + scenario.getUri());
    }

    //Quit driver after tests are done
    @After
    public static void failScenarioScreenshot(Scenario scenario) throws Exception {
        String screenShotName = scenario.getName().replaceAll(" ", "_");

        if (scenario.isFailed()){
            System.out.println(scenario.getName() + " is Failed");
            scenario.log("FAIL");
        }
        else{
            System.out.println(scenario.getName() + " is pass");
        }
        TakesScreenshot ts = (TakesScreenshot) dr.WebdriverManager();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", screenShotName);
        //dr.closeDriver();
    }

}
