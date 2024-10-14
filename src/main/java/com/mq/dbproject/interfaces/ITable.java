package main.java.com.mq.dbproject.interfaces;

import java.util.Map;

public interface ITable {
    void insert(Map<String, String> row);
    Map<String, String> select(String key);
    void update(String key, Map<String, String> newRow);
    void delete(String key);
    void displayTable();
}
