package com.demo.basicdemo.method;


/*
在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数 类型 顺序不同即可
重载就是方法名相同，但是参数的类型、数量、顺序不同
使用场景：方法的功能具有一定的相似性
这种方法名相同，根据传入的参数不同调用不同的方法非常美观，对程序员来说非常友好

* */
public class Overload {

    //返回两个整数的和
    int add(int x, int y) {
        return x + y;
    }

    //返回三个整数的和
    int add(int x, int y, int z) {
        return x + y + z;
    }

    //返回两个小数的和
    double add(double x, double y) {
        return x + y;
    }




    //静态方法的重载
    public static void main(String[] args) {
        main('\u0022');
        main("ocean");
    }

    public static void main(char c) {
        System.out.println(c);
    }

    public static void main(String name) {
        System.out.println(name);
    }

}
