package com.demo.basicdemo.keywords.finals;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * You can add the final keyword to declare the variable as "final" if you don't want others (or yourself) to overwrite existing values
 * which means unchangeable and read-only once assigned a value.
 *
 * 定义：
 *   常量是指在程序的整个运行过程中值保持不变的量；
 *   final修饰变量就变成了常量，其语法: final dataType variableName = value
 *   final修饰的是基本类型变量，那么变量保存的字面值一旦赋值不能变；若修饰的是引用变量，只能指向一个固定的对象(保存的地址不能变)，但是指向对象的内容可以改变
 *   这里不变的本质是变量对应的内存空间保存的变量值不能再改变
 *
 * 赋值：
 * final修饰变量不能采用系统的默认值，必须手动赋值， 声明时赋值(包括局部、成员变量)，代码块赋值，构造器赋值
 *
 * 特点：
 *   常量可以看作一种特殊的变量，只是只能手动赋值一次，一旦初始化就不可以被修改
 *   声明明常量的同时一点要赋予一个初始值，即使是成员变量
 *
 * 分类：
 *   作用范围：静态常量、实例常量和局部常量。
 *   类型：整型常量值 实型常量值 布尔型常量值 字符型 字符串常量值
 *
 * 命名：
 *   为了与变量区别，常量取名一般都用大写字符，多个单词构成时候下划线连接
 *
 * 常量和常量值
 *   常量和常量值是不同的概念，常量可以理解为只能赋值一次的特殊的变量，常量值是常量内存空间保存的数据内容
 *   通常在程序中既可以直接使用常量值，也可以使用常量；
 *
 *  经典使用：全局常量
 *  public static final NATION="CHINA";
 *  常量是public,对所有类开放，但只能被访问，不能修改
 *  所有对象共享全局变量：static
 *
 *
 *
 */
public class Final_Field {


    //final int M;即使的成员变量也必须要初始化

    //实例常量：声明属性时候初始化
    final int QTY = 10;

    //实例常量: 构造器 初始化
    final boolean Flag;

    //实例常量: 构造代码块初始化
    final String NAME;

    //静态代码块初始化静态属性
    final static int PORT;

    //全局常量：声明属性时候初始化
    public static final double PI = 3.14;


    {
        NAME="ocean";//构造代码块初始化实例属性，这里是第一次赋值，之后改变量的值不嫩再改变
    }

    static {
        PORT=10086;//静态代码块初始化静态属性，这里是第一次赋值，之后改变量的值不嫩再改变
    }


    public Final_Field() {
        Flag = true;//构造方法中初始化实例属性，这里是第一次赋值，之后该变量的值不能再改变
        //PORT=10086; //代码块要在构造器之前被执行，因为已经在代码块中被初始化，所以这里不能再次初始化
    }


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

    @Test
    public void test3() {
        double count=new Final_Field().QTY;//常量值自动类型转换然后赋值给变量
        double square= Final_Field.PI*1*1;

      //  double count2=new Final_Field(false).QTY;
    }



    @Test
    public void test4() {
        //这里workChannels 是常量，并且被初始化，永远指向new ConcurrentHashMap<>()
        //这里workChannels保存的地址永远不会变，但是它指向的对象可以改变
         final  Map<String, String> workChannels = new ConcurrentHashMap<>();
         workChannels.put("name","tom");
        workChannels.put("age","22");
    }

}
