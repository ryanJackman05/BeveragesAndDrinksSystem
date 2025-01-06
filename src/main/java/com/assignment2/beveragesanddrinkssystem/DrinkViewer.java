package com.assignment2.beveragesanddrinkssystem;
import Model.Drink;
import controller.SystemData;
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
    protected void submit() // called every time submit button is hit (submit/create)
    {
        if(editing && editingIndex!=-1) { // checks if in editing mode, either updates selected item or adds new one
            updateDrink();
            System.out.println("submitting edit");
        }
        else {
            addNewDrink();
            System.out.println("adding new Drink");
        }
    }
    @FXML
    protected boolean addNewDrink() {
        if(drinkName.getValue()==null || drinkDescription.getValue()==null || drinkCountry.getValue()==null || imageURL.getValue()==null || !Utilities.isDouble(balconyPrice.getText())) return false;
        // return false if values are empty or if IsDouble/IsType checks fail
        SystemData.drinks.addElement(getFields()); // add item, remember that getFIelds should return relevant type
        showDrinks(); // update list view
        return true;
    }
    @FXML
    protected void removeDrink() { // quick and easy delete. uses SelectedIndex
        System.out.println("now deleting "+selectedIndex);
        System.out.println("drink was deleted?: "+drinkList.deleteNode(selectedIndex));
        showDrinks();
        updateView();
    }
    @FXML
    protected void updateDrink() // called by submit if editing = true
    {
        if (!drinkList.updateNode(editingIndex, getFields())){
            infoText.setText("Error: Drink could not be updated");
        }
        resetView();
    }
    @FXML
    protected void editDrink() { // enable edit mode, called by edit button
        if(selectedDrnk != null){
            System.out.println("now editing "+selectedIndex);
            submit.setText("Submit");
            drinkText.setText("Edit Drink Info");
            editing = true;
            editingIndex = selectedIndex;
            setFields(selectedDrink);
        }
    }
    // "Updating View" Methods
    @FXML
    protected void showDrinks() { // updates list
        drinkListView.getItems().clear();
        LinkedList<Drink>.Node<Drink> n = drinkList.head;
        while (n!=null){
            drinkListView.getItems().add(n.getContents().getDrinkName() + "     " + n.getContents().getDrinkDescription()+"    " + n.getContents().getDrinkCountry()+"    " + n.getContents().getImageURL()+"    ");
            n = n.next;
        }
    }
    @FXML
    protected void updateView() { // general view update, called on every click.
        selectedIndex = drinkListView.getSelectionModel().getSelectedIndex();
        System.out.println("selected index: "+selectedIndex);
        LinkedList<Drink>.Node<Drink> node = drinkList.getNode(selectedIndex);
        if(node!=null) { // disable buttons if no selected item
            selectedDrink = node.getContents();
            viewPerfs.setDisable(false);
            edit.setDisable(false);
            delete.setDisable(false);
        }
        else {
            viewPerfs.setDisable(true);
            edit.setDisable(true);
            delete.setDisable(true);
        }
    }
    @FXML
    protected void resetView() // resets ALL fields, and returns to adding mode
    {
        System.out.println("Resetting view");
        editing = false;
        editingIndex = -1;
        submit.setText("Create Drink");
        modeText.setText("Make New Drink");
        infoText.setText("Info about the current action will be displayed here");
        showDrinks();

        drinkName.setText("");
        drinkCountry.setText("");
        imageURL.setText("");
        drinkDescription.setText("");
    }
    public void initialize() // called on every opening of this scene, as a new controller is created every time a scene is set
    {
        HelloController = this; // when new controller instance is created, it becomes Controller
    }
    protected void setFields(Drink drinkInfo) // fills all the fields with data FROM the currently selected item in the list view
    {
        drinkName.setText(drinkInfo.getDrinkName());
        drinkCountry.setValue(drinkInfo.getDrinkCountry());
        imageURL.setText(drinkInfo.getImageURL());
        drinkDescription.setText(drinkInfo.getDrinkDescription());
    }
    protected Drink getFields() // gets the info from the input tab. for fetching input when adding new item
    {
        //parse int for prices
        // double parsing to get value from textfield as number. Double check done in add function (at top)
        return new Drink(drinkName.getText(), drinkDescription.getText(), drinkCountry.getText() ,imageURL.getText());
    }
    public void openHomeView(ActionEvent actionEvent) throws IOException
    {
        HelloApplication.mainStage.setScene(HelloApplication.home);
        HelloApplication.mainStage.setTitle("Home");
    }
}

