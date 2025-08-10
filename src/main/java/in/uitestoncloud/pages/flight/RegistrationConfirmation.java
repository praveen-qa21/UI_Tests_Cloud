package in.uitestoncloud.pages.flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationConfirmation {

    WebDriver driver;

    public RegistrationConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    public String getNameFromConfirmationMsg() throws InterruptedException {

        Thread.sleep(2000);


        return driver.findElement(By.xpath("//p[@class='mt-3']//b")).getText();
    }
}
