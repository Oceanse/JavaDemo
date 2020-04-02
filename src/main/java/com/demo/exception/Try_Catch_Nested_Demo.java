package com.demo.exception;


import org.testng.annotations.Test;

/**
 * Nested try block
 * Sometimes a situation may arise where a part of a block may cause one error and the entire block itself may cause another error.
 * In such cases, com.demo.exception handlers have to be nested.
 * <p>
 * try{
 * statement 1;
 * try{
 * statement 1;
 * statement 2;
 * }catch(Exception e){
 * statement ;
 * }
 * }
 * catch(Exception e){
 * statement ;
 * }
 * statement ;
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
