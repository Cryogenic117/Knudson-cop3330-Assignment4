/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brandon Knudson
 */
package ucf.assignments;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class FileManagement {

    public static void exportHandler(TextField fileNameField , TextField filePathField) {
        // if there is no name for file do not run function
        if(fileNameField.getCharacters().toString().isEmpty()) {
            return;
        }
        Boolean attemptStatus = writeToFile(fileNameField.getCharacters().toString(), filePathField.getCharacters().toString());
        // if the file doesn't write properly give user error
        if(!attemptStatus) {
            filePathField.setText("Invalid Path");
        }
        // if file writes successfully clear user input
        else {
            fileNameField.setText("");
            filePathField.setText("");
        }
    }

   public static Boolean writeToFile(String name, String filePath) {
       PrintWriter writer;

       try {
           FileWriter fw = new FileWriter(filePath + "\\" + name + ".txt", false);
           writer = new PrintWriter(fw);
       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
       // iterate trough list and print item to text file
       writer.println(ListController.allList.size());
       for(int i = 0; i < ListController.allList.size(); i++) {
           writer.println(ListController.allList.get(i).toString());
       }
       writer.close();

       return true;
   }

   public static Boolean importFile(String filePath) {
     File file = new File(filePath);
       int itemCount;
       try {
           Scanner sc = new Scanner(file);
           // get item count
           if (sc.hasNextInt()) {
               itemCount = sc.nextInt();
           }
           // if file format doesn't include number of items
           else {
               System.out.println("Invalid File Format");
               return false;
           }
           sc.nextLine();
           // Iterate through text file and read each item by line
           for(int i = 1; i <= itemCount; i++) {
               String name, description, dueDate, status;
               String temp = sc.nextLine();
               // Separate line by |
               String[] itemContents = temp.split("\\|");
               // assign values
               name = itemContents[0];
               description = itemContents[1];
               status = itemContents[2];
               dueDate = itemContents[3];
               // create list with assigned values
               ListFunctions.addListItem(name, description, dueDate, status);

           }
           sc.close();
           return true;
       } catch (FileNotFoundException e) {
           e.printStackTrace();
           return false;
       }
   }
}
