package com.demo.regix;

import java.util.regex.Pattern;

public class ReegixDemo {
    public static void main(String[] args) {
        String startTime="1234";

        String pattern = "^"+startTime;

        boolean isMatch = Pattern.matches(pattern, "123456");
        System.out.println(isMatch);
    }
}
