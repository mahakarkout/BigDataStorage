package main.java.com.mq.dbproject.implementations;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TableManager {
    private Map<String, Table> tables;

    public TableManager() {
        tables = new HashMap<>();
        loadExistingTables(); // Load existing tables from disk
    }

    // Create a new table
    public void createTable(String tableName) {
        if (tables.containsKey(tableName)) {
            System.out.println("Table " + tableName + " already exists.");
            return;
        }
        Table newTable = new Table(tableName);
        tables.put(tableName, newTable);
        System.out.println("Table " + tableName + " created.");
    }

    // Drop an existing table
    public void dropTable(String tableName) {
        if (tables.containsKey(tableName)) {
            tables.remove(tableName);
            File tableFile = new File("db_data/" + tableName + ".txt");
            if (tableFile.exists()) {
                tableFile.delete(); // Delete the file when dropping the table
            }
            System.out.println("Table " + tableName + " dropped.");
        } else {
            System.out.println("Table " + tableName + " does not exist.");
        }
    }

    // Get a table to perform operations on it
    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    // List all available tables
    public void listTables() {
        System.out.println("Available tables:");
        for (String tableName : tables.keySet()) {
            System.out.println("- " + tableName);
        }
    }

    // Load existing tables from the disk
    private void loadExistingTables() {
        File dbDirectory = new File("db_data");
        if (dbDirectory.exists() && dbDirectory.isDirectory()) {
            File[] tableFiles = dbDirectory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (tableFiles != null) {
                for (File tableFile : tableFiles) {
                    String tableName = tableFile.getName().replace(".txt", "");
                    Table table = new Table(tableName);
                    tables.put(tableName, table);
                    System.out.println("Loaded table: " + tableName);
                }
            }
        } else {
            System.out.println("No existing tables found.");
        }
    }
}
