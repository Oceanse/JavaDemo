package com.demo.oop.inherit.demo3_private;

public class Person {
    public String name;
    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
