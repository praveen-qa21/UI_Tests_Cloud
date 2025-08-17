package in.uitestoncloud.utils.usingOwner;

public class ConfigFactory {


    public static ConfigProp getConfig() {

        return org.aeonbits.owner.ConfigFactory.create(ConfigProp.class);
    }

}
