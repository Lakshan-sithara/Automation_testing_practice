package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertieReader {

    public static String appConfigReader(String key) throws IOException {
        File configFile = new File("src/test/java/configarationFiles/application.properties");
        FileReader fr = new FileReader(configFile);
        Properties properties = new Properties();
        properties.load(fr);

        return properties.get(key).toString();
    }

}
