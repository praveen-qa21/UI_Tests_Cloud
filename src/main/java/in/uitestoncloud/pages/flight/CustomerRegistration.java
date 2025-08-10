package in.uitestoncloud.pages.flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.function.BiConsumer;

public class CustomerRegistration {

    WebDriver driver;

    public CustomerRegistration(WebDriver driver){
        this.driver = driver;
    }



    public CustomerRegistration enterFirstName(String firstName) {

        driver.findElement(By.id("firstName")).sendKeys(firstName);

        return this;
    }

    public CustomerRegistration andThen(){
        return this;
    }


    public RegistrationConfirmation submit() {
        driver.findElement(By.id("register-btn")).click();
        return new RegistrationConfirmation(driver);
    }
}
