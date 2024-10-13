package main.java.com.mq.dbproject.implementations;

import  main.java.com.mq.dbproject.interfaces.IQueryParser;

// import java.util.HashMap;
// import java.util.Map;

public class QueryParser implements IQueryParser {
    @Override
    public String[] parse(String query) {
        // A simple parse logic - this can be expanded later
        return query.split(" ");
    }
}
