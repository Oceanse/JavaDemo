package com.demo.basicdemo.array;

import java.util.Arrays;

public class Arr2 {
    public static void main(String[] args) {
        double[] score={100,110,120};

        //Arrays.streamS  数组stream
        Arrays.stream(score).forEach(item-> System.out.println(item));
    }
}
