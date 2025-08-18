package in.uitestoncloud.tests;

import in.uitestoncloud.utils.usingOwner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.util.Objects;

public class BaseTest {


   public WebDriver driver;

    @BeforeMethod
    public void setDriver() throws MalformedURLException {

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("safari");
//        driver = new RemoteWebDriver(new URL("http://localhost:5487"), capabilities);

        if (Objects.equals(getBrowserChoice("browserName"), "chrome")){
            driver = new ChromeDriver();
        } else if (Objects.equals(getBrowserChoice("browserName"), "msedge")){
            driver = new EdgeDriver();
        }  else if (Objects.equals(getBrowserChoice("browserName"), "firefox")){
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }


    public String getBrowserChoice(String browser) {
        browser = System.getProperty("browserName");// comes from mvn -D or surefire <systemPropertyVariables>
        System.out.println("browser = " + browser);
        if (browser == null || browser.isEmpty()) {
            browser = ConfigFactory.getConfig().browserName(); // fallback from config.properties
        }
        return browser;
    }

}
