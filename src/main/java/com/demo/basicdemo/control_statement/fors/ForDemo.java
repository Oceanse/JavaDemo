package com.demo.basicdemo.control_statement.fors;

import org.testng.annotations.Test;

import java.util.Scanner;


/*
   In programming languages, loops are used to execute a set of instructions/functions repeatedly when some conditions become true.

   循环语句可能包含如下 4 个部分。
   初始化语句（init statement）： 一条或多条语句，这些语句用于完成一些初始化工作，初始化语句在循环开始之前执行。
   循环条件（test_expression）：这是一个 boolean 表达式，这个表达式能决定是否执行循环体。
   循环体（body_statement）：这个部分是循环的主体，如果循环条件允许，这个代码块将被重复执行。如果这个代码块只有一行语句，则这个代码块的花括号是可以省略的。
   迭代语句（iteration_statement）：这个部分在一次循环体执行结束后，对循环条件求值之前执行，通常用于控制循环条件中的变量，使得循环在合适的时候结束。

 *
 * There are three types of loops in Java: for loop, while loop, do-while loop
 *
 *
 *    for(1初值表达式；2条件表达式；3更新表达式){
 *         4循环体
 *    }
 *    执行顺序：1-->2-->4--3>--2>-->4-->3--2------2不满足退出
 *    初始表达式最先被执行，且该表达式只被执行一次
 *    三个表达式都不是必须的，但是两个分号是必须的
 *    for循环中的变量作用域只是for循环体，循环结束后for内的变量就会释放内存空间
 *    for循环体 可以嵌套if switch for while.....
 *
 */
public class ForDemo {

    //死循环；
    // 条件表达式为空时，表示没有循环的终止条件
    @Test
    public void test() {
        for (; ; ) {
            System.out.println(Math.random());
        }
        //System.out.println("这里永远无法执行"); 这里放开会编译不通过，提示unreachable
    }



    @Test
    public void test2() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        //System.out.println(i); 这里已经超出i的作用域，编译错误
    }

    @Test
    public void test3() {

        int sum = 0;//这里可以把sum理解成个框子
        for (int i = 1; i < 10; i += 2) {
            sum += i;
        }
        System.out.println(sum);
    }


    /**
     * 统计某超市上半年的总销售量，要求由用户输入每月的销量
     */
    @Test
    public void test3_2() {

        int sum = 0;//这里可以把sum理解成个框子
        int num;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 7; i ++) {
            System.out.println("请输入第" + i + " 个月的销售数量：");
            num=sc.nextInt();
            sum += num;
        }
        System.out.println("上半年的销售总量为：" + sum);
    }


    @Test
    public void test3_3() {

        int result = 1;//这里可以把result理解成个框子
        for (int i = 1; i < 6; i++) {
            result *= i;
        }
        System.out.println(result);
    }


    /**
     * 初值表达式中的变量放置在for()时，作用域只是循环体
     */
    @Test
    public void test4() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println(i);
        }
        //System.out.println("i="+i); 这里已经超出i的作用域，编译错误
    }


    /**
     * 初值表达式中的变量可以放置在for外边，作用域不再局限于循环体，而是整个方法体
     */
    @Test
    public void test5() {
        int i = 1;
        for (; i < 10; i++) {//i=10时跳出for
            System.out.println(i);
        }
        System.out.println("i=" + i);
    }


    /**
     * 初值表达式中的变量for外边声明，for内初始化作用域是整个方法体
     */
    @Test
    public void test6() {
        int i;
        for (i = 1; i < 10; i++) {//i=10时跳出for
            System.out.println(i);
        }
        System.out.println("i=" + i);
    }


    @Test
    public void test8() {
        for (int i = 100; i > 50; i -= 10) {
            System.out.println(i);
        }
    }

    /**
     * 缺少更新表达式会导致死循环
     */
    @Test
    public void test9() {
        for (int i = 1; i < 10; ) {
            System.out.println(i);
        }
    }


    /**
     * 更新表达式可以放在循环体
     */
    @Test
    public void test10() {
        for (int i = 1; i < 10; ) {
            System.out.println(i);
            i++;
        }
    }


    /**
     * 循环嵌套:Nested For Loop
     * 假设外层循环的循环次数为 n 次，内层循环的循环次数为 m 次，那么内层循环的循环体实际上需要执行 n×m 次
     */




    @Test
    public void test11() {
        for (int i = 1; i < 10; i++) {//把内层的for循环十遍
            for (int j = 1; j <= i; j++) {//内层的for看做普通代码块
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }


    @Test
    public void test12() {
        for (int i = 1; i < 6; i++) {//把内层的for循环十遍
            for (int j = 1; j <= i; j++) {//内层的for看做普通代码块
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test12_2() {
        for (int i = 5; i>0 ; i--) {//把内层的for循环十遍
            for (int j = 1; j <= i; j++) {//内层的for看做普通代码块
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }


    /**
     * 效果等于test12_2
     */
    @Test
    public void test12_3() {
        for (int i = 1; i < 6; i++) {//把内层的for循环十遍
            for (int j = 5; j >= i; j--) {//内层的for看做普通代码块
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }


    /**
     * 1~100之间所有的素数(只能被1和本身整除)
     */
    @Test
    public void test12_4() {
        int count=0;
        for (int i = 1; i < 101; i++) {
            boolean isSushu=true;
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    isSushu=false;
                    break;
                }
            }
            if(isSushu){
                System.out.print(i+" ");
                count++;
                if(count%8==0){
                    System.out.println();
                }
            }
        }
    }




    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <10 ; i++) {
            System.out.println("请输入：");
            String str=sc.nextLine();
            if(str.contains("_")){
                str=str.split("_")[0];
            }
            System.out.println(str);
        }
    }
}
