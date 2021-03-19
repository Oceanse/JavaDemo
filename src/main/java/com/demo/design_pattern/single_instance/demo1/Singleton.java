package com.demo.design_pattern.single_instance.demo1;

/**
 * 背景：
 * 大部分时候都把类的构造器定义成public访问权限，允许任何类自由创建该类的对象。但在某些时候，允许其他类自由创建该类的对象没有任何意义，
 * 还可能造成系统性能下降（因为频繁地创建对象、回收对象带来的系统开销问题），总之，在一些特殊场景下， 要求不允许自由创建该类的对象，
 * 而只允许为该类创建一个对象。
 *
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

