package in.uitestoncloud.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


   public WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }


}
