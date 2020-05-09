package com.demo.basicdemo.method.overload;

public class OverloadDemo2 {

    /**
     * 静态方法main方法的重载
     * JVM只会调用main(String[] args)
     * @param args
     */
    public static void main(String[] args) {
        main('\u0022');
        main("ocean");
    }

    public static void main(char c) {
        System.out.println(c);
    }
    public static void main(String name) {
        System.out.println(name);
    }
}
