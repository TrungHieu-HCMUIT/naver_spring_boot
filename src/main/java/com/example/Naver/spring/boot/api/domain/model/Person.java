package com.example.naver.spring.boot.api.domain.model;

import java.util.UUID;

public class Person {

    private UUID id;
    private String name;
    private int age;
    private String hobbies;

    public Person(String name, int age, String hobbies) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return String.format("Person\nId: %s\nName: %s\nAge: %d\nHobbies: %s\n", id.toString(), name, age, hobbies);
    }
}
