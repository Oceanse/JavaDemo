package com.demo.basicdemo.method;

/**
 *  方法是对一段功能代码的封装，可以被重复调用；
 *
 *  语法： 【修饰符】 返回值类型 方法名(形参列表)
 *  形参中起决定作用的是形参的数据类型，当方法被调用的时候传递的真是数据被称为实参(实际参数)
 *  实参传给形参时候可能会发生自动类型转换
 *
 *  方法体中的代码会自上而下顺序执行，上面的代码执行完才能执行下一行的代码
 *
 *  方法只能定义在类中；不能嵌套定义，可以嵌套调用
 *
 *  main(String[] args)是程序的入口
 *
 */
public class MethodDemo {

    public static void main(String[] args) {
        add(1,1);//这里的两个1会自动转换成double类型
    }

    public static double add(double d1,double d2){
        return d1+d2;
    }
}
