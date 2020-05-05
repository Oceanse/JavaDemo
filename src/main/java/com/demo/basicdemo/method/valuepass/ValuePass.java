package com.demo.basicdemo.method.valuepass;

/**
 * 方法参数传递都是传递变量所保存的值
 * 引用类型变量保存的值是堆内存地址，所以参数是引用变量时传递的是地址
 * 基本类型变量保存的是字面值，所以参数是基本类型变量时传递的是字面值
 */
public class ValuePass {
    public static void main(String[] args) {
        int i=10;
        int j=i;//这里重新分配一块栈内存,并把变量i保存的字面值10传递给了变量j;

        User u=new User();//这里u保存的是堆内存地址
        User u2=u;//这里重新分配一块栈内存,并把变量i保存的地址值传递给了变量u2
    }
}
