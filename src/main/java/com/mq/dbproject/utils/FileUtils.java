package main.java.com.mq.dbproject.utils;

import java.io.*;
import java.util.Map;

public class FileUtils {
    public static void saveToFile(Map<String, String> store, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : store.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromFile(Map<String, String> store, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    store.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            // File might not exist yet, that’s okay
            e.printStackTrace();
        }
    }
}
