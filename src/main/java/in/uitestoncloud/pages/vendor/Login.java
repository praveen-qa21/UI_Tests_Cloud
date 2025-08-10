package in.uitestoncloud.pages.vendor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

   WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }


    public ForgotPassword loginWithWrongCreds() {

//        driver.findElement(By.id("username")).sendKeys();
//        driver.findElement(By.id("password")).sendKeys();
        driver.findElement(By.id("login")).click();
        return new ForgotPassword(driver);
    }


}
