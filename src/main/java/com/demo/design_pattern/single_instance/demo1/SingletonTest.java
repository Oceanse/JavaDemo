package com.demo.design_pattern.single_instance.demo1;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);//比较两个变量保存的变量值，也就是地址
    }
}
