package com.demo.basicdemo.method.overload;

import org.testng.annotations.Test;

public class OverloadDemo4 {

    public void showFood(String food){
        System.out.println("showFood(String food)");
        System.out.println(food);
    }

    public void showFood(String... foods){
        System.out.println("showFood(String... food)");
        for (String food : foods) {
            System.out.println(food);
        }
    }


    /**
     * 重载方法同时包含可变形参showFood(String... food)和showFood(String food)，
     * 那么showFood("noodles")只会调用单参方法showFood(String food)，也就是调用
     * "更精确"的那个；
     *
     * 如果想让showFood("noodles")调用变形参showFood(String... food)，可以传入单元素的数组showFood(new String[]{"noodles"})'
     *
     * 另外不推荐重载可变形参的方法，没有太大意义，还会吉昂蒂程序可读性
     */
    @Test
    public void test(){
        showFood();//showFood(String... food)
        showFood("noodles");//showFood(String food)
        showFood("noodles","dumplings");//showFood(String... food)
    }
}
