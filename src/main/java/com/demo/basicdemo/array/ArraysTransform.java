package com.demo.basicdemo.array;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ArraysTransform {


    /**
     * String<---->char[]
     * String<---->byte[]
     */
    @Test
    public void test() {
        System.out.println(Arrays.toString("ssfds".toCharArray()));
        System.out.println(Arrays.toString("s sf-ds".toCharArray()));
        System.out.println();
        System.out.println(Arrays.toString("ssfds".getBytes()));//打印每个元素的十进制编码
        System.out.println(Arrays.toString("s sf-ds".getBytes()));
    }


    /**
     * Array<--->List
     */
    @Test
    public void test2() {
        String[] fruit = new String[]{"apple", "banana", "grape"};
        List<String> fruitls = Arrays.asList(fruit);

        List<Date> date = Arrays.asList(new Date(), new Date());

        List<String> vegetables = Arrays.asList("tomato", "mushroom", "papper");
    }


}
