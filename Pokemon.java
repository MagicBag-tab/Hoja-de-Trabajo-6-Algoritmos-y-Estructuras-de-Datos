/*
 * Clase que posee todos los datos del pokemon
 * Tiene getters y setters
 * toString que lo vuelve una cadena.
 */

public class Pokemon {

    public String name;
    public String type2;
    public String classification;
    public Double height;
    public Double weight;
    public String abilities;
    public int generation;
    public String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
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
        return "Pokemon [name=" + name + ", type2=" + type2 + ", classification=" + classification + ", height="
                + height + ", weight=" + weight + ", abilities=" + abilities + ", generation=" + generation
                + ", status=" + status + "]";
    }

}
