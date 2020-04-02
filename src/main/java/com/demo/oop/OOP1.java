package com.demo.oop;
/*
*类：对具有相同属性(成员变量)行为(方法)的一组对象的集合
*对象：也称为实例，根据类生成的具体实体，具有明确定义的属性(成员变量)和行为(方法),不同的对象具有各自的一套属性和行为
*类可以理解为汽车设计图，对象就是根据图纸设计出的每辆汽车
* 面向对象程序设计的重点是类的设计
*
* 类和对象的使用:
* 1.创建类，设计类的成员
  2.创建类的对象
  3.通过“对象.属性”或“对象.方法”调用对象的结构。

  关于对象引用：引用是一个变量，是局部变量或者成员变量，引用变量本身有自己的内存地址，并且还保存着对象所在堆内存的地址

* 类成员组成设计：成员变量(类成员变量和实例成员变量) 方法 构造器 代码块 内部类
* 三大特性：封装  (Encapsulation)，继承  (Inheritance)，多态  (Polymorphism)

* */

public class OOP1 {

   //实例变量;
   private String name;
   boolean isMarried;

   //类变量
   private static String nation;


    //构造器
    public OOP1(String name, boolean isMarried) {
        this.name = name;
        this.isMarried = isMarried;
    }

    //方法
    public void show() {
        System.out.println(name + "\t" + isMarried);
    }

    //代码块
    {
        int age = 30;

    }

    //内部类
    class InnerClass{}


}
