package com.demo.basicdemo.control_statement.if_switch;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.testng.annotations.Test;
import java.util.Scanner;

/**
  if语句使用布尔表达式或布尔值作为分支条件来进行分支控制；每次只能执行一个分支
  执行代码块可以是一条语句也可以是多条语句。如果仅有一条语句，可省略条件语句中的大括号 {}。当从编程规范角度不要省略大括号，省略大括号会使程序的可读性变差。

 * 1.   如果条件正确则执行条件执行体1，另外无论条件正确与否，一定会执行执行语句2；
        if(boolean condition){
 *       条件执行体1；
 *      }
 *      执行语句2；

*
 * 2.  如果条件正确则执行条件执行体1；，否则执行 条件执行体2； 每次只能执行一个操作
       if(条件表达式){
 *        条件执行体1；
 *       }
 *     else{
 *      条件执行体2；
 *       }

*
 * 3.  提供多个执行分支
       if(条件表达式){
 *        执行代码块；
 *      }
 *     else if (条件表达式){
 *      执行代码块；
 *      }
 *      ……
 *      else{
 *       执行代码块；
 *      }
 */
public class IfDemo {


    /**
     * if(boolean condition){
     * 条件执行体；
     * }
     */
    @Test
    public void test() {
        String username = "admin"; // 用户名
        String userpass = "123456"; // 密码
        String code = "0000"; // 验证码
        if (username != "admin" || userpass != "123456" || code != "0000") {
            System.out.println("登录失败！");
            System.out.println("请检查输入的用户名、密码和验证码是否正确！");
        }

        int age = 20;
        String sex="mam";
        if (age > 18 && "man".equals(sex))
            System.out.print("You are an adult male");//语句块中只包含一条语句，可以省略大括号
        System.out.println("My age is " + age);
    }

    /**
     * if(boolean condition){\
     *  单行条件执行体；
     *
     * 单行代码块可以省略{}，但是不建议这么做，即使条件执行体只有一行代码；
     * 因为{}使得代码具有更好的可读性
     */
    @Test
    public void test1_2() {

        int age = 20;
        String sex="man";
        if (age > 18 && "man".equals(sex))
            System.out.println("You are an adult male");//语句块中只包含一条语句，可以省略大括号
        System.out.println(String.format("My sex is %s and age is %d",sex,age));//一定会被执行
    }


    /**
     * if(条件表达式){
     * 条件执行体1；
     * }
     * else{
     * 条件执行体2；
     * }
     */
    @Test
    public void test2() {
        double totalPrice = 100;
        int amount = 0;
        double unitPrice = 0;
        if (amount != 0) {
            unitPrice = totalPrice / amount;
        } else {
            System.out.println("The amount cannot be zero");
            return;//若amount==0, 执行到这里会直接退出整个方法
        }
        System.out.println("unitPrice is " + unitPrice);
    }

    /**
     * if(条件表达式){
     * 条件执行体1；
     * }
     * else{
     * 条件执行体2；
     * }
     */
    @Test
    public void test2_2() {
        int year = 2020;
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println("LEAP YEAR");
        } else {
            System.out.println("COMMON YEAR");
        }
    }


    /**
     * if(条件表达式){
     * 条件执行体1；
     * }
     * else if (条件表达式){
     * 条件执行体2；
     * }
     * ……
     * else{
     * 条件执行体3；
     * }
     *
     * 使用此结构时候的原则：一定要先处理包含范围小的情况；
     * 执行到某个分支路径进行判断时候已经把之前的所有范围exclude掉
     *
     */
    @Test
    public void test3() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入成绩:");
        int i = s.nextInt();
        if (i == 100) {
            System.out.println("满分");
        } else if (i >= 90) {//这里等价于 i>=90 & i!=100
            System.out.println("优秀");
        } else if (i >= 60) {//这里等价于 i>=60 & !(i>=90) & !(i==100)
            System.out.println("及格");
        } else {//这里等价于 !(i>=60) & !(i>=90) & !(i==100)
            System.out.println("不及格");
        }
    }


    /**
     * Nested If Statement.
     */
    @Test
    public void test4() {
        //Creating two variables for age and weight
        int age = 25;
        int weight = 48;
        //applying condition on age and weight
        if (age >= 18) {
            if (weight > 50) {
                System.out.println("You are eligible to donate blood");
            } else {
                System.out.println("You are not eligible to donate blood");
            }
        } else {
            System.out.println("Age must be greater than 18");
        }
    }


    @Test
    public void test4_2() {
       String weather="sunny";
       String today="Sunday";
       if(today.equals("Sunday")){
           if(weather.equals("sunny")){
               System.out.println("Play inside rooom");
           }else{
               System.out.println("Play outside room");
           }
       }else{
           System.out.println("Go to work");
       }
    }


    /**
     * if语句中出现return直接退出所在if所在方法
     */
    @Test
    public void test5() {
        //Creating two variables for age and weight
        int age = 25;
        int weight = 48;
        //applying condition on age and weight
        if (age >= 18) {
            if (weight > 50) {
                System.out.println("You are eligible to donate blood");
            } else {
                System.out.println("You are not eligible to donate blood");
                return; //直接退出整个方法
            }
        } else {
            System.out.println("Age must be greater than 18");
        }
        System.out.println("I cannot be executed");
    }
}
