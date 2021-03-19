package com.demo.basicdemo.control_statement.break_continue;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *使用break的场景有两种：switch语句和循环语句
 *循环中：可以直接强行退出当前的循环，某些时候需要在某种条件出现时强行终止循环，而不是等到循环条件为 false 时才退出循环
 *switch:每个 case 子句块的最后添加语句break来退出switch
 *
 * break可以作为单独的java 语句
 * */
public class BreakDemo {

    @Test
    public void test1() {
        int[] scores= new int[]{60,80,100,70,90};

        boolean isFullMarks=false;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i]==100){
                isFullMarks=true;
                break;//break只是退出循环，并不是退出方法(找到获得满分的人就停止遍历，退出循环)
            }
        }

        if(isFullMarks){
            System.out.println("There are someone who get full marks");
        }
    }


    @Test
    public void test1_2() {
        int[] scores= new int[]{60,80,100,70,90};

        boolean isFullMarks=false;
        for (int score: scores) {
            if(score==100){
                isFullMarks=true;
                break;//break只是退出循环，并不是退出方法(找到获得满分的人就停止遍历，退出循环)
            }
        }

        if(isFullMarks){
            System.out.println("There are someone who get full marks");
        }
    }






    @Test
    public void test16() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    break;//i==5时跳出当前循坏,当前循环是内层循环
                }
                System.out.print(i + " + " + j + " = " + (i + j)+"\t");
            }
            System.out.println();
        }

    }


    /**
     * 用标签（label）可以指定一个代码块，标签可以是任何合法有效的 Java 标识符，后跟一个冒号
     * break label;
     */

    @Test
    public void test17() {

        outer: for (int i = 0; i < 3; i++) {
            inner:for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    //break inner;  i==5时跳出内层循环inner,同test16
                    break outer;//i==5时跳出外层循环outer
                }
                System.out.print(i + " + " + j + " = " + (i + j)+"\t");
            }
            System.out.println();
        }

    }




}
