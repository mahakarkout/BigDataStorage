package main.java.com.mq.dbproject.implementations;

import java.util.HashMap;
import java.util.Map;

public class TableManager {
    private Map<String, Table> tables;

    public TableManager() {
        tables = new HashMap<>();
    }

    // Create a new table
    public void createTable(String tableName) {
        if (tables.containsKey(tableName)) {
            System.out.println("Table " + tableName + " already exists.");
            return;
        }
        tables.put(tableName, new Table(tableName));
        System.out.println("Table " + tableName + " created.");
    }

    // Drop an existing table
    public void dropTable(String tableName) {
        if (tables.containsKey(tableName)) {
            tables.remove(tableName);
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
}
