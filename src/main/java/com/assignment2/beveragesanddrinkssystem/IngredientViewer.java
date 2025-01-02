package com.assignment2.beveragesanddrinkssystem;

import Model.Ingredient;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IngredientViewer {
    public void show(Ingredient ingredient) {
        Stage stage = new Stage();
        stage.setTitle("Ingredient Details");

        Label nameLabel = new Label("Name: " + ingredient.getName());
        Label descriptionLabel = new Label("Description: " + ingredient.getDescription());
        Label abvLabel = new Label("ABV: " + ingredient.getABV() + "%");

        VBox layout = new VBox(10, nameLabel, descriptionLabel, abvLabel);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout, 300, 200));
        stage.show();
    }
}

