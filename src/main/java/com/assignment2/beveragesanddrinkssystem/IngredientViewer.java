package com.assignment2.beveragesanddrinkssystem;

import Model.Ingredient;
import controller.SystemData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IngredientViewer {
    // TODO: CHANGE FIELD NAMES AND TYPES. REFER TO THE COMPLETED FXML VIEWS TO SEE WHAT ELEMENTS NEED REFERENCING
    @FXML
    TextField name;
    @FXML
    TextArea desc;
    @FXML
    Slider abv;
    @FXML
    Label infoText;
    @FXML
    Button submit, edit, delete, home;


    // control variables. do not touch pls <333333333
    boolean editing;
    int selectedIndex = -1;
    int editingIndex = -1;
    Ingredient selectedIngredient = null; //  <<< IMPORTANT. THIS WILL ALWAYS BE THE CURRENTLY SELECTED ITEM IN THE LIST, AND USUALLY UPDATES ON EACH CLICK. UNLIKE SELECTED/EDITING INDEX, WHICH WILL OCCASIONALLY STAY LOCKED FOR DATA PROCESSING PURPOSES
    @FXML
    protected void submit() // called every time submit button is hit (submit/create)
    {
        if(editing && editingIndex!=-1) { // checks if in editing mode, either updates selected item or adds new one
            updateShow();
            System.out.println("submitting edit");
        }
        else {
            addNewShow();
            System.out.println("adding new Show");
        }
    }
    @FXML
    protected boolean addNewShow() {
        if(startDate.getValue()==null || endDate.getValue()==null || !Utilities.isDouble(stallsPrice.getText()) || !Utilities.isDouble(circlePrice.getText()) || !Utilities.isDouble(balconyPrice.getText())) return false;
        // return false if values are empty or if IsDouble/IsType checks fail
        SystemData.ingredients.addElement(getFields()); // add item, remember that getFIelds should return relevant type
        showShows(); // update list view
        return true;
    }
    @FXML
    protected void removeShow() { // quick and easy delete. uses SelectedIndex
        System.out.println("now deleting "+selectedIndex);
        System.out.println("show was deleted?: "+showList.deleteNode(selectedIndex));
        showShows();
        updateView();
    }
    @FXML
    protected void updateShow() // called by submit if editing = true
    {
        if (!showList.updateNode(editingIndex, getFields())){
            infoText.setText("Error: Show could not be updated");
        }
        resetView();
    }
    @FXML
    protected void editShow() { // enable edit mode, called by edit button
        if(selectedIngredient != null){
            System.out.println("now editing "+selectedIndex);
            submit.setText("Submit");
            modeText.setText("Edit Show Info");
            editing = true;
            editingIndex = selectedIndex;
            setFields(selectedIngredient);
        }
    }
    // "Updating View" Methods
    @FXML
    protected void showShows() { // updates list
        showListView.getItems().clear();
        LinkedList<Show>.Node<Show> n = showList.head;
        while (n!=null){
            showListView.getItems().add(n.getContents().getTitle() + "     " + n.getContents().getStartDate()+" - "+n.getContents().getEndDate());
            n = n.next;
        }
    }
    @FXML
    protected void updateView() { // general view update, called on every click.
        selectedIndex = showListView.getSelectionModel().getSelectedIndex();
        System.out.println("selected index: "+selectedIndex);
        LinkedList<Show>.Node<Show> node = showList.getNode(selectedIndex);
        if(node!=null) { // disable buttons if no selected item
            selectedIngredient = node.getContents();
            viewPerfs.setDisable(false);
            edit.setDisable(false);
            delete.setDisable(false);
        }
        else {
            viewPerfs.setDisable(true);
            edit.setDisable(true);
            delete.setDisable(true);
        }
        if(!Utilities.isDouble(stallsPrice.getText())) stallsPrice.setText("");
        if(!Utilities.isDouble(circlePrice.getText())) circlePrice.setText("");
        if(!Utilities.isDouble(balconyPrice.getText())) balconyPrice.setText("");
        // resets textfields if type does not match
    }
    @FXML
    protected void resetView() // resets ALL fields, and returns to adding mode
    {
        System.out.println("Resetting view");
        editing = false;
        editingIndex = -1;
        submit.setText("Create Show");
        modeText.setText("Make New Show");
        infoText.setText("Info about the current action will be displayed here");
        showShows();

        title.setText("");
        runtime.setValue(90);
        startDate.setValue(null);
        endDate.setValue(null);
        stallsPrice.setText("");
        circlePrice.setText("");
        balconyPrice.setText("");
    }
    public void initialize() // called on every opening of this scene, as a new controller is created every time a scene is set
    {
        SVController = this; // when new controller instance is created, it becomes Controller
    }
    protected void setFields(Show showInfo) // fills all the fields with data FROM the currently selected item in the list view
    {
        title.setText(showInfo.getTitle());
        runtime.setValue(showInfo.getRuntime());
        startDate.setValue(LStartDate);
        endDate.setValue(LEndDate);
        stallsPrice.setText(""+showInfo.getStallsPrice());
        circlePrice.setText(""+showInfo.getCirclePrice());
        balconyPrice.setText(""+showInfo.getBalconyPrice());
    }
    protected Show getFields() // gets the info from the input tab. for fetching input when adding new item
    {
        //parse int for prices
        double stalls = Double.parseDouble(stallsPrice.getText());
        double circle = Double.parseDouble(circlePrice.getText());
        double balcony = Double.parseDouble(balconyPrice.getText());
        // double parsing to get value from textfield as number. Double check done in add function (at top)
        return new Show(title.getText(), (int)runtime.getValue(), Utilities.dateToString(startDate.getValue()), Utilities.dateToString(endDate.getValue()), stalls, circle, balcony);
    }
    public void openHomeView(ActionEvent actionEvent) throws IOException
    {
        ApplicationStart.mainStage.setScene(ApplicationStart.home);
        ApplicationStart.mainStage.setTitle("Home");
    }
    public void updateSlider() // updates the slider label on movement
    {
        abv.setValue(abv.getValue()); // this line fucking baffles me, but don't touch it
        abvText.setText(""+abv.getValue());
    }
}

