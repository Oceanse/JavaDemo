package com.demo.basicdemo.operator;

import org.testng.annotations.Test;


/**
 * 赋值运算符分为：基本赋值运算符=和扩展赋值运算符+= -+ *= /= %=
 * 赋值运算符优先级：先执行右边的表达式，再将结果赋值给左边变量
 * */

public class AssignmentOperatorDemo {
    @Test
    public void test(){
        byte b=100;
        //b=b+1;  不能将int赋值给byte

        b+=1;//相当于b=b+(byte)1

    }



    @Test
    public void test2() {

        byte b = 0;
        b += 22555;
        System.out.println("b="+b);  //s += 22555隐含了一个强制类型转换,将22555转换为byte，然后相加赋值给byte类型变量s,此过程不改变数据类型实现运算
        //相当于
        byte b2=(byte)22555+0;
        System.out.println("b2="+b2);

        int a=2;
        double d=2.1;
        System.out.println(a+=0.1);  //隐含了一个强制类型转换,a和0.1类型不一致，所以0.1->0,a类型不变
        System.out.println(d+=0.1); //d和0.1类型一致，所以不需要强转
    }
}
