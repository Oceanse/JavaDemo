package com.demo.basicdemo.method.valuepass;

import org.testng.annotations.Test;

/**
 * 基本类型参数的传递，是把字面值进行复制然后传给被调函数。双方各自的后续修改，互不影响。
 */
public class PrimitiveValuePass2 {

    @Test
    public void test(){
        int i = 10;
        int j=20;
        swap(i,j);//基本数据类型是字面值传递，相当于把i和j的字面值复制一份传递给addOne方法
        System.out.println("test: "+i+" "+j);
    }


    public static void swap(int i, int j) {
        System.out.println("swap1: "+i+" "+j);
        int temp=i;
         i=j;
         j=temp;
        System.out.println("swap1: "+i+" "+j);
    }

}

