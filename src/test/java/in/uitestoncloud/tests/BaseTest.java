package in.uitestoncloud.tests;

import in.uitestoncloud.utils.configutils.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.util.Objects;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void printAllConfigs() {
        ConfigFactory.displayAllConfigs();
    }

    @BeforeMethod
    public void setDriver() throws MalformedURLException {

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("safari");
//        driver = new RemoteWebDriver(new URL("http://localhost:5487"), capabilities);

        if (Objects.equals(getBrowserChoice(), "chrome")) {
            driver = new ChromeDriver();
        } else if (Objects.equals(getBrowserChoice(), "msedge")) {
            driver = new EdgeDriver();
        } else if (Objects.equals(getBrowserChoice(), "firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }


    public String getBrowserChoice() {
        String browserType;
        if (System.getProperty("browserType") != null) {
            browserType = System.getProperty("browserType");
            System.out.println("Maven Configuration browserType = " + browserType);
        } else {
            browserType = ConfigFactory.getConfig().browserType();
            System.out.println("Test Configuration browserType = " + browserType);
        }
        return browserType;
    }

}
