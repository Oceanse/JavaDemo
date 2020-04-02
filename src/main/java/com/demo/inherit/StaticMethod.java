package com.demo.inherit;

public class StaticMethod {
    public static void test(){
        System.out.println("static meethod.......");
    }
}


class Child extends StaticMethod{
    public static void main(String[] args) {
        test(); //直接调用静态方法
        StaticMethod.test();//父类去调用父类自己的静态方法
        Child.test();//子类去调用父类的静态方法
    }
}
