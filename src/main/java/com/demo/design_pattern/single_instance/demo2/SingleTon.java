package com.demo.design_pattern.single_instance.demo2;


public class SingleTon {
    private SingleTon() {
    }

    private static class SingleTonHoler {
        private static SingleTon INSTANCE = new SingleTon();
    }

    public static SingleTon getInstance() {
        return SingleTonHoler.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(SingleTon.getInstance() == SingleTon.getInstance());
    }
}
