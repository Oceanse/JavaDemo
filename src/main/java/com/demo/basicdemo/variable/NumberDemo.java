package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.ArrayList;


public class NumberDemo {

    public static void printChar(char c) {
        System.out.println(c);
    }

    public static void printCharacter(Character c) {
        System.out.println(c);
    }

    /**
     * 对于不带任何后缀的整数:
     * 1 如果将一个在byte/short/char范围内的整数常量或者整数常量表达式赋值给byte/short/char变量，那么系统会自动把这个数当成byte/short/char类型
     * 2 其他情况下这个整数都是int类型(把任意一个整数赋值给int/long/float/double变量,系统会把这个变量当成int)
     * 3 如果直接使用不带后缀的整型常量，这个整型常量会被当作int
     *
     *对于不带任何后缀的浮点数：
     *都是double类型数据
     *
     */
    @Test
    public void test() {

        byte b = 127; //这里127是byte类型数据,因为int类型不能自动转换为byte，所以这里127不是int类型，
        short s=127; //这里127是short类型数据,因为int类型不能自动转换为short，所以这里127不是int类型，
        char c=127;//这里127是char类型数据，因为int类型不能自动转换为char，所以这里127不是int类型，
        int i=127; //这里127是int类型数据
        long l = 127;//这里127是int类型是数据，127会自动转换成long类型127L
        long l2 = 127L;//这里127L是long类型是数据
        float f = 127;//这里127是int类型是数据，127会自动转换成float类型127.0f
        double d = 127;//这里127是int类型是数据，127会自动转换成double类型127.0

        //byte b=128; 超出其byte取值范围, 128会被认为是int类型
        //long l3=9999999999;//系统会把9999999999当作是int类型，但是又超出了int的取值范围，会报 Integer Number too large
        long l4 = 9999999999L;//9999999999L表示long类型数据

        //这里的1和(1+1)结果的类型都是int
        //cntrl + 点击println验证
        System.out.println(1);
        System.out.println(1+1);

        byte b2=1+1;//1+1的结果是byte类型
        short s2=1+1;//1+1的结果是short类型
        char c2=1+1;//1+1的结果是char类型
        System.out.println(b2);

        //这里的1.1和(1+1.1)结果的类型都是double
        //cntrl + 点击println验证
        System.out.println(1+1.1);
        System.out.println(1.1);
    }



    /**
     * 不带任何后缀的小数默认是double类型
     * 浮点型数据的表示方法： 小数和科学计数法
     */
    @Test
    public void test2() {
        //float f=2.1;  double类型数据不能直接赋值给float变量
        float f = (float) 2.1;
        float f2 = 2.1f;// 数值后面紧跟F或者f

        float f1 = 35e3f;
        double d1 = 12E4d;
        System.out.println(f1);
        System.out.println(d1);
    }

    /**
     * 整数类型有四种表示方式：二进制binary) 八进制(octal) 十进制(decimal) 十六进制(hexadecimal)；
     *
     * 二进制以0b/0B开头；java7新增了对二进制的支持
     * 八进制以0开头；
     * 十六进制以0x/0X开头，其中10~15以a~f(不区分大小写)表示
     *
     * 原码：一个数的二进制表示
     * 反码：原码按位取反（符号位不变）
     * 补码：反码加1
     * <p>
     * 计算机底层数字以反码形式存储；
     * 对于正数来说：原码 反码 补码三者一致
     * 对于负数来说：原码 --->反码---> 补码
     */
    @Test
    public void test5() {
        byte decimal = 97;//十进制 97是byte类型数据
        short bin=0B01100001;// 二进制  0B01100001是short类型;
        int octal = 0141;//八进制 0141是int类型数据
        long hex2 = 0X61L; //十六进制  0X61L是long类型数据
        long hex = 0X61;//十六进制  0X61是int类型数据,自动转换成long类型

        //十进制形式打印
        System.out.println(decimal);
        System.out.println(bin);
        System.out.println(octal);
        System.out.println(hex);
        System.out.println(hex2);

        /*某些时候程序需要直接使用二进制，二进制"更真实"，更能体现出整数在内存中的存在形式
        一个不带任何后缀的二进制默认表示一个int类型
        注意下面两个二进制最高位都是0
        */
        System.out.println(0B01100001);
        System.out.println(0B11100001);

    }







    public static void main(String[] args) {
          /*基本类型的包装类
        int --> Integer
        byte --> Byte
        short --> Short
        long --> Long
        char --> Character
        float --> Float
        double --> double
        boolean --> Boolean*/

        //基本类型和包装类之间的转换
        Integer i = new Integer(100);//手动装箱
        Character character = new Character('p');//手动装箱
        int j = i.intValue();  //手动拆箱
        char ch = character.charValue();  //手动拆箱
        printChar(character);//Java编译器自动拆箱
        printCharacter(ch);//Java编译器自动装箱
        ArrayList<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);//Java编译器自动装箱


        //JDK5.0的一个新特性是自动装箱和自动拆箱
        Double dd = new Double(1.0);
        double m = dd;//自动拆箱  包装类对象自动转换成基本数据类型 本质上是，编译器编译时自动添加double m=dd.doubleValue()
        Double n = 1.1; //自动装箱  基本类型就自动地封装到与它相似类型的包装中 本质上是，编译器编译时自动添加：Double n =Double.valueOf(n);


        //String--->基本类型
        //当String类型数据 要转换成int、double、float、long等数据类型时，其数据必须由数字构成，
        String st = "789";
        int ii = Integer.valueOf(st);
        double d = Double.valueOf(st);
        long l = Long.valueOf(st);
        float f = Float.valueOf(st);
        //当String类型数据值为true/false时,可转换为boolean
        String s2 = "true";
        boolean bb = Boolean.valueOf(s2);


           /*其它类转字符串
           1 使用包装类的 toString() 方法
           2使用String类的 valueOf() 方法
           3用一个空字符串加上基本类型*/

        int c = 1;
        String strc = new Integer(c).toString();
        String strc2 = String.valueOf(c); //public static String valueOf(Object obj)
        String strc3 = c + "";
        //String转成相应的数组
        char[] chars1 = st.toCharArray();
        byte[] bytes = st.getBytes();
    }



}
