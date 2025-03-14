/*
 * Clase que posee todos los datos del pokemon
 * Tiene getters y setters
 * toString que lo vuelve una cadena.
 */

public class Pokemon {

    public String name;
    public String pokedex;
    public String type1;
    public String type2;
    public String classification;
    public String height;
    public String weight;
    public String abilities;
    public String generation;
    public String status;

    public Pokemon(String name, String pokedex, String type1, String type2, String classification, String height,
            String weight,
            String abilities, String generation, String status) {
        this.name = name;
        this.pokedex = pokedex;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.status = status;
    }

    public String getname() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getpokedex() {
        return pokedex;
    }
    
    public void setpokedex(String pokedex) {
        this.pokedex = pokedex;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pokemon [name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", classification=" + classification
                + ", height=" + height + ", weight=" + weight + ", abilities=" + abilities + ", generation="
                + generation + ", status=" + status + "]";
    }

}
