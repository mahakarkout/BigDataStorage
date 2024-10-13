package main.java.com.mq.dbproject.implementations;

import main.java.com.mq.dbproject.interfaces.IQueryParser;

public class QueryParser implements IQueryParser {
    @Override
    public String[] parse(String query) {
        // A simple parse logic 
        return query.split(" ");
    }
}