package in.uitestoncloud.tests.flighttests;

import in.uitestoncloud.pages.flight.CustomerRegistration;
import in.uitestoncloud.tests.BaseTest;
import in.uitestoncloud.utils.usingOwner.ConfigFactory;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationIT extends BaseTest {


    @Test
    @Description("validate the firstName In Confirmation Page")
    public void validateFirstNameInConfirmationPage()  {
        driver.get(ConfigFactory.getConfig().flight_reservation());
        CustomerRegistration registration = new CustomerRegistration(driver);

        String actualFirstName = registration.enterFirstName("Praveen")
                .andThen()
                .submit()
                .getNameFromConfirmationMsg();

        Assert.assertEquals(actualFirstName, "Praveen");
    }
}


