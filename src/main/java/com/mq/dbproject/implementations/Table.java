package main.java.com.mq.dbproject.implementations;

import main.java.com.mq.dbproject.interfaces.ITable;
import main.java.com.mq.dbproject.utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table implements ITable {
    private String tableName;
    private Map<String, Map<String, String>> rows; // Key is row key, value is a map representing columns
    private List<String> schema; // Schema for the table, defines expected columns

    public Table(String tableName, List<String> schema) {
        this.tableName = tableName;
        this.schema = schema;
        this.rows = new HashMap<>();
        loadFromFile(); // Load existing data from disk
    }

    @Override
    public void insert(Map<String, String> row) {
        String primaryKey = row.get("id");
        if (primaryKey == null) {
            System.out.println("Primary key 'id' is required.");
            return;
        }

        if (!validateRow(row)) {
            System.out.println("Invalid row. The row must contain all columns specified in the schema: " + schema);
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
            if (!validateRow(newRow)) {
                System.out.println("Invalid row. The row must contain all columns specified in the schema: " + schema);
                return;
            }
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
        System.out.println("Schema: " + schema);
        for (Map.Entry<String, Map<String, String>> entry : rows.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Row: " + entry.getValue());
        }
    }

    // Helper methods for validation and file handling
    private boolean validateRow(Map<String, String> row) {
        if (row.size() != schema.size()) {
            return false;
        }
        for (String column : schema) {
            if (!row.containsKey(column)) {
                return false;
            }
        }
        return true;
    }

    private void saveToFile() {
        FileUtils.saveTableToFile(rows, tableName + ".txt");
    }

    private void loadFromFile() {
        FileUtils.loadTableFromFile(rows, tableName + ".txt");
    }
}
