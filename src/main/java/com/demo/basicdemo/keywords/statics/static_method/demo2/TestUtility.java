package com.demo.basicdemo.keywords.statics.static_method.demo2;

import org.testng.annotations.Test;

import static com.demo.basicdemo.keywords.statics.static_method.demo2.MathUtility.square;

public class TestUtility {

    @Test
    public void test() {
        //通过类名调用非本类static方法
        System.out.println(MathUtility.add(1, 2));
        System.out.println(MathUtility.power(2,16));

    }

    /**
     * 静态导入：通过import进其他类的方法到本类中可以实现省略类名或者对象名来调用静态方法
     */
    @Test
    public void test6_2() {
        //import static com.demo.basicdemo.keywords.statics.static_method.demo2.MathUtility.square;
        System.out.println(square(2));
    }

}
