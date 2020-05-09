package com.demo.oop.inherit.demo1_reuse;

public class Dog extends Mamal {

    public Dog() {
        System.out.println(" public Dog() is invoked");
    }

    public void bark() {
        System.out.println("barking...");
    }

    public static void main(String[] args) {
        //一定是先调用父类构造器，再调用本类构造器
        Dog dog=new Dog();

        //Dog类拥有本类和Mamal类、Animal类全部的方法
        dog.eat();
        dog.sleep();
        dog.drinkMilk();
        dog.bark();
    }


}
