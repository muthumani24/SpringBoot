package com.muthu.autowhatsapp.model;

public class Person {

    private String name;
    private String dob;

    public Person(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }
}
