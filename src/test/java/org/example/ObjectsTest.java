package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.example.Assertions.assertEquals;

public class ObjectsTest {

    public int myInt = 0;
    long myLong= 0;
    boolean b = false;

    String hello = "hello";

    @Test
    public void setId() {
        Container container;
        container = new Container();
        container.setId(23132);
        assertEquals(container.getId(), 23132);
    }

    @Test
    void toStringTest() {
        Container container;
        HashMap<String, String> database = new HashMap<>();
        container = new Container(database);
        assertEquals(container.toString(), "org.example.Container@2473b9ce");
        assertEquals(Container.VERSION, "1...");
        assertEquals(Container.geStaticId(), "1...");
    }

    @Test
    void moreConstructors() {
        Container container = new Container();
        assertEquals(container.toString(), "org.example.Container@2473b9ce");
    }

    @Test
    void booleanParsing() {
        assertEquals(true, Boolean.parseBoolean("true"));
        assertEquals(true, Boolean.parseBoolean("TRUE"));
        assertEquals(false, Boolean.parseBoolean(null));
        assertEquals(false, Boolean.parseBoolean(""));
    }
}
