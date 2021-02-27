package com.vip.guess.model;

public class Trophy {
    private final String name;
    private int length;

    public Trophy(String name, int length) {
        this.name = name;
        this.length = length;
    }


    public Trophy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
