package com.demo.basicdemo.control_statement.if_switch;

import org.testng.annotations.Test;

import java.util.Scanner;


/**
 * switch表示“开关”, case 表示情况和情形，值是不允许重复
 * <p>
 * switch(表达式)中表达式的返回值必须是下述几种类型之一：整数(byte，short，char，int， long)及其包装类Byte, Short, Int, Long;还有String，枚举；
 * <p>
 * 先求出表达式的值，然后去匹配condition1, condition2...,如果都不匹配，那么执行default后的代码块
 * <p>
 * break是使得程序跳出switch,所以每个case语句块后面不要忘记break
 * <p>
 * switch(表达式) {
 * case condition1:
 * 语句块1;
 * break;   //表示“停止”，即跳出当前结构。如果缺少break，那么会接着执行下一个 case 分支语句，从而触发多个 case分支。
 * <p>
 * case condition2:
 * 语句块2;
 * break;
 * …
 * case condition:
 * 语句块n;
 * break;
 * <p>
 * default:  default 块和 case 块的先后顺序可以变动，不会影响程序执行结果。通常放在末尾，也可以省略不写。另外default看似没有条件，实际是exclude前面所有情况
 * 语句块n+1;
 * break;
 * }
 *
 * 关于default:
 * switch语句中的default标签看似没有条件，其实是有条件的，条件就是expression表达式的值不能与前面任何一个case 标签后的值相等
 * 通常可以将default语句放在末尾，这样可以省略break语句，但是最好不要省略
 *
 * <p>
 * <p>
 * switch pk if
 * 一般情况下，对于判断条件较少的，可以使用 if 条件语句，但是在实现一些多条件的判断中，最好使用 switch 语句。
 * 我们知道 Java 编译器如何工作。当编译一个 switch 语句时，Java 编译器将检查每个 case 常量并且创造一个“跳转表”，
 * 这个表将用来在表达式值的基础上选择执行路径。因此，如果你需要在一组值中做出选择，switch 语句将比与之等效的 if-else 语句快得多。
 * 编译器可以这样做是因为它知道 case 常量都是同类型的，所要做的只是将它与 switch 表达式相比较看是否相等。对于一系列的 if 表达式，编译器就无此功能。
 */

public class SwitchDemo {


    /**
     * switch-case适合整数/char/String/枚举等"单点值"的判断，不适合"区间的判断"，比如if(i>90)等
     */
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
     * 漏掉break会匹配到所有的case
     */
    @Test
    public void test2() {
        char letter = 'A';
        switch (letter) {
            case 'A':
                System.out.println("优秀");
            case 'B':
                System.out.println("良");
            case 'C':
                System.out.println("及格");
            default:
                System.out.println("不及格");
        }

    }


    @Test
    public void test3() {
        //String season=null; //NPE
        String season = "spring";
        try {
            switch (season) {
                case "spring":
                    System.out.println("春暖花开");
                    break;
                case "summer":
                    System.out.println("夏日炎炎");
                    break;
                case "fall":
                    System.out.println("秋风瑟瑟");
                    break;
                case "winter":
                    System.out.println("白雪皑皑");
                    break;
                default:
                    System.out.println("......");
                    break;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        Color color = Color.GREEN;
        switch (color) {
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            default:
                System.out.println("others");
                break;
        }
    }

    enum Color {
        RED,
        GREEN,
        BLUE;
    }


}
