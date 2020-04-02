package com.demo.others;

public class ToStringDemo {
    String info;

    public ToStringDemo(String info) {
        this.info = info;
        System.out.println("ToStringDemo(String info).....");
    }

    @Override
    public String toString() {
        System.out.println("toString()......");
        return "ToStringDemo{" +
                "info='" + info + '\'' +
                '}';
    }

    public static ToStringDemo test(){
        return new ToStringDemo("hyp");
    }

    public static void main(String[] args) {
        test();
    }

}
