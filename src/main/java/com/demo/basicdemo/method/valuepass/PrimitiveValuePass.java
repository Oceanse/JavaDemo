package com.demo.basicdemo.method.valuepass;

import org.testng.annotations.Test;

/**
 * 基本类型参数的传递，是把字面值进行复制然后传给被调函数。双方各自的后续修改，互不影响。
 */
public class PrimitiveValuePass {

    @Test
    public void test(){
        int i = 10;//这里把i换成m就特别好理解了
        addOne(i);//基本数据类型是字面值传递，相当于把i的字面值复制一份传递给addOne方法
        System.out.println("test: " + i);
    }


    public static void addOne(int i) {
        i++;
        System.out.println("addOne：" + i);
    }

}

