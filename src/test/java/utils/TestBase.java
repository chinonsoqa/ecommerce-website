package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static ExtentSparkReporter SparkReporter;
    public static ExtentReports Extents;
    public static ExtentTest Test;

    public static WebDriver driver;

// --- Manage the browser choice from the properties file and handling that browser is opened once at the start

    // Load of the properties File
    public WebDriver WebdriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+".\\src\\test\\resources\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        //----> URl Environment Selection
        // Check if there is a property from maven command with the name of url
        String url_maven =  System.getProperty("env_url");
        // For Dev environment replace url in global property file
        String url_prop = prop.getProperty("EnvUrl");


        // Browser selection
        if (driver == null)
        {
            if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+".\\src\\test\\resources\\msedgedriver_131.0.2903.51.exe");
                driver = new EdgeDriver();






            }
            if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
            {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+".\\src\\test\\resources\\geckodriver_V0.35.0.exe");
                //System.setProperty("webdriver.gecko.driver", ("C:\\APPS\\TRAD\\DEVTOOLS\\selenium\\geckodriver\\x64\\0.31.0\\geckodriver.exe"));
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                FirefoxOptions options = new FirefoxOptions();
                //options.setBinary(System.getProperty("user.dir")+".\\src\\test\\resources\\geckodriver_V-0.31.0.exe");
                // options.setHeadless(false);


                driver = new FirefoxDriver(options);
            }
            // Implicit general wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            //Maximize Window
            driver.manage().window().maximize(); //To maximize web page



            //driver.get(env_url);

        }
        return driver;

    }


    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit();
            } catch (NoSuchMethodError | NoSuchSessionException | SessionNotCreatedException exception) {
                System.out.println();
            }
            driver = null;
        }
    }

}
