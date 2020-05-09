package com.demo.basicdemo.method.overload;

import org.testng.annotations.Test;

public class OverloadDemo3 {


    /**
     * 返回两个整数的和
     */
    int add(int x, int y) {
        return x + y;
    }

    /**
     * 返回两个小数的和
     */
    double add(double x, double y) {
        return x + y;
    }

    /**
     * 如果没有找到匹配的数据类型，那么会隐式地将一个类型提升到另一个类型
     */
    @Test
    public void test(){
        //由于无法匹配到相关方法，第一个参数自动提升为double, 匹配到add(double x, double y)
        //注意：如果方法中存在匹配类型参数，则不会执行类型提升方法
        new OverloadDemo3().add(1,1.0);

    }
}
