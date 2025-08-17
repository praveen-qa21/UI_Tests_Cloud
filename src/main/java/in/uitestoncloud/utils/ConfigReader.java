package in.uitestoncloud.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static {

//        try (InputStream inputStream = Files.newInputStream(Path.of("src/test/resources/testconfig.properties"))) {
          try(InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("testconfig.properties")){


                  prop.load(inputStream);



        } catch (IOException e) {
            throw new RuntimeException(e + " failu");
        }

    }

    public static String getPropertyValue(String Key) {
        return prop.getProperty(Key);
    }


}
