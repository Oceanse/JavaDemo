package com.demo.basicdemo.method.valuepass;

public class ValuePass {
    public static void main(String[] args) {
        int i=10;
        int j=i;//这里重新分配一块栈内存,并把变量i保存的字面值10传递给了变量j;

        User u=new User();//这里u保存的是堆内存地址
        User u2=u;//这里重新分配一块栈内存,并把变量i保存的地址值传递给了变量u2
    }
}
