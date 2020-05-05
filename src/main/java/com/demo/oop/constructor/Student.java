package com.demo.oop.constructor;
/**
 * 构造方法也叫构造器或者构造函数
 * <p>
 * 权限修饰符 类名(形参) { }
 * 构造方法与类名相同
 * 构造方法会有一个默认返回值，不需要显式声明返回值类型，不用return
 * <p>
 * 调用方式：new 类名(形参)
 * <p>
 * 作用：创建对象； 为对象的成员变量赋初值。
 * <p>
 * Java构造函数重载(overload)：默认构造函数(无参数构造函数)，参数化构造函数
 *
 * 无参数构造函数：如果类中没有构造函数，编译器会自动创建一个默认空参构造函数
 * 作用是根据类型为对象属性提供默认值
 * 该构造函数的权限是随着类的改变而改变的(类为public，构造函数也为public；类改为private，构造函数也改为private)
 *
 * 参数化构造函数：如果手动添加了参数化构造器，那么默认空参构造器就会消失，所以建议手动加上空参构造器；
 * 作用是为不同对象提供不同初始化的值。
 * <p>
 * <p>
 * 一个类中可以多个重载构造方法
 * <p>
 * this在构造方法中调用重载构造方法，只能位于第一行
 */

import org.testng.annotations.Test;

import java.util.Arrays;

public class Student {

    //实例变量只有在对象创建时候才会被声明初始化，也就是先有对象才会有实例变量
    String name;
    int id;
    String[] subject;

    //这里就变成了普通方法
    public void Constructor() {
    }

    //无参构造方法
    public Student() {
        System.out.println("无参构造器");
    }

    //双参构造方法
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("双参构造器");
    }

    //三参构造方法
    public Student(String name, int id, String[] subject) {
        this(name, id);//this调用双参构造器
        this.subject = subject;
        System.out.println("三参构造器");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subject=" + Arrays.toString(subject) +
                '}';
    }
}

class Teacher {
    //这里有一个默认空参构造方法

}

class ClassRoom {

    double square;

    //单参构造方法会覆盖默认的空参构造方法
    public ClassRoom(double square) {
        this.square = square;
    }

}


class ConstructorTest {
    @Test
    public void test() {
        //new ClassRoom(); ClassRoom空参构造器已被覆盖不存在

        //空参构造函数为对象属性提供默认值
        Student student = new Student();
        System.out.println(student.toString());

        //参数化构造函数用于为不同对象提供不同初始化的值。
        Student student2 = new Student("ocean", 18, new String[]{"chinese", "maath", "english"});
        System.out.println(student.toString());
    }
}