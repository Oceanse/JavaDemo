package com.demo.others.scanner;

import java.util.Scanner;

public class ScannerNext {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please give the input:");

        /*1、一定要读取到有效字符后才可以结束输入。
          2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
          3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
             next() 不能得到带有空格的字符串。*/
        String text = scanner.next();
        System.out.println(text);
    }

}
