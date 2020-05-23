package com.demo.exception;

import org.testng.annotations.Test;

/**
 * e.getMessage()： 打印出具体异常的名字，不显示具体位置，不方便调试程序
 * e.printStackTrace()： 会打出详细异常,异常名称,出错位置,异常堆栈，便于调试用
 */
public class GetMessage_PrintStackTrace {

    @Test
    public void test(){
        try {
            int num=1/0;
        }
        //异常被catch时相当于ArithmeticException e = new ArithmeticException("/ by zero");
        catch (ArithmeticException e){
            System.out.println(e.getMessage());// / by zero
        }
    }


    /**
     * printStackTrace打印异常堆栈信息，便于调试
     */
    @Test
    public void test2(){
        try {
            int num=1/0;
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }
    }


    @Test
    public void test3() {
        try {
            int num = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        }
    }
}
