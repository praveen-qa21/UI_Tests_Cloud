package in.uitestoncloud.pages.flight;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerRegistration {

    WebDriver driver;

    public CustomerRegistration(WebDriver driver) {
        this.driver = driver;
    }


    public CustomerRegistration enterFirstName(String firstName) {

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        Allure.step("Enter username: " +firstName);
        return this;
    }

    public CustomerRegistration andThen() {
        return this;
    }


    public RegistrationConfirmation submit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("register-btn"))).click();
        Allure.step("Click Register button");
        return new RegistrationConfirmation(driver);
    }
}
