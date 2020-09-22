package com.demo.oop.inherit.demo3_Polymorphism.OverrideDemo;


/**
 * 静态方法可以被继承，但是不能被重写覆盖
 * 静态方法是编译时绑定的，方法重写是运行时绑定的。
 */
public class Animal_override_static {
    public static void sleep(){
        System.out.println("sleep...");
    }

    public static void main(String[] args) {
        //子类可以继承拥有父类的静态方法
        Animal_override_static.sleep();
        Bat.sleep();
    }
}


class Bat extends Animal_override_static {


   /*静态方法不能被覆盖
   @Override
    public static void sleep(){
        System.out.println("sleep...");
    }*/

}
