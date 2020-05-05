package com.demo.basicdemo.control_statement.breaks;

import org.testng.annotations.Test;

/*
 * continue是结束本次循环，进行下一次循环
 * continue可以作为单独的java 语句
 * */
public class ContinueDemo {

    @Test
    public void test18() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;//i==5时跳过本次循坏
            }
            System.out.println(i);
        }
    }
}
