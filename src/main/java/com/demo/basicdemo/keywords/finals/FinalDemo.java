package com.demo.basicdemo.keywords.finals;


/**
 * 不能被继承
 */
public class FinalDemo {
}


class Shoes {

    /**
     * 不能被修改
     */
    public static final String brand = "Anta";

    /**
     * 所属类被继承时候不能被重写
     */
    public final void function() {
        System.out.println("walk.....");
    }

}


/**
 * 类:  final修饰的类不能被继承
 * 方法：final修饰的方法不能被重写
 * 属性：final修饰的的属性一旦初始化后就不能修改
 */
class SportShoes extends Shoes {

    /*
    重写父类final方法编译报错
    @Override
    public void function(){
        System.out.println("run.....");
    }
    */




    /*只是添加@Override也会被认为是重写
    @Override
    public void function(){
    }
    */



    /*
    不加 @Override也会认为是重写，编译报错
    public void function(){
        System.out.println("run.....");
    }*/


}


// class RunShoes extends SportShoes{ }  final class不允许被继承

