package main.java.com.mq.dbproject.interfaces;

public interface IDataBase {
    void insert(String key, String value);
    String select(String key);
    void update(String key, String value);
    void delete(String key);
}
