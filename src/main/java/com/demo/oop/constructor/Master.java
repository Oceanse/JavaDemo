package com.demo.oop.constructor;


public class Master {

    //创建对象时候，堆内存中先为所有实例变量分配号空间，然后先执行声明变量时的初始值，再执行构造器的初始值
    //也就是说构造器的初始值会覆盖声明变量时的初始值
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
