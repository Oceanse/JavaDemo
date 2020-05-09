package com.demo.basicdemo.array;

import com.demo.oop.inherit.demo2_this_super.Person;
import com.demo.pojo.TestResourceinfo;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Arr {


    /**
     * 数组属引用类型,是多个相同类型数据的组合，包括基本数据类型和引用数据类型
     *
     * 数组一旦分配空间，其长度length是不可变的
     *
     * 动态初始化:声明并指定数组长度,之后再进行赋值(分配空间和赋值分开进行)
     * 静态初始化:在数组创建时直接指定其内容，由系统决定数组的长度(分配内存和赋值同时进行)
     * <p>
     * 简化格式： 数据类型[] 数组名称 = {值, 值, …};
     * 完整格式（推荐）: 数据类型[] 数组名称 = new 数据类型[]{值, 值, …}
     *
     * 数组名变量保存的是数组首元素的内存地址
     *
     * 数组元素都有下标，范围从0到length-1,数组通过下标访问数组元素
     * 数组查询效率很高
     */
    @Test
    public void test() {

        //动态初始化
        int[] arr;      //定义数组，即声明一个int类型的数组arr,这里只是占用栈内存空间
        arr = new int[5];//分配内存空间 数组名 = new 类型[数组元素的个数]  开辟堆内存空间
        System.out.println(Arrays.toString(arr));//数组元素默认全是0

        //赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i;
        }
        System.out.println(Arrays.toString(arr));


        //分配空间和赋值分开进行，所以也是动态初始化
        Person[] p = new Person[3];//声明同时分配内存空间
        System.out.println(Arrays.toString(p));//数组元素默认全是null

        for (int i = 0; i < p.length; i++) {
            p[i] = new Person();
        }
        System.out.println(Arrays.toString(p));


        //静态初始化
        String[] str = {"aa", "bb"};
        String[] str2 = new String[]{"aa", "bb"};

        TestResourceinfo t1 = new TestResourceinfo();
        TestResourceinfo t2 = new TestResourceinfo();
        TestResourceinfo t3 = new TestResourceinfo();
        TestResourceinfo[] tt = {t1, t2, t3};
        TestResourceinfo[] tt2 = new TestResourceinfo[]{t1, t2, t3};

        Date[] date = {new Date(20190719), new Date(20190720)};
        Date[] date2 = new Date[]{new Date(20190719), new Date(20190720)};

    }

    //Arrays.toString查看数组内容
    @Test
    public void test1() {
        int[] id = new int[]{1, 2, 3};

        //直接使用toString方法只会打印出数组的地址
        System.out.println(id);
        System.out.println(id.toString());

        //打印数组内容形式为[数组元素1，数组元素2...]
        System.out.println(Arrays.toString(id));
    }

    //toString源码分析
    public static String toString(int[] a) {
        if (a == null)    //如果数组没有分配堆空间，也就是数组引用为null,返回null
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)   //如果数组长度为0 eg:int[] arr=new int[0];
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    @Test
    public void test2() {

        //数组复制
        System.out.println("*******************************");
        String[] names = new String[]{"ocean", "dahuang", "zhuxiang"};
        String[] names2 = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            names2[i] = names[i];
        }
        System.out.println("names2:" + Arrays.toString(names2));

        /*arrayCopy( arr1, 2, arr2, 5, 10);
        意思是;将arr1数组里从索引为2的元素开始, 复制到数组arr2里的索引为5的位置, 复制的元素个数为10个.*/
        String[] names3 = new String[names.length];
        System.arraycopy(names, 0, names3, 0, names.length);
        System.out.println("names3:" + Arrays.toString(names3));
    }


    @Test
    public void test3() {
        //数组作为引用数据类型，也可以发生引用传递,不同的栈引用可以指向同一块堆内存
        char[] c = new char[]{'a', 'b', 'c'};
        char[] c2 = null;
        c2 = c;
        System.out.println(Arrays.toString(c2));
        c2[0] = 'w';
        System.out.println(c[0]);
    }

    @Test
    public void test4() {

        //数据类型[][] 数组名 = new 数据类型[二维数组的长度/包含的一维数组的个数][每个一维数组的长度];
        double[][] d = new double[2][3];//定义了一个整型的二维数组，其中包含3个一维数组，每个一维数组可以存储5个整数

        int[][] d2 = {{1, 2, 3}, {4, 5, 6}};//=左边声明部分不允许指定长度
        System.out.println(d2.length);
        for (int i = 0; i < d2.length; i++) {
            for (int j = 0; j < d2[i].length; j++) {
                System.out.print(d2[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test5() {
        System.out.println(Arrays.toString("ssfds".toCharArray()));
        System.out.println(Arrays.toString("s sf-ds".toCharArray()));
        System.out.println();
        System.out.println(Arrays.toString("ssfds".getBytes()));
        System.out.println(Arrays.toString("s sf-ds".getBytes()));
        int[] ii = new int[]{3, 1, 8, 2};
        System.out.println(Arrays.toString(ii));
        Arrays.sort(ii);
        System.out.println(Arrays.toString(ii));
    }

    @Test
    public void test6() {
        String[] fruit = new String[]{"apple", "banana", "grape"};
        List<String> fruitls = Arrays.asList(fruit);

        List<Date> date = Arrays.asList(new Date(), new Date());

        List vegetables = Arrays.asList("tomato", "mushroom", "papper");
    }


    public static void printArray(String[] names) {

        System.out.println(names[0]);
    }

    //参数为数组类型的方法可接受可变参数作为入参
    public static void printNames(String... names) {
        printArray(names);
    }

    @Test
    public static void test7() {
        printNames("cc", "dd");
    }


    public static void count(int... i) {
        System.out.println(i);
    }

    //可变参数的方法可接受数组作为入参
    public static void countArr(int[] arr) {
        count(arr);

    }
/* Arrays.asList()中：
    public static <T> List<T> asList(T... a) {
        return new Arrays.ArrayList<>(a);
    }
    asList方法本身接受可变参数，但是可以传入数组*/


}

class A {
    boolean[] b = new boolean[]{true, false, true};
}

class B {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(Arrays.toString(a.b));


    }
}

