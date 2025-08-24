package in.uitestoncloud.utils.configutils;


import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:UITestConfig.properties"})
public interface UITestConfig extends Config, Accessible {

    String env();

    @Key("threadcount")
    @DefaultValue("5")
    int threadcount();

    boolean seleniumGridEnabled();

    String seleniumGridUrl();

    String seleniumGridHostname();

    @Key("browserType")
    @DefaultValue("chrome")
    String browserType();

    @Key("browserHeadless")
    @DefaultValue("false")
    boolean browserHeadless();

    String flightReservationUrl();

    String vendorPortalUrl();

}
