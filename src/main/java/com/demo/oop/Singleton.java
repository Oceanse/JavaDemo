package com.demo.oop;

/**
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点
 */
public class Singleton {

    private static Singleton singleton;//保存创建的对象

    String name;

    /**
     * 构造器私有，保证不能在类的外部创建对象
     * @param name
     */
    private Singleton(String name) {
        this.name = name;
    }

    /**
     * 共有的静态的访问点
     * @return
     */
    public static Singleton getInstance(){
        if(singleton==null){
         singleton=new Singleton("ocean");
        }
        return singleton;
    }
}

class SingletonTest{

    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);//比较两个变量保存的变量值，也就是地址
    }
}
