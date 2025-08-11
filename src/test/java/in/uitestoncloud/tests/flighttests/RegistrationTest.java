package in.uitestoncloud.tests.flighttests;

import in.uitestoncloud.pages.flight.CustomerRegistration;
import in.uitestoncloud.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {


    @Test
    public void validateFirstNameInConfirmationPage()  {
        System.out.println("Test Starts");
        driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        CustomerRegistration registration = new CustomerRegistration(driver);

        String actualFirstName = registration.enterFirstName("Praveen")
                .andThen()
                .submit()
                .getNameFromConfirmationMsg();

        Assert.assertEquals(actualFirstName, "Prawin");
        System.out.println("Test Completed");

    }


}
