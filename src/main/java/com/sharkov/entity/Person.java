package com.sharkov.entity;

public class Person {
        private long id;
        private String name;
        private String lastName;
        private int salary;

    public Person(long id, String name, String lastName, int salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
