package main.java.com.mq.dbproject.implementations;

import main.java.com.mq.dbproject.interfaces.ITable;
import main.java.com.mq.dbproject.interfaces.ITableManager;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableManager implements ITableManager {
    private Map<String, ITable> tables;

    public TableManager() {
        tables = new HashMap<>();
        loadExistingTables(); // Load existing tables from disk
    }

    @Override
    public void createTable(String tableName, List<String> cols) {
        if (tables.containsKey(tableName)) {
            System.out.println("Table " + tableName + " already exists.");
            return;
        }
        ITable newTable = new Table(tableName, cols); // Note we create using Table implementation but store as ITable
        tables.put(tableName, newTable);
        System.out.println("Table " + tableName + " created with columns: " + cols);
    }

    @Override
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

    @Override
    public ITable getTable(String tableName) {
        return tables.get(tableName);
    }

    @Override
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
                    ITable table = new Table(tableName, List.of("id", "name", "email"));
                    tables.put(tableName, table);
                    System.out.println("Loaded table: " + tableName);
                }
            }
        } else {
            System.out.println("No existing tables found.");
        }
    }
}
