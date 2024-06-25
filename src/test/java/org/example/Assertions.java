package org.example;


import java.util.Objects;

public class Assertions {
    public static void assertEquals(int actual, int expected) {
        if (actual != expected) {
            throw new AssertionError("expected %s to be equal but was %s".formatted(expected, actual));
        }
    }

    public static void assertEquals(Object actual, Object expected) {
        if (!Objects.equals(actual, expected)) {
            throw new AssertionError("expected %s to be equal but was %s".formatted(expected, actual));
        }
    }

    public static <T extends Throwable> T assertThrows(Class<T> clazz, Runnable task) {
        try {
            task.run();
        } catch (Throwable e) {
            if (clazz.isInstance(e)) {
                return (T) e;
            }
        }
        throw new AssertionError("expected exception to be thrown but got nothing");
    }
}