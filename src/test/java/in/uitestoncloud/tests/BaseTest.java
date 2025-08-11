package in.uitestoncloud.tests;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {


   public WebDriver driver;

    @BeforeMethod
    public void setDriver() throws MalformedURLException {

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("safari");
//        driver = new RemoteWebDriver(new URL("http://localhost:5487"), capabilities);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }


}
