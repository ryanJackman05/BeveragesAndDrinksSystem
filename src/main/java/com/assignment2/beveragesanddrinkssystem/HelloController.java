package com.assignment2.beveragesanddrinkssystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController
{
    @FXML
    private Label welcomeText;

    @FXML
    protected void openDrinksView()
    {
        HelloApplication.mainStage.setScene(HelloApplication.drinksView);
    }
    @FXML
    protected void openIngsView()
    {
        HelloApplication.mainStage.setScene(HelloApplication.ingsView);
    }
}