/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ListController {
    public static ObservableList<Item> allList;

    //Table
    @FXML public TableView<Item> tableView;
    @FXML public TableColumn<Item, String> itemNameColumn;
    @FXML public TableColumn<Item, String> descriptionColumn;
    @FXML public TableColumn<Item, String> dueDateColumn;
    @FXML public TableColumn<Item, String> statusColumn;

    // Choice box
    @FXML ObservableList<String> displayBoxList = FXCollections.observableArrayList("All", "Incomplete", "Complete");
    @FXML private ChoiceBox displayBox;

    // Text field
    @FXML public TextField filePathField;
    @FXML public TextField fileNameField;

    // Initializers
    @FXML private void initialize() {
        initializeDisplayBox();
        initializeTable();
    }
    public void initializeDisplayBox() {
        displayBox.setValue("All");
        displayBox.setItems(displayBoxList);
    }
    public void initializeTable() {
        // sets up table columns
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("dueDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("status"));

        allList = ListFunctions.initialize();
        refreshView();

        //allow fields to be edited
        tableView.setEditable(true);
        itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public void refreshView() {
        tableView.setItems(allList);
    }

    // Allows user to change display
    public void changeDisplayType(ActionEvent actionEvent) {
        if(displayBox.getValue().toString().compareTo("All") == 0) {
            System.out.println("Display All");
            refreshView();
        }
        else if(displayBox.getValue().toString().compareTo("Incomplete") == 0) {
            System.out.println("Display Incomplete");
            tableView.setItems(ListFunctions.displayIncomplete(allList));
        }
        else if(displayBox.getValue().toString().compareTo("Complete") == 0) {
            System.out.println("Display Complete");
            tableView.setItems(ListFunctions.displayComplete(allList));
        }
    }

    //Change columns content with double click
    public void changeItemNameEvent(CellEditEvent cell) {
        Item itemSelected = tableView.getSelectionModel().getSelectedItem();
        itemSelected.setItemName(cell.getNewValue().toString());
    }
    public void changeDescriptionNameEvent(CellEditEvent cell) {
        Item itemSelected = tableView.getSelectionModel().getSelectedItem();
        if(cell.getNewValue().toString().length() <= 256) {
            itemSelected.setDescription(cell.getNewValue().toString());
        }
        else {
            itemSelected.setDescription("Over character Limit");
        }
    }
    public void changeStatusEvent(CellEditEvent cell) {
        Item itemSelected = tableView.getSelectionModel().getSelectedItem();
        if(cell.getNewValue().toString().toLowerCase().compareTo("complete") == 0) {
            itemSelected.setStatus(cell.getNewValue().toString());
            return;
        }
        else if(cell.getNewValue().toString().toLowerCase().compareTo("incomplete") == 0) {
            itemSelected.setStatus(cell.getNewValue().toString());
            return;
        }
            itemSelected.setStatus("Invalid");
    }
    public void changeDueDateEvent(CellEditEvent cell) {
        Item itemSelected = tableView.getSelectionModel().getSelectedItem();

        //verify entry using local date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(cell.getNewValue().toString(), formatter);

        itemSelected.setDueDate(date.toString());
    }

    // Button Functions
    public void deleteButtonClicked(ActionEvent actionEvent) {
        ListFunctions.deleteListItem(tableView.getSelectionModel().getSelectedItems(), allList);
        // refreshes display according to display selection
        changeDisplayType(actionEvent);
    }
    // creates new empty item
    public void addButtonClicked(ActionEvent actionEvent) {
        ListFunctions.addEmptyListItem(allList);
    }
    // calls import function and then refreshes Display based on type
    public void importButtonClicked(ActionEvent actionEvent) {
        FileManagement.importFile(filePathField.getCharacters().toString());
        changeDisplayType(actionEvent);

    }
    // exports to file using given name and path
    public void exportButtonClicked(ActionEvent actionEvent) {
        FileManagement.exportHandler(fileNameField, filePathField);
    }
    // assign display to new empty list
    public void clearListButtonClicked(ActionEvent actionEvent) {
        // Only allowed to be used when using all view
        if(displayBox.getValue().toString().toLowerCase().compareTo("all") == 0) {
            allList = FXCollections.observableArrayList();
            refreshView();
        }
    }
}

