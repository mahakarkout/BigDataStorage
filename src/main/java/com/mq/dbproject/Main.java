package main.java.com.mq.dbproject;


import  main.java.com.mq.dbproject.implementations.TableManager;
import  main.java.com.mq.dbproject.implementations.Table;

import java.util.HashMap;
import java.util.Map;
public class Main {
public static void main(String[] args) {
        TableManager tableManager = new TableManager();

        // Create a new table
        tableManager.createTable("users");

        // Get the table to perform operations
        Table usersTable = tableManager.getTable("users");

        // Insert rows into the table
        Map<String, String> row1 = new HashMap<>();
        row1.put("id", "1");
        row1.put("name", "Maha");
        row1.put("email", "maha@example.com");
        usersTable.insert(row1);

        Map<String, String> row2 = new HashMap<>();
        row2.put("id", "2");
        row2.put("name", "Zo Alfekar");
        row2.put("email", "Deeb@example.com");
        usersTable.insert(row2);

        // Display the table
        usersTable.displayTable();

        // Update a row
        Map<String, String> updatedRow = new HashMap<>();
        updatedRow.put("id", "1");
        updatedRow.put("name", "MahaUpdated");
        updatedRow.put("email", "mahaupdated@example.com");
        usersTable.update("1", updatedRow);

        // Display the table again to see the changes
        usersTable.displayTable();

        // Drop the table
        tableManager.dropTable("users");

        // List tables (to verify it has been dropped)
        tableManager.listTables();
    }
}


