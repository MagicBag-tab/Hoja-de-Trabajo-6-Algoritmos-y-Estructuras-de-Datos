import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Map<String, Pokemon> allPokemons;
    private Map<String, Pokemon> userCollection;

    @Before
    public void setUp() {
        allPokemons = Factory.CreateMap("HashMap");
        userCollection = Factory.CreateMap("HashMap");

        allPokemons.put("Pikachu",
                new Pokemon("Pikachu", "25", "Electric", "", "Mouse Pokémon", "0.4m", "6kg", "Static", "1", "Normal"));
        allPokemons.put("Charmander",
                new Pokemon("Charmander", "4", "Fire", "", "Lizard Pokémon", "0.6m", "8.5kg", "Blaze", "1", "Normal"));
    }

    @Test
    public void testOrdenarColeccionPorType1() {

        userCollection.put("Pikachu", allPokemons.get("Pikachu"));
        userCollection.put("Charmander", allPokemons.get("Charmander"));

        List<Pokemon> sortedUserCollection = new ArrayList<>(userCollection.values());
        sortedUserCollection.sort(Comparator.comparing(Pokemon::getType1));

        assertEquals("Charmander", sortedUserCollection.get(1).getname());
        assertEquals("Pikachu", sortedUserCollection.get(0).getname());
    }

    @Test
    public void testBuscarPokemonPorHabilidad() {
        String habilidadBuscada = "Blaze";

        List<Pokemon> resultado = allPokemons.values().stream()
                .filter(p -> p.getAbilities().equalsIgnoreCase(habilidadBuscada))
                .collect(Collectors.toList());

        assertEquals(1, resultado.size());
        assertEquals("Charmander", resultado.get(0).getname());
    }

}
