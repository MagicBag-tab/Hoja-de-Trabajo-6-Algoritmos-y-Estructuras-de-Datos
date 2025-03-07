import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory {

    public static Map<String, String> CreateMap(String name) {

        switch (name) {
            case "HashMap":
                Map<String, String> hmap = new HashMap<>();
                return hmap;

            case "TreeMap":
                Map<String, String> tmap = new TreeMap<>();
                return tmap;

            case "LinkedHashMap":
                Map<String, String> lmap = new LinkedHashMap<>();
                return lmap;

            default:
                throw new IllegalArgumentException("Elemento incorreto");
        }
    }
}