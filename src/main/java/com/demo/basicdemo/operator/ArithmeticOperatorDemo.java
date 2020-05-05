package com.demo.basicdemo.operator;

import org.testng.annotations.Test;

public class ArithmeticOperatorDemo {


    /**
     * 算数运算符：Arithmetic Operator
     * + - * / % ++ --
     * -除了作为减号外，还可以是求负运算符
     */
    @Test
    public void test() {

        int i = 1;
        int i2 = 2;
        System.out.println("i + i2="+(i + i2));
        System.out.println("i - i2="+(i - i2));
        System.out.println("i * i2="+(i * i2));//结果和参与运算变量类型一致
        System.out.println("i / i2="+(i / i2));
        System.out.println();

        System.out.println("10*10/5+3-1*4/2="+(10*10/5+3-1*4/2));//先乘除后加减

        double d = 1.0;
        System.out.println(d / 2);//int类型2先自动转换为double类型

        //System.out.println(1/0);//java.lang.ArithmeticException: / by zero
        System.out.println(1 / 0.0);
        System.out.println(-1.0 / 0);//被除数或者除数有一个是小数，那么除数可以为0，结果为无穷大

        //-除了作为减号外，还可以是求负运算符
        int po = 1;
        int na = -po;
        System.out.println(na);
    }



    /**
     * 取模运算 *
     */
    @Test
    public void test2(){
        //取模运算符号看左边
        System.out.println(5%2);
        System.out.println(5%-2);
        System.out.println(-5%2);
        System.out.println(-5%-2);

        int i=2;
        if(i%2==0){
            System.out.println(i+"是偶数");
        }
    }


    /**
     *  ++ --都是单目运算符(Unary Operator)，只能有一个操作数
     *  ++a,--a： 先进行自增或者自减运算，再使用；
     *  a++,a--: 先使用，再进行自增或者自减运算

     * 自增自减运算只能操作变量，不能操作常量或者表达式
     */
    @Test
    public void test3(){

        int i = 1;
        int i2 = 2*i++;
        System.out.println("i=" + i);
        System.out.println("i2=" + i2);
        System.out.println();

        int i3 = 3;
        int i4 = 2*++i3;
        System.out.println("i3=" + i3);
        System.out.println("i4=" + i4);
        System.out.println();

        int a=10;
        int b=10;
        System.out.println(a++ + ++a);//10+12=22
        System.out.println(b++ + b++);//10+11=21

        //int i5=1++;不能对常量进行自增自减

        //赋值表达式的结果是最左边变量的值，但是不能对表达式进行自增自减
        System.out.println(i=100);
        //System.out.println((i=100)++);
    }



    /**
     * java.lang.Math 类提供的工具方法可以完成求幂、开方、绝对值等运算
     */
    @Test
    public void test4() {
        System.out.println(Math.abs(-1.2));//|-1.2|
        System.out.println(Math.pow(2, 3));//2^3
        System.out.println(Math.sqrt(4));
        System.out.println(Math.random());//0~1随机数
    }
}
