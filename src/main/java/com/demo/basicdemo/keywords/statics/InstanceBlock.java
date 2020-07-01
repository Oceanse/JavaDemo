package com.demo.basicdemo.keywords.statics;


/*
* 实例代码块属于对象级别，随着对象的创建而进行加载
* 一个类中可以有多个实例代码块，自上而下顺次执行
* */
public class InstanceBlock {

    public static void main(String[] args) {
        new InstanceBlock();
        new InstanceBlock();
        new InstanceBlock();
    }

    {
        System.out.println("I am instance block1");
    }

    {
        System.out.println("I am instance block2");
    }

}