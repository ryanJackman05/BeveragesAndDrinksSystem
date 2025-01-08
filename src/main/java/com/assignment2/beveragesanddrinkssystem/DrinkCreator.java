package com.assignment2.beveragesanddrinkssystem;

import Model.Drink;
import Model.Ingredient;
import Model.Measure;
import controller.LinkList;
import controller.SystemData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.Utilities;

import java.io.IOException;
import java.util.Objects;

public class DrinkCreator {
    public static DrinkCreator DCController;
    private LinkList<Drink> drinkList;
    private LinkList<Ingredient> ingredientList;
    @FXML
    TextField drinkName;
    @FXML
    TextArea drinkDescription;
    @FXML
    TextField drinkCountry;
    @FXML
    ListView<Pane> ingredientListView;
    @FXML
    ListView<String> drinkListView;
    @FXML
    Label infoText, modeText;
    @FXML
    Button submit, edit, delete, openButton, home;


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
        if(drinkName.getText()==null || drinkDescription.getText()==null || drinkCountry.getText()==null) return false;
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
        if(selectedDrink != null){
            System.out.println("now editing "+selectedIndex);
            submit.setText("Submit");
            modeText.setText("Edit Drink Info");
            editing = true;
            editingIndex = selectedIndex;
            setFields(selectedDrink);
        }
    }
    // "Updating View" Methods
    @FXML
    protected void showDrinks() { // updates list
        drinkListView.getItems().clear();
        LinkList<Drink>.Node<Drink> n = drinkList.head;
        while (n!=null){
            System.out.println("SHowig DRinks");
            drinkListView.getItems().add(n.getContents().getDrinkName() + "     " + n.getContents().getABV());
            n = n.next;
        }
    }
    @FXML
    protected void updateView() { // general view update, called on every click.
        selectedIndex = drinkListView.getSelectionModel().getSelectedIndex();
        System.out.println("selected index: "+selectedIndex);
        LinkList<Drink>.Node<Drink> node = drinkList.getNode(selectedIndex);
        if(node!=null) { // disable buttons if no selected item
            selectedDrink = node.getContents();
            edit.setDisable(false);
            delete.setDisable(false);
            openButton.setDisable(false);
        }
        else {
            edit.setDisable(true);
            delete.setDisable(true);
            openButton.setDisable(true);
        }
    }
    @FXML
    protected void resetView() // resets ALL fields, and returns to adding mode
    {
        System.out.println("Resetting drinks view");
        ingredientList = SystemData.ingredients;
        drinkList = SystemData.drinks;
        editing = false;
        editingIndex = -1;
        submit.setText("Create Drink");
        modeText.setText("Make New Drink");
        infoText.setText("Info about the current action will be displayed here");
        showDrinks();

        drinkName.setText("");
        drinkCountry.setText("");
        drinkDescription.setText("");

        ingredientListView.getItems().clear();
        LinkList<Ingredient>.Node<Ingredient> n = ingredientList.head;
        while (n!=null){
            RadioButton rb = new RadioButton(n.getContents().getName());
            TextField tf = new TextField();
            rb.setPrefWidth(120);
            tf.setPrefWidth(60);
            HBox measureBox = new HBox();
            measureBox.getChildren().add(0,tf);
            measureBox.getChildren().add(0,rb);
            ingredientListView.getItems().add(measureBox);
            n = n.next;
        }
    }
    public void initialize() throws IOException // called on every opening of this scene, as a new controller is created every time a scene is set
    {
        DCController = this; // when new controller instance is created, it becomes Controller
        drinkList = SystemData.drinks;
        ingredientList = SystemData.ingredients;
    }
    protected void setFields(Drink drinkInfo) // fills all the fields with data FROM the currently selected item in the list view
    {
        drinkName.setText(drinkInfo.getDrinkName());
        drinkCountry.setText(drinkInfo.getDrinkCountry());
        drinkDescription.setText(drinkInfo.getDrinkDescription());

        LinkList<Measure> drinkMeasures = selectedDrink.getRecipe().getMeasures();
        for (int i = 0; i < ingredientListView.getItems().size(); i++) {
            Pane measurePane = ingredientListView.getItems().get(i);
            RadioButton rb = (RadioButton) measurePane.getChildren().get(0);
            TextField tf = (TextField) measurePane.getChildren().get(1);
            rb.setSelected(false);
            tf.setText("");
            for (int j = 0; j < drinkMeasures.getLength(); j++) {
                Measure m = drinkMeasures.getNode(j).getContents();
                if(Objects.equals(rb.getText(), m.getIngredient().getName())){
                    rb.setSelected(true);
                    tf.setText(""+m.getVolume());
                }
            }
        }
    }
    protected Drink getFields() // gets the info from the input tab. for fetching input when adding new item
    {
        //parse int for prices
        LinkList<Measure> measures = new LinkList<Measure>();
        for (int i = 0; i < ingredientListView.getItems().size(); i++) {
            Pane measurePane = ingredientListView.getItems().get(i);
            RadioButton rb = (RadioButton) measurePane.getChildren().get(0);
            TextField tf = (TextField) measurePane.getChildren().get(1);
            if(rb.isSelected()){
                if(!Utilities.isDouble(tf.getText()) || Objects.equals(tf.getText(), "")){
                    tf.setText("");
                    infoText.setText("Error: non-number value assigned to ingredient");
                }
                else{
                    measures.addElement(new Measure(ingredientList.getNode(i).getContents(), Double.parseDouble(tf.getText())));
                    // double parsing to get value from textfield as number. Double check done in add function (at top)
                }
            }

        }

        return new Drink(drinkName.getText(), drinkCountry.getText(), drinkDescription.getText(), measures);
    }
    public void openHomeView(ActionEvent actionEvent) throws IOException
    {
        HelloApplication.mainStage.setScene(HelloApplication.home);
        HelloApplication.mainStage.setTitle("Home");
    }
    public void openDrinkViewer(ActionEvent actionEvent) throws IOException
    {
        HelloApplication.drinksViewer.setUserData(selectedDrink);
        HelloApplication.mainStage.setScene(HelloApplication.drinksViewer);
        HelloApplication.mainStage.setTitle("Drink View");

        DrinkViewer.DVController.loadData();
    }
}