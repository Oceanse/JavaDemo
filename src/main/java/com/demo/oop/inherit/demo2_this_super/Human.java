package com.demo.oop.inherit.demo2_this_super;

public class Human {

    private String name;
    private int age;
    private boolean married;

    public Human() {
        System.out.println("Human() is invoked");
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, boolean married) {
        this(name,age);//this调用本类重载构造函数
        this.married = married;
        System.out.println("Human(String name, int age, boolean married) is called");
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

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void info() {
        System.out.println(name + " is " + age + " years old and is he married: "+married);
    }

    public static void showNation(){
        System.out.println(" I come from China");
    }

}




