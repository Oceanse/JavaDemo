package com.demo.basicdemo.keywords.finals.final_field;

import org.checkerframework.checker.units.qual.C;

public class Static_Final_Field {
    public static final String COMPANY="Ericsson";


    /**
     * Math类中，圆周率被定义为静态常量
     * public static final double PI = 3.14159265358979323846;
     *
     * System类中，out被定义为静态常量
     * public final static PrintStream out = null
     * @param r
     * @return
     */
    public double getCircleArea(double r){
        System.out.println("Area is: "+Math.PI*r*r);
        return Math.PI*r*r;
    }
}


interface Car{
    //这里实际上是public static final String brand=null;
    String brand=null; //成员常量必须初始化
}

class BMW implements Car{

    /**
     * 父接口成员常量已经初始化，这里不能再次初始化
     * @param brand
     */
    public BMW(String brand) {
        //this.brand=brand;//cannot assign a value to final variable brand
    }
}
