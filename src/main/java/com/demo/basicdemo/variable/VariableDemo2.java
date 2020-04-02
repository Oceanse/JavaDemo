package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

public class VariableDemo2 {


    @Test
    public void test() {




    }



    @Test
    public void test2() {

        //方法体中的代码自上而下执行
        //Java 中的变量需要先声明后使用

        //System.out.println(c);
        int c=0;

    }


    @Test
    public void test3() {

        int c=0;

       // double c=1.0;  在同一个作用域内，变量名不能相同

    }





    @Test
    public void test4() {
        int a,b=123;//等价于 int a; int b=123;

        //System.out.println(a);
        System.out.println(b);

    }


  /*  @Test
    public void test3() {

        int a,b,c=1;//a,b只是声明并分配内存空间，但是没有初始化
        //System.out.println(a);
        //System.out.println(b);
        System.out.println(c);

    }
*/





}
