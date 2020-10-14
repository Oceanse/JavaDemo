package com.demo.basicdemo.variable.variable_datatype;

import org.testng.annotations.Test;

import java.util.ArrayList;


public class NumberDemo {



    /**
     * 对于不带任何后缀的整数:
     *    1 如果将一个 整数常量 或者 整数常量表达式结果 在byte/short/char范围内的赋值给byte/short/char变量，那么系统会自动把这个整数常量或者整数常量表达式当成byte/short/char类型
     *    2 其他情况下这个整数常量或者整数常量表达式都是int类型(把任意一个整数赋值给int/long/float/double变量,系统会把这个变量当成int)
     *
     * 对于不带任何后缀的浮点数：
     *    都是double类型数据
     *
     */
    @Test
    public void test() {

        byte b = 127; //这里127是byte类型数据,因为int类型不能自动转换为byte，所以这里127不是int类型，
        short s=127; //这里127是short类型数据,因为int类型不能自动转换为short，所以这里127不是int类型，
        char c=127;//这里127是char类型数据，因为int类型不能自动转换为char，所以这里127不是int类型，
        int i=127; //这里127是int类型数据
        long l = 127L;//这里127L是long类型是数据
        float f = 127.f;//这里127.f是float类型是数据
        double d = 127.0;//这里127.0是double类型是数据

        byte b2=128-1;//128-1的结果在byte类型表示范围内， 所以(128-1)是byte类型
        short s2=1+1;//1+1的结果是short类型
        char c2=1+1;//1+1的结果是char类型

        System.out.println(1); //不带任何后缀的整数默认是int
        System.out.println(1.0); //不带任何后缀的小数默认是double
    }


    @Test
    public void test1_2() {
        //byte b2=128; 超出其byte取值范围, 128会被认为是int类型
        //long l2=9999999999;//系统会把9999999999当作是int类型，但是又超出了int的取值范围，会报 Integer Number too large
        int b3=128;
        long l3 = 9999999999L;//9999999999L表示long类型数据

    }



    /**
     * 整数类型有四种表示方式：
     * 二进制binary) 八进制(octal) 十进制(decimal) 十六进制(hexadecimal)；
     *
     * 二进制以0b/0B开头；java7新增了对二进制的支持
     * 八进制以0开头；
     * 十六进制以0x/0X开头，其中10~15以a~f(不区分大小写)表示
     *
     * 原码：一个数的二进制表示
     * 反码：原码按位取反（符号位不变）
     * 补码：反码加1
     * <p>
     * 计算机底层数字以反码形式存储；
     * 对于正数来说：原码 反码 补码三者一致
     * 对于负数来说：原码 --->反码---> 补码
     */
    @Test
    public void test2_1() {
        byte decimal = 97;//十进制 97是byte类型数据
        short bin=0B01100001;// 二进制  0B01100001是short类型;
        int octal = 0141;//八进制 0141是int类型数据
        long hex2 = 0X61L; //十六进制  0X61L是long类型数据
        long hex = 0X61;//十六进制  0X61是int类型数据,自动转换成long类型

        //十进制形式打印
        System.out.println(decimal);
        System.out.println(bin);
        System.out.println(octal);
        System.out.println(hex);
        System.out.println(hex2);

        //某些时候程序需要直接使用二进制，二进制"更真实"，更能体现出整数在内存中的存在形式
        //一个不带任何后缀的二进制默认表示一个int类型
        System.out.println(0B01100001);
        System.out.println(0B01100001L);

    }
    /**
     * 浮点型数据的表示方法：
     * 小数和科学计数法
     */
    @Test
    public void test2_2() {
        float f1 = 35000.0f;
        float f2 = 35e3f;//3.5 x 10^3f
        System.out.println(f1);
        System.out.println(f2);

        double d1 = 12000.0;
        double d2 = 12E3;//1.2 x 10^3
        System.out.println(d1);
        System.out.println(d2);
    }

    /**
     * 自动类型转换
     */
    @Test
    public void test3_1(){
        long l = 127;//这里127是int类型是数据，127会自动转换成long类型127L
        float f = 127;//这里127是int类型是数据，127会自动转换成float类型127.0f
        double d = 127;//这里127是int类型是数据，127会自动转换成double类型127.0

        //(1+1.1)结果的类型都是double
        //cntrl + 点击println验证
        System.out.println(1+1.1);//int 1会自动转成double 1.0,然后再运算
    }


    /**
     * 强制类型转换
     */
    @Test
    public void test3_2(){

        //float f=2.1;  double类型数据不能直接赋值给float变量
        double d=2.1;
        float f = (float) d;//double变量存储的变量值2.1复制一份，然后强转成float类型，再赋值
        System.out.println(d);
        System.out.println(f);

    }


    /**
     * 数值型String--->数值型包装类
     */
    @Test
    public void test4(){

        //当String类型数据 要转换成int、double、float、long等数据类型时，其数据必须由数字构成，
        String st = "789";
        Integer ii = Integer.valueOf(st);
        Double d = Double.valueOf(st);
        Long l = Long.valueOf(st);
        Float f = Float.valueOf(st);
    }


    /**
     * 数值型String--->数值型基本类型
     */
    @Test
    public void test5(){

        //当String类型数据 要转换成int、double、float、long等数据类型时，其数据必须由数字构成，
        String stringNumber = System.getProperty("number");

        int number = Integer.parseInt(stringNumber);
        if(number==20201231){
            System.out.println("Good luck");
        }
    }


}
