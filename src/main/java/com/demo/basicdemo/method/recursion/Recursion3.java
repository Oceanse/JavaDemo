package com.demo.basicdemo.method.recursion;


/*
递归很消耗内存，方法调用一次，方法压栈一次
* 一直递归导致不断的压栈，最后造成StackOverflowError
* 所以递归必须有结束条件，但是递归太深还是可能造成栈溢出错误
* */
public class Recursion3 {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }


    public static int factorial(int n){

        //结束条件
        if (n==1) {
            return 1;
        }

        return n*factorial(n-1);

    }

}
