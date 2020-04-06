package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.*;


/**
 * 标识符：字母，0-9 ，_或 $，数字不可以开头；java中所有命名的位置所用的都是标识符: 接口名 类名 方法名 变量名
 * <p>
 * Java语言是强类型语言，指定类型的变量只能接受与之匹配的数值
 * <p>
 * 变量的作用：编程的本质就是对内存数据进行访问和修改。程序运行时候所有的数据及保存在内存当中，所以会通过变量这一机制对内存中的数据进行访问和修改
 * 变量类型决定内存空间大小，变量名就是这块内存空间的名字(同一个作用域内，变量名不能相同)
 * <p>
 * 变量定义：本质是申请一块特定类型的内存并起个名字；格式：数据类型 变量名
 * <p>
 * 变量赋值：把数据存入指定的内存空间，基本类型变量存储字面值，引用类型变量存储对象的引用(地址)；并且可以反复写入赋值，所以称之为变量
 * <p>
 * 变量三要素：数据类型 变量名 变量值
 * <p>
 * 分类：
 * 按类型：八种基本数据类型(Primitive Data Type：数值型，字符型，boolean型)   三种引用数据类型(Reference Data Type:类似于指针，包括Object及其子类 接口 数组)
 * 按作用域：局部变量 全局变量
 * <p>
 * 变量类型转换：
 * 数据类型的转换是在所赋值的数值类型和被变量接收的数据类型不一致时发生的，它需要从一种数据类型转换成另一种数据类型；
 * 数据类型转换的本质是对数据进行强转，包括栈内存和堆内存中数据
 * 自动类型转换和强制类型转换  向上转型/向下转型 装箱/拆箱 其他类型<==>字符串
 * <p>
 * <p>
 * Note:
 * 变量方法命名：驼峰命名法(第一个单词以小写字母开始；从第二个单词开始以后的每个单词的首字母都采用大写字母)；变量名不能是关键字
 * null：null可以堪称是一种特殊的引用类型变量值，不能赋值给基本类型变量，可以赋值给任意引用类型的变量，可以理解为内存空间存储着null这种不指向任何位置的特殊数据
 */
public class VariableDemo {


    /**
     * 变量的声明和初始化
     */
    @Test
    public void test() {
        //You can declare a variable without assigning the value, and assign the value later
        int a;  //声明只是分配内存空间，但是内存空间没有存储值，并起名为a
        a = 1;    //给变量名为a的内存空间赋值1
        System.out.println(a);//打印变量a存储的值

        //Create a variable called b of type double and assign it the value 1.0:
        double b = 1.0;//声明double类型变量的同时赋值为1.0
        System.out.println(b);//打印变量d存储的值

        //Note that if you assign a new value to an existing variable, it will overwrite the previous value:
        char c = 'a';//声明char类型变量的同时赋值为'a'
        c = 'b';     //将变量c存储的值重新赋值为'b'
        System.out.println(c);

        // Cannot assign a value to a final variable
        final int myNum = 15;
        //myNum = 20;  // will generate an error:

        //To declare more than one variable of the same type, use a comma-separated list:
        int x = 5, y = 6, z = 50;
        System.out.println(x + y + z);

        //方法体中的代码自上而下执行,  Java 中的变量需要先声明后使用
        //System.out.println(d);
        int d = 0;


        //int d=1;   在同一个作用域内，变量名不能相同

    }


    /**
     * 变量分类
     */
    @Test
    public void test1() {

        //八种基本数据类型
        byte b = 123;   //byte占有内存1个字节（8bit）,取值范围-2^7~2^7-1也就是-128~127(2^8=256)  Save memory when you are certain that the value will be within -128 and 127:
        short s = 256;  //2字节 取值范围-2^15~2^15-1
        int i = 456888; //4字节 取值范围-2^31~2^31-1
        long l = 234L;  //8字节 取值范围-2^63~2^63-1
        float f = 1.0F; //4字节
        double d = 2.0; //8字节
        char c = 'n';   //2字节(2^16=65536: 0~65535, \u0000~\uffff)
        boolean flag = true;//1 bit

        //Java中还允许使用转义字符‘\’来将其后的字符转变为特殊字符型常量。 例如：'\n'是一个字符，表示换行符; '\t'是一个字符，表示制表符
        char c2 = '\n';
        char c3 = '\t';


        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.SIZE);
        System.out.println();

