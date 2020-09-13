package com.demo.basicdemo.control_statement.if_switch;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Scanner;


/**

 switch表示“开关”, case 表示情况和情形，值是不允许重复

 switch(表达式)中表达式的返回值必须是下述几种类型之一：整数(byte，short，char，int， long)及其包装类Byte, Short, Int, Long;还有String，枚举；

 先求出表达式的值，然后去匹配condition1, condition2...,如果都不匹配，那么执行default后的代码块

 break是使得程序跳出switch,所以每个case语句块后面不要忘记break

 switch(表达式) {
    case condition1:
        语句块1;
        break;   //表示“停止”，即跳出当前结构。如果缺少break，那么会接着执行下一个 case 分支语句，从而触发多个 case分支。

    case condition2:
        语句块2;
        break;
    …
    case conditionn:
        语句块n;
        break;

    default:  //default 块和 case 块的先后顺序可以变动，不会影响程序执行结果。通常放在末尾，也可以省略不写。另外default看似没有条件，实际是exclude前面所有情况
        语句块n+1;
    break;
}


 switch pk if
 一般情况下，对于判断条件较少的，可以使用 if 条件语句，但是在实现一些多条件的判断中，最好使用 switch 语句。
 我们知道 Java 编译器如何工作。当编译一个 switch 语句时，Java 编译器将检查每个 case 常量并且创造一个“跳转表”，
 这个表将用来在表达式值的基础上选择执行路径。因此，如果你需要在一组值中做出选择，switch 语句将比与之等效的 if-else 语句快得多。
 编译器可以这样做是因为它知道 case 常量都是同类型的，所要做的只是将它与 switch 表达式相比较看是否相等。对于一系列的 if 表达式，编译器就无此功能。

 */

public class SwitchDemo {

    @Test
    public void test() {

        Scanner s = new Scanner(System.in);
        System.out.println("请输入成绩:");
        //Integer i = s.nextInt();
        int i = s.nextInt();
        switch (i) {
            case 100:
                System.out.println("满分");
                break;
            case 90:
                System.out.println("优秀");
                break;
            default: //default子句是可任选的，当没有匹配的case时，执行default
                System.out.println("其它");
                break;
        }
    }


    /**
     * 漏掉break
     */
    @Test
    public void test1_2() {
        char letter = 'A';
        switch (letter) {
            case 'A':
                System.out.println("A");
            case 'B':
                System.out.println("B");
            default:
                System.out.println("其它");
        }

    }


    @Test
    public void test2() {
        /*Scanner s=new Scanner(System.in);
        System.out.println("input:");
        String season=s.nextLine();*/

        //String season=null;  NPE

        String season = "spring";
        switch (season) {
            case "spring":
                System.out.println("spring");
                break;
            case "summer":
                System.out.println("summer");
                break;
            case "fall":
                System.out.println("fall");
                break;
            case "winter":
                System.out.println("winter");
                break;
            default:
                System.out.println("......");
                break;
        }
    }

    /**
     * 本程序首先获取当前的星期值，然后使用 switch 语句判断 week 的值：
     * 0 表示星期日，1 表示星期一，2 表示星期二……以此类推，6 表示星期六。
     * 只要 week 值与 case 值相符合，则程序将执行该 case 中的语句，并跳出 switch 语句，输出结果。
     */
    @Test
    public void test3() {
        String weekDate = "";
        Calendar calendar = Calendar.getInstance();  // 获取当前时间
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;  // 获取星期的第几日
        switch (week) {
            case 0:
                weekDate = "星期日";
                break;
            case 1:
                weekDate = "星期一";
                break;
            case 2:
                weekDate = "星期二";
                break;
            case 3:
                weekDate = "星期三";
                break;
            case 4:
                weekDate = "星期四";
                break;
            case 5:
                weekDate = "星期五";
                break;
            case 6:
                weekDate = "星期六";
                break;
        }
        System.out.println("今天是 " + weekDate);
    }

}
