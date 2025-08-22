package in.uitestoncloud.utils.configutils;


import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config;


@Config.Sources({"classpath:UITestConfig.properties"})
public interface UITestConfig extends Config, Accessible {

    @Key("env")
    String env();

    @Key("parallel.execution.count")
    @DefaultValue("5")
    int parallelExecutionCount();

    @Key("selenium.grid.enabled")
    boolean seleniumGridEnabled();

    @Key("selenium.grid.url")
    String seleniumGridUrl();

    @Key("selenium.grid.hostname")
    String seleniumGridHostname();

    @Key("browser.type")
    String browserType();

    @Key("browser.headless")
    boolean browserHeadless();

    @Key("flightReservation.url")
    String flightReservationUrl();

    @Key("vendorPortal.url")
    String vendorPortalUrl();

}
