package com.assignment2.beveragesanddrinkssystem;

import javafx.fxml.FXML;
import Model.Drink;
import controller.SystemData;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class HelloController
{
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private ListView<String> resultList;

    private SystemData systemData;

    public void initialize(SystemData systemData) {
        this.systemData = systemData;

        searchButton.setOnAction(e -> {
            String keyword = searchField.getText().toLowerCase();
            Collectors Collectors;
            var results = systemData.getDrinks().stream()
                    .filter(drink -> drink.getName().toLowerCase().contains(keyword) ||
                            drink.getDescription().toLowerCase().contains(keyword))
                    .map(Drink::toString)
                    .collect(Collectors.toList());

            resultList.setItems(FXCollections.observableArrayList(results));
        });
    }
}