package com.demo.basicdemo.method;

import org.testng.annotations.Test;


/**
 * jdk1.5开始支持形参个数可变的参数，简称为可变形参
 * 语法是在最后一个参数类型和参数名中间加三个点: printNames(String... names),它表明方法可以接受多个参数值
 *
 * 可变参数列表 vs 参数数组
 *   可变参数的本质就是一个数组参数，printNames(String... names)类似于printNAmes(String[] names)，所以实参数组可以传给形参可变参数，实参可变参数可以传给数组形参
 *   在调用的时候可变参数显得更加的方便简洁
 *   数组形参可以位于参数列表的任意位置，但是可变参数只能位于参数列表的最后
 *
 *
 */
public class ChangeableParameters {

    /**
     *可变参数只能位于参数列表的最后
     * @param classfication
     * @param books
     */
    public void showBooks(String classfication, String...books){
        System.out.println(classfication);

        //可变参数的本质就是一个数组参数
        for (String book : books) {
            System.out.print(book+"\t");
        }
    }

    @Test
    public  void test() {
        showBooks("technical","thinking in java", "spring in action");
    }






    //可变参数实参可以传递给数组形参或者说参数为数组类型的方法可接受可变参数作为入参
    public static void printNames(String... names) {
        printArray(names);
    }

    public static void printArray(String[] names) {
        System.out.println(names[0]);
    }

    @Test
    public static void testx() {
        printNames("cc", "dd");
    }







    //数组实参可以传递给可变参数形参或者说可变参数的方法可接受数组作为入参
    public static void countArr(int[] arr) {
        count(arr);
    }

    public static void count(int... args) {
        for (int arg : args) {
            System.out.println(arg);
        }
    }

    @Test
    public static void test2() {
        countArr(new int[]{1,2,3});
    }


}
