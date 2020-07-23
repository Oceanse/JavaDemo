package com.demo.testNG;

import org.testng.annotations.Test;

public class OrderTest {
    @Test()
    public void cMethod() {
        System.out.println("Method---ccc");
    }
    @Test()
    public void bMethod() {
        System.out.println("Method---bbb");
    }
    @Test()
    public void aMethod() {
        System.out.println("Method---aaa");
    }
}
