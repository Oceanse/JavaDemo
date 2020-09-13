package com.demo.basicdemo.method;
/**
* 每条线程都有一个独立的栈,在线程创建时创建
*
* 用栈的存取顺序是先进后出,后进先出,就像是手枪弹夹,后进去的先打出来;
* 方法法人嵌套调就是不断压栈弹栈的过程
*
* a-->b-->c(a调用b,b调用c),  那么a,b,c会依次压栈，a在最下面，b在中间，c在最上面面
* c最先执行完，最先弹栈(释放栈内存)，b在弹栈，a最后弹栈
 *
 * 如果方法嵌套调用的深度越大，那么占用的栈空间就会越大
* */


public class MethodStack {

    //压栈顺序：main-->average-->sum
    //弹栈顺序：sum-->average-->main

    public static void main(String[] args) {
        int chinese=130;
        int math=150;
        int averageScore=average(130,150);
        System.out.println(averageScore);

    }

    public static int average(int i, int j){
        int m= sum(i,j);
        return  m/2;
    }


    private static int sum(int i, int j){
        return i+j;
    }
}
