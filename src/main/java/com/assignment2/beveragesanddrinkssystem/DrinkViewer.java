package com.assignment2.beveragesanddrinkssystem;

import Model.Drink;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DrinkViewer {
    public void show(Drink drink) {
        Stage stage = new Stage();
        stage.setTitle("Drink Details");

        Label nameLabel = new Label("Name: " + drink.getName());
        Label originLabel = new Label("Origin: " + drink.getOrigin());
        Label descriptionLabel = new Label("Description: " + drink.getDescription());
        Label abvLabel = new Label("ABV: " + drink.calculateTotalABV() + "%");

        VBox layout = new VBox(10, nameLabel, originLabel, descriptionLabel, abvLabel);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout, 300, 200));
        stage.show();
    }
}

