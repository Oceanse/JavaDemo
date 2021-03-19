package com.demo.oop.constructor;

/**
 * 构造器并不是完全负责创建java对象，实际上当系统构造器的方法体执行之前，系统已经创建了一个对象，为该对象分配内存空间，
 * 并根据实例成员的默认值(或者具体值)以及构造代码块，为这个对象进行了初步初始化；这个阶段这个对象还不能被外部程序访问，
 * 只能在该构造器的方法体中通过this来引用；然后再执行构造器的方法体进一步初始化对象。
 * 当构造器的执行体执行结束后，这个对像作为构造器的返回值被返回，通常还会赋给另一个引用类型的变量，从而让外部程序可以访问该对象。
 * 带参构造器修改对象的默认属性值，并返回创建的对象给外界使用；
 * 空参构造器不会修改默认属性，只是返回创建的对象给外界使用
 */
public class Master {

    //把成员变量(无论是否显式初始化)和构造代码块脑补到构造器的代码块中
    String post="master";

    public Master() {

    }

    public Master(String post) {
        this.post = post;
    }



    @Override
    public String toString() {
        return "Master{" +
                "post='" + post + '\'' +
                '}';
    }

}
