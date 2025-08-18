package in.uitestoncloud.pages.vendor;

import io.qameta.allure.Allure;
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
        Allure.step("Login Btn Clicked with Invalid Creds");
        return new ForgotPassword(driver);
    }


}
