package Model;

import java.util.Objects;

public class Measure {
    private Ingredient ingredient;
    private double volume;

    public Measure(Ingredient ingredient, double volume) {
        this.ingredient = ingredient;
        this.volume = volume;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Measure measure)) return false;
        return Double.compare(getVolume(), measure.getVolume()) == 0 && Objects.equals(getIngredient(), measure.getIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredient(), getVolume());
    }

    @Override
    public String toString() {
        return volume + "ml of " + ingredient;
    }
}
