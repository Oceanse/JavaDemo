package com.demo.oop.encapsulation;

/**
 * private也可以对方法进行封装，不允许外部类对象调用
 * 类内部某个public方法可以调用private方法，然后把这个public方法对外开放
 */
public class EncapsulationDemo2 {
    public static void main(String[] args) {
        int chinese=130;
        int math=150;
        int averageScore=avrage(130,150);
        System.out.println(averageScore);

    }

    public static int avrage(int i, int j){
        int m= sum(i,j);
        return  m/2;
    }


    private static int sum(int i, int j){
        return i+j;
    }
}
