package com.demo.basicdemo.variable.variable_datatype;

import org.testng.annotations.Test;

import java.util.ArrayList;


public class NumberDemo {


    /**
     * 数值型变量占用的bit
     * 取值范围
     */
    @Test
    public void test(){
        //Byte
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.SIZE);
        System.out.println();

        //Character
        System.out.println();
        System.out.println(Character.MIN_VALUE);// \u0000
        System.out.println(Character.MAX_VALUE);// \uFFFF
        System.out.println((int)Character.MIN_VALUE);// 0
        System.out.println((int)Character.MAX_VALUE);// 65535
        System.out.println(Character.SIZE);
        System.out.println();



        /*浮点型数据包括单精度浮点型（float）和双精度浮点型（double），代表有小数精度要求的数字，
          之间的区别主要是所占用的内存大小不同；双精度类型 double 比单精度类型 float 具有更高的精度和更大的表示范围
          浮点数有两种表达方式：小数和科学计数法
          Float和Double的最小值和最大值都是以科学记数法的形式输出的，结尾的"E+数字"表示E之前的数字要乘以10的多少次方。
          比如3.14E3就是3.14 × 103 =3140，3.14E-3 就是 3.14 x 10-3 =0.00314。*/
        //Float
        System.out.println(Float.MIN_VALUE);//最小正数
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.SIZE);

        //Double
        System.out.println();
        System.out.println(Double.MIN_VALUE);//最小正数
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.SIZE);
        System.out.println();

        //byte[] number={0,100,127,128};  //这里128超出了byte的表示范围，编译报错
    }






    /**
     * 对于不带任何后缀的整数:
     *    1 如果将一个 整数常量 或者 整数常量表达式结果 在byte/short/char范围内的赋值给byte/short/char变量，那么系统会自动把这个整数常量或者整数常量表达式当成byte/short/char类型
     *    2 其他情况下这个整数常量或者整数常量表达式都是int类型(把任意一个整数赋值给int/long/float/double变量,系统会把这个变量当成int)
     *
     * 对于不带任何后缀的浮点数：
     *    都是double类型数据
     *
     */
    @Test
    public void test1_1() {

        byte b = 127; //这里127是byte类型数据,因为int类型不能自动转换为byte，所以这里127不是int类型，
        short s=127; //这里127是short类型数据,因为int类型不能自动转换为short，所以这里127不是int类型，
        char c=127;//这里127是char类型数据，因为int类型不能自动转换为char，所以这里127不是int类型，
        int i=127; //这里127是int类型数据
        long l = 127;//这里127是int类型是数据，127会自动转换成long类型127L
        float f = 127;//这里127是int类型是数据，127会自动转换成float类型127.0f
        double d = 127;//这里127是int类型是数据，127会自动转换成double类型127.0
        long l2 = 127L;//这里127L是long类型是数据
        float f2 = 127.f;//这里127.f是float类型是数据
        double d2 = 127.0;//这里127.0是double类型是数据

        byte b2=128-1;//128-1的结果在byte类型表示范围内， 所以(128-1)是byte类型
        short s2=1+1;//1+1的结果在short类型表示范围内，所以(1+1)是short类型
        char c2='a'+1;//'a'+1的结果在char类型表示范围内, 所以('a'+1)是char类型

        System.out.println(1); //不带任何后缀的整数默认是int,ctrl + 点击println验证
        System.out.println(1.0); //不带任何后缀的小数默认是double, ctrl + 点击println验证
    }


    /**
     * 表示long类型时候最好加上后缀，这样应该会省去自动转换的过程，提高性能
     */
    @Test
    public void test1_4() {
        //byte b2=128; 超出其byte取值范围, 128会被认为是int类型
        //long l2=9999999999;//系统会把9999999999当作是int类型，但是又超出了int的取值范围，会报 Integer Number too large
        int b3=128;
        long l3 = 9999999999L;//9999999999L表示long类型数据
    }



    /**
     * 整数类型有四种表示方式(数制)：
     * 二进制binary) 八进制(octal) 十进制(decimal) 十六进制(hexadecimal)；
     *
     * 二进制以0b/0B开头；java7新增了对二进制的支持
     * 八进制以0开头；
     * 十六进制以0x/0X开头，其中10~15以a~f(不区分大小写)表示
     *
     * 原码：一个数的二进制表示
     * 反码：原码按位取反（符号位不变）
     * 补码：反码加1
     * <p>
     * 计算机底层数字以补码形式存储；
     * 对于正数来说：原码 反码 补码三者一致
     * 对于负数来说：原码 --->反码---> 补码
     */
    @Test
    public void test2_1() {
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

        //某些时候程序需要直接使用二进制，二进制"更真实"，更能体现出整数在内存中的存在形式
        //一个不带任何后缀的二进制默认表示一个int类型
        System.out.println(0B01100001);
        System.out.println(0B01100001L);

    }
    /**
     * 浮点型数据的表示方法：
     * 小数和科学计数法
     */
    @Test
    public void test2_2() {
        float f1 = 3500.0f;
        float f2 = 3.5e3f;//3.5 x 10^3f
        System.out.println(f1);
        System.out.println(f2);

        double d1 = 12000.0;
        double d2 = 12E3;//12 x 10^3
        System.out.println(d1);
        System.out.println(d2);
    }

    /**
     * 自动类型转换(为了使变量和变量值类型匹配)
     * 直接对数值或者变量值的副本进行类型转换
     */
    @Test
    public void test3_1(){
        long l = 127;//这里127是int类型是数据，127会自动转换成long类型127L
        float f = 127;//这里127是int类型是数据，127会自动转换成float类型127.0f
        double d = 127;//这里127是int类型是数据，127会自动转换成double类型127.0

        //(1+1.1)结果的类型都是double， ctrl + 点击println验证
        System.out.println(1+1.1);//int 1会自动转成double 1.0,然后再运算

        double totalPrice=100.0;
        int quantity=100;
        double price = totalPrice/quantity;//quantity变量值的副本进行类型转换，int--->double,保证参与计算的数值类型一致
    }



    /**
     * 强制类型转换:强制显示的把一个数据类型转换为另外一种数据类型,也称之为“narrow conversion”:缩小转换
     * 变量空间存储的变量值复制一份然后进行类型转换，变量本身(变量类型和变量值)并没有发生改变
     * 语法：（targetType）value
     * 被强转对象可以是对象或者该对象对应的引用变量；也可以是基本类型数据或者基本类型数据对应的变量
     */
    @Test
    public void test3_2(){

        //float f=2.1;  double类型数据不能直接赋值给float变量
        double d=2.1;
        float f = (float) d;//double变量存储的变量值2.1复制一份，然后强转成float类型，再赋值
        System.out.println(d);   //ctrl + 点击println验证
        System.out.println(f);   //ctrl + 点击println验证
    }


    /**
     * 强转可能会引起溢出(Overflow)，造成数据丢失
     */
    @Test
    public void test3_3() {

        float f = 1.0f;
        int in = (int) f;//这里只是把变量f对应内存区域的数据拷贝一份，然后对副本进行强转，并不会改变变量f空间类型以及存储的数值
        System.out.println("f=" + f);
        System.out.println("in=" + in);

        //浮点数到整数的转换是通过舍弃小数得到,可以强转常量值
        System.out.println();
        System.out.println((int) 23.5);
        System.out.println((int) -23.5f);

        /*
         * 强转可能损失精度example1: ;
         * 强转过程：
         * int类型 22555底层以补码存储(正数原码反码补码一致)：00000000 00000000 01011000 00011011
         * 强转成byte,补码截取掉高位三个字节，保存低位一个字节进行保存  00011011
         * 00011011 最高位是0，表示正数，补码等于反码等于原码：00011011，转化成十进制就是27
         * */
        int i = 22555;
        byte bt = (byte) i;
        byte bt2 = (byte) 22555;
        System.out.println("i: " + i);//i的类型和保存的值并不会改变
        System.out.println("bt:" + bt);
        System.out.println("bt2:" + bt2);
        System.out.println();


        /*
         * 强转可能损失精度example2;
         * 强转过程：
         * int类型 233底层存储形式(补码)：00000000 00000000 00000000 11101001
         * 强转成byte,补码截取掉高位三个字节，保存低位一个字节进行保存   11101001
         * 11101000 最高位是1，表示负数；补码减1，得到反码：11101000
         * 反码除符号位外其它按位取反得到原码：10010111,其中最高位是符号位，所以转成十进制是-23
         * */
        int i2 = 233;
        byte bt3 = (byte) i2;
        byte bt4 = (byte) 233;
        System.out.println("i2: " + i2);//i2的值并不会改变
        System.out.println("bt3:" + bt3);
        System.out.println("bt4:" + bt4);
    }





    /**
     * 数值型String--->数值型包装类
     */
    @Test
    public void test4(){

        //当String类型数据 要转换成int、double、float、long等数据类型时，其数据必须由数字构成，
        String st = "789";
        Integer ii = Integer.valueOf(st);
        Double d = Double.valueOf(st);
        Long l = Long.valueOf(st);
        Float f = Float.valueOf(st);
    }


    /**
     * 数值型String--->数值型基本类型
     */
    @Test
    public void test5(){

        //当String类型数据 要转换成int、double、float、long等数据类型时，其数据必须由数字构成，
        String stringNumber = System.getProperty("number");

        int number = Integer.parseInt(stringNumber);
        if(number==20210321){
            System.out.println("Good luck");
        }
    }


}
