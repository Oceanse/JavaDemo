package com.demo.basicdemo.keywords.finals.final_field;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * You can add the final keyword to declare the variable as "final" if you don't want others (or yourself) to overwrite existing values
 * which means unchangeable and read-only once assigned a value.
 * <p>
 * 定义：
 * 常量是指在程序的整个运行过程中值保持不变的量；
 * final修饰变量就变成了常量，其语法: final dataType variableName = value
 * final修饰的是基本类型变量，那么变量保存的字面值一旦赋值不能变；若修饰的是引用变量，只能指向一个固定的对象(保存的地址不能变)，但是指向对象的内容可以改变
 * 这里不变的本质是变量对应的内存空间保存的变量值不能再改变
 * <p>
 * 赋值：
 * final修饰变量不能采用系统的默认值，必须手动赋值， 声明时赋值(包括局部、成员变量)，代码块赋值，构造器赋值
 * <p>
 * 特点：
 * 常量可以看作一种特殊的变量，只是只能手动赋值一次，一旦初始化就不可以被修改，声明明常量的同时一点要赋予一个初始值，即使是成员变量。
 * 对千final修饰的成员变量而言， 一旦有了初始值， 就不能被重新赋值， 如果既没有在定义成员变量时指定初始值， 也没有在初始化块、
 * 构造器中为成员变量指定初始值， 那么这些成员变量的值将一直是系统默认分配的0、false或null,
 * 这些成员变量也就完全失去了存在的意义。因此Java语法规定： final修饰的成员变量必须由程序员显式地指定初始值。
 * <p>
 * 分类：
 * 作用范围：静态常量、实例常量和局部常量。
 * 类型：整型常量值 实型常量值 布尔型常量值 字符型 字符串常量值
 * <p>
 * 命名：
 * 为了与变量区别，常量取名一般都用大写字符，多个单词构成时候下划线连接
 * <p>
 * 常量和常量值
 * 常量和常量值是不同的概念，常量可以理解为只能赋值一次的特殊的变量，常量值是常量内存空间保存的数据内容
 * 通常在程序中既可以直接使用常量值，也可以使用常量；
 * <p>
 * 经典使用：全局常量
 * public static final NATION="CHINA";
 * 常量是public,对所有类开放，但只能被访问，不能修改
 * 所有对象共享全局变量：static
 */
public class FinalField {


    //final int M;即使的成员变量也必须要初始化

    //实例常量：声明属性时候初始化
    final int QTY = 10;

    //实例常量: 构造器 初始化
    final boolean Flag;

    //实例常量: 构造代码块初始化
    final String NAME;

    //全局常量：静态代码块初始化
     static final int PORT;

    //全局常量：声明属性时候初始化
    public static final double PI = 3.14;


    {
        NAME = "ocean";//构造代码块初始化实例属性，这里是第一次赋值，之后改变量的值不能再改变
    }

    static {
        PORT = 10086;//静态代码块初始化静态属性，这里是第一次赋值，之后改变量的值不能再改变
    }


    public FinalField() {
        Flag = true;//构造方法中初始化实例属性，这里是第一次赋值，之后该变量的值不能再改变
        //NAME = "ocean";//实例代码块要在构造器之前被执行，因为NAME已经在代码块中被初始化，所以这里不能再次初始化
        //PORT=10086; //静态代码块要在构造器之前被执行，因为PORT已经在代码块中被初始化，所以这里不能再次初始化
    }


    /**
     * 基本类型常量
     * 常量初始化之后便不能进行修改
     */
    @Test
    public void test() {
        // 局部常量
        final int  ID = 15721166;
        //ID=15721167;  不能修改常量的值
    }


    /**
     * 引用变量
     * 常量初始化之后便不能进行修改
     */
    @Test
    public void test2() {
        //scores 是局部常量，并且被初始化，永远指向首次声明的new ConcurrentHashMap<>()

        //这里scores保存的地址永远不会变，指向的对象永远不变，但是指向的对象的内容可以改变
        final Map<String, String> scores = new ConcurrentHashMap<>();
        scores.put("chinese", "118");
        scores.put("math", "13722");

        //scores = new ConcurrentHashMap<>();  //scores不能指向另一个对象
    }


    @Test
    public void test2_2() {
        //sb是局部常量，并且被初始化，永远指向首次声明的new StringBuilder()

        //这里sb保存的地址永远不会变，指向的对象永远不变，但是指向的对象的内容可以改变
        final StringBuilder sb = new StringBuilder();
        sb.append("I ").append("am ").append("chinese");
        //sb=new StringBuilder(); //sb不能指向另一个对象
    }


    /**
     * 基本类型常量
     * 如果没有使用局部常量，可以不进行初始化
     */
    @Test
    public void test3() {
        final char LETTER;
        final String NATION;
        System.out.println("如果没有使用局部常量，可以不进行初始化");
    }

    @Test
    public void test4() {
        double count = new FinalField().QTY;//常量值自动类型转换然后赋值给变量
        double square = FinalField.PI * 1 * 1;//常量参与运算
    }


    public void test5(final int a) {
        //该方法被调用时候会传入一个实参(对形参赋值)，因此方法体中不能对final 修饰的形参赋值
        //a=4;
        //另外意味着这个形参变量一点被赋值之后，在整个方法体中值都保持不变
    }


    /**
     * 对一个final变量来说， 不管它是类变量、实例变量， 还是局部变量，这个final变量就不再是一个变量， 而是相当于一个直接量。
     * 对于这个程序来说， 变髦a其实根本不存在， 当程序执行System.out.println(a); 代码时， 实际转换为执行
     * System.out.println(5)。
     *
     * final修饰符的一个重要用途就是定义” 宏变量” 。当定义fmal变量时就为该变量指定了初始值， 而且该初始值可以在编译时就确定下来，
     * 那么这个final变量本质上就是一个＂宏变量” ， 编译器会把程序中所有用到该变量的地方直接替换成该变量的值。
     */
    @Test
    public void test6() {
       //定义一个普通局部变址
        final int a = 5;
        System.out.println(a);
    }


    /**
     * 除上面那种为final变量赋值时赋直接量的情况外， 如果被赋的表达式只是基本的算术表达式或字符串连接运算(即使字符串连接运算中包含隐式类型
     * （将数值转换为字符串）转换)，没有访问普通变量或者调用方法，Java编译器同样会将这种final变量当成“ 宏变星” 处理
     */
    @Test
    public void test7() {
        //下面定义了4 个final "宏变蜇"
        final int a = 5 + 2;
        final double b = 1.2 / 3;
        final String str = "疯狂n" + "Java";
        final String book = "疯狂Java 讲义" + 99.0;

        //下面的book2 变量的值因为调用了方法， 所以编译器无法在编译时被确定下来
        final String book2 = "疯狂Java 讲义： " + String.valueOf(99.0);
    }



}
