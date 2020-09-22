package com.demo.basicdemo.keywords.finals;

import java.util.Arrays;

/**
 * 当final修饰变量属于引用类型变量时候，仅表示这个变量保存的地址或者指向的对象时不可变的，但是对象的内容确时可变的，
 * 这就不符合不可变类的初衷；期待结果是变量指向的对象和这个对象都不能被修改
 * 就是要保证final引用变量指向的对象没有其他手柄指向它
 */
public class Unmutable_Instance3 {
    private final int[] myArray;
    public Unmutable_Instance3(int[] array) {
        this.myArray = array.clone(); // 数组对象的副本的地址赋值给myArray
    }
    public int[] getMyArray(){
        return myArray.clone();
    }

    public static void main(String[] args) {
        int[] count=new int[]{1,2,3};
        Unmutable_Instance3 u=new Unmutable_Instance3(count);
        System.out.println(Arrays.toString(u.getMyArray()));

        //成员变量myArray指向的数组对象发生了改变
        count[0]=3;
        System.out.println(Arrays.toString(u.getMyArray()));

    }
}
