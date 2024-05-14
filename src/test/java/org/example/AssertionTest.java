package org.example;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.example.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class AssertionTest {

    @Test
    void intEquals() {
        assertEquals(1, 1);
    }

    @Test
    void doubleEquals() {
        assertEquals(1., 1.);
    }

    @Test
    void intEqualsFails() {
        var e = Assertions.assertThrows(AssertionError.class, () -> assertEquals(1, 2));
        assertEquals(e.getMessage(), "expected 2 to be equal but was 1");
    }

    @Test
    void stringEquals() {
        assertEquals("a", "a");
    }

    @Test
    void stringNotEquals() {
        assertThrows(AssertionError.class, () -> assertEquals("a", "b"));
    }


    @Test
    void stringNotEquals2() {
        Assertions.assertThrows(AssertionError.class, () -> assertEquals("a", "b"));
    }

    @Test
    void objectEquals() {
        var it = new Resource("id");
        var other = new Resource("id");
        assertEquals(it, other);
    }

    @Test
    void objectNotEquals() {
        var it = new Resource("it");
        var other = new Resource("other");
        Assertions.assertThrows(AssertionError.class, () -> assertEquals(it, other));
    }
}