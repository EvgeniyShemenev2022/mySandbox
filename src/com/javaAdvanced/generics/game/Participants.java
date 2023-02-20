package com.javaAdvanced.generics.game;

public abstract class Participants {

    private String name;
    private int age;

    public Participants(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
