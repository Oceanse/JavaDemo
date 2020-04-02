package com.demo.others;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

public class Demo {
    public static void main(String[] args) throws IOException {
        URL url = Demo.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(url);
    }


    @Test
    public void test(){
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-kk-mm-ss");
        String timeStamp = dateFormat.format(System.currentTimeMillis());
        System.out.println(timeStamp);
    }
}
