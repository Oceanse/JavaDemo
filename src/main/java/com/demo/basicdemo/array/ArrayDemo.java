package com.demo.basicdemo.array;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 数组属引用类型,是多个相同类型数据的组合，包括基本数据类型和引用数据类型
 *
 * 数组变量是一个引用变量，存在于栈中，保存的是数组首元素的内存地址或者理解为指向堆内存中对应的数组对象；只有通过引用变量才能访问和修改数组元素
 *
 *
 * 动态初始化:声明并指定数组长度,之后再进行手动赋值(分配空间和手动赋值分开进行)
 *
 * 静态初始化:在数组创建时候同时手动赋值初始化，由系统决定数组的长度(分配内存和赋值同时进行)
 *   简化格式： 数据类型[] 数组名称 = {值, 值, …};
 *   完整格式（推荐）: 数据类型[] 数组名称 = new 数据类型[]{值, 值, …}
 *
 * 数组名变量保存的是数组首元素的内存地址
 *
 * 数组元素都有下标，范围从0到length-1,数组通过下标访问数组元素
 * 数组查询效率很高
 * 数组一旦分配空间，其长度length是不可变的
 */
public class ArrayDemo {

    /**
     * 声明数组
     */
    @Test
    public void test1() {

        //这里只是声明int[]/double[]/char[]/String[]类型的数组，要把int[]/double[]/char[]/String[]理解成一种引用数据类型，
        // 而num,scores等只是引用类型变量，这里还没有指向堆内存中对应的数组对象
        // 只是占用栈内存空间，也不能指定数组长度
        int[] num;
        double[] score;
        char[] letters;
        String[] names;
    }


    @Test
    public void test2() {
        //数组元素必须属于Nember类或者其子类
        //而number只是引用类型变量，指向堆内存中对应的数组对象或者保存着堆内存中对应的数组对象的地址
        Number[] number=new Number[]{new Double(1.0), new Integer(1)} ;

        number=null;//切断数组引用变量和数组对象的联系，此时没有任何引用指向数组对象，上面数组对象将会变成垃圾被回收

    }


    @Test
    public void test3() {
        //数组作为引用数据类型，也可以发生引用传递,不同的栈引用可以指向同一块堆内存
        char[] c = new char[]{'a', 'b', 'c'};
        char[] c2 = null;
        c2 = c;
        System.out.println(Arrays.toString(c2));
        c2[0] = 'w';
        System.out.println(c[0]);
    }

    @Test
    public void test4() {
        Mouse m1=new Mouse("black");
        Mouse m2=new Mouse("white");

        //数组中两个元素类型也是引用类型，而且两个元素和m1，m2分别指向同一对象
        Mouse[] mouse=new Mouse[2];
        mouse[0]=m1;
        mouse[1]=m2;

        //通过数组元素或者m1,m2修改Mouse访问到的对象是相同的
        System.out.println(m1.getColor());
        System.out.println(mouse[0].getColor());

        //通过数组元素或者m1,m2修改Mouse对象时是等价的
        mouse[0].setColor("blue");
        System.out.println(m1.getColor());
        System.out.println(mouse[0].getColor());

        //通过数组元素或者m1,m2修改Mouse对象时是等价的
        m1.setColor("red");
        System.out.println(m1.getColor());
        System.out.println(mouse[0].getColor());

    }
}

class Mouse{
    String color;

    public Mouse(String color){
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
