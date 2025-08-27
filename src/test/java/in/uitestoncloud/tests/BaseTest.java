package in.uitestoncloud.tests;

import in.uitestoncloud.utils.configutils.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class BaseTest {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite
    public void setConfigs() {
        ConfigFactory.displayAllConfigs();
    }

    @BeforeMethod
    public void setDriver() throws MalformedURLException {

        if (ConfigFactory.getConfig().seleniumGridEnabled()) {
            getRemoteDriver();
        } else {
            getLocalDriver();
        }
        driver.get().manage().window().maximize();
    }

    @AfterMethod
    public void quitDriver() {
        driver.get().quit();
    }

    public void getRemoteDriver() throws MalformedURLException {
        ChromeOptions chromeOptions;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (ConfigFactory.getConfig().browserType().equals("chrome")) {
            chromeOptions = new ChromeOptions();
            if (ConfigFactory.getConfig().browserHeadless()) {
                chromeOptions.addArguments("--headless");
            }
            capabilities.setBrowserName(ConfigFactory.getConfig().browserType());
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            chromeOptions.merge(capabilities);
            driver.set(new RemoteWebDriver(new URL(String.format(ConfigFactory.getConfig().seleniumGridUrl(),ConfigFactory.getConfig().seleniumGridHostname())), chromeOptions));
        } else {
            capabilities.setBrowserName("firefox");
            driver.set(new RemoteWebDriver(new URL(String.format(ConfigFactory.getConfig().seleniumGridUrl(),ConfigFactory.getConfig().seleniumGridHostname())), capabilities));
        }
    }

    public void getLocalDriver() {
        String browserChoice = ConfigFactory.getConfig().browserType();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (ConfigFactory.getConfig().browserHeadless()) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--no-sandbox");             // required in CI
        chromeOptions.addArguments("--disable-dev-shm-usage");  // overcome limited resource issues
        chromeOptions.addArguments("--remote-allow-origins=*");

        switch (browserChoice) {
            case "chrome" ->
                    driver.set(new ChromeDriver(chromeOptions));
            case "firefox" -> driver.set(new FirefoxDriver());
        }
    }

}
