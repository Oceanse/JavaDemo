package com.demo.oop.inherit.demo3_Polymorphism;


/**
 * 运行时多态性不能由数据成员实现。
 * 在下面给出的例子中，这两个类都有一个数据成员:speedlimit，通过引用子类对象的父类的引用变量来访问数据成员。
 * 由于我们访问的数据成员没有被重写，因此它将访问父类的数据成员
 */
public class PolymorphhismDemo3 {
    public static void main(String args[]){
        Bike obj=new Honda3();
        System.out.println(obj.speedlimit);//90
    }
}
class Bike {
    int speedlimit = 90;
}

class Honda3 extends Bike {
    int speedlimit = 150;
}
