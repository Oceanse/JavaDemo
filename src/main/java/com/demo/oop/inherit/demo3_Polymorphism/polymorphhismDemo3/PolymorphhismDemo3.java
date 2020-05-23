package com.demo.oop.inherit.demo3_Polymorphism.polymorphhismDemo3;


/**
 静态绑定(属性)：编译期和运行期，成员变量（包括静态变量和实例变量）只与引用变量所声明的类型的对象绑定，
 这种绑定属于静态绑定，因为在编译阶段已经做了绑定
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
