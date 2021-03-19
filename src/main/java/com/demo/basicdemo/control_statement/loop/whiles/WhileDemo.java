package com.demo.basicdemo.control_statement.loop.whiles;

import org.testng.annotations.Test;

/**
 *  初始化条件
 *  while(条件表达式){
 *    循环体(包含更新条件)
 *  }
 * 先判断条件表达式-->循环体-->条件表达式--->.....
 * 如果条件表达式一开始就是false, 循环体一次都不会执行
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
     * 循环体只有一句时候可以省略{}，不建议这么做，因为这样会降低程序的可读性
     */
    @Test
    public void test1_2()  {
        int i=10;
        while (i>0)
            System.out.println(i--);
        System.out.println("我不属于while循环");

    }


    /**
     * 死循环
     * ;也是一个合法的语句，是特殊的空语句
     * 由于空语句没有迭代条件，所以陷入死循环
     */
    @Test
    public void test1_3()  {
        int i=10;
        while (i>0);
        System.out.println("我不属于while循环，但是永远得不到执行机会");

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
