package com.demo.basicdemo.control_statement.break_continue;

import org.testng.annotations.Test;

/**
 * continue是跳过本次循环continue后面剩下的语句，接着进行下一次循环，并不会终止循环
 * continue可以作为单独的java 语句
 * */
public class ContinueDemo {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;//i==5时跳过本次循坏
            }
            System.out.println(i);
        }
    }


    /**
     * continue是跳过本次循环continue后面剩下的语句，接着进行下一次循环
     * 所以continue放在最后是没有意义的，因为这相当于没有忽略任何语句
     */
    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                continue;//i==5时跳过本次循坏
            }
        }
    }

}
