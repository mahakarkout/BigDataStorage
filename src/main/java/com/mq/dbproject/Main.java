package main.java.com.mq.dbproject;

import main.java.com.mq.dbproject.implementations.TableManager;
import main.java.com.mq.dbproject.implementations.Table;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    



                /*------------------------------Testing creating & inserting data in the disk----------------------------------*/
        TableManager tableManager = new TableManager();
        // Step 1: Create a new table called "users"
        tableManager.createTable("users");
        // Step 2: Get the "users" table to perform operations
        Table usersTable = tableManager.getTable("users");

        // Step 3: Insert some rows into the table
        Map<String, String> row1 = new HashMap<>();
        row1.put("id", "1");
        row1.put("name", "Maha");
        row1.put("email", "maha@example.com");
        usersTable.insert(row1);

        Map<String, String> row2 = new HashMap<>();
        row2.put("id", "2");
        row2.put("name", "Deeb");
        row2.put("email", "Deeb@example.com");
        usersTable.insert(row2);

        // Display the table to check the data was inserted correctly
        usersTable.displayTable();




        /*------------------------------Testing Loading the data from disk----------------------------------*/

        // TableManager tableManager = new TableManager();

        // // Step 1: Get the "users" table to perform operations
        // Table usersTable = tableManager.getTable("users");

        // // Step 2: Display the data from the table to confirm it was loaded correctly
        // if (usersTable != null) {
        //     usersTable.displayTable();
        // } else {
        //     System.out.println("Table not found.");
        // }



        /*------------------------------Testing updating the data in the disk----------------------------------*/

        // TableManager tableManager = new TableManager();

        // // Step 1: Get the "users" table to perform operations
        // Table usersTable = tableManager.getTable("users");
        // Map<String, String> updatedRow = new HashMap<>();
        // updatedRow.put("id", "1");
        // updatedRow.put("name", "Maha");
        // updatedRow.put("email", "mahaupdated@example.com");
        // usersTable.update("1", updatedRow);
        // usersTable.displayTable();



        /*------------------------------Testing deleting a row from data in the disk----------------------------------*/
        // TableManager tableManager = new TableManager();
        // // Step 1: Get the "users" table to perform operations
        // Table usersTable = tableManager.getTable("users");
        // usersTable.delete("2");

        // // Step 2: Display the table to verify changes
        // usersTable.displayTable();


    }
}
