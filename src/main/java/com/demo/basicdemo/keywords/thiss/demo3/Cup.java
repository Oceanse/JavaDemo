package com.demo.basicdemo.keywords.thiss.demo3;

public class Cup {
    void showThis() {
        System.out.println(this);
    }

    public static void main(String args[]) {
        Cup obj = new Cup();
        System.out.println(obj);// prints the reference ID
        obj.showThis();// prints same reference ID
    }

}
