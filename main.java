import java.io.*;
import java.util.*;

public class Main {
    private static final String USER_CSV = "mi_coleccion.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "pokemon_data_pokeapi.csv";

        System.out.println("Seleccione el tipo de Map para los Pokémon:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Ingrese la opción que desea: ");
        String map = scanner.nextLine();
        scanner.nextLine();

        Map<String, Pokemon> allPokemons;
        switch (map) {
            case "HashMap":
                allPokemons = Factory.CreateMap("HashMap");
                break;
            case "TreeMap":
                allPokemons = Factory.CreateMap("TreeMap");
                break;
            case "LinkedHashMap":
                allPokemons = Factory.CreateMap("LinkedHashMap");
                break;
            default:
                System.out.println("Opción no válida. Se usará HashMap por defecto.");
                allPokemons = Factory.CreateMap("HashMap");
        }

        allPokemons = FileReaderPokemon.loadPokemonData(filePath, allPokemons);

        Map<String, Pokemon> userCollection = Factory.CreateMap("HashMap");
        loadUserCollection(userCollection);

        int op = 0;

        while (op != 6) {
            System.out.println("MENÚ");
            System.out.println("1. Agregar un Pokémon a la colección personal");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección personal ordenada por Type1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por Type1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opp = scanner.nextInt();
            scanner.nextLine();

            switch (opp) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon que desea agregar: ");
                    String nameToAdd = scanner.nextLine().trim();
                    if (allPokemons.containsKey(nameToAdd)) {
                        if (!userCollection.containsKey(nameToAdd)) {
                            Pokemon newPokemon = allPokemons.get(nameToAdd);
                            userCollection.put(nameToAdd, newPokemon);
                            saveUserCollection(newPokemon);
                            System.out.println("Pokémon agregado a la colección.");
                        } else {
                            System.out.println("Este Pokémon ya está en la colección.");
                        }
                    } else {
                        System.out.println("El Pokémon no se encuentra en los datos.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del Pokémon que desea buscar: ");
                    String nameToSearch = scanner.nextLine().trim();
                    if (allPokemons.containsKey(nameToSearch)) {
                        System.out.println(allPokemons.get(nameToSearch));
                    } else {
                        System.out.println("Pokémon no encontrado, intente de nuevo.");
                    }
                    break;

                case 3:
                    System.out.println("Colección Personal por type1:");
                    List<Pokemon> sortedUserCollection = new ArrayList<>(userCollection.values());
                    sortedUserCollection.sort(Comparator.comparing(Pokemon::getType1));
                    for (Pokemon p : sortedUserCollection) {
                        System.out.println(p);
                    }
                    break;

                case 4:
                    System.out.println("Todos los Pokémon existentes por type1:");
                    List<Pokemon> sortedAllPokemons = new ArrayList<>(allPokemons.values());
                    sortedAllPokemons.sort(Comparator.comparing(Pokemon::getType1));
                    for (Pokemon p : sortedAllPokemons) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String abilityToSearch = scanner.nextLine().trim();
                    System.out.println("Pokémon con habilidad: " + abilityToSearch);
                    boolean found = false;
                    for (Pokemon p : allPokemons.values()) {
                        if (p.getAbilities().contains(abilityToSearch)) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No se encontraron Pokémon con esa habilidad.");
                    }
                    break;

                case 6:
                    System.out.println("Gracias uu.");
                    op = 6;
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void saveUserCollection(Pokemon pokemon) {
        try (FileWriter writer = new FileWriter(USER_CSV, true);
                BufferedWriter bw = new BufferedWriter(writer);
                PrintWriter out = new PrintWriter(bw)) {

            File file = new File(USER_CSV);
            if (file.length() == 0) {
                out.println("Name,Pokedex,Type1,Type2,Classification,Height,Weight,Abilities,Generation,Status");
            }

            out.println(pokemon.getname() + "," + pokemon.getpokedex() + "," + pokemon.getType1() + ","
                    + pokemon.getType2() + "," + pokemon.getClassification() + "," + pokemon.getHeight() + ","
                    + pokemon.getWeight() + "," + pokemon.getAbilities() + "," + pokemon.getGeneration() + ","
                    + pokemon.getStatus());

        } catch (IOException e) {
            System.err.println("Error al guardar la colección: " + e.getMessage());
        }
    }

    private static void loadUserCollection(Map<String, Pokemon> userCollection) {
        File file = new File(USER_CSV);
        if (!file.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(USER_CSV))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 10)
                    continue;
                Pokemon p = new Pokemon(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8],
                        data[9]);
                userCollection.put(data[0], p);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar la colección: " + e.getMessage());
        }
    }
}
