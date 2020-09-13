package com.demo.basicdemo.control_statement.fors;

import org.testng.annotations.Test;

import java.util.Scanner;


/**
   In programming languages, loops are used to execute a set of instructions/functions repeatedly when some conditions become true.

   循环语句可能包含如下 4 个部分。
   初始化语句（init statement）： 一条或多条语句，这些语句用于完成一些初始化工作，初始化语句在循环开始之前执行。
   循环条件（test_expression）：这是一个 boolean 表达式，这个表达式能决定是否执行循环体。
   循环体（body_statement）：这个部分是循环的主体，如果循环条件允许，这个代码块将被重复执行。如果这个代码块只有一行语句，则这个代码块的花括号是可以省略的。
   迭代语句（iteration_statement）：这个部分在一次循环体执行结束后，对循环条件求值之前执行，通常用于控制循环条件中的变量，使得循环在合适的时候结束。

 *
 * There are three types of loops in Java: for loop, while loop, do-while loop
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


    /**
     * 死循环；
     *  条件表达式为空时，表示没有循环的终止条件
     */
    @Test
    public void test() {
        for (; ; ) {
            System.out.println(Math.random());
        }
        //System.out.println("这里永远无法执行"); 这里放开会编译不通过，提示unreachable
    }

    /**
     * 缺少更新表达式会导致死循环
     */
    @Test
    public void test1_2() {
        for (int i = 1; i < 10; ) {
            System.out.println(i);
        }
    }



    /**
     * 更新表达式可以放在循环体
     */
    @Test
    public void test1_3() {
        for (int i = 1; i < 10; ) {
            System.out.println(i);
            i++;
        }
    }


    /**
     * i*=0.1导致i永远为0，所以不建议在循环体那日修改循环变量的值，否则会增加程序出错的可能性
     * 如果真的需要访问修改，建议创建一个临时变量，临时变量=循环变量，然后修改临时变量的值
     */
    @Test
    public void test1_4() {
        for (int i = 1; i < 10; i++ ) {
            i*=0.1;
            System.out.println(i);
        }
    }

    /**
     * for循环内定义的变量在循环结束后就会被释放
     * 也就是初值表达式中的变量放置在for()时，作用域只是循环体
     */
    @Test
    public void test2() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        //System.out.println(i); 这里已经超出i的作用域，编译错误
    }





    /**
     * 初值表达式中的变量可以放置在for外边，作用域不再局限于循环体，而是整个方法体
     * 从而可以在for循环之外访问循环变量的值
     */
    @Test
    public void test2_2() {
        int i = 1;
        for (; i < 10; i++) {//i=10时跳出for
            System.out.println(i);
        }
        System.out.println("i=" + i);
    }


    /**
     * 为了能够在for循环之外访问循环变量的值，还可以在for循环之外，定义一个临时变量
     */
    @Test
    public void test2_3() {
        int temp=0;
        for (int i = 1; i < 10; i++) {//i=10时跳出for
            temp=i;
        }
        System.out.println("temp=" + temp);//打印循环结束时候，循环体内i的值
    }



    @Test
    public void test3() {
        int sum = 0;//这里可以把sum理解成个篮子
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

        int sum = 0;//这里可以把sum理解成个篮子
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

        int result = 1;//这里可以把result理解成个篮子
        for (int i = 1; i < 6; i++) {
            result *= i;
        }
        System.out.println(result);
    }




    /**
     * 循环嵌套:Nested For Loop
     * 假设外层循环的循环次数为 n 次，内层循环的循环次数为 m 次，那么内层循环的循环体实际上需要执行 n×m 次
     */
    @Test
    public void test11_1() {
        for (int i = 1; i < 10; i++) {//把内层的for循环十遍
            for (int j = 1; j <= i; j++) {//内层的for看做普通代码块
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();//外层循环执行完一次就换行
        }
    }


    @Test
    public void test11_2() {
        for (int i = 1; i < 6; i++) {//把内层的for循环十遍
            for (int j = 1; j <= i; j++) {//内层的for看做普通代码块
                System.out.print("*"+" ");
            }
            System.out.println();//外层循环执行完一次就换行
        }
    }

    @Test
    public void test11_3() {
        for (int i = 5; i>0 ; i--) {//把内层的for循环十遍
            for (int j = 1; j <= i; j++) {//内层的for看做普通代码块
                System.out.print("*"+" ");
            }
            System.out.println();//外层循环执行完一次就换行
        }
    }


    /**
     * 效果等于test11_3
     */
    @Test
    public void test11_4() {
        for (int i = 1; i < 6; i++) {//把内层的for循环十遍
            for (int j = 5; j >= i; j--) {//内层的for看做普通代码块
                System.out.print("*"+" ");
            }
            System.out.println();//外层循环执行完一次就换行
        }
    }


    /**
     * 1~100之间所有的素数(只能被1和本身整除)
     */
    @Test
    public void test11_5() {
        int count=0;
        for (int i = 1; i < 101; i++) {
            boolean isSushu=true;
            for (int j = 2; j < i; j++) {
                if(i%j==0){//能够被1和本身之外的其他数整除就不是质数
                    isSushu=false;
                    break;
                }
            }
            if(isSushu){
                System.out.print(i+" ");
                count++;
                if(count%8==0){ //每8个换行
                    System.out.println();
                }
            }
        }
    }




    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <3 ; i++) {
            System.out.println("请输入：");
            String str=sc.nextLine();
            if(str.contains("_")){
                str=str.split("_")[0];
            }
            System.out.println(str);
        }
    }
}
