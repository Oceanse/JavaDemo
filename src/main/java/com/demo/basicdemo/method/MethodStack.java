package com.demo.basicdemo.method;
/*
* 每条线程都有一个独立的栈,在线程创建时创建
*
* 用栈的存取顺序是先进后出,后进先出,就像是手枪弹夹,后进去的先打出来;
* 方法法人嵌套调就是不断压栈弹栈的过程
*
* a-->b-->c(a调用b,b调用c),  那么a,b,c会依次压栈，a在最下面，b在中间，c在最下面
* c最先执行完，最先弹栈(释放栈内存)，b在弹栈，a最后弹栈
* */


public class MethodStack {
    public static void main(String[] args) {
        int i=1;
        int n=doubles(i);
        System.out.println(n);

    }

    public static int doubles(int i){
        int m= 2*i;
        return  squares(m);
    }


    public static int squares(int i){
        return i*i;
    }
}
