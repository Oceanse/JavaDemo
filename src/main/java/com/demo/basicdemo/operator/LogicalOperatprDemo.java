package com.demo.basicdemo.operator;

import org.testng.annotations.Test;

/**
 *
 逻辑运算符(Logical Operatpr)用于连接两个结果布尔类型的变量/常量/表达式，用于执行多个判断，
 判断的结果是 true 或 false。
 */
public class LogicalOperatprDemo {

    @Test
    public void test(){
        // &&和||短路
        // 所谓短路，就是当参与运算的一个操作数已经足以推断出这个表达式的值的时候，另外一个操作数（有可能是表达式）就不会 执行

        int i=2;
        boolean b=false;
        if((b) & (i++)>0){//i++会被执行
        }
        System.out.println("i: "+i);


        int i2=2;
        boolean b2=false;
        if ((b2) && (i2++>0)) {//i2++不会被执行
        }
        System.out.println("i2: "+i2);


        int i3=2;
        boolean b3=true;
        if((b3) | (i3--)>0){
        }
        System.out.println("i3: "+i3);


        int i4=2;
        boolean b4=true;
        if((b4) || (i4--)>0){
        }
        System.out.println("i4: "+i4);
    }


    /**
     *  //!单目运算符，只需要一个操作数；操作数是结果为布尔类型的变量/常量/表达式
     *  操作数为true,则返回false;操作数为false,则返回true
     */
    @Test
    public void test2(){
        System.out.println("!true: "+!true);
        System.out.println("!(2>1): "+!(2<1));
    }


    /**
     * 异或：两个操作数不同时返回true,相同时返回false
     */
    @Test
    public void test3(){
        System.out.println(true ^ true);
        System.out.println(('c'>'a')^(1>2));
    }


    /**
     * 非：~
     * 运算规则：如果位为0，结果是1，如果位为1，结果是0.
     */
    @Test
    public void test4(){
        byte b=0B01100000;//最高符号位是0说明是正数，转成十进制96，原码反码补码一致；
        System.out.println(b);

        //0B01100000; 补码取反~得新补码：10011111
        //新补码10011111是负数，减去1得到反码：10011110
        //反码代表负数，符号位不变，剩余位取反得原码：11100001
        //原码：11100001十进制： -97
        System.out.println(~b);

    }

}
