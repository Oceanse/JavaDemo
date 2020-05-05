package com.demo.basicdemo.variable;

import org.testng.annotations.Test;


/**
 * You can add the final keyword to declare the variable as "final" if you don't want others (or yourself) to overwrite existing values
 * which means unchangeable and read-only once assigned a value.
 * <p>
 * Java 语言使用 final 关键字来定义一个常量，其语法: final dataType variableName = value
 * final修饰变量就变成了常量；常量可以看作一种特殊的变量，只是只能赋值一次，赋值一次后便不能进行修改
 *
 * 常量有三种类型：静态常量、实例常量和局部常量。
 *
 * 为了与变量区别，常量取名一般都用大写字符。
 */
public class ConstantDemo {

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




}
