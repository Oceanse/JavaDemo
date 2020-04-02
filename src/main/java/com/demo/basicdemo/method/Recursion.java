package com.demo.basicdemo.method;


/*
递归很消耗内存，方法调用一次，方法压栈一次
* 一直递归导致不断的压栈，最后造成StackOverflowError
* 所以递归必须有结束条件，但是递归太深还是可能造成栈溢出错误
* */
public class Recursion {
    public static void main(String[] args) {
        System.out.println("main begin..");
        new Recursion().m();
        System.out.println("main over..");
    }


    public void m(){
        System.out.println("m begin...");
        m();
        System.out.println("m over...");

    }

}
