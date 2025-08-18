package in.uitestoncloud.tests.vendorapptests;

import in.uitestoncloud.pages.vendor.Login;
import in.uitestoncloud.tests.BaseTest;
import in.uitestoncloud.utils.usingOwner.ConfigFactory;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    @Description("validate the Invalid Login")
    public void validateInvalidLogin() throws InterruptedException {
        Login login = new Login(driver);

        driver.get(ConfigFactory.getConfig().vendor_portal());

        Assert.assertTrue(login.loginWithWrongCreds().isForgetPwdOpened());
    }

}
