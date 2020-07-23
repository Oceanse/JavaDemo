package com.demo.testNG;

import org.testng.annotations.*;

public class Before_AfterDemo {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is beforeSuite method ");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is beforeClass method ");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is beforeMethod method ");
    }


    @Test
    public void testExample1() {
        System.out.println("This is Test  testExample1 ");
    }


    @Test
    public void testExample2() {
        System.out.println("This is Test  testExample2 " );
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("This is AfterMethod Method  ");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is afterClass method ");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is AfterSuite method ");
    }

}
