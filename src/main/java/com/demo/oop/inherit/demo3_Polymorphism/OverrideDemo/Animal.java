package com.demo.oop.inherit.demo3_Polymorphism.OverrideDemo;

import com.demo.concurrent.threadpool.A;

/**
 * 重写(Override)
 * 当父类实例方法不能满足子类需求，可以对父类继承的方法进行重写,重写只是针对方法，不针对属性，重写后子类只拥有重写后的方法
 * 子类方法和父类方法的返回值 方法名(参数)完全相同时候，编译器就会认为子类对父类方法进行了重写，无论带不带有@Override
 * 重写方法的方法名/参数必须和被重写的方法保持一致
 * 重写后方法的权限不能小于被重写方法的权限
 * 重写后方法的返回值类型比被重写的方法的返回值类型更小或者相等
 * 重写后方法抛出的异常不能多于被重写方法
 * 静态方法不能被覆盖
 */
public class Animal {
    void move() {
        System.out.println("移动");
    }



    Object demo(){
        return "hi";
    }

    public static void main(String[] args) {
        Animal a =new Sparrow();
        a.move();
    }
}


class Bird extends Animal {

    //重写后方法的权限可以变大
    @Override
    public void move() {
        System.out.println("飞翔");
    }

    // 重写后方法的返回值类型比被重写的方法的返回值类型更小或者相等
    @Override
    public String demo() {
        return "飞翔";
    }



   /*
    重写后方法的权限不能小于被重写方法的权限
    @Override
    private void move() {
        System.out.println("飞翔");
    }*/

}





class Sparrow extends Bird {

    @Override
    public void move(){
        System.out.println("麻雀飞翔");
    }



  /*静态方法不能被重写
    @Override
    public static void sleep(){
        System.out.println("123sleep...");
    }*/
}

