import java.util.Map;

public class Factory {

    public static Map<String, String> CreateMap(String name) {

        switch (name) {
            case "HashMap":
                return;

            case "TreeMap":
                return;

            case "LinkedHashMap":
                return;

            default:
                throw new IllegalArgumentException("Elemento incorreto");
                break;
        }
    }
}