package com.demo.basicdemo.variable.variable_datatype;

import org.testng.annotations.Test;

public class BooleanDemo {


    /**
     * 布尔String--->Boolean
     * 布尔String类型数据值为true/false/TRUE/FALSE/True/False,etc时,可转换为boolean
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


    /**
     * String转成基本类型boolean
     * "True","true","TrUe"等等通过parseBoolean都会转成true
     * 其它字符串(包括null)都会转为false
     */
    @Test
    public void test2(){
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("TRUE"); // true
        boolean b3 = Boolean.parseBoolean("false"); // false
        boolean b4 = Boolean.parseBoolean("FALSE"); // false
        boolean b5 = Boolean.parseBoolean("others"); // false
        boolean b6 = Boolean.parseBoolean(""); // false
        boolean b7 = Boolean.parseBoolean(null); // false
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(b7);
    }






}
