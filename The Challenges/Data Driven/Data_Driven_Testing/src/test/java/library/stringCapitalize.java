package library;

import java.util.Arrays;
import java.util.stream.Collectors;

public class stringCapitalize {

    public static String capitalize(String value){

        // 1. Handle Null or Empty
        if (value == null || value.isEmpty()) {
            return value;
        }

        // 2. Handle very short words (e.g., "id" -> "ID")
        if (value.trim().length() <= 2) {
            return value.toUpperCase();
        }

        // 3. Handle Sentences (Check if it contains spaces)
        if (value.trim().contains(" ")) {
            return Arrays.stream(value.split("\\s+"))
                    .filter(word -> !word.isEmpty()) // Ensure no empty strings from split
                    .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                    .collect(Collectors.joining(" "));
        }

        // 4. Handle Single Words
        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();


    }

}
