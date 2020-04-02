package com.demo.others.scanner;

import org.testng.annotations.Test;

import java.util.Scanner;

public class ScannerNextLine {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please give the input:");

        /*以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。*/
        String text = scanner.nextLine();
        System.out.println(text);
    }

    @Test
    public void test(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please give the input:");

        /*以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。*/
        String text = scanner.nextLine();
        System.out.println(text);
    }

}
