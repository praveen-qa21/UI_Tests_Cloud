package in.uitestoncloud.tests.smoke;

import in.uitestoncloud.tests.BaseTest;
import in.uitestoncloud.utils.configutils.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleSmokeTest extends BaseTest {

    @Test
    public void isFlightReservationUP(){
        driver.get().get(ConfigFactory.getConfig().flightReservationUrl());
        Assert.assertEquals(driver.get().getTitle(), "Book Your Flights");
    }

    @Test
    public void isVendorPortalUP(){
        driver.get().get(ConfigFactory.getConfig().vendorPortalUrl());
        Assert.assertEquals(driver.get().getTitle(), "Login");
    }

}
