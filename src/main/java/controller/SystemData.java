package controller;

import Model.Drink;
import Model.Ingredient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SystemData {
    private List<Drink> drinks;
    private List<Ingredient> ingredients;

    public SystemData() {
        this.drinks = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void saveData(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(drinks);
            oos.writeObject(ingredients);
        }
    }

    public void loadData(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            drinks = (List<Drink>) ois.readObject();
            ingredients = (List<Ingredient>) ois.readObject();
        }
    }
}
