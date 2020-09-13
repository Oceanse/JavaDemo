package com.demo.basicdemo.array;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayAccess {

    /**
     * 通过索引访问数组元素
     * 索引起点：0
     * 索引终点：length-1
     */
    @Test
    public void test1() {
        double[] score={110,118.5,120};
        System.out.println(score[0]);
        System.out.println(score[1]);
        System.out.println(score[2]);
        System.out.println(score[3]);//产生ArrayIndexOutOfBoundsException
    }


    /**
     * 通过for遍历/迭代数组元素
     */
    @Test
    public void test2() {
        String[] fruits=new String[]{"apple","orange","banana"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }

    /**
     * 通过foreach遍历/迭代数组元素(不需要索引)
     * 不会修改数组或者集合的元素的值
     */
    @Test
    public void test3() {
        String[] fruits=new String[]{"apple","orange","banana"};
        for (String fruit : fruits) {//相当于把每个数组元素的值传递给fruit
            System.out.println(fruit.toUpperCase());//修改fruit的值
        }

        //fruits数组元素本身没有改变
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }



    /**
     *   Arrays.toString查看数组内容
     */
    @Test
    public void test4() {
        int[] id = new int[]{1, 2, 3};

        //直接使用toString方法只会打印出数组的地址
        System.out.println(id);
        System.out.println(id.toString());

        //打印数组内容形式为[数组元素1，数组元素2...]
        System.out.println(Arrays.toString(id));
    }

    @Test
    public void test5() {
        double[] score={100,110,120};

        //Arrays.streamS  数组stream
        Arrays.stream(score).forEach(item-> System.out.println(item));
    }



    @Test
    public void test6() {

        //数据类型[][] 数组名 = new 数据类型[二维数组的长度/包含的一维数组的个数][每个一维数组的长度];
        double[][] d = new double[2][3];//定义了一个整型的二维数组，其中包含2个一维数组，每个一维数组可以存储3个整数

        int[][] d2 = {{1, 2, 3}, {4, 5, 6}};//=左边声明部分不允许指定长度
        System.out.println(d2.length);
        for (int i = 0; i < d2.length; i++) {
            for (int j = 0; j < d2[i].length; j++) {
                System.out.print(d2[i][j] + " ");
            }
            System.out.println();
        }
    }

}
