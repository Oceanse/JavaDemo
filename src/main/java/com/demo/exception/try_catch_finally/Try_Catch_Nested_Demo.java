package com.demo.exception.try_catch_finally;


import org.testng.annotations.Test;

/**
 * Nested try block
 * Sometimes a situation may arise where a part of a block may cause one error and the entire block itself may cause another error.
 * In such cases, com.demo.exception handlers have to be nested.
 *
 * 异常处理嵌套的深度最好不要超过两层，深度太深没有必要，而且会降低程序的可读性
 */
public class Try_Catch_Nested_Demo {

    @Test
    public void test2_11() {
        try {

            try {
                System.out.println("going to divide");
                int b = 39 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

            try {
                int a[] = new int[5];
                a[5] = 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }

            System.out.println("other statement");
        } catch (Exception e) {
            System.out.println("handeled");
        }

        System.out.println("normal flow..");
    }



}
