package com.demo.basicdemo.control_statement;

import org.testng.annotations.Test;

import java.util.Scanner;

public class SwitchLoop {

    @Test
    public void test(){


        /*switch(变量){
	case 常量1:
		语句1;
		break;
	case 常量2:
		语句2;
		break;
	… …
	case 常量N:
		语句N;
		break;
	default:
		语句;
		break;
	 } */

        //switch(表达式)中表达式的返回值必须是下述几种类型之一：byte，short，char，int，枚举，String；
        //default子句是可任选的，当没有匹配的case时，执行default
        Scanner s=new Scanner(System.in);
        System.out.println("请输入成绩:");
        int i=s.nextInt();
        switch (i){
            case 100:
                System.out.println("满分");
                break;
            case 90:
                System.out.println("优秀");
                break;
            default:
                System.out.println("其它");
                break;
        }

    }


    @Test
    public void test2(){
        /*Scanner s=new Scanner(System.in);
        System.out.println("input:");
        String season=s.nextLine();*/

        //String season=null;  NPE

        String season="spring";
        switch(season){
            case "spring":
                System.out.println("spring");
                break;
            case "summer":
                System.out.println("summer");
                break;
            case  "fall":
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


/*
1.  if(true){
	执行代码块；
     }

2.  if(条件表达式){
	执行代码块；
      }
     else{
	执行代码块；
      }

3.  if(条件表达式){
	执行代码块；
      }
      else if (条件表达式){
	执行代码块；
      }
       ……
       else{
	执行代码块；
       }

* */
    @Test
    public void test3(){
        Scanner s=new Scanner(System.in);
        System.out.println("请输入成绩:");
        int i=s.nextInt();
        if(i==100){
            System.out.println("满分");
            }
        else if (i>=90){
            System.out.println("优秀");
        }
        else if(i>=60){
            System.out.println("及格");
    }
    else {
            System.out.println("不及格");
        }

    }


}
