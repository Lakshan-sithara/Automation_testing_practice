package library;

public class stringCapitalize {

    public static String capitalize(String value){

        if (value == null || value.isEmpty()){
            return value;
        }

        return value.substring(0,1).toUpperCase() + value.substring(1).toLowerCase();

    }

}
