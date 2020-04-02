package com.demo.basicdemo.constants;

import org.testng.annotations.Test;

public class Constant {


    /*常量是指在程序的整个运行过程中值保持不变的量；
    * 常量和常量值是不同的概念，常量值是常量的具体和直观的表现形式，常量是形式化的表现；
    * 常量不同于常量值，它可以在程序中用符号来代替常量值使用，因此在使用前必须先定义；
    * 声明常量的同时一点要赋予一个初始值，即使是成员变量，常量一旦初始化就不可以被修改；
    * 通常在程序中既可以直接使用常量值，也可以使用常量
    * 为了与变量区别，常量取名一般都用大写字符
    * 声明常量的同时要赋予一个初始值
    *
    *
    * 常量值又称为字面常量，它是通过数据直接表示，因此有很多种数据类型
    * 整型常量值 实型常量值  布尔型常量值  字符型和字符串常量值
    *
    *Java 语言使用 final 关键字来定义一个常量，其语法如下所示：
    *    final dataType variableName = value
    *
    *
    *
    *
    * */



    //final int m;即使的成员变量也必须要初始化
    final int M=1;
    final boolean FLAG=true;

    @Test
    public void test(){
        final String NAME="ocean";
        //NAME="pam";对常量重新赋值会导致错误
        int m=new Constant().M;//常量值赋值给变量
        double d=Math.PI;//这里PI是static final

    }

}
