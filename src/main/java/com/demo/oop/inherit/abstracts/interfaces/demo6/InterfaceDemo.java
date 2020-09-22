package com.demo.oop.inherit.abstracts.interfaces.demo6;

import java.util.Arrays;

interface A {
    public static final int A = 1;

    public abstract void infoA();

    //java8开始接口允许定义具象方法，但是必须用default修饰
    default void printLetters(char[] letters){
        System.out.println("char[] letters of interface A....");
        System.out.println(Arrays.toString(letters));
    }
}


interface B {
    public static final int B = 2;

    public abstract void infoB();

    //在 java8 中的接口中不仅增加了默认方法，还增加了静态方法。使用方式接口名.方法名。
    public static void show(){
        System.out.println("static method of B....");
    }
}



//抽象类
abstract class D{
     public void printLetters(char[] letters){
         System.out.println("char[] letters of class D....");
        System.out.println(Arrays.toString(letters));
    }
}



//多继承
interface C extends A,B{
}



//多实现
public class InterfaceDemo extends D implements C {

    @Override
    public void infoA() { }

    @Override
    public void infoB() { }

    public static void main(String[] args) {
        //InterfaceDemo.show();
    }
}

class Test{

    public static void main(String[] args) {
        //类优先的原则: 若一个接口中定义了一个默认方法，而另一个父类中又定义了一个同名方法时，选择父类中的方法
        new InterfaceDemo().printLetters("abc".toCharArray());//继承拥有父类的default方法

        //在 java8 中的接口中不仅增加了默认方法，还增加了静态方法。使用方式接口名.方法名。
        //注意：不能通过子类类名调用
        B.show();

        //继承拥有父类的静态变量
        System.out.println(InterfaceDemo.A);
        System.out.println(InterfaceDemo.B);



    }
}