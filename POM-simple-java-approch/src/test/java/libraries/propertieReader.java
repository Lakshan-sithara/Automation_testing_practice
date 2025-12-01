package libraries;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class propertieReader {

    public static String getElements(String key){

        Properties prop = new Properties();

        try{
            File f = new File("src/test/java/configFiles/elements/elements.properties");
            FileReader fr = new FileReader(f);
            prop.load(fr);
            fr.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return prop.get(key).toString();

    }

}
