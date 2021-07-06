/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.io.IOException;

public class ListController {
    @FXML
    ObservableList<String> displayBoxList = FXCollections.observableArrayList("All", "Incomplete", "Complete");
    @FXML
    // set up choice box
    private ChoiceBox displayBox;
    @FXML
    private void initialize() {
        displayBox.setValue("All");
        displayBox.setItems(displayBoxList);

    }

    // Button Functions
    @FXML
    public void nextButtonClicked(ActionEvent actionEvent) {
        // getList(next)
        // display next List on table
    }
    public void previousButtonClicked(ActionEvent actionEvent) {
        // getList(previous)
        //display previous list on table
    }
    void displayBoxListener() {
        // if(displaybox is all) do nothing
        // else if (display box = completed) show only completed items in list
        // else if (display box = completed) show only uncompleted items in list
    }
    public void changeButtonClicked(ActionEvent actionEvent) {
        //check namefield if empty continue else replace
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
        //get name in Name field if empty ignore input
        // search for name in Map once found delete name
    }

    public void deleteListButtonClicked(ActionEvent actionEvent) {
        //delete entire list currently displayed
    }

    public void addButtonClicked(ActionEvent actionEvent) {
        //add list item if Name field isn't empty
        // if any other field is empty default to "empty"
    }

    public void importButtonClicked(ActionEvent actionEvent) {
        //attempt to download external text file with correct format to list
        // capable of importing as many lists as included in text file
    }

    public void exportAllButtonClicked(ActionEvent actionEvent) {
        // will write all lists stored in ram to a text file and call write function for each list
    }

    public void exportButtonClicked(ActionEvent actionEvent) {
        //will export the currently displayed list
    }
    public void createListButtonClicked(ActionEvent actionEvent) {
        //reads list name field
        // creates text file with data
        // passes text file to create list function
    }

    public void changeDescriptionButtonClicked(ActionEvent actionEvent) {
        // will take the name entered in namefield and if it matches a current entry then the description will change to what is in the description field
    }

    public void changeNameButtonClicked(ActionEvent actionEvent) {
        // Will match name in name field with entry and replace with value in NewNameField
    }

    public void changeDateButtonClicked(ActionEvent actionEvent) {
        // WIll match name with result and replace the date with the dateduefield
    }


    public void completeItemButtonPressed(ActionEvent actionEvent) {
        // take in name field and mark corresponding item as complete
    }
}

