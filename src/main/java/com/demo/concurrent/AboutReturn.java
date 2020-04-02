package com.demo.concurrent;

public class AboutReturn {

    public static void main(String[] args) {
        int age=test();
        System.out.println("main="+age);
    }

    public static int test() {
        int age = 30;

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + " ");
            }
        }).start();

        System.out.println();

        System.out.println("我30");
        return age;
    }


}
