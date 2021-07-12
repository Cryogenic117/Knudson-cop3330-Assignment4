/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListFunctions {
    // Create New Observable List and add one empty item
    public static ObservableList<Item> initialize() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        addEmptyListItem(items);
        return items;
    }
    // Create new list with only "complete" status items
    public static ObservableList<Item> displayComplete(ObservableList<Item> items) {
        ObservableList<Item> completeList = FXCollections.observableArrayList();
        for (Item item : items) {
            if (item.getStatus().toLowerCase().compareTo("complete") == 0) {
                completeList.add(item);
            }
        }
        return completeList;
    }
    // Create new list with only "incomplete" status items
    public static ObservableList<Item> displayIncomplete(ObservableList<Item> items) {
        ObservableList<Item> incompleteList = FXCollections.observableArrayList();
        for (Item item : items) {
            if (item.getStatus().toLowerCase().compareTo("incomplete") == 0) {
                incompleteList.add(item);
            }
        }
        return incompleteList;
    }
    // create list item with default values
    public static void addEmptyListItem(ObservableList<Item> items) {
        items.add(new Item("Enter Item name", "Enter up to 256 Characters", "Enter Complete or Incomplete", "YYYY-MM-DD"));
    }
    // Uses setters from item to convert strings to item
    public static void addListItem(String item, String description, String dueDate, String status) {
        ListController.allList.add(new Item(item, description, dueDate, status));
    }
    // Search All list for list of items selected to be deleted and delete if found
    public static void deleteListItem(ObservableList<Item> selected, ObservableList<Item> list) {
        for(Item item : selected) {
            list.remove(item);
        }
    }
}
