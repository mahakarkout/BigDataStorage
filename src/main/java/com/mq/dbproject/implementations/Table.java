package main.java.com.mq.dbproject.implementations;


import main.java.com.mq.dbproject.interfaces.ITable;
import main.java.com.mq.dbproject.utils.FileUtils;

import java.util.HashMap;
import java.util.Map;

public class Table implements ITable {
    private String tableName;
    private Map<String, Map<String, String>> rows; // Key is row key, value is a map representing columns

    public Table(String tableName) {
        this.tableName = tableName;
        this.rows = new HashMap<>();
        loadFromFile(); // Load data from disk
    }

    @Override
    public void insert(Map<String, String> row) {
        String primaryKey = row.get("id");
        if (primaryKey == null) {
            System.out.println("Primary key 'id' is required.");
            return;
        }
        rows.put(primaryKey, row);
        saveToFile();
    }

    @Override
    public Map<String, String> select(String key) {
        return rows.get(key);
    }

    @Override
    public void update(String key, Map<String, String> newRow) {
        if (rows.containsKey(key)) {
            rows.put(key, newRow);
            saveToFile();
        } else {
            System.out.println("Row not found for key: " + key);
        }
    }

    @Override
    public void delete(String key) {
        rows.remove(key);
        saveToFile();
    }

    @Override
    public void displayTable() {
        System.out.println("Table: " + tableName);
        for (Map.Entry<String, Map<String, String>> entry : rows.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Row: " + entry.getValue());
        }
    }

    // Save all rows to file
    private void saveToFile() {
        FileUtils.saveTableToFile(rows, tableName + ".txt");
    }

    // Load rows from file
    private void loadFromFile() {
        FileUtils.loadTableFromFile(rows, tableName + ".txt");
    }
}
