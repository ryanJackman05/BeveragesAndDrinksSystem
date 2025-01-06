package com.assignment2.beveragesanddrinkssystem;
import Model.Ingredient;
import controller.LinkList;
import controller.SystemData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import utils.Utilities;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IngredientViewer {
    // TODO: CHANGE FIELD NAMES AND TYPES. REFER TO THE COMPLETED FXML VIEWS TO SEE WHAT ELEMENTS NEED REFERENCING
    @FXML
    TextField name;
    @FXML
    ListView<String> ingredientListView;
    @FXML
    TextArea description;
    @FXML
    Slider abv;
    @FXML
    Label infoText, modeText, abvText;
    @FXML
    Button submit, edit, delete, home;

    LinkList<Ingredient> ingredientList;
    public static IngredientViewer IVController;


    // control variables. do not touch pls <333333333
    boolean editing;
    int selectedIndex = -1;
    int editingIndex = -1;
    Ingredient selectedIngredient = null; //  <<< IMPORTANT. THIS WILL ALWAYS BE THE CURRENTLY SELECTED ITEM IN THE LIST, AND USUALLY UPDATES ON EACH CLICK. UNLIKE SELECTED/EDITING INDEX, WHICH WILL OCCASIONALLY STAY LOCKED FOR DATA PROCESSING PURPOSES
    @FXML
    protected void submit() // called every time submit button is hit (submit/create)
    {
        if(editing && editingIndex!=-1) { // checks if in editing mode, either updates selected item or adds new one
            updateIngredient();
            System.out.println("submitting edit");
        }
        else {
            addNewIngredient();
            System.out.println("adding new Ingredient");
        }
    }
    @FXML
    protected boolean addNewIngredient() {
        if(name.getText()==null || description.getText()==null) return false;
        // return false if values are empty or if IsDouble/IsType checks fail
        SystemData.ingredients.addElement(getFields()); // add item, remember that getFIelds should return relevant type
        showIngredients(); // update list view
        return true;
    }
    @FXML
    protected void removeIngredient() { // quick and easy delete. uses SelectedIndex
        System.out.println("now deleting "+selectedIndex);
        System.out.println("show was deleted?: "+ingredientList.deleteNode(selectedIndex));
        showIngredients();
        updateView();
    }
    @FXML
    protected void updateIngredient() // called by submit if editing = true
    {
        if (!ingredientList.updateNode(editingIndex, getFields())){
            infoText.setText("Error: Ingredient could not be updated");
        }
        resetView();
    }
    @FXML
    protected void editIngredient() { // enable edit mode, called by edit button
        if(selectedIngredient != null){
            System.out.println("now editing "+selectedIndex);
            submit.setText("Submit");
            modeText.setText("Edit Ingredient Info");
            editing = true;
            editingIndex = selectedIndex;
            setFields(selectedIngredient);
        }
    }
    // "Updating View" Methods
    @FXML
    protected void showIngredients() { // updates list
        ingredientListView.getItems().clear();
        LinkList<Ingredient>.Node<Ingredient> n = ingredientList.head;
        while (n!=null){
            ingredientListView.getItems().add(n.getContents().getName() + "     " + n.getContents().getDescription()+"    "+n.getContents().getAbv());
            n = n.next;
        }
    }
    @FXML
    protected void updateView() { // general view update, called on every click.
        selectedIndex = ingredientListView.getSelectionModel().getSelectedIndex();
        System.out.println("selected index: "+selectedIndex);
        LinkList<Ingredient>.Node<Ingredient> node = ingredientList.getNode(selectedIndex);
        if(node!=null) { // disable buttons if no selected item
            selectedIngredient = node.getContents();
            edit.setDisable(false);
            delete.setDisable(false);
        }
        else {
            edit.setDisable(true);
            delete.setDisable(true);
        }
        // resets textfields if type does not match
    }
    @FXML
    protected void resetView() // resets ALL fields, and returns to adding mode
    {
        System.out.println("Resetting view");
        editing = false;
        editingIndex = -1;
        submit.setText("Create Ingredient");
        modeText.setText("Make New Ingredient");
        infoText.setText("Info about the current action will be displayed here");
        showIngredients();

        name.setText("");
        abv.setValue(90);
        description.setText("");
    }
    public void initialize() // called on every opening of this scene, as a new controller is created every time a scene is set
    {
        IVController = this; // when new controller instance is created, it becomes Controller
    }
    protected void setFields(Ingredient ingredientInfo) // fills all the fields with data FROM the currently selected item in the list view
    {
        name.setText(ingredientInfo.getName());
        abv.setValue(ingredientInfo.getAbv());
        abvText.setText(""+abv.getValue());
        description.setText(ingredientInfo.getDescription());
    }
    protected Ingredient getFields() // gets the info from the input tab. for fetching input when adding new item
    {
        // double parsing to get value from textfield as number. Double check done in add function (at top)
        return new Ingredient(name.getText(), description.getText(), abv.getValue());
    }
    public void openHomeView(ActionEvent actionEvent) throws IOException
    {
        HelloApplication.mainStage.setScene(HelloApplication.home);
        HelloApplication.mainStage.setTitle("Home");
    }
    public void updateSlider() // updates the slider label on movement
    {
        abv.setValue(abv.getValue()); // this line fucking baffles me, but don't touch it
        abvText.setText(""+abv.getValue());
    }
}

