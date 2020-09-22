package com.demo.basicdemo.array;

import com.demo.oop.inherit.demo2_this_super.Human;
import com.demo.pojo.TestResourceinfo;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ArrayOthers {


    /**
     * copy
     */
    @Test
    public void test() {

        //数组复制
        String[] names = new String[]{"ocean", "dahuang", "zhuxiang"};
        String[] names2 = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            names2[i] = names[i];
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
     * sort
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

}