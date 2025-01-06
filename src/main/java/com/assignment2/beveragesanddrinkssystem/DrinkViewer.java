package com.assignment2.beveragesanddrinkssystem;
import Model.Drink;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class DrinkViewer {
    // TODO: CHANGE FIELD NAMES AND TYPES. REFER TO THE COMPLETED FXML VIEWS TO SEE WHAT ELEMENTS NEED REFERENCING
    @FXML
    TextField drinkName;
    @FXML
    TextArea drinkDescription;
    @FXML
    TextField drinkCountry;
    @FXML
    TextField imageURL;
    @FXML
    Label infoText;
    @FXML
    Button submit, edit, delete, home;


    // control variables. do not touch pls <333333333
    boolean editing;
    int selectedIndex = -1;
    int editingIndex = -1;
    Drink selectedDrink = null; //  <<< IMPORTANT. THIS WILL ALWAYS BE THE CURRENTLY SELECTED ITEM IN THE LIST, AND USUALLY UPDATES ON EACH CLICK. UNLIKE SELECTED/EDITING INDEX, WHICH WILL OCCASIONALLY STAY LOCKED FOR DATA PROCESSING PURPOSES

    @FXML
    protected void updateView() { // general view update, called on every click.

    }
    @FXML
    protected void resetView() // resets ALL fields, and returns to adding mode
    {
        drinkName.setText("");
        drinkCountry.setText("");
        imageURL.setText("");
        drinkDescription.setText("");
    }
    public void initialize() // called on every opening of this scene, as a new controller is created every time a scene is set
    {
        // when new controller instance is created, it becomes Controller
    }
    public void loadData()
    {
        if(HelloApplication.drinksViewer.getUserData().getClass().equals(Drink.class)) {
            selectedDrink = (Drink) HelloApplication.drinksViewer.getUserData();
            drinkName.setText("Show: "+selectedDrink.getDrinkName());
            drinkDescription.setText(selectedDrink.getDrinkDescription());
            drinkCountry.setText(selectedDrink.getDrinkCountry());
        }
        else {
            System.out.println("Drink could not be found in userdata");
        }
    }
    public void openHomeView(ActionEvent actionEvent) throws IOException
    {
        HelloApplication.mainStage.setScene(HelloApplication.home);
        HelloApplication.mainStage.setTitle("Home");
    }
}

