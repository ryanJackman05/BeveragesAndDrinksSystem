package com.assignment2.beveragesanddrinkssystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController
{
    @FXML
    private Label welcomeText;

    @FXML
    protected void openDrinksSearch()
    {
        HelloApplication.mainStage.setScene(HelloApplication.drinksViewer);
    }
    @FXML
    protected void openDrinksCreator()
    {
        HelloApplication.mainStage.setScene(HelloApplication.drinksCreator);
    }
    // creator and viewer are within the same view
    @FXML
    protected void openIngsSearch()
    {
        HelloApplication.mainStage.setScene(HelloApplication.ingsSearch);
    }
    @FXML
    protected void openIngsCreator()
    {
        HelloApplication.mainStage.setScene(HelloApplication.ingsViewer);
    }
}