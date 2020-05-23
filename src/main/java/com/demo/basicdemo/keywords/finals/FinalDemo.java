package com.demo.basicdemo.keywords.finals;


/**
 * 类:  final修饰的类不能被继承
 * 方法：final修饰的方法不能被重写
 * 属性：final修饰的的属性不能修改
 */
public class FinalDemo {

    public static void main(String[] args) {
        //Shoes.brand="Lining";
    }
}

class Shoes{

    /**
     * 不能被修改
     */
    public static final String brand="Anta";

    /**
     * 不能被重写
     */
    public final void function(){
        System.out.println("walk.....");
    }

}

/**
 * 不能被继承
 */
final class SportShoes extends Shoes{

    /*
    编译报错
    @Override
    public void function(){
        System.out.println("run.....");
    }
    */



    /*
    不加 @Override也会认为是重写，编译报错
    public void function(){
        System.out.println("run.....");
    }*/


}



// class RunShoes extends SportShoes{ }  final class不允许被继承

