package Model;

public class Recipe {
    private Ingredient ingredient;
    private double quantity; // Quantity in milliliters

    public Recipe(Ingredient ingredient, double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return ingredient.getName() + " - " + quantity + "ml";
    }
}