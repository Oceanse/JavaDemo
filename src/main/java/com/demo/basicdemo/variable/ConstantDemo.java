package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * You can add the final keyword to declare the variable as "final" if you don't want others (or yourself) to overwrite existing values
 * which means unchangeable and read-only once assigned a value.
 * <p>
 * 定义：
 * 常量是指在程序的整个运行过程中值保持不变的量；
 * final修饰变量就变成了常量，其语法: final dataType variableName = value
 * <p>
 * 特点：
 * 常量可以看作一种特殊的变量，只是只能赋值一次，一旦初始化就不可以被修改
 * 声明明常量的同时一点要赋予一个初始值，即使是成员变量
 * <p>
 * 分类：
 * 作用范围：静态常量、实例常量和局部常量。
 * 类型：整型常量值 实型常量值 布尔型常量值 字符型 字符串常量值
 * <p>
 * 命名：
 * 为了与变量区别，常量取名一般都用大写字符。
 * <p>
 * 常量和常量值
 * 常量和常量值是不同的概念，常量可以理解为只能赋值一次的特殊的变量，常量值是常量内存空间保存的数据内容
 * 通常在程序中既可以直接使用常量值，也可以使用常量；
 */
public class ConstantDemo {


    //final int M;即使的成员变量也必须要初始化

    //实例常量
    final int QTY = 10;

    //静态常量
    public static final double PI = 3.14;


    /**
     * 常量初始化之后便不能进行修改
     */
    @Test
    public void test() {
        // 局部常量
        final String NATION = "China";
        //NATION="America";  不能修改常量的值
    }


    /**
     * 如果没有使用局部常量，可以不进行初始化
     */
    @Test
    public void test2() {
        final char LETTER;
        System.out.println("如果没有使用局部常量，可以不进行初始化");
    }

    @Test
    public void test3() {
        double count = new ConstantDemo().QTY;//常量值自动类型转换然后赋值给变量
        double square = ConstantDemo.PI * 1 * 1;
    }


    @Test
    public void test4() {
        //这里引用类型变量phone 是常量，也就是保存的对象地址永远不会改变，也就是指向的对象不会改变； 但是指向对象的属性可以改变
        final CellPhone phone = new CellPhone("nova5");
        System.out.println(phone);

        //被指对象的内容可以改变
        phone.setBrand("iphone");
        System.out.println(phone);

    }


    @Test
    public void test4_2() {
        //这里workChannels 是常量，永远指向new ConcurrentHashMap<>()
        final Map<String, String> workChannels = new ConcurrentHashMap<>();

        //被指对象的内容可以改变
        workChannels.put("name", "tom");
        workChannels.put("age", "22");
    }

}


class CellPhone {
    String brand;

    public CellPhone(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "brand='" + brand + '\'' +
                '}';
    }
}