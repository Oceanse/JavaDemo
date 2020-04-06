package com.demo.basicdemo.operator;

import org.testng.annotations.Test;


/**
 * 条件运算符（？：）也称为三元运算符
 * <p>
 * 语法：boolean表达式 ？ 表达式 1 ： 表达式 2
 * <p>
 * boolean表达式为true则执行表达式 1 ;boolean表达式为 false 则执行表达式 2
 */
public class TernaryOperatorDemo {

    @Test
    public void test() {
        int i = 1;
        int j = 2;
        System.out.println((i > j) ? i : j);//求两个数的最大值
        System.out.println((i <j) ? i : j);//求两个数的最小值
    }


}
