package in.uitestoncloud.pages.vendor;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class ForgotPassword {


    WebDriver driver;

    ForgotPassword(WebDriver driver){
        this.driver = driver;
    }


    public boolean isForgetPwdOpened() throws InterruptedException {
        Thread.sleep(2000);
        return Objects.equals(driver.getTitle(), "Forgot Password");
    }
}
