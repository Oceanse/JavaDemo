package com.demo.lambda.whylambda;


/**
 * 本质：用来创建函数型接口对象
 * 使用条件：只能创建函数型接口(内部只有一个抽象方法的接口)对象
 * 作用：lambda可以用来创建函数型接口对象，这个对象可以赋值给某个引用变量 或者 作为实参传给方法 或者 作为方法的返回值
 * 语法： (参数列表)->{方法体}，参数列表就是函数型接口内部的抽象方法的参数列表，方法体就是对这个抽象方法的实现
 *
 */
public class Action implements Runnable {
    @Override
    public void run() {
        System.out.println("fly....");
    }
}


class Test{


    public static void main(String[] args) {

        //传统方法,需要创建实现类及其对象
        Runnable r=new Action();
        new Thread(r).start();


        //匿名内部类，不需要创建实现类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run....");
            }
        }).start();


        //lambda表达式更加简洁
        new Thread(()->{
            System.out.println("walk...");
        }).start();
    }

}
