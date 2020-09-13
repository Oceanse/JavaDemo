package com.demo.basicdemo.operator;

import org.testng.annotations.Test;


/**
 * 关系运算符(Relational Operator)用于用来比较判断两个数值型变量/常量/表达式的大小或者其他类型变量/常量/表达式是否相等,当运算符对应的关系成立时，运算结果是 true，否则是 false
 * = 和 != 可以应用于基本数据类型和引用类型。两者本质上上比较的都是变量存储的变量值，只是这个值可能是字面值，可能是对象的引用(对象的地址)
 * 当用于引用类型比较时，比较的是对象地址(两个引用是否指向同一个对象);
 * 当用于基本数据类型比较，比较的是他们的字面值
 * 变量中存储的不是字面值就是地址
 *
 * */
public class RelationalOperatorDemo {


    @Test
    public void test3_1(){

        //基本类型变量值大小的比较
        int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b) );
        System.out.println("a != b = " + (a != b) );
        System.out.println("a > b = " + (a > b) );
        System.out.println("a < b = " + (a < b) );
        System.out.println("b >= a = " + (b >= a) );//大于或者等于
        System.out.println("b <= a = " + (b <= a) );//小于或者等于

        //引用变量比较
        Integer i1=new Integer(10);
        Integer i2=new Integer(10);
        System.out.println("i1=i2: "+(i1==i2));//i1和i2存储的是对象的堆内存地址，这里是不相等的


        //数值常量比较大小
        System.out.println("10>=10: "+(10>=10));
        System.out.println("10==10: "+(10.0==10));//基本数据类型比较，比较的是他们的值


        //布尔常量比较是否相同
        System.out.println("true==false: "+(true==false));

        //int和char比较，char类型参与大小比较或者运算时候会以编号身份参与
        System.out.println("'a'==97: "+('a'==97));
    }


    @Test
    public void test3_2() {
        //注意==和=
        boolean b = false;
        if (b = true){//赋值表达式的值是左边变量存储的值
            System.out.println("zhen.....");
        }
        else{
            System.out.println("jia...");
        }
    }

}
