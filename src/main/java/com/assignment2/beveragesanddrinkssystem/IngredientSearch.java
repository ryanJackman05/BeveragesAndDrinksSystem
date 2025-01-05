package com.assignment2.beveragesanddrinkssystem;

import Model.Ingredient;
import controller.SystemData;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class IngredientSearch {
    private SystemData systemData;

    public IngredientSearch(SystemData systemData) {
        this.systemData = systemData;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Search Ingredients");

        TextField searchField = new TextField();
        ListView<String> resultList = new ListView<>();
        Button searchButton = new Button("Search");

        searchButton.setOnAction(e -> {
            String keyword = searchField.getText().toLowerCase();
            List<String> results = systemData.getIngredients()
                    .getClass()
                    .isInterface(ingredient -> ingredient.getName().toLowerCase().contains(keyword) ||
                            ingredient.getDescription().toLowerCase().contains(keyword))
                    .map(Ingredient::toString)
                    .collect(Collectors.toList());

            resultList.setItems(FXCollections.observableArrayList(results));
        });

        VBox layout = new VBox(10, new Label("Search:"), searchField, searchButton, resultList);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout, 400, 300));
        stage.show();
    }
}
