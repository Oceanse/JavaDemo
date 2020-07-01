package com.demo.basicdemo.operator;

import org.testng.annotations.Test;


/**
 * 条件运算符（？：）也称为三元运算符
 * <p>
 * 语法：boolean表达式？表达式 1：表达式 2, 表达式1和表达式2可以是常量,变量或表达式
 * <p>
 * boolean表达式为true则执行表达式 1 ;boolean表达式为 false 则执行表达式 2
 * 有时候可用来替换if-else
 * <p>
 * 表达式a>b?b>c?1:0:2 是从右向左结合（右结合）的，那么该表达式被解析为a>b?(b>c?1:0):2
 */
public class TernaryOperatorDemo {

    @Test
    public void test() {

        String result = true ? "right" : "wrong";
        String result2 = false ? "right" : "wrong";
        System.out.println(result);
        System.out.println(result2);}


    /**
     * ?: 替换if-else
     */
    @Test
    public void test2() {

        /*
        * if(i<j)
             min=i;
          else
            min=j;
        * */
        int i = 1;
        int j = 2;
        int max = (i > j) ? i : j;//求两个数的最大值
        System.out.println(max);


        /*
        * if(i>j)
             ma=i;
          else
            max=j;
        * */
        int min = (i < j) ? i : j;//求两个数的最小值
        System.out.println(min);



        /*
        * int number=100;
         * if(number%2==0){
         *    System.out.println("even number");
         * }else{
         *     System.out.println("odd number");
         * }
        * */
        int number = 100;
        String output = number % 2 == 0 ? "even number" : "odd number";
        System.out.println(output);

    }




    /**
     * int number=-13;
     * if(number>0){
     * System.out.println("POSITIVE");
     * }else if(number<0){
     * System.out.println("NEGATIVE");
     * }else{
     * System.out.println("ZERO");
     * }
     */
    @Test
    public void test3() {
        int number = 100;
        String output = number > 0 ? "positive number" : number < 0 ? "negative number" : "zero";//等价于number>0? "positive number" : (number<0?"negative number":"zero")
        System.out.println(output);
    }


}