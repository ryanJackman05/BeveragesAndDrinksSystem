package Model;

public class Ingredient {
    private String name;
    private String description;
    private double abv; // Alcohol content, 0 if non-alcoholic

    public Ingredient(String name, String description, double abv) {
        this.name = name;
        this.description = description;
        this.abv = abv;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getAbv() {
        return abv;
    }

    @Override
    public String toString() {
        return name + " (" + abv + "% ABV): " + description;
    }
}
