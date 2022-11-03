package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    Properties properties;
    FileReader reader;

    public PropertyLoader() {
        properties = new Properties();
        try {
            reader = new FileReader("src/main/resources/test.properties");
            properties.load(reader);
        }
        catch (IOException e) {
            System.out.print("Unable to load test.properties");
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String property) {
        String propertyValue;
        System.out.println("Fetching property:" + property);
        propertyValue = properties.getProperty(property);
        System.out.println("Property value got:" + propertyValue);
        return propertyValue;
    }




}
