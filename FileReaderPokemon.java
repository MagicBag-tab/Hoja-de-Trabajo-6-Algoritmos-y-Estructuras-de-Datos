import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileReaderPokemon {

    public static Map<String, Pokemon> loadPokemonData(String filePath, Map<String, Pokemon> pokemonMap) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length < 10)
                    continue;

                String name = data[0].trim();
                String pokedex = data[1].trim();
                String type1 = data[2].trim();
                String type2 = data[3].trim();
                String classification = data[4].trim();
                String height = data[5].trim();
                String weight = data[6].trim();

                StringBuilder abilitiesBuilder = new StringBuilder();

                /*
                 * Algunas partes poseen datos entre comillas separados por comas
                 * entonces no toma correctamente la información, utiliza este for
                 * para corregir esta parte.
                 */
                for (int i = 7; i < data.length - 2; i++) {
                    if (!data[i].trim().isEmpty()) {
                        if (abilitiesBuilder.length() > 0)
                            abilitiesBuilder.append(", ");
                        abilitiesBuilder.append(data[i].trim());
                    }
                }
                String abilities = abilitiesBuilder.toString();

                String generation = data[data.length - 2].trim();
                String status = data[data.length - 1].trim();

                pokemonMap.put(name, new Pokemon(name, pokedex, type1, type2, classification, height, weight, abilities,
                        generation, status));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return pokemonMap;
    }
}
