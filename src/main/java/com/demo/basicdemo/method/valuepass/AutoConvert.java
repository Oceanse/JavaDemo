package com.demo.basicdemo.method.valuepass;

import org.testng.annotations.Test;

/**
 * 实参转化成形参时候可能会自动类型转换去匹配形参
 * 如果没有找到匹配的数据类型，那么编译器会自动将一个类型转换成另一个类型(自动类型转换，小--->大)来匹配被调函数
 * 匹配被调函数只能够在满足自动转换的条件下发生
 */
public class AutoConvert {

    double add(double x, double y) {
        return x + y;
    }


    @Test
    public void test(){
        //由于无法匹配到相关方法，第一个参数1和第二个参数自动转换成为double, 匹配到add(double x, double y)
        add(1,1);

    }
}
