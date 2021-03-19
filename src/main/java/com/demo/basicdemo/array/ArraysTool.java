package com.demo.basicdemo.array;

import com.demo.basicdemo.code_block.construct_block.demo1.Person;
import com.demo.oop.inherit.demo2_this_super.Human;
import com.demo.pojo.TestResourceinfo;
import org.testng.annotations.Test;
import sun.dc.path.PathError;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Arrays类处于java.util包下， 为了在程序中使用Arrays类， 必须在程序中导入java.util.Arrays类。
 */
public class ArraysTool {


    /**
     * System.arraycopy
     */
    @Test
    public void test() {

        //数组复制
        String[] names = new String[]{"ocean", "dahuang", "zhuxiang"};//names存储着每个字符串常量池中的地址
        String[] names2 = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            names2[i] = names[i];//把原数组中的变量值(每个字符串常量池中的地址)赋值给新的变量，新的数组也会保存着原数组中的对应的字符串常量池中的地址
        }
        System.out.println("names2:" + Arrays.toString(names2));


        /*
        arrayCopy( arr1, 2, arr2, 5, 10);
        意思是;将arr1数组里从索引为2的元素开始, 复制到数组arr2里的索引为5的位置, 复制的元素个数为10个.
        */
        String[] names3 = new String[names.length];
        System.arraycopy(names, 0, names3, 0, names.length);
        System.out.println("names3:" + Arrays.toString(names3));
    }


    /**
     * Arrays.sort
     */
    @Test
    public void test2() {
        int[] ii = new int[]{3, 1, 8, 2};
        System.out.println(Arrays.toString(ii));
        Arrays.sort(ii);
        System.out.println(Arrays.toString(ii));
    }


    /**
     * Arrays.toString
     */
    @Test
    public void test3() {
        boolean[] b = new boolean[]{true, false, true};
        System.out.println(Arrays.toString(b));
    }


    /**
     * 测试发现，如果是基本类型数组，用==比较两个数组元素的字面值是否相同
     *         如果是引用类型数组，用equals比较两个数组元素的是否相同
     */
    @Test
    public void test4() {
        double[] scores=new double[]{1,2,3,4,5,6};
        double[] scores2=new double[]{1,2,3,4,5,6};
        System.out.println(Arrays.equals(scores, scores2));


        Double[] scores3=new Double[]{new Double(1),new Double(2)};
        Double[] scores4=new Double[]{new Double(1),new Double(2)};
        System.out.println(Arrays.equals(scores3, scores4));

        Person[] personList = new Person[]{new Person("ocean", 31)};
        Person[] personList2 = new Person[]{new Person("ocean", 31)};
        System.out.println(Arrays.equals(personList, personList2));
    }

    @Test
    public void test5() {
        double[] score = {100, 110, 120};

        //Arrays.streamS  数组stream
        Arrays.stream(score).forEach(item -> System.out.println(item));
    }


    /**
     * public static <T> List<T> asList(T... a)
     * Array--->List
     */
    @Test
    public void test6() {

        List<Person> personList=Arrays.asList(new Person[]{new Person(),new Person()});//传入数组对象

        String[] fruit = new String[]{"apple", "banana", "grape"};
        List<String> fruits = Arrays.asList(fruit);////传入数组对象的引用

        List<String> vegetables = Arrays.asList("tomato", "mushroom", "papper");//传入可变参数

        List<Date> date = Arrays.asList(new Date(), new Date());//传入可变参数

    }

}
