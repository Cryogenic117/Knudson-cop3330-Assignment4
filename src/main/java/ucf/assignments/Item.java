/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private final SimpleStringProperty itemName;
    private final SimpleStringProperty description;
    private final SimpleStringProperty status;
    private final SimpleStringProperty dueDate;

    public Item(String itemName, String description, String status, String dueDate) {
        this.itemName = new SimpleStringProperty(itemName);
        this.description = new SimpleStringProperty(description);
        this.status = new SimpleStringProperty(status);
        this.dueDate = new SimpleStringProperty(dueDate);
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getDueDate() {
        return dueDate.get();
    }

    public void setDueDate(String dueDate) {
        this.dueDate.set(dueDate);
    }

    @Override
    public String toString() {
        return getItemName() +"|"+getDescription()+"|"+getDueDate()+"|"+getStatus();
    }
}