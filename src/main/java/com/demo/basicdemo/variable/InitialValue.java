package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.Arrays;

public class InitialValue {
    //成员变量会具有初始
    byte b;
    short s ;
    int i;
    long l;
    float f;
    double d;
    boolean bo;
    char c;
    static int age;//静态变量具有默认初始值

    /*总结：1. 我们知道，Character类定了最小值 MIN_VALUE = '\u0000'，
              这也是ASCII表的最小值，这样描述：空字符（NUL），只是看起来时空格，但是不是空格
            2. 虽然它转换为字符串输出为空格，但是它与空格、空字符串、NULL和"null"都不同，
              所以无法找到能够描述它的符号
            3.  \+u+xxxx  其中xxxx表示一个16进制数字 这种格式是unicode码的写法,表示一个char字符
   */
    char c2='\u0000';//char变量默认值；等价于 char c;
    char c3='\u0020';//英文半角空格
    char c4='\u3000';//中文全角空格
    String string=" ";

    String str;
    Object o;
    Runnable r;
    int[] arr;

    @Test
    public void test(){
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bo);
        System.out.println("age="+age);
        System.out.println("b"+c+"d");  //初始值默认为空格
        System.out.println("b"+c2+"d");
        System.out.println("b"+c3+"d");
        System.out.println("b"+string+"d");
        System.out.println(str);
        System.out.println(o);
        System.out.println(r);
        System.out.println("arr="+Arrays.toString(arr));
    }

    public void test2(){
        //int i; 局部变量必须要显式的初始化
        int i=1;
        if(i!=2){
            System.out.println("right");
        }

        //String str;局部变量必须要显式的初始化
        String str=null; //String str=null会对引用变量str(存在栈内存)赋值为null,但是不会开辟堆空间，str完成了初始化
        System.out.println(str);
    }
}
