package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamTest {


    private final List<City> cities = List.of(
            new City("Yux", 873),
            new City("redford", 220),
            new City("Yux", 310),
            new City("Yucatan", 87),
            new City("Terrace", 3_122_934));


    @Test
    void collectorsTpMap() {
    }

    @Test
    void groupBy() {
    }



    @Test
    void sumByReduce() {
    }

    @Test
    void toLongStream() {
    }


    public record City(String name, long population) {
    }

}


