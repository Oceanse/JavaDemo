package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

public class boxing_unboxing {

    @Test
    public void test() {

        //自动装箱
        Double dd=new Double(1.0);
        double m=dd;//自动拆箱  包装类对象自动转换成基本数据类型 本质上编译器编译时自动添加double m=dd.doubleValue()
        Double n=1.1; //自动装箱  基本类型就自动地封装到与它相似类型的包装中，本质上编译器编译时自动添加：Double n =Double.valueOf(n);
        Object obj='a';//这里个人理解为先自动转型，再向上转型 ,编译器自动添加Object obj=Character.valueOf('a');
    }
}
