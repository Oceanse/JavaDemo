package com.demo.basicdemo.keywords.finals;

import java.util.Arrays;

/**
 * 关于不可变类：
 * 当final修饰的成员变量属于引用类型变量时候，仅表示这个变量保存的地址或者指向的对象时不可变的，但是对象的内容确时可变的，
 * 这就不符合不可变类的初衷；期待结果是变量指向的对象和这个对象的内容都不能被修改
 * 因此要保证final引用变量指向的对象没有其他手柄指向它，也就是保证只有final引用变量指向那个对象
 */
public class Unmutable_Instance3 {
    private final int[] myArray;

    // 把数组对象拷贝一份，然后把副本(拷贝的拿分)的地址赋值给myArray，所以这里array和myArray是指向两个地址不同、内容相同的数组
    public Unmutable_Instance3(int[] array) {
        this.myArray = array.clone();
    }
    public int[] getMyArray(){
        return myArray.clone();
    }

    public static void main(String[] args) {
        int[] count=new int[]{1,2,3};
        Unmutable_Instance3 u=new Unmutable_Instance3(count);//这里count和myArray是指向两个地址不同、内容相同的数组
        System.out.println(Arrays.toString(u.getMyArray()));

        //count的改变不会导致myArray的改变，所以成员变量myArray指向的数组对象不会发生改变
        count[0]=3;
        System.out.println(Arrays.toString(u.getMyArray()));

    }
}
