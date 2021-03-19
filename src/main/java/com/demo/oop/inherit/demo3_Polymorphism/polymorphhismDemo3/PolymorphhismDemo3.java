package com.demo.oop.inherit.demo3_Polymorphism.polymorphhismDemo3;


/**
 属性静态绑定：编译期和运行期，成员变量（包括静态变量和实例变量）只与引用变量所声明的类型的对象绑定，
 这种绑定属于静态绑定，因为在编译阶段已经做了绑定
 */
public class PolymorphhismDemo3 {
    public static void main(String args[]){
        //属性永远和多态引用变量(父变量指向子类对象)声明类型的对象绑定或者编译时类型对象绑定
        Bike obj=new Honda3();
        System.out.println(obj.speedLimit);//90

        //若想访问运行时类型对象的属性，需要向下转型
        if(obj instanceof Honda3){
           Honda3 h= (Honda3)obj;//h的编译时类型和运行时类型都是Honda3，所以可以访问Honda3对象的属性值
            System.out.println(h.speedLimit);//150
        }
    }
}
class Bike {
    int speedLimit = 90;

}

class Honda3 extends Bike {
    int speedLimit = 150;
}
