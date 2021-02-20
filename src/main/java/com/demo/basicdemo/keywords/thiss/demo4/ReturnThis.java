package com.demo.basicdemo.keywords.thiss.demo4;


public class ReturnThis {
    int count;
    public ReturnThis countAdd(){
        count++;
        return this;
    }

    public static void main(String[] args) {
        ReturnThis returnThis = new ReturnThis();
        returnThis.countAdd().countAdd().countAdd();
        System.out.println(returnThis.count);
    }
}
