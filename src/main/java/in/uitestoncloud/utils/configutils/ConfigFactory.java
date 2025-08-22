package in.uitestoncloud.utils.configutils;

public class ConfigFactory {

    public static UITestConfig getConfig() {
        return org.aeonbits.owner.ConfigFactory.create(UITestConfig.class);
    }

    public static void displayAllConfigs(){
        getConfig().list(System.out);
    }
}
