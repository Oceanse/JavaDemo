package com.demo.basicdemo.method.valuepass;

import org.testng.annotations.Test;


/**
 * 匹配被调函数只能够在满足自动转换的条件下发生
 */
public class AutoConvert2 {


    /**
     * 返回两个float小数的和
     */
    double add(float x, float y) {
        return x + y;
    }


    /**
     * 如果没有找到匹配的数据类型，那么会隐式地将一个类型提升到另一个类型(自动类型转换)
     */
    @Test
    public void test(){
        //由于无法匹配到相关方法，但是两个double类型的实参又不能自动转换成float参数，所以会编译报错
        //this.add(1.0,1.0);

    }
}
