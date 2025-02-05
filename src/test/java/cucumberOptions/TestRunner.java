package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  ".\\src\\test\\features",
        glue = "stepDefinitions",
        stepNotifications = true,
        monochrome = true,

        //tags = "@login",


        plugin = {

                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt",
        }

)



public class TestRunner {
}
