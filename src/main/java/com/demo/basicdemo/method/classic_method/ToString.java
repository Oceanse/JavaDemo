package com.demo.basicdemo.method.classic_method;


/*
* String toString()是Object类的方法，返回堆对象的字符串表示，若不重写返回的是对应类的 全类名@堆内存地址
* Object是所有类的父类，所以任何类都拥有toString()方法，若不重写，返回的依然是对应类的全类名@堆内存地址
* */

import com.demo.inherit.Persons;
import org.testng.annotations.Test;

class Worker{
    String occuption;

    @Override
    public String toString() {
        return "Worker{" +
                "occuption='" + occuption + '\'' +
                '}';
    }
}

public class ToString {
    public static void main(String[] args) {





    }

    @Test
    public void test(){
        //print括号中打印的如果是引用类型变量，会打印该引用指向对对象的toString方法
        System.out.println(new Object());
        Persons p=new Persons();
        System.out.println(p);
    }



    @Test
    public void test2(){
        System.out.println(new Object().toString());
        System.out.println(new Persons().toString());//没有重写toString，返回的依然是对应类的 全类名@堆内存地址
        System.out.println(new Worker().toString());//重写toString,子类拥有的是重写后的toString
    }




    //包装类重写了toString
    @Test
    public void test3(){

        String name="ocean";
        System.out.println(name);
        System.out.println(name.toString());


        System.out.println(new Character('a').toString());
        System.out.println(new Character('a'));
    }


}
