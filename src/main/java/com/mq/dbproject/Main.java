package main.java.com.mq.dbproject;

import main.java.com.mq.dbproject.implementations.TableManager;
import main.java.com.mq.dbproject.interfaces.ITable;
import main.java.com.mq.dbproject.interfaces.ITableManager;
import main.java.com.mq.dbproject.implementations.Table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    
                /*------------------------------Testing creating & inserting data in the disk----------------------------------*/


        ITableManager tableManager = new TableManager();

        // Step 1: Define the schema for the "users" table
        List<String> userSchema = Arrays.asList("id", "name", "email");

        // Step 2: Create a new table called "users" with the defined schema
        tableManager.createTable("users", userSchema);

        // Step 3: Get the "users" table to perform operations
        ITable usersTable = tableManager.getTable("users");

        // Step 4: Insert some rows into the table
        if (usersTable != null) {
            Map<String, String> row1 = new HashMap<>();
            row1.put("id", "1");
            row1.put("name", "Maha");
            row1.put("email", "maha@gmail.com");
            usersTable.insert(row1);

            // Attempt to insert an invalid row (missing a column)
            Map<String, String> row2 = new HashMap<>();
            row2.put("id", "2");
            row2.put("name", "Deeb");
            row2.put("email", "Deeb@gmail.com");
            usersTable.insert(row2); // This should fail since "email" is missing

            // Display the table to check the data
            usersTable.displayTable();




        /*------------------------------Testing Loading the data from disk----------------------------------*/

        // ITableManager tableManager = new TableManager();

        // // Step 1: Define the schema for the "users" table
        // List<String> userSchema = Arrays.asList("id", "name", "email");

        // // Step 2: Get the "users" table to perform operations
        //  ITable usersTable = tableManager.getTable("users");

        // // Step 3: Display the data from the table to confirm it was loaded correctly
        // if (usersTable != null) {
        //     usersTable.displayTable();
        // } else {
        //     System.out.println("Table not found.");
        // }



        /*------------------------------Testing updating the data in the disk----------------------------------*/

        // ITableManager tableManager = new TableManager();

        // // Step 1: Get the "users" table to perform operations
        //  ITable usersTable = tableManager.getTable("users");
        // Map<String, String> updatedRow = new HashMap<>();
        // updatedRow.put("id", "1");
        // updatedRow.put("name", "Maha");
        // updatedRow.put("email", "mahaupdated@example.com");
        // usersTable.update("1", updatedRow);
        // usersTable.displayTable();



        /*------------------------------Testing deleting a row from data in the disk----------------------------------*/
        // ITableManager tableManager = new TableManager();
        // // Step 1: Get the "users" table to perform operations
        //  ITable usersTable = tableManager.getTable("users");
        // usersTable.delete("2");

        // // Step 2: Display the table to verify changes
        // usersTable.displayTable();


    }
}
}



