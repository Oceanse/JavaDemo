package com.demo.basicdemo.control_statement.break_continue;

import org.testng.annotations.Test;



/**
 *使用break的场景有两种：switch语句和循环语句
 *循环中：可以直接强行退出当前的循环，某些时候需要在某种条件出现时强行终止循环，而不是等到循环条件为 false 时才退出循环
 *switch:每个 case 子句块的最后添加语句break来退出switch
 *
 * break可以作为单独的java 语句
 * */
public class BreakDemo {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;//i==5时跳出当前循坏
            }
            System.out.println(i);
        }
        System.out.println("======");//bbreak只是退出循环，并不是退出方法，所以这里依然可以打印
    }


    @Test
    public void test16() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    break;//i==5时跳出当前循坏,当前循环是内层循环
                }
                System.out.println(i + " + " + j + " = " + (i + j));
            }
        }

    }


    /**
     * 用标签（label）可以指定一个代码块，标签可以是任何合法有效的 Java 标识符，后跟一个冒号
     * break label;
     */

    @Test
    public void test17() {

        outter: for (int i = 0; i < 3; i++) {
            inner:for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    //break inner;  i==5时跳出内层循环inner,同test16
                    break outter;//i==5时跳出外层循环outter
                }
                System.out.println(i + " + " + j + " = " + (i + j));
            }
        }

    }




}
