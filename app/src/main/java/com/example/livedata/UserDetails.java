package com.example.livedata;

public class UserDetails {
    private String name;
    private int age;

    public UserDetails(String name, int age) {
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
