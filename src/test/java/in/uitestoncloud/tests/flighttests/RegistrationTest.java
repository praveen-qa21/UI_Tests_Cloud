package in.uitestoncloud.tests.flighttests;

import in.uitestoncloud.pages.flight.CustomerRegistration;
import in.uitestoncloud.tests.BaseTest;
import in.uitestoncloud.utils.usingOwner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {


    @Test
    public void validateFirstNameInConfirmationPage()  {
        System.out.println("Test Starts");
        driver.get(ConfigFactory.getConfig().flight_reservation());
        CustomerRegistration registration = new CustomerRegistration(driver);

        String actualFirstName = registration.enterFirstName("Praveen")
                .andThen()
                .submit()
                .getNameFromConfirmationMsg();

        Assert.assertEquals(actualFirstName, "Praveen");
        System.out.println("Test Completed");

    }
}
