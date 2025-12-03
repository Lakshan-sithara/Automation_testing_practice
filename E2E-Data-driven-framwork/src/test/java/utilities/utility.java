package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utility {

    public static Object fetchPropertyValue(String key) {

        Properties prop = new Properties();

        try {
            // File operations must be inside a try block
            FileInputStream file = new FileInputStream("src/test/java/configFiles/config.properties");
            prop.load(file);
        } catch (IOException e) {
            // This prints an error if the file is not found
            e.printStackTrace();
        }

        return prop.get(key);
    }
}