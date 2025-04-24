package org.example;

public record Hello(String name, Long id) {

    private static final String low;

    static{
        low = "15";
    }

    public Hello{
        name = name;
        id = id;
    }
}
