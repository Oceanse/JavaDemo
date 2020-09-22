package com.demo.basicdemo.keywords.finals;

/**
 * 定义：
 * 不可变类（Immutable Objects）：当类的实例一经创建，其内容便不可改变，即无法修改其成员变量。
 *
 * 优点：
 *    1 效率，例如字符串常量池，字符串常量池可以将一些字符常量放在常量池中重复使用，避免每次都重新创建相同的对象、节省存储空间
 *    2 安全性，不可变对象天生是线程安全的，在不同线程共享对象，不需要同步机制，因为对象的值是固定的。
 *
 * 缺点:
 *     资源开销，对象需要频繁的修改属性，则每一次修改都会新创建一个对象，产生大量的资源开销。
 *
 * Java 中八个基本类型的包装类和 String 类都属于不可变类
 *
 * 设计一个不可变类：
 *
 * 类的成员变量都应该是private final的，保证成员变量不可改变。
 * 提供带参构造器，根据传入的参数初始化成员变量
 * 仅为该类的属性提供getter方法，不提供setter等修改成员变量的方法，因为普通方法也无法修改成员变量的值
 *
 */
public class Unmutable_Instance {
    private final String name;
    private final int age;

    public Unmutable_Instance(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        //实例一经创建，其内容便不可改变，即无法修改其成员变量。
        Unmutable_Instance u=new Unmutable_Instance("ocean",30);

        //实例一经创建，其内容便不可改变，即无法修改其成员变量。
        Double d=new Double(1.0);
    }
}
