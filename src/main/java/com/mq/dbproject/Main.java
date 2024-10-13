package main.java.com.mq.dbproject;



import main.java.com.mq.dbproject.implementations.KeyValueDatabase;
import main.java.com.mq.dbproject.interfaces.IDataBase;

public class Main {
    public static void main(String[] args) {
        IDataBase db = new KeyValueDatabase();
        
        // Insert data
        db.insert("user1", "Alice");
        db.insert("user2", "Bob");
        
        // Select data
        System.out.println("user1: " + db.select("user1")); // Should print "Alice"
        
        // Update data
        db.update("user1", "AliceUpdated");
        System.out.println("user1 after update: " + db.select("user1")); // Should print "AliceUpdated"
        
        // Delete data
        db.delete("user2");
        System.out.println("user2: " + db.select("user2")); // Should print "null"
    }
}

