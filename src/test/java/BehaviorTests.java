/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brandon Knudson
 */
import org.junit.jupiter.api.Test;

public class BehaviorTests {
    @Test
    private void addNewList() {
        // read in list by being given a path
        // appendList to hashmap
        // check hashmap to see if the list was added successfully
    }
    @Test
    private void removeList() {
        // take name of list
        // search for name in hashmap
        // call remove list function
        // check that the list is gone
    }
    @Test
    private void editListTitle() {
        // take in list title
        // search for name
        // replace name with test name
        // check for test name
    }
    @Test
    private void addItemToList() {
        // take in list title
        // search for name
        // add item to list
        // check size params
        // check test item is in place
    }
    @Test
    private void removeItemFromList() {
        // take in list title
        // take in name of item
        // search for item by name
        // delete item
        // check to ensure item is not present
    }
    @Test
    private void editDescription() {
        // take in list title
        // take in item name
        // search for item in title
        // replace description
        // ensure test description is present in correct item
    }
    @Test
    private void editDate() {
        // take in list title
        // search by name
        // replace title
        // check correct item has new test date
    }
    @Test
    private void markComplete() {
        // search for item by name
        // set status stored in item class to incomplete
        // check correct status
    }
    @Test
    private void Display() {
        // create test list of 100 items
        // check display all by displaying each item to gui
        // check for errors
        // test it loops 100 times
    }
    @Test
    private void DisplayComplete() {
        // create a list of 100 items with complete status
        // ensure all are displayed
        // check for incomplete status in what is sent to gui
    }
    @Test
    private void DisplayIncomplete() {
        // create a list of 100 items with incomplete status
        // ensure all are displayed
        // check for complete status in what is sent to gui
    }
    @Test
    private void saveList() {
        // search for list by name
        // call write file function on list
        // test outfile for matching expected values
    }
    @Test
    private void SaveAllLists() {
        // iterate through lists
        // call write function for each list
        // test outfile for matching expected values
    }
    @Test
    private void importList() {
        // read text file in path location
        // load text file data to Map
        // check data in list to match
    }
    @Test
    private void importMultipleLists() {
        // read text file in path location
        // load text file data to Map
        // check data for all lists to match
    }
}
