package main.java.com.mq.dbproject.interfaces;

import java.util.List;

public interface ITableManager {
    void createTable(String tableName, List<String> schema);
    void dropTable(String tableName);
    ITable getTable(String tableName);
    void listTables();
}