package in.uitestoncloud.pages.flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationConfirmation {

    WebDriver driver;

    public RegistrationConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    public String getNameFromConfirmationMsg() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='mt-3']//b"))).getText();
    }
}
