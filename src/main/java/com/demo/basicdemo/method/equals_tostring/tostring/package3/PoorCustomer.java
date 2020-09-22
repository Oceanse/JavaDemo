package com.demo.basicdemo.method.equals_tostring.tostring.package3;

import com.demo.basicdemo.method.equals_tostring.tostring.package2.Customer;

public class PoorCustomer extends Customer {
    public static void main(String[] args) {
        //PoorCustomer继承Customer，所以会继承拥有Customer的toString方法(Customer的toString方法已经被重写)
        System.out.println(new PoorCustomer());
    }
}
