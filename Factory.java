import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory {
    /*
     * Clase Factory la cual crea un tipo de map dependiendo de lo que se elija.
     */
    public static Map<String, Pokemon> CreateMap(String name) {

        switch (name) {
            case "HashMap":
                return new HashMap<>();

            case "TreeMap":
                return new TreeMap<>();

            case "LinkedHashMap":
                return new LinkedHashMap<>();

            default:
                throw new IllegalArgumentException("Elemento incorreto");
        }
    }
}