package com.demo.basicdemo.variable.variable_datatype;

import org.testng.annotations.Test;

public class BooleanDemo {


    /**
     * 布尔tring--->Boolean
     * 布尔tring类型数据值为true/false/TRUE/FALSE/True/False,etc时,可转换为boolean
     */
    @Test
    public void test(){
        String s = "true";
        String s2 = "True";
        boolean b = Boolean.valueOf(s);
        boolean b2 = Boolean.valueOf(s);
        System.out.println(b);
        System.out.println(b2);
    }


}
