import java.util.Map;

public class Factory {

    public static Map<String, String> CreateMap(String name) {

        switch (name) {
            case "HashMap":
                return HashMapOP();

            case "TreeMap":
                return TreeMapOP();

            case "LinkedHashMap":
                return LinkedHashMap();

            default:
                throw new IllegalArgumentException("Elemento incorreto");
                break;
        }
    }
}