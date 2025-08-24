package in.uitestoncloud.utils.configutils;

public class ConfigFactory {

    public static UITestConfig getConfig() {
        return org.aeonbits.owner.ConfigFactory.create(UITestConfig.class, System.getProperties());
    }

    public static void displayAllConfigs() {
        System.out.println("============Configs=================");
        System.out.println("env                      = " + getConfig().env());
        System.out.println("selenium.grid.enabled    =" + getConfig().seleniumGridEnabled());
        System.out.println("seleniumGridUrl          =" +getConfig().seleniumGridUrl());
        System.out.println("seleniumGridHostname     =" +getConfig().seleniumGridHostname());
        System.out.println(String.format(ConfigFactory.getConfig().seleniumGridUrl(),ConfigFactory.getConfig().seleniumGridHostname()));
        System.out.println("browserType              = " + getConfig().browserType());
        System.out.println("browser.headless         = " + getConfig().browserHeadless());
        System.out.println("parallel.execution.count =" + getConfig().threadcount());
        System.out.println("====================================");
    }
}
