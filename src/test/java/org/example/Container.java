package org.example;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private int id = 123;
    private Map<String, String> database;
    private Map<String, String> fluxSystem;

    public static final String VERSION = "1.5.42";

    public Container() {
        this(new HashMap<>());
    }

    public Container(Map<String, String> database) {
        this.database = database;
        fluxSystem = new HashMap<>();
    }

    public void setId(int i) {
        id = i;
    }

    public String getId() {
        return runComplexIdFetching();
    }

    public static int geStaticId() {
        return Integer.parseInt(VERSION);
    }

    private String runComplexIdFetching() {
        String returnId = database.get("id");
        if (returnId == null) {
            returnId =  fluxSystem.get("id");
        }
        return returnId;
    }
}
