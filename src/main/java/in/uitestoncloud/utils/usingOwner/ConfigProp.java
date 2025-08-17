package in.uitestoncloud.utils.usingOwner;


import org.aeonbits.owner.Config;



@Config.Sources({"classpath:testconfig.properties"})
public interface ConfigProp extends Config {


    String flight_reservation();


    String vendor_portal();


}
