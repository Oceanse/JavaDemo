package com.demo.oop.constructor;

import org.testng.annotations.Test;

/*
 * 构造方法也叫构造器或者构造函数
 *
 * 语法：
 * 权限修饰符 类名(形参) { }
 *
 * 特点：
 *  构造方法与类名相同
 *  构造方法会有一个默认返回值(返回当前类的实例)，不需要显式声明返回值类型，不用return
 *  构造方法不能用static修饰
 *
 * 调用方式：new 类名(形参)
 *
 * 作用：
 *  创建对象；
 *  空参构造函数根据类型为对象提供默认值
 *  为对象的成员变量赋初值(默认值或者特定值 )。
 *  参数化构造函数用于为不同对象提供不同初始化的值
 *  总结：创建并初始化对象
 *
 *
 *
 *
 * Java构造函数重载(overload)： 一个类中可以多个名字相同，参数不同的重载构造方法包括：
 *     默认构造函数(无参数构造函数)，
 *     参数化构造函数
 *
 *   this在构造方法中调用重载构造方法，只能位于第一行
 *   作用: 比如五参构造器可以直接调用四参构造器来初始化其中的四个属性，这样可以减少重复代码(软件行业建议不要把相同的代码书写两次以上)
 *      ，使得代码简洁; 同时如果A调用B,B调用C, 如果修改三个函数共有的某个属性，只需要修改C,方便代码的维护
 *   继承中的构造器调用详见继承模块讲解
 *
 *
 *   无参数构造函数：
 *     如果类中没有构造函数，编译器会自动创建一个默认空参构造函数
 *     作用是根据类型为对象属性提供默认值
 *     该构造函数的权限是随着类的改变而改变的(类为public，构造函数也为public；类改为private，构造函数也改为private)
 *
 *   参数化构造函数：
 *     如果手动添加了参数化构造器，那么默认空参构造器就会消失，所以建议手动加上空参构造器；
 *     作用是为不同对象提供不同初始化的值。
 */
public class ConstructorTest {

    /**
     * 空参构造函数为对象属性提供默认值
     */
    @Test
    public void test() {
        Student student = new Student();
        System.out.println(student.toString());
        System.out.println();
    }

    /**
     *  参数化构造函数用于为不同对象提供不同初始化的值。
     */
    @Test
    public void test2(){
        Student student2 = new Student("ocean", 18, new String[]{"chinese", "math", "english"});
        System.out.println(student2.toString());
        System.out.println();
    }

    /**
     * 调用拷贝构造函数
     */
    @Test
    public void test3(){
        Student student = new Student("ocean", 18, new String[]{"chinese", "math", "english"});
        Student student3 = new Student(student);
        System.out.println(student3.toString());
    }

    @Test
    public void test4(){
        //new ClassRoom(); ClassRoom空参构造器已被覆盖不存在
    }

    /**
     * 创建对象时候，堆内存中先为所有实例变量分配号空间，然后先执行声明变量时的初始值，再执行构造器的初始值
     * 也就是说构造器的初始值会覆盖声明变量时的初始值
     */
    @Test
    public void test5(){
        System.out.println(new Master().toString());
        System.out.println(new Master("master2").toString());
    }
}