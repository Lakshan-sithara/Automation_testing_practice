package library;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class jsonDataReader {

    public static Map<String,Object>  getTestData(){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/test/java/configarationFiles/testData.json");
        return mapper.readValue(file, Map.class);
    }

}
