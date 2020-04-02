package com.demo.basicdemo.method.valuepass;

public class MethodValuePass {


    //方法参数传递都是传递变量所保存的值，只不过引用变量保存的值是堆内存地址，所以参数是引用变量时传递的是地址
    public static void main(String[] args) {
        int i = 10;//这里把i换成m就特别好理解了
        addOne(i);//基本数据类型是值传递，相当于把i的字面值赋值一份传递给addOne方法
        System.out.println("main: " + i);
    }

    public static void addOne(int i) {
        i++;
        System.out.println("addOne：" + i);
    }



}

