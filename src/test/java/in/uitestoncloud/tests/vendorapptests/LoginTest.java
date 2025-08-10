package in.uitestoncloud.tests.vendorapptests;

import in.uitestoncloud.pages.vendor.Login;
import in.uitestoncloud.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void validateInvalidLogin() throws InterruptedException {

        Login login = new Login(driver);

        driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");

        Assert.assertTrue(login.loginWithWrongCreds().isForgetPwdOpened());

    }

}
