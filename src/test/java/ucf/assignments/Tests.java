/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tests {

    @Test
    void addListItem() {
        ObservableList<Item> test = FXCollections.observableArrayList();
        ListFunctions.addEmptyListItem(test);

        Assertions.assertFalse(test.isEmpty());

    }
    @Test
    void removeListItem() {
        ObservableList<Item> test = FXCollections.observableArrayList();
        ListFunctions.addEmptyListItem(test);

        test.remove(0);

        Assertions.assertTrue(test.isEmpty());
    }
    @Test
    void clearList() {
        ObservableList<Item> test = FXCollections.observableArrayList();
        ListFunctions.addEmptyListItem(test);
        ListFunctions.addEmptyListItem(test);
        ListFunctions.addEmptyListItem(test);
        ListFunctions.addEmptyListItem(test);
        ListFunctions.addEmptyListItem(test);

        test = FXCollections.observableArrayList();
        Assertions.assertTrue(test.isEmpty());
    }
    @Test
    void DisplayComplete() {
        ObservableList<Item> test = FXCollections.observableArrayList();
        test.add(new Item("Test1", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test2", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test3", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test1", "This is a test" , "Incomplete" , "2021-01-01"));
        test.add(new Item("Test2", "This is a test" , "Incomplete" , "2021-01-01"));
        test = ListFunctions.displayComplete(test);

        Assertions.assertEquals(3,test.size());
    }
    @Test
    void DisplayIncomplete() {
        ObservableList<Item> test = FXCollections.observableArrayList();
        test.add(new Item("Test1", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test2", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test3", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test1", "This is a test" , "Incomplete" , "2021-01-01"));
        test.add(new Item("Test2", "This is a test" , "Incomplete" , "2021-01-01"));
        test = ListFunctions.displayIncomplete(test);

        Assertions.assertEquals(2,test.size());
    }
    @Test
    void ExportListTest() {
        ObservableList<Item> test = FXCollections.observableArrayList();
        test.add(new Item("Test1", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test2", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test3", "This is a test" , "Complete" , "2021-01-01"));
        test.add(new Item("Test1", "This is a test" , "Incomplete" , "2021-01-01"));
        test.add(new Item("Test2", "This is a test" , "Incomplete" , "2021-01-01"));

        ListController.allList = test;
        String path = "C:\\Users\\bknud\\Desktop\\test";

        Assertions.assertTrue(FileManagement.writeToFile("test1", path));


    }
    @Test
    void importListTest() {
        ListController.allList = FXCollections.observableArrayList();
        String path = "C:\\Users\\bknud\\Desktop\\test";

        Assertions.assertTrue(FileManagement.importFile(path+"\\test1.txt"));
    }

}