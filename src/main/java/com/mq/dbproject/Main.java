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

        String tableName="managers";

        // Define the columns for the table
        List<String> tableCols = Arrays.asList("id", "name", "email");

        // Create a new table
        tableManager.createTable(tableName, tableCols);

        // fetch the table
        ITable newTable = tableManager.getTable(tableName);

        // Insert some rows
        if (newTable != null) {
            Map<String, String> row1 = new HashMap<>();
            row1.put("id", "1");
            row1.put("name", "MahaKarkout");
            row1.put("email", "maha@gmail.com");
            newTable.insert(row1);

            Map<String, String> row2 = new HashMap<>();
            row2.put("id", "2");
            row2.put("name", "DeebAli");
            row2.put("email", "Deeb@gmail.com");
            newTable.insert(row2);


            // Display the data
            newTable.displayTable();




        /*------------------------------Testing Loading the data from disk----------------------------------*/

        // ITableManager tableManager = new TableManager();

        

        // // Define the columns for the table
        // List<String> tableCols = Arrays.asList("id", "name", "email");

        // // Step 2: Get the "users" table to perform operations
        //  ITable usersTable = tableManager.getTable("managers");

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
        // updatedRow.put("name", "MahaUpdated");
        // updatedRow.put("email", "mahaupdated@example.com");
        // usersTable.update("1", updatedRow);
        // usersTable.displayTable();



        /*------------------------------Testing deleting a row from data in the disk----------------------------------*/
        // System.out.println("\n--- Testing Delete Row ---");
        // ITable usersTable = tableManager.getTable("managers");
        
        // if (usersTable != null) {
        //     boolean deleted = usersTable.delete("2"); // Try to delete row with key "2"
    
        //     if (!deleted) {
        //         System.out.println("Attempted to delete non-existent row with ID '2'.");
        //     }
    
        //     usersTable.displayTable();
        // } else {
        //     System.out.println("Error: Table managers not found.");
        // }
    
}
}

}


