package com.demo.basicdemo.code_block.construct_block;

/**
 * Person类中存在若干个包含相同代码逻辑的构造函数，存在很多重复代码，
 */
public class Person {
    String name;
    int age;

    public Person() {
        System.out.println("I am chinese");
    }

    public Person(String name) {
        System.out.println("I am chinese");
        this.name = name;
    }

    public Person(int age) {
        System.out.println("I am chinese");
        this.age = age;
    }

    public Person(String name, int age) {
        System.out.println("I am chinese");
        this.name = name;
        this.age = age;
    }


}
