package stepdefinitions.hooks;

import com.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties properties;

    @Before(order = 0)
    public void getProperty(){
    configReader = new ConfigReader();
    properties = configReader.init_properties();
    }

    @Before(order = 1)
    public void launchBrowser() {
        driverFactory = new DriverFactory();
        String browser = properties.getProperty("browser");
        driver = driverFactory.init_Driver(browser);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After (order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", scenarioName);
        }
    }
}
