package com.demo.oop.constructor;

import org.testng.annotations.Test;

/**
 * 构造方法也叫构造器或者构造函数
 * <p>
 * 权限修饰符 类名(形参) { }
 * 构造方法与类名相同
 * 构造方法会有一个默认返回值(返回当前类的实例)，不需要显式声明返回值类型，不用return
 * <p>
 * 调用方式：new 类名(形参)
 * <p>
 * 作用：
 * 创建对象；
 * 为对象的成员变量赋初值(默认值或者特定值 )。
 * 默认构造函数根据类型为对象提供默认值
 * 参数化构造函数用于为不同对象提供不同初始化的值
 * <p>
 * Java构造函数重载(overload)：默认构造函数(无参数构造函数)，参数化构造函数
 * <p>
 * 无参数构造函数：如果类中没有构造函数，编译器会自动创建一个默认空参构造函数
 * 作用是根据类型为对象属性提供默认值
 * 该构造函数的权限是随着类的改变而改变的(类为public，构造函数也为public；类改为private，构造函数也改为private)
 * <p>
 * 参数化构造函数：如果手动添加了参数化构造器，那么默认空参构造器就会消失，所以建议手动加上空参构造器；
 * 作用是为不同对象提供不同初始化的值。
 * <p>
 * <p>
 * 一个类中可以多个重载构造方法
 * <p>
 * this在构造方法中调用重载构造方法，只能位于第一行
 * <p>
 * 继承中的构造器调用详见继承模块讲解
 */
public class ConstructorTest {
    @Test
    public void test() {

        //空参构造函数为对象属性提供默认值
        Student student = new Student();
        System.out.println(student.toString());
        System.out.println();

        //参数化构造函数用于为不同对象提供不同初始化的值。
        Student student2 = new Student("ocean", 18, new String[]{"chinese", "math", "english"});
        System.out.println(student2.toString());
        System.out.println();

        //调用拷贝构造函数
        Student student3 = new Student(student2);
        System.out.println(student3.toString());

        //new ClassRoom(); ClassRoom空参构造器已被覆盖不存在
    }
}