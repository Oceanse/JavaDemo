package com.demo.exception;

import org.testng.annotations.Test;

/*
java.lang.RuntimeException :
ClassCastException
ArrayIndexOutOfBoundsException
NullPointerException
ArithmeticException

运行时异常就是在运行期间才会出现的异常，它是指Java程序在运行时产生的由解释器引发的各种异常,
可以在编译时被忽略(eclipse每次保存都自动编译，而且运行的时候如果代码没有改变根本不会重新编译)


javac出来的异常就是编译时异常，就是说把源代码编译成字节码（class）文件时报的异常，
一般如果用Eclispe,你敲完代码保存的时候就是编译的时候。


java运行时若出现异常事件，就会生成一个异常对象，该异常对象封装了异常事件的信息，
并把该对象交给java运行时系统，这个过程称为抛出异常；java运行时系统默认处理方式是打印该异常对象
包含的信息*/


public class RunTimeExectionType {

    @Test
    public void test(){
        String[] names=new String[]{"aa","bb","cc"};
        for (int i = 0; i < 4; i++) {
            System.out.print(names[i]+"\t");
        }
    }

    @Test
    public void test2(){
        int a=0;
        int b=1;
        System.out.println(b/a);
    }

    @Test
    public void test3(){
        String str=null;
        System.out.println(str.isEmpty());
    }

    @Test
    public void test4(){
        Pers p=new Woman();
        Man m=(Man)p;       //编译时不会报错

        Pers p2=new Pers();
        Man m2=(Man)p2;     //编译时不会报错
    }




}

class Pers{
}

class Man extends Pers{
}

class Woman extends Pers{
}