package com.assignment2.beveragesanddrinkssystem;

import Model.Drink;
import controller.SystemData;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DrinkCreator {
    private SystemData systemData;

    public DrinkCreator(SystemData systemData) {
        this.systemData = systemData;
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Create New Drink");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nameField = new TextField();
        TextField originField = new TextField();
        TextArea descriptionArea = new TextArea();
        TextField imageURLField = new TextField();

        Button addButton = new Button("Add Drink");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String origin = originField.getText();
            String description = descriptionArea.getText();
            String imageURL = imageURLField.getText();

            if (!name.isEmpty() && !origin.isEmpty() && !description.isEmpty()) {
                Drink drink = new Drink(name, origin, description, imageURL);
                systemData.addDrink(drink);
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields!");
                alert.show();
            }
        });

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Origin:"), 0, 1);
        grid.add(originField, 1, 1);
        grid.add(new Label("Description:"), 0, 2);
        grid.add(descriptionArea, 1, 2);
        grid.add(new Label("Image URL:"), 0, 3);
        grid.add(imageURLField, 1, 3);
        grid.add(addButton, 1, 4);

        stage.setScene(new Scene(grid, 400, 300));
        stage.show();
    }
}