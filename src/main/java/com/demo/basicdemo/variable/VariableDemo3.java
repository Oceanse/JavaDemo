package com.demo.basicdemo.variable;

import org.testng.annotations.Test;


/**
 * 类变量也称为静态变量，static 关键字声明，但必须在方法之外
 * 所有对象共享同一类变量
 * java虚拟机在加载类的过程中为静态变量分配内存，其生命周期取决于类的生命周期
 * 静态变量可以直接通过类名进行访问，也可以通过对象访问
 *
 *
 * 成员变量在类中方法外
 * 具有初始默认值
 * 在对象创建的时候创建，在对象被销毁的时候销毁
 * 整个类中有效
 *
 *
 *
 * 局部变量包括形参 方法体内 代码块内
 * 局部变量没有默认值,除了形参外必须初始化
 * 局部变量只在当前{}有效
 * 局部变量是在栈上分配的
 * 作用的范围结束，变量空间会自动释放
 *
 * */

public class VariableDemo3 {

    static int age = 100;// 所有对象共享类变量
    String name = "ocean";


    @Test
    public void test() {

        String name = "haiyang";//局部变量的值会覆盖同名成员变量的值
        int age=120;//局部变量的值会覆盖同名类变量的值
        System.out.println(age);
        System.out.println(name);
        System.out.println(new VariableDemo3().name);//打印成员变量
        System.out.println(VariableDemo3.age);//打印类变量
    }

    {
        int age=100;//局部变量
    }


}
