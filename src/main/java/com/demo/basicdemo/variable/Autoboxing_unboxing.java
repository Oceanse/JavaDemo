package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.ArrayList;



/**
原始类型	包装类型
boolean	Boolean
byte	Byte
char	Character
float	Float
int	Integer
long	Long
short	Short
double	Double

当表格中左边列出的基础类型与它们的包装类有如下几种情况时，编译器会自动帮我们进行装箱或拆箱.

进行 = 赋值操作（装箱或拆箱）
进行+，-，*，/混合运算 （拆箱）
进行>,<,==比较运算（拆箱）
调用equals进行比较（装箱）
ArrayList,HashMap等集合类 添加基础类型数据时（装箱）

我们看一段平常很常见的代码
public void testAutoBox() {
    List<Float> list = new ArrayList<>();
    list.add(1.0f);
    float firstElement = list.get(0);
}

list集合存储的是Float包装类型，我传入的是float基础类型，所以需要进行装箱，
而最后的get方法返回的是Float包装类型，我们赋值给float基础类型，所以需要进行拆箱，很简单，安排的明明白白
*/
public class Autoboxing_unboxing {

    /**
     * 拆箱和装箱就是基本类型和包装类之间的转换
     * 基本类型--->包装类
     * int --> Integer
     * byte --> Byte
     * short --> Short
     * long --> Long
     * char --> Character
     * float --> Float
     * double --> double
     * boolean --> Boolean
     */
    @Test
    public void test() {

        //手动装箱1
        Integer i = new Integer(100);
        Character character = new Character('p');

        //手动装箱2
        Integer i2 = Integer.valueOf(100);
        Character character2 = Character.valueOf('p');

        //手动拆箱1,  String----->基本数据类型
        int i3 = Integer.parseInt("123");
        long l = Long.parseLong("456L");
        boolean b = Boolean.parseBoolean("true");


        //手动拆箱2，很少用到
        int j = i.intValue();
        char ch = character.charValue();
    }


    /**
     * 自动装箱和自动拆箱是JDK5.0的一个新特性
     */
    @Test
    public void test2() {

        Double dd = new Double(1.0);
        double m = dd;//自动拆箱  包装类对象自动转换成基本数据类型 本质上是，编译器编译时自动添加double m=dd.doubleValue()
        Double n = 1.1; //自动装箱  基本类型就自动地封装到与它相似类型的包装中 本质上是，编译器编译时自动添加：Double n =Double.valueOf(n);
    }


    /**
     * 自动装箱和自动拆箱是JDK5.0的一个新特性
     */
    @Test
    public void test3() {
        //自动装箱
        ArrayList<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);//Java编译器自动装箱:  doubles.add(new Double(1.0));

        //自动拆箱
        printChar(new Character('c'));

        //自动装箱
        printCharacter('c');
    }

    /**
     * 这个方法可以接受char类型或者其包装类Character
     *
     * @param c
     */
    public static void printChar(char c) {
        System.out.println(c);
    }


    /**
     * 这个方法可以接受char类型或者其包装类Character
     *
     * @param c
     */
    public static void printCharacter(Character c) {
        System.out.println(c);
    }


    /**
     * String----->int等基本数据类型
     * 注意涉及到数值型数据时候传入格式不对会抛出NumberFormatException
     * boolean不会抛出NumberFormatException
     * 不存在Character.parseCharacter(String str),  因为字符串不能转成字符
     */
    @Test
    public void test4() {

        double d = Double.parseDouble("100.0");

        //只有传入true(忽略大小写)时候才返回true，其他字符串返回false
        System.out.println(Boolean.parseBoolean("TrUe"));//true
        System.out.println(Boolean.parseBoolean("null"));//false
        System.out.println(Boolean.parseBoolean(""));//false

        //Float f=Float.parseFloat("abc"); //NumberFormatException: For input string: "abc"

        //如果number==null, java.lang.NumberFormatException: null
        String number = System.getProperty("number");
        int i = Integer.parseInt(number);
    }


    /**
     * 基本类型--->String
     */
    @Test
    public void test5() {
        System.out.println(String.valueOf(100));
        System.out.println(String.valueOf('c'));
        System.out.println(String.valueOf(true));

        //扩展
        System.out.println(String.valueOf("aaa"));
        System.out.println(String.valueOf(null));

    }


}