        /*Float和Double的最小值和最大值都是以科学记数法的形式输出的，结尾的"E+数字"表示E之前的数字要乘以10的多少次方。
        比如3.14E3就是3.14 × 103 =3140，3.14E-3 就是 3.14 x 10-3 =0.00314。*/
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.SIZE);


        //三种引用数据类型接口类型 类类型 数组类型
        //引用类型变量存储对象的引用(地址)
        Object o;
        String myName = "ocean";

        Map map;
        List ls;
        Set set;

        String[] nameList;
    }


    /**
     * 自动类型转换
     * 容量小的类型自动转换为容量大的数据类型byte、short、char-->int-->long-->float-->double
     * byte,short,char之间不会相互转换,他们三者在计算时首先转换为int类型，即使是同类型间计算也会先转换成int再计算
     * 有多种类型的数据混合运算时， 系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算
     */
    @Test
    public void test2_1() {

        byte b = 1;
        short s = 2;
        char c1 = 'a';

        //以下运算都是讲各变量首先转换成int,再进行计算，即使是同类型之间的运算
        int bb = b + b;
        int ss = s + s;
        int c11 = c1 + c1;
        int sum = b + s + c1;

        System.out.println("1==========================");
        System.out.println(sum);

        long l = b;//byte类型数据可以跨级自动转换成log(猜测byte--->int--->long)

        //若参与运算的数据类型不同，则先自动转换成同一类型，然后进行运算。
        System.out.println("2==========================");
        System.out.println(12 / 5);
        System.out.println(12.0f / 5);
        System.out.println(12.0 / 5L);//long自动转为double(5->5.0),然后进行运算

        //任何基本类型的值和字符串值进行连接运算时(+)，基本类型的值将自动转化为字符串类型。
        System.out.println("3==========================");
        System.out.println('a' + 1 + "Hello!");//char占2字节，int4字节，char-->int
        System.out.println("Hello!" + 'a' + 1);

        //向上转型可以看作是一种自动类型转换
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Number[] numbers = new Integer[]{1, 2, 3};

    }


    /**
     * 对于不带任何后缀(F/f, L/l)的整数
     * 如果将一个在byte/short范围内的整数赋值给byte/short变量，那么系统会自动把这个数当成byte/short类型
     * 其他情况下把任意一个整数赋值给int/long/float/double变量,系统会把这个变量当成int
     */
    @Test
    public void test2_2() {
        // byte b=128; 超出其取值范围

        byte b = 127; //这里127是byte类型数据
        long l = 127;//这里127是int类型是数据，会自动转换成long
        long l2 = 127L;//这里127L是long类型是数据

        //long l3=9999999999;//系统会把9999999999当作是int类型，但是又超出了int的取值范围，会报 Integer Number too large
        long l3 = 9999999999L;//9999999999L表示long类型数据
    }


    /**
     * 强制类型转换:强制显示的把一个数据类型转换为另外一种数据类型,也称之为“narrow conversion”:缩小转换
     * 语法：（targetType）value
     * 被强转对象可以是对象或者该对象对应的引用变量；也可以是基本类型数据或者基本类型数据对应的变量
     * 强转可能会引起溢出(Overflow)，造成数据丢失
     */
    @Test
    public void test3() {

        float f = 1.0f;
        int in = (int) f;//个人理解这里强转只是把变量f对应内存区域的数据拷贝一份，然后对副本进行强转，并不会影响变量f对应内存区域的数据
        System.out.println("f=" + f);
        System.out.println("in=" + in);

        /*
         * 强转可能损失精度;
         * 强转过程：
         * int类型 2255555底层存储形式(正数原码反码补码一致)：00000000 00000000 01011000 00011011
         * 强转成byte,补码截取掉高位三个字节，保存低位一个字节进行保存  00011011
         * 00011011 最高位是0，表示正数，原码等于反码补码：00011011，转化成十进制就是27
         * */
        int i = 22555;
        byte bt = (byte) i;
        byte bt2 = (byte) 22555;
        System.out.println("bt:" + bt);
        System.out.println("bt2:" + bt2);


        /*
         * 强转可能损失精度;
         * 强转过程：
         * int类型 233底层存储形式(补码)：00000000 00000000 00000000 11101001
         * 强转成byte,补码截取掉高位三个字节，保存低位一个字节进行保存   11101001
         * 11101000 最高位是1，表示负数；补码减1，得到反码：11101000
         * 反码除符号位外其它按位取反得到原码：10010111,其中最高位是符号位，所以转成十进制是-23
         * */
        int i2 = 233;
        byte bt3 = (byte) i2;
        byte bt4 = (byte) 233;
        System.out.println("bt3:" + bt3);
        System.out.println("bt4:" + bt4);
    }


    /**
     * 浮点数到整数的转换是通过舍弃小数得到,可以强转常量值
     */
    @Test
    public void test3_2() {
        System.out.println((int) 23.5);
        System.out.println((int) -23.5f);
    }


    /**
     * 不带任何后缀的小数默认是double类型
     */
    @Test
    public void test3_3() {
        //float f=2.1;  double类型数据不能直接赋值给float变量
        float f = (float) 2.1;
    }


    /**
     * 向下转型可以看成一种强制类型转换
     */
    @Test
    public void test3_4() {
        Object obj = new String("spring-boot");
        String str = (String) obj;
        System.out.println(str);
    }

    /**
     * 其他类型====>String类型
     * 1 String.valueOf()
     * 2 追加空串"",此时+是连接符
     * 3 引用类型 toString()
     */
    @Test
    public void test4() {

        //int、double、boolean、char、float、long、Object类型数据转换成String,String.valueof
        System.out.println(String.valueOf(12.f));
        System.out.println(String.valueOf('c'));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(new Object()));
        System.out.println(String.valueOf(new Object().toString()));

        //空串是一个已经实例化之后的对象，是有堆内存空间的，只不过内存空间中存储的值为空。
        System.out.println(1 + 2 + "");
        System.out.println("" + 1 + 2);
    }


    /**
     * 整数类型有四种表示方式：二进制 八进制 十进制 十六进制；
     * 二进制以0b/0B开头；java7新增了对二进制的支持
     * 八进制以0开头；
     * 十六进制以0x/0X开头，其中10~15以a~f(不区分大小写)表示
     * <p>
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
        int decimal = 123;//十进制
        int octal = 0123;//八进制
        int hex = 0X123;//十六进制
/*
        //某些时候程序需要直接使用二进制，二进制“更真实”，更能体现出整数在内存中的存在形式；柚子额程序(尤其游戏开发)，使用二进制更加便捷；
        //一个不带任何后缀的二进制默认表示一个int类型
        //最高位是符号位，0正1负
        int binary=0B11000000;//二进制int类型数据占用四个字节32位，不足32位高位用0补齐；所以最高符号位是0，代表正数，原码 反码 补码三者一致
        long binary2=0b1111111111111111111111111111111111111111111L; //二进制long类型占用8个字节64位，不足64位高位用0补齐；所以最高符号位是0，代表正数，原码 反码 补码三者一致
        long binary3=0B11000000;///二进制int类型数据自动转换为long类型数据，不足64位高位用0补齐；所以最高符号位是0，代表正数，原码 反码 补码三者一致
        System.out.println(binary);//十进制输出：192
        System.out.println(binary2);//十进制输出： 8796093022207
        System.out.println(binary3);//十进制输出：192

        //一个不带任何后缀的二进制默认表示一个int类型，没有十进制时候的特殊情形；所以下面需要进行强制类型转换
        byte b=(byte)0X11000000;
        System.out.println(b);*/


    }


}


