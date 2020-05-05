package com.demo.basicdemo.control_statement.whiles;

import org.testng.annotations.Test;

/*
 * while(条件表达式){
 *    循环体
 *  }
 *
 *  先判断条件表达式-->循环体-->条件表达式---.....
 *
 *
 *  初始化条件
 *  while(条件表达式){
 *    循环体(包含更新条件)
 *  }
 *
 * 循环体可能一次都不会执行
 * */
public class WhileDemo {

    //死循环
    @Test
    public void test() throws InterruptedException {
        while (true) {
            System.out.println(Math.random());
            Thread.sleep(1000);
        }
        //System.out.println("这里永远无法执行"); 这里放开会编译不通过，提示unreachable
    }


    /**
     * while 语句计算 10 的阶乘
     */
    @Test
    public void test2() {
        int i = 1;
        int n = 1;
        while (i <= 10) {
            n *= i;
            i++;
        }
        System.out.println("10的阶乘结果为：" + n);
    }


    /**
     * 图书列表中保存 50 条信息，现在需要让它每行显示 10 条，分 5 行
     */
    @Test
    public void test3() {
        int pageIndex = 1;
        while (pageIndex < 51) {
            System.out.print(pageIndex + "\t");
            if (pageIndex % 10 == 0) {
                System.out.println();
            }
            pageIndex++;
        }
    }


}
