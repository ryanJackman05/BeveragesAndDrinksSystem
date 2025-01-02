package Model;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private double abv; // Alcohol by volume (0 if non-alcoholic)

    public Drink(String name, String description, double abv) {
        this.name = name;
        this.description = description;
        this.abv = abv;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getAbv() {
        return abv;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return name + " (" + abv + "% ABV): " + description;
    }
}
