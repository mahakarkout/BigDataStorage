package main.java.com.mq.dbproject.implementations;

import main.java.com.mq.dbproject.interfaces.IDataBase;
import java.util.HashMap;
import java.util.Map;

public class KeyValueDatabase implements IDataBase {
    private Map<String, String> store;

    public KeyValueDatabase() {
        store = new HashMap<>();
    }

    @Override
    public void insert(String key, String value) {
        store.put(key, value);
    }

    @Override
    public String select(String key) {
        return store.get(key);
    }

    @Override
    public void update(String key, String value) {
        if (store.containsKey(key)) {
            store.put(key, value);
        } else {
            System.out.println("Key not found");
        }
    }

    @Override
    public void delete(String key) {
        store.remove(key);
    }
}