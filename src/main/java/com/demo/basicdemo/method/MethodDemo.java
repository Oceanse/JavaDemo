package com.demo.basicdemo.method;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 *  方法是对一段功能代码的封装，可以被重复调用；
 *
 *  语法： 【修饰符】 返回值类型 方法名(形参列表)
 *
 *      修饰符：权限修饰符/final/static等
 *
 *      返回值类型：有的时候需要方法返回最终的结果给主调函数，可以用return返回；返回值类型就是返回结果的类型
 *
 *      方法名：方法名和形参可以一起定位某个具体的方法
 *
 *      形参：形参中起决定作用的是形参的数据类型
 *      实参: 当方法被调用的时候传递的真实数据被称为实参(实际参数)
 *      实参传给形参时候可能会发生自动类型转换
 *
 *
 *  方法只能定义在类中；不能嵌套定义(方法中定义方法)
 *  方法可以嵌套调用(方法中调用方法)，可以在方法内调用，也可以在方法外调用
 *
 *  方法体中的代码会自上而下顺序执行，上面的代码执行完才能执行下一行的代码
 *
 *
 *  main(String[] args)方法是程序的入口
 *
 */
public class MethodDemo {


    //方法外调用方法
    int[] sortArray= new MethodDemo().sort(new int[]{1,3,2});


    /**
     * 方法中不能嵌套定义方法
     */
    @Test
    public void test() {

       /*
       方法中不能嵌套定义方法
        public int[] sort(int[] array){
            Arrays.sort(array);
            return array;
        }
        */

        this.sort(new int[]{1,3,2});

    }


    public int[] sort(int[] array){
        Arrays.sort(array);
        return array;
    }


    /**
     * 实参传递给形参时候可以自动类型转换以匹配形参
     */
    @Test
    public void test2() {
        add(1,1);//这里的两个1会自动转换成double类型
    }

    public static double add(double d1,double d2){
        return d1+d2;
    }









}
