package SearchEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SynonymDatabase {

    public List<String> getSynonyms(String word) {
        if (word == null) return Collections.emptyList();

        String key = word.toLowerCase();

        // Simple hardcoded database for the demo
        switch (key) {
            case "computer":
                return Arrays.asList("PC", "Laptop", "Machine");
            case "car":
                return Arrays.asList("Automobile", "Vehicle", "Sedan");
            case "phone":
                return Arrays.asList("Smartphone", "Mobile", "Cell");
            case "university":
                return Arrays.asList("College", "Institute", "School");
            case "haw hamburg":
                return Arrays.asList("Hamburg University of Applied Sciences", "HAW");
            default:
                return Collections.emptyList();
        }
    }
}