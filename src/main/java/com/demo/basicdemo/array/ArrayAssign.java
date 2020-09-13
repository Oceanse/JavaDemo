package com.demo.basicdemo.array;

import com.demo.oop.inherit.demo2_this_super.Human;
import com.demo.pojo.TestResourceinfo;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;

public class ArrayAssign {

    /**
     * 动态初始化数组：先分配空间(指明数组长度)，然后程序员手动赋值(初始化)
     */
    @Test
    public void test() {

        //先分配空间
        int[] arr;      //声明数组，即声明一个int[] 类型的数组arr,这里只是占用栈内存空间;
        arr = new int[5];//分配内存空间 数组名 = new 类型[数组元素的个数] 开辟堆内存空间，这里系统已经默认初始化完
        System.out.println(Arrays.toString(arr));//数组元素默认全是0

        //手动赋值(初始化)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i; //把每个字面值赋值给数组元素空间
        }
        System.out.println(Arrays.toString(arr));




        //先分配空间
        Human[] p = new Human[3];//声明同时分配内存空间
        System.out.println(Arrays.toString(p));//数组元素默认全是null

        //手动赋值(初始化)
        for (int i = 0; i < p.length; i++) {
            p[i] = new Human();//把每个对象地址赋值给数组元素空间
        }
        System.out.println(Arrays.toString(p));


    }

    /**
     * 静态初始化数组：分配空间和手动赋值(初始化)同时进行，由系统决定数组长度
     */
    @Test
    public void test2() {

        //分配空间和手动赋值(初始化)同时进行
        String[] str = {"aa", "bb"};
        String[] str2 = new String[]{"aa", "bb"};

        //分配空间和手动赋值(初始化)同时进行
        TestResourceinfo t1 = new TestResourceinfo();
        TestResourceinfo t2 = new TestResourceinfo();
        TestResourceinfo t3 = new TestResourceinfo();
        TestResourceinfo[] tt = {t1, t2, t3};//tt数组的每个空间中保存着t1,t2,t3对象的地址
        TestResourceinfo[] tt2 = new TestResourceinfo[]{t1, t2, t3};//tt2数组的每个空间中保存着t1,t2,t3对象的地址

        Date[] date = {new Date(20190719), new Date(20190720)};
        Date[] date2 = new Date[]{new Date(20190719), new Date(20190720)};

    }


}
