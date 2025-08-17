package in.uitestoncloud.tests.vendorapptests;

import in.uitestoncloud.pages.vendor.Login;
import in.uitestoncloud.tests.BaseTest;
import in.uitestoncloud.utils.usingOwner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void validateInvalidLogin() throws InterruptedException {
        System.out.println("2nd Test Starts");
        Login login = new Login(driver);

        driver.get(ConfigFactory.getConfig().vendor_portal());

        Assert.assertTrue(login.loginWithWrongCreds().isForgetPwdOpened());
        System.out.println("2nd Test Ends");
    }

}
